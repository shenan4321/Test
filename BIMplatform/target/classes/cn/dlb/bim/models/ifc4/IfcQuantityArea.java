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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Quantity Area</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link cn.dlb.bim.models.ifc4.IfcQuantityArea#getAreaValue <em>Area Value</em>}</li>
 *   <li>{@link cn.dlb.bim.models.ifc4.IfcQuantityArea#getAreaValueAsString <em>Area Value As String</em>}</li>
 *   <li>{@link cn.dlb.bim.models.ifc4.IfcQuantityArea#getFormula <em>Formula</em>}</li>
 * </ul>
 *
 * @see cn.dlb.bim.models.ifc4.Ifc4Package#getIfcQuantityArea()
 * @model
 * @generated
 */
public interface IfcQuantityArea extends IfcPhysicalSimpleQuantity {
	/**
	 * Returns the value of the '<em><b>Area Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Area Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Area Value</em>' attribute.
	 * @see #setAreaValue(double)
	 * @see cn.dlb.bim.models.ifc4.Ifc4Package#getIfcQuantityArea_AreaValue()
	 * @model
	 * @generated
	 */
	double getAreaValue();

	/**
	 * Sets the value of the '{@link cn.dlb.bim.models.ifc4.IfcQuantityArea#getAreaValue <em>Area Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Area Value</em>' attribute.
	 * @see #getAreaValue()
	 * @generated
	 */
	void setAreaValue(double value);

	/**
	 * Returns the value of the '<em><b>Area Value As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Area Value As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Area Value As String</em>' attribute.
	 * @see #setAreaValueAsString(String)
	 * @see cn.dlb.bim.models.ifc4.Ifc4Package#getIfcQuantityArea_AreaValueAsString()
	 * @model
	 * @generated
	 */
	String getAreaValueAsString();

	/**
	 * Sets the value of the '{@link cn.dlb.bim.models.ifc4.IfcQuantityArea#getAreaValueAsString <em>Area Value As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Area Value As String</em>' attribute.
	 * @see #getAreaValueAsString()
	 * @generated
	 */
	void setAreaValueAsString(String value);

	/**
	 * Returns the value of the '<em><b>Formula</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Formula</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Formula</em>' attribute.
	 * @see #isSetFormula()
	 * @see #unsetFormula()
	 * @see #setFormula(String)
	 * @see cn.dlb.bim.models.ifc4.Ifc4Package#getIfcQuantityArea_Formula()
	 * @model unsettable="true"
	 * @generated
	 */
	String getFormula();

	/**
	 * Sets the value of the '{@link cn.dlb.bim.models.ifc4.IfcQuantityArea#getFormula <em>Formula</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Formula</em>' attribute.
	 * @see #isSetFormula()
	 * @see #unsetFormula()
	 * @see #getFormula()
	 * @generated
	 */
	void setFormula(String value);

	/**
	 * Unsets the value of the '{@link cn.dlb.bim.models.ifc4.IfcQuantityArea#getFormula <em>Formula</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFormula()
	 * @see #getFormula()
	 * @see #setFormula(String)
	 * @generated
	 */
	void unsetFormula();

	/**
	 * Returns whether the value of the '{@link cn.dlb.bim.models.ifc4.IfcQuantityArea#getFormula <em>Formula</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Formula</em>' attribute is set.
	 * @see #unsetFormula()
	 * @see #getFormula()
	 * @see #setFormula(String)
	 * @generated
	 */
	boolean isSetFormula();

} // IfcQuantityArea