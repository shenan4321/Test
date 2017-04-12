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
package cn.dlb.bim.models.ifc4;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Texture Vertex List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link cn.dlb.bim.models.ifc4.IfcTextureVertexList#getTexCoordsList <em>Tex Coords List</em>}</li>
 * </ul>
 *
 * @see cn.dlb.bim.models.ifc4.Ifc4Package#getIfcTextureVertexList()
 * @model
 * @generated
 */
public interface IfcTextureVertexList extends IfcPresentationItem {
	/**
	 * Returns the value of the '<em><b>Tex Coords List</b></em>' reference list.
	 * The list contents are of type {@link cn.dlb.bim.models.ifc4.ListOfIfcParameterValue}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tex Coords List</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tex Coords List</em>' reference list.
	 * @see cn.dlb.bim.models.ifc4.Ifc4Package#getIfcTextureVertexList_TexCoordsList()
	 * @model
	 * @generated
	 */
	EList<ListOfIfcParameterValue> getTexCoordsList();

} // IfcTextureVertexList
