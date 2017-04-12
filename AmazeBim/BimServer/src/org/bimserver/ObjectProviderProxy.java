package org.bimserver;

import java.io.IOException;

import org.bimserver.database.queries.om.QueryException;

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

import org.bimserver.plugins.serializers.ObjectProvider;
import org.bimserver.shared.HashMapVirtualObject;

public class ObjectProviderProxy implements ObjectProvider {

	private ObjectProvider objectProvider;
	private ObjectListener objectListener;

	public ObjectProviderProxy(ObjectProvider objectProvider, ObjectListener objectListener) {
		this.objectProvider = objectProvider;
		this.objectListener = objectListener;
	}

	@Override
	public HashMapVirtualObject next() throws BimserverDatabaseException {
		HashMapVirtualObject next = objectProvider.next();
		if (next != null) {
			objectListener.newObject(next);
		}
		return next;
	}

	@Override
	public ObjectProvider copy() throws IOException, QueryException {
		return objectProvider.copy();
	}
}