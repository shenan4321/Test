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
package cn.dlb.bim.models.store.impl;

import org.eclipse.emf.ecore.EClass;

import cn.dlb.bim.models.store.ArrayDefinition;
import cn.dlb.bim.models.store.StorePackage;
import cn.dlb.bim.models.store.TypeDefinition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Array Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link cn.dlb.bim.models.store.impl.ArrayDefinitionImpl#getType <em>Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ArrayDefinitionImpl extends TypeDefinitionImpl implements ArrayDefinition {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ArrayDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StorePackage.Literals.ARRAY_DEFINITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeDefinition getType() {
		return (TypeDefinition) eGet(StorePackage.Literals.ARRAY_DEFINITION__TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(TypeDefinition newType) {
		eSet(StorePackage.Literals.ARRAY_DEFINITION__TYPE, newType);
	}

} //ArrayDefinitionImpl