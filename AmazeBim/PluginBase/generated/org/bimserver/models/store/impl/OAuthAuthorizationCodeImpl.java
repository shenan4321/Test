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
package org.bimserver.models.store.impl;

import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.models.store.Authorization;
import org.bimserver.models.store.OAuthAuthorizationCode;
import org.bimserver.models.store.OAuthServer;
import org.bimserver.models.store.StorePackage;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>OAuth Authorization Code</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.store.impl.OAuthAuthorizationCodeImpl#getOauthServer <em>Oauth Server</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.OAuthAuthorizationCodeImpl#getCode <em>Code</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.OAuthAuthorizationCodeImpl#getAuthorization <em>Authorization</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OAuthAuthorizationCodeImpl extends IdEObjectImpl implements OAuthAuthorizationCode {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OAuthAuthorizationCodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StorePackage.Literals.OAUTH_AUTHORIZATION_CODE;
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
	public OAuthServer getOauthServer() {
		return (OAuthServer) eGet(StorePackage.Literals.OAUTH_AUTHORIZATION_CODE__OAUTH_SERVER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOauthServer(OAuthServer newOauthServer) {
		eSet(StorePackage.Literals.OAUTH_AUTHORIZATION_CODE__OAUTH_SERVER, newOauthServer);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCode() {
		return (String) eGet(StorePackage.Literals.OAUTH_AUTHORIZATION_CODE__CODE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCode(String newCode) {
		eSet(StorePackage.Literals.OAUTH_AUTHORIZATION_CODE__CODE, newCode);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Authorization getAuthorization() {
		return (Authorization) eGet(StorePackage.Literals.OAUTH_AUTHORIZATION_CODE__AUTHORIZATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAuthorization(Authorization newAuthorization) {
		eSet(StorePackage.Literals.OAUTH_AUTHORIZATION_CODE__AUTHORIZATION, newAuthorization);
	}

} //OAuthAuthorizationCodeImpl
