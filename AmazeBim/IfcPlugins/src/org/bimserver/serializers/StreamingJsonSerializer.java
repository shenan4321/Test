package org.bimserver.serializers;

/******************************************************************************
 * Copyright (C) 2009-2016  BIMserver.org
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
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import java.io.InputStream;
import java.io.OutputStream;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.emf.SharedJsonStreamingSerializer;
import org.bimserver.models.store.IfcHeader;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginManagerInterface;
import org.bimserver.plugins.serializers.ObjectProvider;
import org.bimserver.plugins.serializers.ProjectInfo;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.plugins.serializers.SerializerInputstream;
import org.bimserver.plugins.serializers.StreamingReader;
import org.bimserver.plugins.serializers.StreamingSerializer;

public class StreamingJsonSerializer implements StreamingSerializer, StreamingReader {

	private ObjectProvider objectProvider;
	private IfcHeader ifcHeader;
	private PluginConfiguration pluginConfiguration;
	private SharedJsonStreamingSerializer sharedJsonStreamingSerializer;

	public StreamingJsonSerializer(PluginConfiguration pluginConfiguration) {
		this.pluginConfiguration = pluginConfiguration;
	}

	@Override
	public void init(ObjectProvider objectProvider, ProjectInfo projectInfo, IfcHeader ifcHeader, PluginManagerInterface pluginManager, PackageMetaData packageMetaData) throws SerializerException {
		this.objectProvider = objectProvider;
		this.ifcHeader = ifcHeader;
		sharedJsonStreamingSerializer = new SharedJsonStreamingSerializer(objectProvider, ifcHeader, true);
	}

	@Override
	public void writeToOutputStream(OutputStream outputStream) throws SerializerException, BimserverDatabaseException {
		
		boolean result = sharedJsonStreamingSerializer.write(outputStream);
		while (result) {
			result = sharedJsonStreamingSerializer.write(outputStream);
		}
	}

	@Override
	public InputStream getInputStream() {
		return new SerializerInputstream(this);
	}

	@Override
	public boolean write(OutputStream out) throws SerializerException, BimserverDatabaseException {
		return sharedJsonStreamingSerializer.write(out);
	}
}