package org.bimserver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.activation.DataHandler;

import org.bimserver.database.DatabaseRestartRequiredException;
import org.bimserver.database.berkeley.DatabaseInitException;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.plugins.OptionsParser;
import org.bimserver.plugins.serializers.SerializerPlugin;
import org.bimserver.shared.LocalDevelopmentResourceFetcher;
import org.bimserver.shared.exceptions.PluginException;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.interfaces.AdminInterface;
import org.bimserver.shared.interfaces.AuthInterface;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.bimserver.shared.interfaces.SettingsInterface;
import org.bimserver.utils.FileDataSource;
import org.bimserver.webservices.ServiceMap;
import org.bimserver.webservices.authorization.SystemAuthorization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LocalDevBimServerStarter {
	private static final Logger LOGGER = LoggerFactory.getLogger(LocalDevBimServerStarter.class);
	private BimServer bimServer;
	
	public static void main(String[] args) {
		new LocalDevBimServerStarter().start(-1, "localhost", 8080, 8085, new OptionsParser(args).getPluginDirectories());
//		new LocalDevBimServerStarter().start(2, "localhost", 8081, 8086, gitDir);
	}

	public void start(int id, String address, int port, int pbport, Path[] pluginDirectories) {
		BimServerConfig config = new BimServerConfig();
		config.setHomeDir(Paths.get("home" + (id == -1 ? "" : id)));
		config.setResourceFetcher(new LocalDevelopmentResourceFetcher(Paths.get("../")));
		config.setStartEmbeddedWebServer(true);
		config.setClassPath(System.getProperty("java.class.path"));
		config.setLocalDev(true);
		config.setPort(port);
		config.setStartCommandLine(true);
		config.setDevelopmentBaseDir(Paths.get("../BimServer"));
		bimServer = new BimServer(config);
		bimServer.getVersionChecker().getLocalVersion().setDate(new Date());
		bimServer.setEmbeddedWebServer(new EmbeddedWebServer(bimServer, config.getDevelopmentBaseDir(), config.isLocalDev()));
		try {
			bimServer.start();
			LocalDevPluginLoader.loadPlugins(bimServer.getPluginManager(), pluginDirectories);
			try {
				AdminInterface adminInterface = bimServer.getServiceFactory().get(new SystemAuthorization(1, TimeUnit.HOURS), AccessMethod.INTERNAL).get(AdminInterface.class);
				adminInterface.setup("http://localhost:" + port, "My BIMserver", "My Description", "http://localhost:" + port + "/img/bimserver.png", "Administrator", "admin@bimserver.org", "admin");
				SettingsInterface settingsInterface = bimServer.getServiceFactory().get(new SystemAuthorization(1, TimeUnit.HOURS), AccessMethod.INTERNAL).get(SettingsInterface.class);
				settingsInterface.setCacheOutputFiles(true);
				settingsInterface.setPluginStrictVersionChecking(true);
			} catch (Exception e) {
				// Ignore
			}
			
			bimServer.activateServices();
			
		} catch (PluginException e) {
			LOGGER.error("", e);
		} catch (ServiceException e) {
			LOGGER.error("", e);
		} catch (DatabaseInitException e) {
			LOGGER.error("", e);
		} catch (BimserverDatabaseException e) {
			LOGGER.error("", e);
		} catch (DatabaseRestartRequiredException e) {
			LOGGER.error("", e);
		}
	}

	public BimServer getBimServer() {
		return bimServer;
	}
}