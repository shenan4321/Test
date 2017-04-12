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
import cn.dlb.bim.models.ifc2x3tc1.IfcImageTexture;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Image Texture</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link cn.dlb.bim.models.ifc2x3tc1.impl.IfcImageTextureImpl#getUrlReference <em>Url Reference</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcImageTextureImpl extends IfcSurfaceTextureImpl implements IfcImageTexture {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcImageTextureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_IMAGE_TEXTURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUrlReference() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_IMAGE_TEXTURE__URL_REFERENCE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUrlReference(String newUrlReference) {
		eSet(Ifc2x3tc1Package.Literals.IFC_IMAGE_TEXTURE__URL_REFERENCE, newUrlReference);
	}

} //IfcImageTextureImpl