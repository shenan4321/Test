package cn.dlb.bim.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cn.dlb.bim.PlatformContext;
import cn.dlb.bim.component.PlatformInitDatas;
import cn.dlb.bim.component.PlatformServer;
import cn.dlb.bim.ifc.GeometryGenerator;
import cn.dlb.bim.ifc.database.IfcModelDbException;
import cn.dlb.bim.ifc.database.IfcModelDbSession;
import cn.dlb.bim.ifc.database.OldQuery;
import cn.dlb.bim.ifc.deserializers.DeserializeException;
import cn.dlb.bim.ifc.deserializers.IfcStepDeserializer;
import cn.dlb.bim.ifc.emf.IfcModelInterface;
import cn.dlb.bim.ifc.emf.IfcModelInterfaceException;
import cn.dlb.bim.ifc.emf.PackageMetaData;
import cn.dlb.bim.ifc.emf.Schema;
import cn.dlb.bim.ifc.engine.IRenderEngine;
import cn.dlb.bim.ifc.engine.RenderEngineException;
import cn.dlb.bim.ifc.model.BasicIfcModel;
import cn.dlb.bim.ifc.serializers.IfcStepSerializer;
import cn.dlb.bim.models.geometry.GeometryInfo;
import cn.dlb.bim.models.ifc2x3tc1.IfcProduct;
import cn.dlb.bim.service.IBimService;
import cn.dlb.bim.vo.GeometryInfoVo;

@Service("BimService")
public class BimServiceImpl implements IBimService {

	@Autowired
	@Qualifier("PlatformServer")
	private PlatformServer server;

	@Override
	public List<GeometryInfoVo> queryDbGeometryInfo(Integer rid) {
		PackageMetaData packageMetaData = server.getMetaDataManager()
				.getPackageMetaData(Schema.IFC2X3TC1.getEPackageName());
		PlatformInitDatas platformInitDatas = server.getPlatformInitDatas();
		IfcModelDbSession session = new IfcModelDbSession(server.getIfcModelDao(), server.getMetaDataManager(), platformInitDatas);
		BasicIfcModel model = new BasicIfcModel(packageMetaData);
		try {
			session.get(rid, model, new OldQuery(packageMetaData, true));
		} catch (IfcModelDbException e) {
			e.printStackTrace();
		} catch (IfcModelInterfaceException e) {
			e.printStackTrace();
		}

		List<GeometryInfoVo> geometryList = new ArrayList<>();

		for (IfcProduct ifcProduct : model.getAllWithSubTypes(IfcProduct.class)) {
			if (ifcProduct.getRepresentation() != null
					&& ifcProduct.getRepresentation().getRepresentations().size() != 0) {

				GeometryInfoVo adaptor = new GeometryInfoVo();
				boolean flag = adaptor.adapt(ifcProduct);
				if (flag) {
					geometryList.add(adaptor);
				}
			}
		}

		return geometryList;
	}

	@Override
	public List<IfcModelInterface> queryAllIfcModel() {

		Schema schema = Schema.IFC2X3TC1;
		File[] ifcFiles = getIfcFileList();

		List<IfcModelInterface> modelList = new ArrayList<>();

		for (File file : ifcFiles) {

			IfcStepDeserializer deserializer = server.getSerializationManager().createIfcStepDeserializer(schema);
			IfcStepSerializer serializer = server.getSerializationManager().createIfcStepSerializer(schema);

			try {
				deserializer.read(file);
				IfcModelInterface model = deserializer.getModel();

				IRenderEngine renderEngine = server.getRenderEngineFactory()
						.createRenderEngine(schema.getEPackageName());

				GeometryGenerator generator = new GeometryGenerator(model, serializer, renderEngine);
				generator.generateForAllElements();

				modelList.add(model);
			} catch (DeserializeException e) {
				e.printStackTrace();
			} catch (RenderEngineException e) {
				e.printStackTrace();
			}

		}
		return modelList;
	}

	@Override
	public List<GeometryInfoVo> queryGeometryInfo() {

		Schema schema = Schema.IFC2X3TC1;
		File[] ifcFiles = getIfcFileList();

		List<GeometryInfoVo> geometryList = new ArrayList<>();

		if (ifcFiles == null) {
			return geometryList;
		}

		IfcStepDeserializer deserializer = server.getSerializationManager().createIfcStepDeserializer(schema);
		IfcStepSerializer serializer = server.getSerializationManager().createIfcStepSerializer(schema);

		try {
			deserializer.read(ifcFiles[0]);
			IfcModelInterface model = deserializer.getModel();

			IRenderEngine renderEngine = server.getRenderEngineFactory().createRenderEngine(schema.getEPackageName());

			GeometryGenerator generator = new GeometryGenerator(model, serializer, renderEngine);
			generator.generateForAllElements();

			for (IfcProduct ifcProduct : model.getAllWithSubTypes(IfcProduct.class)) {
				if (ifcProduct.getRepresentation() != null
						&& ifcProduct.getRepresentation().getRepresentations().size() != 0) {

					GeometryInfoVo adaptor = new GeometryInfoVo();
					boolean flag = adaptor.adapt(ifcProduct);
					if (flag) {
						geometryList.add(adaptor);
					}
				}
			}
		} catch (DeserializeException e) {
			e.printStackTrace();
		} catch (RenderEngineException e) {
			e.printStackTrace();
		}

		return geometryList;
	}

	public File[] getIfcFileList() {
		File dir = PlatformContext.getClassRootPath().resolve("file/").toAbsolutePath().toFile();
		if (dir.isDirectory()) {
			return dir.listFiles();
		}
		return null;
	}

	@Override
	public int deserializeModelFileAndSave(File modelFile) {

		Schema schema = Schema.IFC2X3TC1;

		IfcStepDeserializer deserializer = server.getSerializationManager().createIfcStepDeserializer(schema);
		IfcStepSerializer serializer = server.getSerializationManager().createIfcStepSerializer(schema);
		int rid = -1;
		try {
			long startTime = System.currentTimeMillis();
			deserializer.read(modelFile);
			long endTime = System.currentTimeMillis();
			
			System.out.println("deserialize time : " + (endTime - startTime) + "millis");
			
			IfcModelInterface model = deserializer.getModel();

			IRenderEngine renderEngine = server.getRenderEngineFactory().createRenderEngine(schema.getEPackageName());

			GeometryGenerator generator = new GeometryGenerator(model, serializer, renderEngine);
			generator.generateForAllElements();
			long endTime1 = System.currentTimeMillis();
			System.out.println("render time : " + (endTime1 - endTime) + "millis");
			PlatformInitDatas platformInitDatas = server.getPlatformInitDatas();
			model.fixOids(platformInitDatas);
			IfcModelDbSession session = new IfcModelDbSession(server.getIfcModelDao(), server.getMetaDataManager(), platformInitDatas);
			session.saveIfcModel(model);
			rid = model.getModelMetaData().getRevisionId();
		} catch (DeserializeException e) {
			e.printStackTrace();
		} catch (RenderEngineException e) {
			e.printStackTrace();
		} catch (IfcModelDbException e) {
			e.printStackTrace();
		}

		return rid;
	}

}
