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
import org.bimserver.database.Record;
import org.bimserver.database.SearchingRecordIterator;
import org.bimserver.database.queries.om.Include;
import org.bimserver.database.queries.om.QueryException;
import org.bimserver.database.queries.om.QueryPart;
import org.bimserver.shared.QueryContext;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;

public class FollowReferenceStackFrame extends DatabaseReadingStackFrame implements ObjectProvidingStackFrame {

	private long oid;
	private boolean hasRun = false;
	private Include include;
	private EReference fromReference;
	
	public FollowReferenceStackFrame(QueryObjectProvider queryObjectProvider, Long oid, QueryContext reusable, QueryPart queryPart, EReference fromReference, Include include) {
		super(reusable, queryObjectProvider, queryPart);
		this.oid = oid;
		this.fromReference = fromReference;
		this.include = include;
	}

	@Override
	public boolean process() throws BimserverDatabaseException, QueryException {
		if (getQueryObjectProvider().hasRead(oid)) {
			processPossibleIncludes(null, include);
			return true;
		}
		
		if (hasRun) {
			return true;
		}
		hasRun = true;
		if (oid == -1) {
			throw new BimserverDatabaseException("Cannot get object for oid " + oid);
		}
		EClass eClass = getQueryObjectProvider().getDatabaseSession().getEClassForOid(oid);
		ByteBuffer mustStartWith = ByteBuffer.wrap(new byte[12]);
		mustStartWith.putInt(getReusable().getPid());
		mustStartWith.putLong(oid);
		ByteBuffer startSearchWith = ByteBuffer.wrap(new byte[16]);
		startSearchWith.putInt(getReusable().getPid());
		startSearchWith.putLong(oid);
		startSearchWith.putInt(-getReusable().getRid());

		SearchingRecordIterator recordIterator = getQueryObjectProvider().getDatabaseSession().getKeyValueStore().getRecordIterator(eClass.getEPackage().getName() + "_" + eClass.getName(), mustStartWith.array(),
				startSearchWith.array(), getQueryObjectProvider().getDatabaseSession());
		try {
			Record record = recordIterator.next();
			if (record == null) {
				return true;
			}
			getQueryObjectProvider().incReads();
			ByteBuffer keyBuffer = ByteBuffer.wrap(record.getKey());
			ByteBuffer valueBuffer = ByteBuffer.wrap(record.getValue());
			keyBuffer.getInt(); // pid
			long keyOid = keyBuffer.getLong();
			int keyRid = -keyBuffer.getInt();
			if (keyRid <= getReusable().getRid()) {
				if (valueBuffer.capacity() == 1 && valueBuffer.get(0) == -1) {
					valueBuffer.position(valueBuffer.position() + 1);
					return true;
					// deleted entity
				} else {
					currentObject = convertByteArrayToObject(eClass, keyOid, valueBuffer, keyRid);
					
					if (currentObject != null) {
						EReference opposite = getPackageMetaData().getInverseOrOpposite(currentObject.eClass(), fromReference);
						if (opposite != null) {
							currentObject.addUseForSerialization(opposite);
						}
					}
					
					processPossibleIncludes(null, include);
				}
			} else {
				return true;
			}
		} finally {
			recordIterator.close();
		}
		return true;
	}
	
	@Override
	public String toString() {
		try {
			EClass eClass = getQueryObjectProvider().getDatabaseSession().getEClassForOid(oid);
			return "FollowReferenceStackFrame (" + eClass.getName() + "." + fromReference.getName() + ", " + oid + ")";
		} catch (BimserverDatabaseException e) {
			e.printStackTrace();
		}
		return "FollowReferenceStackFrame (" + fromReference.getName() + ")";
	}
}