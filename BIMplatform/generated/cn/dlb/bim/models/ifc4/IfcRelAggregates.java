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
 * A representation of the model object '<em><b>Ifc Rel Aggregates</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link cn.dlb.bim.models.ifc4.IfcRelAggregates#getRelatingObject <em>Relating Object</em>}</li>
 *   <li>{@link cn.dlb.bim.models.ifc4.IfcRelAggregates#getRelatedObjects <em>Related Objects</em>}</li>
 * </ul>
 *
 * @see cn.dlb.bim.models.ifc4.Ifc4Package#getIfcRelAggregates()
 * @model
 * @generated
 */
public interface IfcRelAggregates extends IfcRelDecomposes {
	/**
	 * Returns the value of the '<em><b>Relating Object</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link cn.dlb.bim.models.ifc4.IfcObjectDefinition#getIsDecomposedBy <em>Is Decomposed By</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relating Object</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relating Object</em>' reference.
	 * @see #setRelatingObject(IfcObjectDefinition)
	 * @see cn.dlb.bim.models.ifc4.Ifc4Package#getIfcRelAggregates_RelatingObject()
	 * @see cn.dlb.bim.models.ifc4.IfcObjectDefinition#getIsDecomposedBy
	 * @model opposite="IsDecomposedBy"
	 * @generated
	 */
	IfcObjectDefinition getRelatingObject();

	/**
	 * Sets the value of the '{@link cn.dlb.bim.models.ifc4.IfcRelAggregates#getRelatingObject <em>Relating Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relating Object</em>' reference.
	 * @see #getRelatingObject()
	 * @generated
	 */
	void setRelatingObject(IfcObjectDefinition value);

	/**
	 * Returns the value of the '<em><b>Related Objects</b></em>' reference list.
	 * The list contents are of type {@link cn.dlb.bim.models.ifc4.IfcObjectDefinition}.
	 * It is bidirectional and its opposite is '{@link cn.dlb.bim.models.ifc4.IfcObjectDefinition#getDecomposes <em>Decomposes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Related Objects</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Related Objects</em>' reference list.
	 * @see cn.dlb.bim.models.ifc4.Ifc4Package#getIfcRelAggregates_RelatedObjects()
	 * @see cn.dlb.bim.models.ifc4.IfcObjectDefinition#getDecomposes
	 * @model opposite="Decomposes"
	 * @generated
	 */
	EList<IfcObjectDefinition> getRelatedObjects();

} // IfcRelAggregates