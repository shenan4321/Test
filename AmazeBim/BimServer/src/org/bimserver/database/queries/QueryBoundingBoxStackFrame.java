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

import java.nio.ByteBuffer;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession.GetResult;
import org.bimserver.database.Record;
import org.bimserver.database.SearchingRecordIterator;
import org.bimserver.database.queries.om.InBoundingBox;
import org.bimserver.database.queries.om.QueryException;
import org.bimserver.database.queries.om.QueryPart;
import org.bimserver.shared.HashMapVirtualObject;
import org.bimserver.shared.HashMapWrappedVirtualObject;
import org.bimserver.shared.QueryContext;
import org.bimserver.utils.BinUtils;
import org.eclipse.emf.ecore.EClass;

public class QueryBoundingBoxStackFrame extends DatabaseReadingStackFrame implements ObjectProvidingStackFrame {
	private EClass eClass;
	private SearchingRecordIterator typeRecordIterator;
	private Record record;
	private InBoundingBox inBoundingBox;

	public QueryBoundingBoxStackFrame(QueryObjectProvider queryObjectProvider, EClass eClass, QueryPart queryPart, QueryContext reusable, InBoundingBox inBoundingBox) throws BimserverDatabaseException {
		super(reusable, queryObjectProvider, queryPart);
		this.eClass = eClass;
		this.inBoundingBox = inBoundingBox;

		String tableName = eClass.getEPackage().getName() + "_" + eClass.getName();
		if (reusable.getOidCounters() != null) {
			if (!reusable.getOidCounters().containsKey(eClass)) {
				return; // will skip to next one
			}
			long startOid = reusable.getOidCounters().get(eClass);
			ByteBuffer tmp = ByteBuffer.allocate(12);
			tmp.putInt(reusable.getPid());
			tmp.putLong(startOid + 1);
			typeRecordIterator = queryObjectProvider.getDatabaseSession().getKeyValueStore().getRecordIterator(tableName, BinUtils.intToByteArray(getReusable().getPid()), tmp.array(), queryObjectProvider.getDatabaseSession());
			record = typeRecordIterator.next();
		} else {
//			LOGGER.warn("Potential too-many-reads");
			typeRecordIterator = queryObjectProvider.getDatabaseSession().getKeyValueStore().getRecordIterator(tableName, BinUtils.intToByteArray(getReusable().getPid()), BinUtils.intToByteArray(getReusable().getPid()), queryObjectProvider.getDatabaseSession());
			record = typeRecordIterator.next();
		}
	}
	
	@Override
	public boolean process() throws BimserverDatabaseException, QueryException {
		if (typeRecordIterator == null) {
			return true;
		}
		if (record == null) {
			currentObject = null;
			typeRecordIterator.close();
			return true;
		}

		currentObject = null;
		
		ByteBuffer nextKeyStart = ByteBuffer.allocate(12);
		getQueryObjectProvider().incReads();
		ByteBuffer keyBuffer = ByteBuffer.wrap(record.getKey());
		int keyPid = keyBuffer.getInt();
		long keyOid = keyBuffer.getLong();
		int keyRid = -keyBuffer.getInt();
		ByteBuffer valueBuffer = ByteBuffer.wrap(record.getValue());
		GetResult map = getMap(eClass, eClass, valueBuffer, keyPid, keyOid, keyRid);
		if (map == GetResult.CONTINUE_WITH_NEXT_OID) {
			nextKeyStart.position(0);
			nextKeyStart.putInt(getReusable().getPid());
			nextKeyStart.putLong(keyOid + 1);
			record = typeRecordIterator.next(nextKeyStart.array());
		} else {
			record = typeRecordIterator.next();
		}

		if (currentObject != null) {
			if (currentObject.has("geometry")) {
				long geometryInfoId = (Long) currentObject.get("geometry");
				HashMapVirtualObject geometryInfo = getByOid(geometryInfoId);
				HashMapWrappedVirtualObject minBounds = (HashMapWrappedVirtualObject) geometryInfo.get("minBounds");
				HashMapWrappedVirtualObject maxBounds = (HashMapWrappedVirtualObject) geometryInfo.get("maxBounds");
				double minX = (double) minBounds.eGet("x");
				double minY = (double) minBounds.eGet("y");
				double minZ = (double) minBounds.eGet("z");
				double maxX = (double) maxBounds.eGet("x");
				double maxY = (double) maxBounds.eGet("y");
				double maxZ = (double) maxBounds.eGet("z");
				if (
						minX > inBoundingBox.getX() &&
						minY > inBoundingBox.getY() &&
						minZ > inBoundingBox.getZ() &&
						maxX < inBoundingBox.getX() + inBoundingBox.getWidth() &&
						maxY < inBoundingBox.getY() + inBoundingBox.getHeight() &&
						maxZ < inBoundingBox.getZ() + inBoundingBox.getDepth()) {
				} else {
					currentObject = null;
				}
			} else {
				currentObject = null;
			}
		}
		
		processPossibleIncludes(eClass, getQueryPart());
		
		return false;
	}
	
	public HashMapVirtualObject getCurrentObject() {
		return currentObject;
	}
}
