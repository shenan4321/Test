package cn.dlb.bim.ifc.database.queries.om;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import cn.dlb.bim.ifc.emf.PackageMetaData;

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