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

import org.eclipse.emf.ecore.EStructuralFeature;

public class WaitingVirtualObject {
	// The object that has a missing reference
	private final VirtualObject object;

	// The structural feature (usually a reference) on which to 'connect' the object on
	private final EStructuralFeature structuralFeature;

	private int lineNumber;

	private int bufferPosition = -1;
	
	public WaitingVirtualObject(int lineNumber, VirtualObject object, EStructuralFeature structuralFeature, int bufferPosition) {
		this.lineNumber = lineNumber;
		this.object = object;
		this.structuralFeature = structuralFeature;
		this.bufferPosition = bufferPosition;
	}

	public VirtualObject getObject() {
		return object;
	}

	public EStructuralFeature getStructuralFeature() {
		return structuralFeature;
	}
	
	public int getLineNumber() {
		return lineNumber;
	}
	
	@Override
	public String toString() {
		return getObject() + " " + getStructuralFeature().getName();
	}
	
	public int getBufferPosition() {
		return bufferPosition;
	}
}