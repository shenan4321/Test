package org.bimserver.database.queries;

/******************************************************************************
 * Copyright (C) 2009-2016  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.queries.om.JsonQueryObjectModelConverter;
import org.bimserver.database.queries.om.Query;
import org.bimserver.database.queries.om.QueryException;
import org.bimserver.database.queries.om.QueryPart;
import org.bimserver.emf.MetaDataManager;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.plugins.serializers.ObjectProvider;
import org.bimserver.shared.HashMapVirtualObject;
import org.eclipse.emf.ecore.EClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class QueryObjectProvider implements ObjectProvider {

	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

	// So far 10000000 has proven to not be enough for some legit IFC files
	private static final int MAX_STACK_FRAMES_PROCESSED = 100000000;
	
	// So far 100000 has proven to not be enough for some legit IFC files
	private static final int MAX_STACK_SIZE = 1000000;
	private static final Logger LOGGER = LoggerFactory.getLogger(QueryObjectProvider.class);
	private DatabaseSession databaseSession;
	private BimServer bimServer;
	
	private final Set<Long> oidsRead = new HashSet<>();
	private Deque<StackFrame> stack;
	private long start = -1;
	private long reads = 0;
	private long stackFramesProcessed = 0;
	private final Set<Long> goingToRead = new HashSet<>();
	private Query query;
	private StackFrame stackFrame;

	private Set<Long> roids;

	private PackageMetaData packageMetaData;

	public QueryObjectProvider(DatabaseSession databaseSession, BimServer bimServer, Query query, Set<Long> roids, PackageMetaData packageMetaData) throws IOException, QueryException {
		this.databaseSession = databaseSession;
		this.bimServer = bimServer;
		this.query = query;
		this.roids = roids;
		this.packageMetaData = packageMetaData;
		
		stack = new ArrayDeque<StackFrame>();
		stack.push(new StartFrame(this, roids));
		
		for (QueryPart queryPart : query.getQueryParts()) {
			if (queryPart.hasOids()) {
				goingToRead.addAll(queryPart.getOids());
			}
		}
	}

	public QueryObjectProvider copy() throws IOException, QueryException {
		QueryObjectProvider queryObjectProvider = new QueryObjectProvider(databaseSession, bimServer, query, roids, packageMetaData);
		return queryObjectProvider;
	}
	
	public static QueryObjectProvider fromJsonNode(DatabaseSession databaseSession, BimServer bimServer, JsonNode fullQuery, Set<Long> roids, PackageMetaData packageMetaData) throws JsonParseException, JsonMappingException, IOException, QueryException {
		if (fullQuery instanceof ObjectNode) {
			JsonQueryObjectModelConverter converter = new JsonQueryObjectModelConverter(packageMetaData);
			Query query = converter.parseJson("query", (ObjectNode) fullQuery);
			return new QueryObjectProvider(databaseSession, bimServer, query, roids, packageMetaData);
		} else {
			throw new QueryException("Query root must be of type object");
		}
	}
	
	public static QueryObjectProvider fromJsonString(DatabaseSession databaseSession, BimServer bimServer, String json, Set<Long> roids, PackageMetaData packageMetaData) throws JsonParseException, JsonMappingException, IOException, QueryException {
		return fromJsonNode(databaseSession, bimServer, OBJECT_MAPPER.readValue(json, ObjectNode.class), roids, packageMetaData);
	}
	
	public Query getQuery() {
		return query;
	}

	@Override
	public HashMapVirtualObject next() throws BimserverDatabaseException {
		if (start == -1) {
			start = System.nanoTime();
		}
		try {
			while (!stack.isEmpty()) {
				if (stack.size() > MAX_STACK_SIZE) {
					dumpEndQuery();
					throw new BimserverDatabaseException("Query stack size > 10000, probably a bug, please report");
				}
				stackFrame = stack.peek();
				if (stackFrame.isDone()) {
					stack.pop();
					continue;
				}
				stackFramesProcessed++;
				if (stackFramesProcessed > MAX_STACK_FRAMES_PROCESSED) {
					dumpEndQuery();
					throw new BimserverDatabaseException("Too many stack frames processed ( > " + MAX_STACK_FRAMES_PROCESSED + "), probably a bug, please report");
				}
				boolean done = stackFrame.process();
				stackFrame.setDone(done);
				if (stackFrame instanceof ObjectProvidingStackFrame) {
					HashMapVirtualObject currentObject = ((ObjectProvidingStackFrame) stackFrame).getCurrentObject();
					if (currentObject != null) {
						if (!oidsRead.contains(currentObject.getOid())) {
							oidsRead.add(currentObject.getOid());
							return currentObject;
						}
					}
				}
			}
		} catch (Exception e) {
			throw new BimserverDatabaseException(e);
		}

		dumpEndQuery();
		
		return null;
	}
	
	public StackFrame getStackFrame() {
		return stackFrame;
	}
	
	private void dumpEndQuery() {
		StackFrame poll = stack.poll();
		int i=0;
		if (poll != null) {
			LOGGER.info("Query dump");
			while (poll != null && i < 20) {
				i++;
				LOGGER.info("\t" + poll.toString());
				poll = stack.poll();
			}
		}
		long end = System.nanoTime();
		LOGGER.debug("Query, " + reads + " reads, " + stackFramesProcessed + " stack frames processed, " + oidsRead.size() + " objects read, " + ((end - start) / 1000000) + "ms");
	}

	public void incReads() {
		reads++;
	}

	public DatabaseSession getDatabaseSession() {
		return databaseSession;
	}

	public MetaDataManager getMetaDataManager() {
		return bimServer.getMetaDataManager();
	}

	public boolean hasRead(long oid) {
		return oidsRead.contains(oid);
	}

	public void push(StackFrame stackFrame) {
		if (!stackFrame.isDone()) {
			stack.push(stackFrame);
		}
	}

	public boolean hasReadOrIsGoingToRead(EClass eClass) {
		for (QueryPart queryPart : query.getQueryParts()) {
			if (queryPart.hasTypes()) {
				if (queryPart.getTypes().contains(eClass)) {
					if (queryPart.getGuids() == null && queryPart.getNames() == null && queryPart.getOids() == null && queryPart.getInBoundingBox() == null && queryPart.getProperties() == null && queryPart.getClassifications() == null) {
						return true;
					}
				}
			} else {
				return (queryPart.getGuids() == null && queryPart.getNames() == null && queryPart.getOids() == null && queryPart.getInBoundingBox() == null && queryPart.getProperties() == null && queryPart.getClassifications() == null);
			}
		}
		return false;
	}
	
	public boolean hasReadOrIsGoingToRead(Long oid) {
		if (oidsRead.contains(oid)) {
			return true;
		}
		if (goingToRead.contains(oid)) {
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}