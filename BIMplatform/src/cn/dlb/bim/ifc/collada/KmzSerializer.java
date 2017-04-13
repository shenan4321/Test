package cn.dlb.bim.ifc.collada;

/******************************************************************************
 * Copyright (C) 2009-2017  BIMserver.org
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

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.dlb.bim.ifc.emf.IfcModelInterface;
import cn.dlb.bim.ifc.emf.ProjectInfo;
import cn.dlb.bim.ifc.serializers.EmfSerializer;
import cn.dlb.bim.ifc.serializers.SerializerException;
import cn.dlb.bim.ifc.shared.ProgressReporter;
import cn.dlb.bim.utils.UTF8PrintWriter;

public class KmzSerializer extends EmfSerializer {

	private static final Logger LOGGER = LoggerFactory.getLogger(KmzSerializer.class);
	private ColladaSerializer ifcToCollada;

	@Override
	public void init(IfcModelInterface model, ProjectInfo projectInfo, boolean normalizeOids) throws SerializerException {
		super.init(model, projectInfo, normalizeOids);
		try {
			ifcToCollada = new ColladaSerializer();
			ifcToCollada.init(model, projectInfo, normalizeOids);
		} catch (SerializerException e) {
			throw new SerializerException(e);
		}
	}

	@Override
	public boolean write(OutputStream out, ProgressReporter progressReporter) throws SerializerException {
		if (getMode() == Mode.BODY) {
			try {
				ZipOutputStream zipOutputStream = new ZipOutputStream(out);
				zipOutputStream.putNextEntry(new ZipEntry("doc.kml"));
				writeKmlFile(zipOutputStream);
				zipOutputStream.closeEntry();
				zipOutputStream.putNextEntry(new ZipEntry("files/collada.dae"));
				ifcToCollada.write(zipOutputStream, null);
				zipOutputStream.closeEntry();
				zipOutputStream.finish();
				zipOutputStream.flush();
			} catch (IOException e) {
				LOGGER.error("", e);
			}
			setMode(Mode.FINISHED);
			return true;
		} else if (getMode() == Mode.HEADER) {
			setMode(Mode.BODY);
			return true;
		} else if (getMode() == Mode.FINISHED) {
			return false;
		}
		return false;
	}

	@SuppressWarnings("resource")
	private void writeKmlFile(OutputStream out) {
		PrintWriter writer = new UTF8PrintWriter(out);
		writer.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		writer.println("<kml xmlns=\"http://www.opengis.net/kml/2.2\">");
		writer.println("<Placemark>");
		writer.println("	<name>" + (getProjectInfo() != null ? getProjectInfo().getName() : "") + "</name>");
		writer.println("	<description>" + (getProjectInfo() != null ? getProjectInfo().getDescription() : "") + "</description>");
		writer.println("	<LookAt>");
		writer.println("		<longitude>" + (getProjectInfo() != null ? getProjectInfo().getX() : "0") + "</longitude>");
		writer.println("		<latitude>" + (getProjectInfo() != null ? getProjectInfo().getY() : "0") + "</latitude>");
		writer.println("		<altitude>0</altitude>");
		writer.println("		<heading>-27.70337734057933</heading>");
		writer.println("		<tilt>65.74454495876547</tilt>");
		writer.println("		<range>127.2393107680517</range>");
		writer.println("	</LookAt>");
		writer.println("	<Model id=\"model_4\">");
		writer.println("		<altitudeMode>relativeToGround</altitudeMode>");
		writer.println("		<Location>");
		writer.println("			<longitude>" + (getProjectInfo() != null ? getProjectInfo().getX() : "0") + "</longitude>");
		writer.println("			<latitude>" + (getProjectInfo() != null ? getProjectInfo().getY() : "0") + "</latitude>");
		writer.println("			<altitude>" + (getProjectInfo() != null ? getProjectInfo().getZ() : "0") + "</altitude>");
		writer.println("		</Location>");
		writer.println("		<Orientation>");
		writer.println("			<heading>" + (getProjectInfo() != null ? getProjectInfo().getDirectionAngle() : "") + "</heading>");
		writer.println("			<tilt>0</tilt>");
		writer.println("			<roll>0</roll>");
		writer.println("		</Orientation>");
		writer.println("		<Scale>");
		writer.println("			<x>1</x>");
		writer.println("			<y>1</y>");
		writer.println("			<z>1</z>");
		writer.println("		</Scale>");
		writer.println("		<Link>");
		writer.println("			<href>vxvxcvcx (15).kmz/files/collada.dae</href>");
		writer.println("		</Link>");
		writer.println("		<ResourceMap>");
//		writer.println("			<Alias>");
//		writer.println("				<targetHref>../files/collada.dae</targetHref>");
//		writer.println("				<sourceHref>../files/collada.dae</sourceHref>");
//		writer.println("			</Alias>");
		writer.println("		</ResourceMap>");
		writer.println("	</Model>");
		writer.println("</Placemark>");
		writer.println("</kml>");
		writer.flush();
		// Don't close it, because we are writing to a zip stream
	}
}