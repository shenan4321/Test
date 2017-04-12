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
import cn.dlb.bim.models.ifc4.IfcOpeningElement;
import cn.dlb.bim.models.ifc4.IfcOpeningElementTypeEnum;
import cn.dlb.bim.models.ifc4.IfcRelFillsElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Opening Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link cn.dlb.bim.models.ifc4.impl.IfcOpeningElementImpl#getPredefinedType <em>Predefined Type</em>}</li>
 *   <li>{@link cn.dlb.bim.models.ifc4.impl.IfcOpeningElementImpl#getHasFillings <em>Has Fillings</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcOpeningElementImpl extends IfcFeatureElementSubtractionImpl implements IfcOpeningElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcOpeningElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_OPENING_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcOpeningElementTypeEnum getPredefinedType() {
		return (IfcOpeningElementTypeEnum) eGet(Ifc4Package.Literals.IFC_OPENING_ELEMENT__PREDEFINED_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPredefinedType(IfcOpeningElementTypeEnum newPredefinedType) {
		eSet(Ifc4Package.Literals.IFC_OPENING_ELEMENT__PREDEFINED_TYPE, newPredefinedType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPredefinedType() {
		eUnset(Ifc4Package.Literals.IFC_OPENING_ELEMENT__PREDEFINED_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPredefinedType() {
		return eIsSet(Ifc4Package.Literals.IFC_OPENING_ELEMENT__PREDEFINED_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRelFillsElement> getHasFillings() {
		return (EList<IfcRelFillsElement>) eGet(Ifc4Package.Literals.IFC_OPENING_ELEMENT__HAS_FILLINGS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetHasFillings() {
		eUnset(Ifc4Package.Literals.IFC_OPENING_ELEMENT__HAS_FILLINGS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetHasFillings() {
		return eIsSet(Ifc4Package.Literals.IFC_OPENING_ELEMENT__HAS_FILLINGS);
	}

} //IfcOpeningElementImpl