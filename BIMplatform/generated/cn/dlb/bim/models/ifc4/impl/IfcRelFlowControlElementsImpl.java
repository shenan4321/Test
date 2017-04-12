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
import cn.dlb.bim.models.ifc4.IfcDistributionControlElement;
import cn.dlb.bim.models.ifc4.IfcDistributionFlowElement;
import cn.dlb.bim.models.ifc4.IfcRelFlowControlElements;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Rel Flow Control Elements</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link cn.dlb.bim.models.ifc4.impl.IfcRelFlowControlElementsImpl#getRelatedControlElements <em>Related Control Elements</em>}</li>
 *   <li>{@link cn.dlb.bim.models.ifc4.impl.IfcRelFlowControlElementsImpl#getRelatingFlowElement <em>Relating Flow Element</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcRelFlowControlElementsImpl extends IfcRelConnectsImpl implements IfcRelFlowControlElements {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcRelFlowControlElementsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_REL_FLOW_CONTROL_ELEMENTS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcDistributionControlElement> getRelatedControlElements() {
		return (EList<IfcDistributionControlElement>) eGet(Ifc4Package.Literals.IFC_REL_FLOW_CONTROL_ELEMENTS__RELATED_CONTROL_ELEMENTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDistributionFlowElement getRelatingFlowElement() {
		return (IfcDistributionFlowElement) eGet(Ifc4Package.Literals.IFC_REL_FLOW_CONTROL_ELEMENTS__RELATING_FLOW_ELEMENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelatingFlowElement(IfcDistributionFlowElement newRelatingFlowElement) {
		eSet(Ifc4Package.Literals.IFC_REL_FLOW_CONTROL_ELEMENTS__RELATING_FLOW_ELEMENT, newRelatingFlowElement);
	}

} //IfcRelFlowControlElementsImpl