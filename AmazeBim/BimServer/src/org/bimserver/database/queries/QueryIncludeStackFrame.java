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

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.queries.om.CanInclude;
import org.bimserver.database.queries.om.Include;
import org.bimserver.database.queries.om.QueryException;
import org.bimserver.database.queries.om.QueryPart;
import org.bimserver.shared.HashMapVirtualObject;
import org.bimserver.shared.QueryContext;
import org.bimserver.shared.WrappedVirtualObject;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;

import com.google.common.collect.Iterators;

public class QueryIncludeStackFrame extends DatabaseReadingStackFrame {

	private Set<Short> outputFilterCids;
	private Iterator<EReference> featureIterator;
	private Include include;
	private EReference feature;
	private HashSet<?> directFeatureSet;

	public QueryIncludeStackFrame(QueryObjectProvider queryObjectProvider, QueryContext queryContext, CanInclude previousInclude, Include include, HashMapVirtualObject currentObject, QueryPart queryPart) throws QueryException, BimserverDatabaseException {
		super(queryContext, queryObjectProvider, queryPart);
		this.include = include;
		this.currentObject = currentObject;
		
		List<EReference> features = include.getFields();
		List<EReference> featuresDirect = include.getFieldsDirect();
		
		if ((features == null || features.isEmpty()) && (featuresDirect == null || featuresDirect.isEmpty())) {
			setDone(true);
			return;
		}
		if (features == null) {
			featureIterator = featuresDirect.iterator();
			directFeatureSet = new HashSet<>(featuresDirect);
		} else if (featuresDirect == null) {
			featureIterator = features.iterator();
		} else {
			featureIterator = Iterators.concat(features.iterator(), featuresDirect.iterator());
		}
		if (include.getOutputTypes() != null) {
			this.outputFilterCids = new HashSet<>();
			for (EClass eClass : include.getOutputTypes()) {
				short cid = queryObjectProvider.getDatabaseSession().getCidOfEClass(eClass);
				outputFilterCids.add(cid);
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean process() throws BimserverDatabaseException, QueryException {
		feature = featureIterator.next();
		Object value = currentObject.eGet(feature);
		if (value != null) {
			if (feature.isMany()) {
				List<Long> list = (List<Long>)value;
				for (Object r : list) {
					if (r instanceof Long) {
						if (directFeatureSet != null && directFeatureSet.contains(feature)) {
							// TODO not supported for now
//							processDirectReference((Long)r);
						} else {
							processReference((Long)r);
						}
					} else {
						// ??
					}
				}
			} else {
				if (value instanceof Long) {
					long refOid = (Long) value;
					if (directFeatureSet != null && directFeatureSet.contains(feature)) {
						processDirectReference(currentObject, feature, (Long)refOid);
					} else {
						processReference(refOid);
					}
				} else if (value instanceof WrappedVirtualObject) {
					// ??
				}
			}
		}
		
		return !featureIterator.hasNext();
	}

	private void processDirectReference(HashMapVirtualObject currentObject, EReference feature2, Long oid) throws BimserverDatabaseException {
		HashMapVirtualObject byOid = getByOid(oid);
		currentObject.setDirectReference(feature2, byOid);
	}

	private void processReference(long refOid) {
		if (outputFilterCids == null || outputFilterCids.contains((short)refOid)) {
			if (!getQueryObjectProvider().hasRead(refOid)) {
				getQueryObjectProvider().push(new FollowReferenceStackFrame(getQueryObjectProvider(), refOid, getReusable(), getQueryPart(), feature, include));
			}
		}
	}
}