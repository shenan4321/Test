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

import cn.dlb.bim.models.store.ObjectIDMPluginConfiguration;
import cn.dlb.bim.models.store.RenderEnginePluginConfiguration;
import cn.dlb.bim.models.store.SerializerPluginConfiguration;
import cn.dlb.bim.models.store.StorePackage;
import cn.dlb.bim.models.store.UserSettings;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Serializer Plugin Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link cn.dlb.bim.models.store.impl.SerializerPluginConfigurationImpl#getObjectIDM <em>Object IDM</em>}</li>
 *   <li>{@link cn.dlb.bim.models.store.impl.SerializerPluginConfigurationImpl#getUserSettings <em>User Settings</em>}</li>
 *   <li>{@link cn.dlb.bim.models.store.impl.SerializerPluginConfigurationImpl#getRenderEngine <em>Render Engine</em>}</li>
 *   <li>{@link cn.dlb.bim.models.store.impl.SerializerPluginConfigurationImpl#isStreaming <em>Streaming</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SerializerPluginConfigurationImpl extends PluginConfigurationImpl implements SerializerPluginConfiguration {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SerializerPluginConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StorePackage.Literals.SERIALIZER_PLUGIN_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectIDMPluginConfiguration getObjectIDM() {
		return (ObjectIDMPluginConfiguration) eGet(StorePackage.Literals.SERIALIZER_PLUGIN_CONFIGURATION__OBJECT_IDM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObjectIDM(ObjectIDMPluginConfiguration newObjectIDM) {
		eSet(StorePackage.Literals.SERIALIZER_PLUGIN_CONFIGURATION__OBJECT_IDM, newObjectIDM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UserSettings getUserSettings() {
		return (UserSettings) eGet(StorePackage.Literals.SERIALIZER_PLUGIN_CONFIGURATION__USER_SETTINGS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserSettings(UserSettings newUserSettings) {
		eSet(StorePackage.Literals.SERIALIZER_PLUGIN_CONFIGURATION__USER_SETTINGS, newUserSettings);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RenderEnginePluginConfiguration getRenderEngine() {
		return (RenderEnginePluginConfiguration) eGet(StorePackage.Literals.SERIALIZER_PLUGIN_CONFIGURATION__RENDER_ENGINE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRenderEngine(RenderEnginePluginConfiguration newRenderEngine) {
		eSet(StorePackage.Literals.SERIALIZER_PLUGIN_CONFIGURATION__RENDER_ENGINE, newRenderEngine);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isStreaming() {
		return (Boolean) eGet(StorePackage.Literals.SERIALIZER_PLUGIN_CONFIGURATION__STREAMING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStreaming(boolean newStreaming) {
		eSet(StorePackage.Literals.SERIALIZER_PLUGIN_CONFIGURATION__STREAMING, newStreaming);
	}

} //SerializerPluginConfigurationImpl
