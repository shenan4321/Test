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

import cn.dlb.bim.ifc.emf.IdEObjectImpl;
import cn.dlb.bim.models.ifc4.Ifc4Package;
import cn.dlb.bim.models.ifc4.IfcExternalReferenceRelationship;
import cn.dlb.bim.models.ifc4.IfcPropertyAbstraction;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Property Abstraction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link cn.dlb.bim.models.ifc4.impl.IfcPropertyAbstractionImpl#getHasExternalReferences <em>Has External References</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcPropertyAbstractionImpl extends IdEObjectImpl implements IfcPropertyAbstraction {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcPropertyAbstractionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_PROPERTY_ABSTRACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcExternalReferenceRelationship> getHasExternalReferences() {
		return (EList<IfcExternalReferenceRelationship>) eGet(Ifc4Package.Literals.IFC_PROPERTY_ABSTRACTION__HAS_EXTERNAL_REFERENCES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetHasExternalReferences() {
		eUnset(Ifc4Package.Literals.IFC_PROPERTY_ABSTRACTION__HAS_EXTERNAL_REFERENCES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetHasExternalReferences() {
		return eIsSet(Ifc4Package.Literals.IFC_PROPERTY_ABSTRACTION__HAS_EXTERNAL_REFERENCES);
	}

} //IfcPropertyAbstractionImpl
