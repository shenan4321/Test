package org.bimserver.client;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

import org.bimserver.client.json.JsonBimServerClientFactory;
import org.bimserver.interfaces.objects.SBimServerInfo;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SQueryEnginePluginConfiguration;
import org.bimserver.plugins.services.Flow;
import org.bimserver.shared.ChannelConnectionException;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.BimServerClientException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.meta.SServicesMap;

public class ClientRunner {
    public static void main(String[] args) {
        try {
//            JsonBimServerClientFactory factory = new JsonBimServerClientFactory("http://localhost:8080");
//            BimServerClient client = factory.create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			JsonBimServerClientFactory factory = new JsonBimServerClientFactory("http://localhost:8080");
			BimServerClient client = factory.create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
            doSomethingWithClient(client);
        } catch (BimServerClientException e) {
            e.printStackTrace();
        } catch (ServiceException e) {
            e.printStackTrace();
        } catch (ChannelConnectionException e) {
            e.printStackTrace();
        }
    }
    
	public static void doSomethingWithClient(BimServerClient client) {
		try {
			String randomName = "Random " + new Random().nextLong();
			
//			// Create a new project with a random name
			SProject project = client.getServiceInterface().addProject(randomName, "ifc2x3tc1");
//			
			long poid = project.getOid();
			String comment = "This is a comment";
			
			SServicesMap serverMap = client.getServicesMap();
//			serverMap.getByName(name)
			
			SDeserializerPluginConfiguration deserializerByName = client.getServiceInterface().getDeserializerByName("IfcStepDeserializer");
			
			// Make sure you change this to a path to a local IFC file
			Path demoIfcFile = Paths.get("file/huahuatest.ifc");
			
			// Here we actually checkin the IFC file. Flow.SYNC indicates that we only want to continue the code-flow after the checkin has been completed
			client.checkin(poid, comment, deserializerByName.getOid(), false, Flow.SYNC, demoIfcFile);
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (UserException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
