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

import org.eclipse.emf.ecore.EClass;

import cn.dlb.bim.models.ifc4.Ifc4Package;
import cn.dlb.bim.models.ifc4.IfcInterceptorType;
import cn.dlb.bim.models.ifc4.IfcInterceptorTypeEnum;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Interceptor Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link cn.dlb.bim.models.ifc4.impl.IfcInterceptorTypeImpl#getPredefinedType <em>Predefined Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcInterceptorTypeImpl extends IfcFlowTreatmentDeviceTypeImpl implements IfcInterceptorType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcInterceptorTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_INTERCEPTOR_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcInterceptorTypeEnum getPredefinedType() {
		return (IfcInterceptorTypeEnum) eGet(Ifc4Package.Literals.IFC_INTERCEPTOR_TYPE__PREDEFINED_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPredefinedType(IfcInterceptorTypeEnum newPredefinedType) {
		eSet(Ifc4Package.Literals.IFC_INTERCEPTOR_TYPE__PREDEFINED_TYPE, newPredefinedType);
	}

} //IfcInterceptorTypeImpl
