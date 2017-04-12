/**
 * Copyright (C) 2009-2014 BIMserver.org
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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package cn.dlb.bim.models.ifc4.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import cn.dlb.bim.models.ifc4.Ifc4Package;
import cn.dlb.bim.models.ifc4.IfcTriangulatedFaceSet;
import cn.dlb.bim.models.ifc4.ListOfELong;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Triangulated Face Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link cn.dlb.bim.models.ifc4.impl.IfcTriangulatedFaceSetImpl#getCoordIndex <em>Coord Index</em>}</li>
 *   <li>{@link cn.dlb.bim.models.ifc4.impl.IfcTriangulatedFaceSetImpl#getNormalIndex <em>Normal Index</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcTriangulatedFaceSetImpl extends IfcTessellatedFaceSetImpl implements IfcTriangulatedFaceSet {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcTriangulatedFaceSetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_TRIANGULATED_FACE_SET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ListOfELong> getCoordIndex() {
		return (EList<ListOfELong>) eGet(Ifc4Package.Literals.IFC_TRIANGULATED_FACE_SET__COORD_INDEX, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ListOfELong> getNormalIndex() {
		return (EList<ListOfELong>) eGet(Ifc4Package.Literals.IFC_TRIANGULATED_FACE_SET__NORMAL_INDEX, true);
	}

} //IfcTriangulatedFaceSetImpl
