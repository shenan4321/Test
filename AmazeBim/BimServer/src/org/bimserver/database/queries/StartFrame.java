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

import java.util.Iterator;
import java.util.Set;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.queries.om.QueryException;

public class StartFrame extends StackFrame {

	private Iterator<Long> roidsIterator;
	private QueryObjectProvider queryObjectProvider;

	public StartFrame(QueryObjectProvider queryObjectProvider, Set<Long> roids) throws QueryException {
		this.queryObjectProvider = queryObjectProvider;
		if (roids.size() == 0) {
			throw new QueryException("At least one roid required");
		}
		this.roidsIterator = roids.iterator();
	}

	@Override
	public boolean process() throws BimserverDatabaseException {
		queryObjectProvider.push(new RevisionStackFrame(queryObjectProvider, this.roidsIterator.next()));
		if (this.roidsIterator.hasNext()) {
			return false;
		}
		return true;
	}
}