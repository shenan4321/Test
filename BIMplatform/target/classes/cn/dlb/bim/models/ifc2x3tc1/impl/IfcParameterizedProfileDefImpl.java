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
package cn.dlb.bim.models.ifc2x3tc1.impl;

import org.eclipse.emf.ecore.EClass;

import cn.dlb.bim.models.ifc2x3tc1.Ifc2x3tc1Package;
import cn.dlb.bim.models.ifc2x3tc1.IfcAxis2Placement2D;
import cn.dlb.bim.models.ifc2x3tc1.IfcParameterizedProfileDef;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Parameterized Profile Def</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link cn.dlb.bim.models.ifc2x3tc1.impl.IfcParameterizedProfileDefImpl#getPosition <em>Position</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcParameterizedProfileDefImpl extends IfcProfileDefImpl implements IfcParameterizedProfileDef {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcParameterizedProfileDefImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_PARAMETERIZED_PROFILE_DEF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcAxis2Placement2D getPosition() {
		return (IfcAxis2Placement2D) eGet(Ifc2x3tc1Package.Literals.IFC_PARAMETERIZED_PROFILE_DEF__POSITION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPosition(IfcAxis2Placement2D newPosition) {
		eSet(Ifc2x3tc1Package.Literals.IFC_PARAMETERIZED_PROFILE_DEF__POSITION, newPosition);
	}

} //IfcParameterizedProfileDefImpl
