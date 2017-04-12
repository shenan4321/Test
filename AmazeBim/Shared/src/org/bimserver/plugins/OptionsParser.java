package org.bimserver.plugins;

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

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class OptionsParser {
	private Path[] pluginDirectories;

	public OptionsParser(String... args) {
		Options options = new Options();

		options.addOption("plugins", true, "Directory from which to load plugins");
		
		CommandLineParser parser = new DefaultParser();
		pluginDirectories = null;
		try {
			CommandLine cmd = parser.parse(options, args);
			if (cmd.hasOption("plugins")) {
				String[] plugins = cmd.getOptionValues("plugins");
				pluginDirectories = new Path[plugins.length];
				for (int i=0; i<plugins.length; i++) {
					pluginDirectories[i] = Paths.get(plugins[i]);
					if (!Files.isDirectory(pluginDirectories[i])) {
						throw new RuntimeException("plugins parameter must point to a directory (" + pluginDirectories[i] + ")");
					}
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public Path[] getPluginDirectories() {
		return pluginDirectories;
	}
}
