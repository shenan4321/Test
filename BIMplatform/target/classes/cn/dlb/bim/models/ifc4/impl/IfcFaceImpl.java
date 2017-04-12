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
import cn.dlb.bim.models.ifc4.IfcFace;
import cn.dlb.bim.models.ifc4.IfcFaceBound;
import cn.dlb.bim.models.ifc4.IfcTextureMap;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Face</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link cn.dlb.bim.models.ifc4.impl.IfcFaceImpl#getBounds <em>Bounds</em>}</li>
 *   <li>{@link cn.dlb.bim.models.ifc4.impl.IfcFaceImpl#getHasTextureMaps <em>Has Texture Maps</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcFaceImpl extends IfcTopologicalRepresentationItemImpl implements IfcFace {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcFaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_FACE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcFaceBound> getBounds() {
		return (EList<IfcFaceBound>) eGet(Ifc4Package.Literals.IFC_FACE__BOUNDS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcTextureMap> getHasTextureMaps() {
		return (EList<IfcTextureMap>) eGet(Ifc4Package.Literals.IFC_FACE__HAS_TEXTURE_MAPS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetHasTextureMaps() {
		eUnset(Ifc4Package.Literals.IFC_FACE__HAS_TEXTURE_MAPS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetHasTextureMaps() {
		return eIsSet(Ifc4Package.Literals.IFC_FACE__HAS_TEXTURE_MAPS);
	}

} //IfcFaceImpl