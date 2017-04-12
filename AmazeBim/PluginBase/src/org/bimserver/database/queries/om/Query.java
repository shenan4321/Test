package org.bimserver.database.queries.om;

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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.bimserver.emf.PackageMetaData;

public class Query {
	private final Map<String, Include> defines = new HashMap<>();
	private final List<QueryPart> queryParts = new ArrayList<>();
	private String name;
	private PackageMetaData packageMetaData;
	
	public Query(String name, PackageMetaData packageMetaData) {
		this.name = name;
		this.packageMetaData = packageMetaData;
	}

	public Query(PackageMetaData packageMetaData) {
		this.name = "Query-" + new Random().nextInt();
		this.packageMetaData = packageMetaData;
	}

	public void addDefine(String name, Include include) {
		defines.put(name, include);
	}
	
	public void addQueryPart(QueryPart queryPart) {
		queryParts.add(queryPart);
	}
	
	public String getName() {
		return name;
	}

	public Include getDefine(String includeName) {
		return defines.get(includeName);
	}
	
	public List<QueryPart> getQueryParts() {
		return queryParts;
	}
	
	public Map<String, Include> getDefines() {
		return defines;
	}
	
	public QueryPart createQueryPart() {
		QueryPart queryPart = new QueryPart(packageMetaData);
		addQueryPart(queryPart);
		return queryPart;
	}
	
	public Include createDefine(String name) {
		Include include = new Include(packageMetaData);
		this.defines.put(name, include);
		return include;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("defines\n");
		for (String define : defines.keySet()) {
			sb.append("\t" + define + "\n");
			Include include = defines.get(define);
			include.dump(2, sb);
		}
		sb.append("queries\n");
		for (QueryPart queryPart : queryParts) {
			queryPart.dump(2, sb);
		}
		return sb.toString();
	}

	public PackageMetaData getPackageMetaData() {
		return packageMetaData;
	}
}