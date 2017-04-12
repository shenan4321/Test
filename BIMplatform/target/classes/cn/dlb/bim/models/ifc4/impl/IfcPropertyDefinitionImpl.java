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
import cn.dlb.bim.models.ifc4.IfcPropertyDefinition;
import cn.dlb.bim.models.ifc4.IfcRelAssociates;
import cn.dlb.bim.models.ifc4.IfcRelDeclares;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Property Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link cn.dlb.bim.models.ifc4.impl.IfcPropertyDefinitionImpl#getHasContext <em>Has Context</em>}</li>
 *   <li>{@link cn.dlb.bim.models.ifc4.impl.IfcPropertyDefinitionImpl#getHasAssociations <em>Has Associations</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcPropertyDefinitionImpl extends IfcRootImpl implements IfcPropertyDefinition {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcPropertyDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_PROPERTY_DEFINITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRelDeclares> getHasContext() {
		return (EList<IfcRelDeclares>) eGet(Ifc4Package.Literals.IFC_PROPERTY_DEFINITION__HAS_CONTEXT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetHasContext() {
		eUnset(Ifc4Package.Literals.IFC_PROPERTY_DEFINITION__HAS_CONTEXT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetHasContext() {
		return eIsSet(Ifc4Package.Literals.IFC_PROPERTY_DEFINITION__HAS_CONTEXT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRelAssociates> getHasAssociations() {
		return (EList<IfcRelAssociates>) eGet(Ifc4Package.Literals.IFC_PROPERTY_DEFINITION__HAS_ASSOCIATIONS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetHasAssociations() {
		eUnset(Ifc4Package.Literals.IFC_PROPERTY_DEFINITION__HAS_ASSOCIATIONS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetHasAssociations() {
		return eIsSet(Ifc4Package.Literals.IFC_PROPERTY_DEFINITION__HAS_ASSOCIATIONS);
	}

} //IfcPropertyDefinitionImpl