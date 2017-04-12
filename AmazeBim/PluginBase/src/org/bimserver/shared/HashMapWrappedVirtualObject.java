package org.bimserver.shared;

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
import java.util.HashMap;
import java.util.Map;

import org.bimserver.BimserverDatabaseException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EStructuralFeature;

public class HashMapWrappedVirtualObject extends AbstractHashMapVirtualObject implements WrappedVirtualObject {

	private EClass eClass;
	private final Map<EStructuralFeature, Object> map = new HashMap<>();

	public HashMapWrappedVirtualObject(QueryContext reusable, EClass eClass) {
		this.eClass = eClass;
	}

	@Override
	public EClass eClass() {
		return eClass;
	}

	public Object eGet(EStructuralFeature feature) {
		return map.get(feature);
	}
	
	@Override
	public void setAttribute(EStructuralFeature eStructuralFeature, Object value) throws BimserverDatabaseException {
		map.put(eStructuralFeature, value);
	}

	@Override
	public void set(String name, Object value) throws BimserverDatabaseException {
		EStructuralFeature eStructuralFeature = eClass.getEStructuralFeature(name);
		map.put(eStructuralFeature, value);
	}

	@Override
	public ByteBuffer write() throws BimserverDatabaseException {
		return null;
	}

	public Object eGet(String name) {
		EStructuralFeature feature = eClass.getEStructuralFeature(name);
		return eGet(feature);
	}

	@Override
	public boolean useFeatureForSerialization(EStructuralFeature feature) {
		throw new UnsupportedOperationException();
	}

	@Override
	public int getSize() {
		int size = 2;
		for (EStructuralFeature eStructuralFeature : map.keySet()) {
			size += getPrimitiveSize((EDataType) eStructuralFeature.getEType(), map.get(eStructuralFeature));
		}
		return size;
	}

	@Override
	public boolean useFeatureForSerialization(EStructuralFeature feature, int index) {
		// TODO Auto-generated method stub
		return false;
	}
}