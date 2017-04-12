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

import cn.dlb.bim.ifc.emf.IdEObjectImpl;
import cn.dlb.bim.models.ifc4.Ifc4Package;
import cn.dlb.bim.models.ifc4.IfcApplication;
import cn.dlb.bim.models.ifc4.IfcChangeActionEnum;
import cn.dlb.bim.models.ifc4.IfcOwnerHistory;
import cn.dlb.bim.models.ifc4.IfcPersonAndOrganization;
import cn.dlb.bim.models.ifc4.IfcStateEnum;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Owner History</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link cn.dlb.bim.models.ifc4.impl.IfcOwnerHistoryImpl#getOwningUser <em>Owning User</em>}</li>
 *   <li>{@link cn.dlb.bim.models.ifc4.impl.IfcOwnerHistoryImpl#getOwningApplication <em>Owning Application</em>}</li>
 *   <li>{@link cn.dlb.bim.models.ifc4.impl.IfcOwnerHistoryImpl#getState <em>State</em>}</li>
 *   <li>{@link cn.dlb.bim.models.ifc4.impl.IfcOwnerHistoryImpl#getChangeAction <em>Change Action</em>}</li>
 *   <li>{@link cn.dlb.bim.models.ifc4.impl.IfcOwnerHistoryImpl#getLastModifiedDate <em>Last Modified Date</em>}</li>
 *   <li>{@link cn.dlb.bim.models.ifc4.impl.IfcOwnerHistoryImpl#getLastModifyingUser <em>Last Modifying User</em>}</li>
 *   <li>{@link cn.dlb.bim.models.ifc4.impl.IfcOwnerHistoryImpl#getLastModifyingApplication <em>Last Modifying Application</em>}</li>
 *   <li>{@link cn.dlb.bim.models.ifc4.impl.IfcOwnerHistoryImpl#getCreationDate <em>Creation Date</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcOwnerHistoryImpl extends IdEObjectImpl implements IfcOwnerHistory {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcOwnerHistoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_OWNER_HISTORY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPersonAndOrganization getOwningUser() {
		return (IfcPersonAndOrganization) eGet(Ifc4Package.Literals.IFC_OWNER_HISTORY__OWNING_USER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwningUser(IfcPersonAndOrganization newOwningUser) {
		eSet(Ifc4Package.Literals.IFC_OWNER_HISTORY__OWNING_USER, newOwningUser);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcApplication getOwningApplication() {
		return (IfcApplication) eGet(Ifc4Package.Literals.IFC_OWNER_HISTORY__OWNING_APPLICATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwningApplication(IfcApplication newOwningApplication) {
		eSet(Ifc4Package.Literals.IFC_OWNER_HISTORY__OWNING_APPLICATION, newOwningApplication);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcStateEnum getState() {
		return (IfcStateEnum) eGet(Ifc4Package.Literals.IFC_OWNER_HISTORY__STATE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setState(IfcStateEnum newState) {
		eSet(Ifc4Package.Literals.IFC_OWNER_HISTORY__STATE, newState);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetState() {
		eUnset(Ifc4Package.Literals.IFC_OWNER_HISTORY__STATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetState() {
		return eIsSet(Ifc4Package.Literals.IFC_OWNER_HISTORY__STATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcChangeActionEnum getChangeAction() {
		return (IfcChangeActionEnum) eGet(Ifc4Package.Literals.IFC_OWNER_HISTORY__CHANGE_ACTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChangeAction(IfcChangeActionEnum newChangeAction) {
		eSet(Ifc4Package.Literals.IFC_OWNER_HISTORY__CHANGE_ACTION, newChangeAction);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetChangeAction() {
		eUnset(Ifc4Package.Literals.IFC_OWNER_HISTORY__CHANGE_ACTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetChangeAction() {
		return eIsSet(Ifc4Package.Literals.IFC_OWNER_HISTORY__CHANGE_ACTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getLastModifiedDate() {
		return (Long) eGet(Ifc4Package.Literals.IFC_OWNER_HISTORY__LAST_MODIFIED_DATE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastModifiedDate(long newLastModifiedDate) {
		eSet(Ifc4Package.Literals.IFC_OWNER_HISTORY__LAST_MODIFIED_DATE, newLastModifiedDate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLastModifiedDate() {
		eUnset(Ifc4Package.Literals.IFC_OWNER_HISTORY__LAST_MODIFIED_DATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLastModifiedDate() {
		return eIsSet(Ifc4Package.Literals.IFC_OWNER_HISTORY__LAST_MODIFIED_DATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPersonAndOrganization getLastModifyingUser() {
		return (IfcPersonAndOrganization) eGet(Ifc4Package.Literals.IFC_OWNER_HISTORY__LAST_MODIFYING_USER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastModifyingUser(IfcPersonAndOrganization newLastModifyingUser) {
		eSet(Ifc4Package.Literals.IFC_OWNER_HISTORY__LAST_MODIFYING_USER, newLastModifyingUser);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLastModifyingUser() {
		eUnset(Ifc4Package.Literals.IFC_OWNER_HISTORY__LAST_MODIFYING_USER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLastModifyingUser() {
		return eIsSet(Ifc4Package.Literals.IFC_OWNER_HISTORY__LAST_MODIFYING_USER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcApplication getLastModifyingApplication() {
		return (IfcApplication) eGet(Ifc4Package.Literals.IFC_OWNER_HISTORY__LAST_MODIFYING_APPLICATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastModifyingApplication(IfcApplication newLastModifyingApplication) {
		eSet(Ifc4Package.Literals.IFC_OWNER_HISTORY__LAST_MODIFYING_APPLICATION, newLastModifyingApplication);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLastModifyingApplication() {
		eUnset(Ifc4Package.Literals.IFC_OWNER_HISTORY__LAST_MODIFYING_APPLICATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLastModifyingApplication() {
		return eIsSet(Ifc4Package.Literals.IFC_OWNER_HISTORY__LAST_MODIFYING_APPLICATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getCreationDate() {
		return (Long) eGet(Ifc4Package.Literals.IFC_OWNER_HISTORY__CREATION_DATE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreationDate(long newCreationDate) {
		eSet(Ifc4Package.Literals.IFC_OWNER_HISTORY__CREATION_DATE, newCreationDate);
	}

} //IfcOwnerHistoryImpl