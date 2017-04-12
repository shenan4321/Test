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
import cn.dlb.bim.models.ifc4.IfcDistributionElement;
import cn.dlb.bim.models.ifc4.IfcRelConnectsPortToElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Distribution Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link cn.dlb.bim.models.ifc4.impl.IfcDistributionElementImpl#getHasPorts <em>Has Ports</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcDistributionElementImpl extends IfcElementImpl implements IfcDistributionElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcDistributionElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_DISTRIBUTION_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRelConnectsPortToElement> getHasPorts() {
		return (EList<IfcRelConnectsPortToElement>) eGet(Ifc4Package.Literals.IFC_DISTRIBUTION_ELEMENT__HAS_PORTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetHasPorts() {
		eUnset(Ifc4Package.Literals.IFC_DISTRIBUTION_ELEMENT__HAS_PORTS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetHasPorts() {
		return eIsSet(Ifc4Package.Literals.IFC_DISTRIBUTION_ELEMENT__HAS_PORTS);
	}

} //IfcDistributionElementImpl
