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

import javax.activation.DataHandler;

import org.eclipse.emf.ecore.EClass;

import cn.dlb.bim.ifc.emf.IdEObjectImpl;
import cn.dlb.bim.models.store.DownloadResult;
import cn.dlb.bim.models.store.StorePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Download Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link cn.dlb.bim.models.store.impl.DownloadResultImpl#getProjectName <em>Project Name</em>}</li>
 *   <li>{@link cn.dlb.bim.models.store.impl.DownloadResultImpl#getRevisionNr <em>Revision Nr</em>}</li>
 *   <li>{@link cn.dlb.bim.models.store.impl.DownloadResultImpl#getFile <em>File</em>}</li>
 *   <li>{@link cn.dlb.bim.models.store.impl.DownloadResultImpl#getSerializerOid <em>Serializer Oid</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DownloadResultImpl extends IdEObjectImpl implements DownloadResult {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DownloadResultImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StorePackage.Literals.DOWNLOAD_RESULT;
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
	public String getProjectName() {
		return (String) eGet(StorePackage.Literals.DOWNLOAD_RESULT__PROJECT_NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProjectName(String newProjectName) {
		eSet(StorePackage.Literals.DOWNLOAD_RESULT__PROJECT_NAME, newProjectName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getRevisionNr() {
		return (Integer) eGet(StorePackage.Literals.DOWNLOAD_RESULT__REVISION_NR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRevisionNr(Integer newRevisionNr) {
		eSet(StorePackage.Literals.DOWNLOAD_RESULT__REVISION_NR, newRevisionNr);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataHandler getFile() {
		return (DataHandler) eGet(StorePackage.Literals.DOWNLOAD_RESULT__FILE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFile(DataHandler newFile) {
		eSet(StorePackage.Literals.DOWNLOAD_RESULT__FILE, newFile);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getSerializerOid() {
		return (Long) eGet(StorePackage.Literals.DOWNLOAD_RESULT__SERIALIZER_OID, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSerializerOid(long newSerializerOid) {
		eSet(StorePackage.Literals.DOWNLOAD_RESULT__SERIALIZER_OID, newSerializerOid);
	}

} //DownloadResultImpl
