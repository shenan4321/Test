package cn.dlb.bim.ifc.serializers;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.slf4j.LoggerFactory;

import com.google.common.base.Charsets;

import cn.dlb.bim.ifc.deserializers.IfcParserWriterUtils;
import cn.dlb.bim.ifc.emf.IdEObject;
import cn.dlb.bim.ifc.model.IfcHeader;
import cn.dlb.bim.ifc.shared.ProgressReporter;
import cn.dlb.bim.utils.StringUtils;
import nl.tue.buildingsmart.schema.EntityDefinition;

public abstract class IfcStepSerializer extends IfcSerializer {
	private static final byte[] NEW_LINE = "\n".getBytes(Charsets.UTF_8);
	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(IfcStepSerializer.class);
	private static final EcorePackage ECORE_PACKAGE_INSTANCE = EcorePackage.eINSTANCE;
	private static final String NULL = "NULL";
	private static final String OPEN_CLOSE_PAREN = "()";
	private static final String ASTERISK = "*";
	private static final String PAREN_CLOSE_SEMICOLON = ");";
	private static final String DASH = "#";
	private static final String IFC_LOGICAL = "IfcLogical";
	private static final String IFC_BOOLEAN = "IfcBoolean";
	private static final String DOT = ".";
	private static final String COMMA = ",";
	private static final String OPEN_PAREN = "(";
	private static final String CLOSE_PAREN = ")";
	private static final String BOOLEAN_UNDEFINED = ".U.";
	private static final String DOLLAR = "$";
	private static final String WRAPPED_VALUE = "wrappedValue";
	
	private Iterator<IdEObject> iterator;
	private String headerSchema;
	private long writeCounter;
	private OutputStream outputStream;

	public IfcStepSerializer() {
	}

	protected void setHeaderSchema(String headerSchema) {
		this.headerSchema = headerSchema;
	}
	
	public boolean write(OutputStream outputStream, ProgressReporter progressReporter) throws SerializerException {
		try {
			this.outputStream = outputStream;
			if (getMode() == Mode.HEADER) {
				writeHeader();
				setMode(Mode.BODY);
				iterator = model.getValues().iterator();
				return true;
			} else if (getMode() == Mode.BODY) {
				if (iterator.hasNext()) {
					write(iterator.next());
					writeCounter++;
					if (progressReporter != null) {
						progressReporter.update(writeCounter, model.size());
					}
				} else {
					iterator = null;
					setMode(Mode.FOOTER);
					return write(outputStream, progressReporter);
				}
				return true;
			} else if (getMode() == Mode.FOOTER) {
				writeFooter();
				if (progressReporter != null) {
					progressReporter.update(model.size(), model.size());
				}
				setMode(Mode.FINISHED);
				return true;
			} else if (getMode() == Mode.FINISHED) {
				return false;
			}			
			return false;
		} catch (IOException e) {
			throw new SerializerException(e);
		}
	}

	private void writeFooter() throws IOException {
		println("ENDSEC;");
		println("END-ISO-10303-21;");
	}

	private void writeHeader() throws IOException {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		println("ISO-10303-21;");
		println("HEADER;");
		IfcHeader ifcHeader = getModel().getModelMetaData().getIfcHeader();
		if (ifcHeader == null) {
			Date date = new Date();
			println("FILE_DESCRIPTION ((''), '2;1');");
			println("FILE_NAME ('', '" + dateFormatter.format(date) + "', (''), (''), '', 'BIMserver', '');");
			println("FILE_SCHEMA (('" + headerSchema + "'));");
		} else {
			print("FILE_DESCRIPTION ((");
			print(StringUtils.concat(ifcHeader.getDescription(), "'", ", "));
			println("), '" + ifcHeader.getImplementationLevel() + "');");
			println("FILE_NAME ('" + ifcHeader.getFilename() + "', '" + dateFormatter.format(ifcHeader.getTimeStamp()) + "', (" + StringUtils.concat(ifcHeader.getAuthor(), "'", ", ") + "), (" + StringUtils.concat(ifcHeader.getOrganization(), "'", ", ") + "), '" + ifcHeader.getPreProcessorVersion() + "', '" + ifcHeader.getOriginatingSystem() + "', '"	+ ifcHeader.getAuthorization() + "');");

			//	println("FILE_SCHEMA (('" + ifcHeader.getIfcSchemaVersion() + "'));");
			println("FILE_SCHEMA (('" + headerSchema + "'));");
		}
		println("ENDSEC;");
		println("DATA;");
		// println("//This program comes with ABSOLUTELY NO WARRANTY.");
		// println("//This is free software, and you are welcome to redistribute it under certain conditions. See www.bimserver.org <http://www.bimserver.org>");
	}

	private void println(String line) throws IOException {
		byte[] bytes = line.getBytes(Charsets.UTF_8);
		outputStream.write(bytes, 0, bytes.length);
		outputStream.write(NEW_LINE, 0, NEW_LINE.length);
	}

	private void print(String text) throws IOException {
		byte[] bytes = text.getBytes(Charsets.UTF_8);
		outputStream.write(bytes, 0, bytes.length);
	}
	
	private void write(IdEObject object) throws SerializerException, IOException {
		EClass eClass = object.eClass();
		if (eClass.getEAnnotation("hidden") != null) {
			return;
		}
		print(DASH);
		int convertedKey = getExpressId(object);
		if (convertedKey == -1) {
			throw new SerializerException("Going to serialize an object with id -1 (" + object.eClass().getName() + ")");
		}
		print(String.valueOf(convertedKey));
		print("= ");
		String upperCase = getPackageMetaData().getUpperCase(eClass);
		if (upperCase == null) {
			throw new SerializerException("Type not found: " + eClass.getName());
		}
		print(upperCase);
		print(OPEN_PAREN);
		boolean isFirst = true;
		EntityDefinition entityBN = getPackageMetaData().getSchemaDefinition().getEntityBN(object.eClass().getName());
		for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
			if (feature.getEAnnotation("hidden") == null && (entityBN != null && (!entityBN.isDerived(feature.getName()) || entityBN.isDerivedOverride(feature.getName())))) {
				EClassifier type = feature.getEType();
				if (type instanceof EEnum) {
					if (!isFirst) {
						print(COMMA);
					}
					writeEnum(object, feature);
					isFirst = false;
				} else if (type instanceof EClass) {
					EReference eReference = (EReference)feature;
					if (!getPackageMetaData().isInverse(eReference)) {
						if (!isFirst) {
							print(COMMA);
						}
						writeEClass(object, feature);
						isFirst = false;
					}
				} else if (type instanceof EDataType) {
					if (!isFirst) {
						print(COMMA);
					}
					writeEDataType(object, entityBN, feature);
					isFirst = false;
				}
			}
		}
		println(PAREN_CLOSE_SEMICOLON);
	}

	private void writeEDataType(IdEObject object, EntityDefinition entityBN, EStructuralFeature feature) throws SerializerException, IOException {
		if (entityBN != null && entityBN.isDerived(feature.getName())) {
			print(ASTERISK);
		} else if (feature.isMany()) {
			writeList(object, feature);
		} else {
			writeObject(object, feature);
		}
	}

	private void writeEClass(IdEObject object, EStructuralFeature feature) throws SerializerException, IOException {
		Object referencedObject = object.eGet(feature);
		if (referencedObject instanceof IdEObject && ((IdEObject)referencedObject).eClass().getEAnnotation("wrapped") != null) {
			writeWrappedValue(object, feature, ((EObject)referencedObject).eClass());
		} else {
			if (referencedObject instanceof EObject && model.contains((IdEObject) referencedObject)) {
				print(DASH);
				print(String.valueOf(getExpressId((IdEObject) referencedObject)));
			} else {
				EntityDefinition entityBN = getPackageMetaData().getSchemaDefinition().getEntityBN(object.eClass().getName());
				if (entityBN != null && entityBN.isDerived(feature.getName())) {
					print(ASTERISK);
				} else if (feature.isMany()) {
					writeList(object, feature);
				} else {
					writeObject(object, feature);
				}
			}
		}
	}

	private void writeObject(IdEObject object, EStructuralFeature feature) throws SerializerException, IOException {
		Object ref = object.eGet(feature);
		if (ref == null || (feature.isUnsettable() && !object.eIsSet(feature))) {
			EClassifier type = feature.getEType();
			if (type instanceof EClass) {
				EStructuralFeature structuralFeature = ((EClass) type).getEStructuralFeature(WRAPPED_VALUE);
				if (structuralFeature != null) {
					String name = structuralFeature.getEType().getName();
					if (name.equals(IFC_BOOLEAN) || name.equals(IFC_LOGICAL) || structuralFeature.getEType() == EcorePackage.eINSTANCE.getEBoolean()) {
						print(BOOLEAN_UNDEFINED);
					} else {
						print(DOLLAR);
					}
				} else {
					print(DOLLAR);
				}
			} else {
				if (type == EcorePackage.eINSTANCE.getEBoolean()) {
					print(BOOLEAN_UNDEFINED);
				} else if (feature.isMany()) {
					print("()");
				} else {
					print(DOLLAR);
				}
			}
		} else {
			if (ref instanceof EObject) {
				writeEmbedded((EObject) ref);
			} else if (feature.getEType() == ECORE_PACKAGE_INSTANCE.getEDouble()) {
				writeDoubleValue((Double)ref, object, feature);
			} else {
				IfcParserWriterUtils.writePrimitive(ref, outputStream);
			}
		}
	}

	private void writeDoubleValue(double value, EObject object, EStructuralFeature feature) throws SerializerException, IOException {
		if (model.isUseDoubleStrings()) {
			Object stringValue = object.eGet(object.eClass().getEStructuralFeature(feature.getName() + "AsString"));
			if (stringValue != null) {
				print((String)stringValue);
				return;
			}
		}
		IfcParserWriterUtils.writePrimitive(value, outputStream);
	}

	private void writeEmbedded(EObject eObject) throws SerializerException, IOException {
		EClass class1 = eObject.eClass();
		print(getPackageMetaData().getUpperCase(class1));
		print(OPEN_PAREN);
		EStructuralFeature structuralFeature = class1.getEStructuralFeature(WRAPPED_VALUE);
		if (structuralFeature != null) {
			Object realVal = eObject.eGet(structuralFeature);
			if (structuralFeature.getEType() == ECORE_PACKAGE_INSTANCE.getEDouble()) {
				writeDoubleValue((Double)realVal, eObject, structuralFeature);
			} else {
				IfcParserWriterUtils.writePrimitive(realVal, outputStream);
			}
		}
		print(CLOSE_PAREN);
	}

	private void writeList(IdEObject object, EStructuralFeature feature) throws SerializerException, IOException {
		List<?> list = (List<?>) object.eGet(feature);
		List<?> doubleStingList = null;
		boolean listElementDouble = false;//linfujun, i change the code here to fix the bug
		if (feature.getEType() == EcorePackage.eINSTANCE.getEDouble() && model.isUseDoubleStrings()) {
			EStructuralFeature doubleStringFeature = feature.getEContainingClass().getEStructuralFeature(feature.getName() + "AsString");
			if (doubleStringFeature == null) {//linfujun,i changed it
				doubleStringFeature = feature.getEContainingClass().getEStructuralFeature(feature.getFeatureID());
				listElementDouble = true;
			}
			if (doubleStringFeature == null) {
				throw new SerializerException("Field " + feature.getName() + "AsString" + " not found");
			}
			doubleStingList = (List<?>) object.eGet(doubleStringFeature);
		}
		if (list.isEmpty()) {
			if (!feature.isUnsettable()) {
				print(OPEN_CLOSE_PAREN);
			} else {
				print("$");
			}
		} else {
			print(OPEN_PAREN);
			boolean first = true;
			int index = 0;
			for (Object listObject : list) {
				if (!first) {
					print(COMMA);
				}
				if ((listObject instanceof IdEObject) && model.contains((IdEObject)listObject)) {
					IdEObject eObject = (IdEObject) listObject;
					print(DASH);
					print(String.valueOf(getExpressId(eObject)));
				} else {
					if (listObject == null) {
						print(DOLLAR);
					} else {
						if (listObject instanceof IdEObject && feature.getEType().getEAnnotation("wrapped") != null) {
							IdEObject eObject = (IdEObject) listObject;
							Object realVal = eObject.eGet(eObject.eClass().getEStructuralFeature("wrappedValue"));
							if (realVal instanceof Double) {
								if (model.isUseDoubleStrings()) {
									Object stringVal = eObject.eGet(eObject.eClass().getEStructuralFeature("wrappedValueAsString"));
									if (stringVal != null) {
										print((String) stringVal);
									} else {
										IfcParserWriterUtils.writePrimitive(realVal, outputStream);
									}
								} else {
									IfcParserWriterUtils.writePrimitive(realVal, outputStream);
								}
							} else {
								IfcParserWriterUtils.writePrimitive(realVal, outputStream);
							}
						} else if (listObject instanceof EObject) {
							IdEObject eObject = (IdEObject) listObject;
							EClass class1 = eObject.eClass();
							EStructuralFeature structuralFeature = class1.getEStructuralFeature(WRAPPED_VALUE);
							if (structuralFeature != null) {
								Object realVal = eObject.eGet(structuralFeature);
								print(getPackageMetaData().getUpperCase(class1));
								print(OPEN_PAREN);
								if (realVal instanceof Double) {
									writeDoubleValue((Double)realVal, eObject, structuralFeature);
								} else {
									IfcParserWriterUtils.writePrimitive(realVal, outputStream);
								}
								print(CLOSE_PAREN);
							} else {
								if (feature.getEAnnotation("twodimensionalarray") != null) {
									writeList(eObject, eObject.eClass().getEStructuralFeature("List"));
								} else {
									LOGGER.info("Unfollowable reference found from " + object + "(" + object.getOid() + ")." + feature.getName() + " to " + eObject + "(" + eObject.getOid() + ")");
								}
							}
						} else {
							if (doubleStingList != null) {
								if (index < doubleStingList.size()) {
									String val = null;//linfujun, i fix bug here
									if (!listElementDouble) {
										val = (String)doubleStingList.get(index);
									}
									if (val == null) {
										IfcParserWriterUtils.writePrimitive(listObject, outputStream);
									} else {
										print(val);
									}
								} else {
									IfcParserWriterUtils.writePrimitive(listObject, outputStream);
								}
							} else {
								IfcParserWriterUtils.writePrimitive(listObject, outputStream);
							}
						}
					}
				}
				first = false;
				index++;
			}
			print(CLOSE_PAREN);
		}
	}

	private void writeWrappedValue(EObject object, EStructuralFeature feature, EClass ec) throws SerializerException, IOException {
		Object get = object.eGet(feature);
		boolean isWrapped = ec.getEAnnotation("wrapped") != null;
		EStructuralFeature structuralFeature = ec.getEStructuralFeature(WRAPPED_VALUE);
		if (get instanceof EObject) {
			boolean isDefinedWrapped = feature.getEType().getEAnnotation("wrapped") != null;
			EObject betweenObject = (EObject) get;
			if (betweenObject != null) {
				if (isWrapped && isDefinedWrapped) {
					Object val = betweenObject.eGet(structuralFeature);
					String name = structuralFeature.getEType().getName();
					if ((name.equals(IFC_BOOLEAN) || name.equals(IFC_LOGICAL)) && val == null) {
						print(BOOLEAN_UNDEFINED);
					} else if (structuralFeature.getEType() == ECORE_PACKAGE_INSTANCE.getEDouble()) {
						writeDoubleValue((Double)val, betweenObject, feature);
					} else {
						IfcParserWriterUtils.writePrimitive(val, outputStream);
					}
				} else {
					writeEmbedded(betweenObject);
				}
			}
		} else if (get instanceof EList<?>) {
			EList<?> list = (EList<?>) get;
			if (list.isEmpty()) {
				if (!feature.isUnsettable()) {
					print(OPEN_CLOSE_PAREN);
				} else {
					print("$");
				}
			} else {
				print(OPEN_PAREN);
				boolean first = true;
				for (Object o : list) {
					if (!first) {
						print(COMMA);
					}
					EObject object2 = (EObject) o;
					Object val = object2.eGet(structuralFeature);
					if (structuralFeature.getEType() == ECORE_PACKAGE_INSTANCE.getEDouble()) {
						writeDoubleValue((Double)val, object2, structuralFeature);
					} else {
						IfcParserWriterUtils.writePrimitive(val, outputStream);
					}
					first = false;
				}
				print(CLOSE_PAREN);
			}
		} else {
			if (get == null) {
				EClassifier type = structuralFeature.getEType();
				if (type.getName().equals("IfcBoolean") || type.getName().equals("IfcLogical") || type == ECORE_PACKAGE_INSTANCE.getEBoolean()) {
					print(BOOLEAN_UNDEFINED);
				} else {
					EntityDefinition entityBN = getPackageMetaData().getSchemaDefinition().getEntityBN(object.eClass().getName());
					if (entityBN != null && entityBN.isDerived(feature.getName())) {
						print(ASTERISK);
					} else {
						print(DOLLAR);
					}
				}
			}
		}
	}

	private void writeEnum(EObject object, EStructuralFeature feature) throws SerializerException, IOException {
		Object val = object.eGet(feature);
		if (feature.getEType().getName().equals("Tristate")) {
			IfcParserWriterUtils.writePrimitive(val, outputStream);
		} else {
			if (val == null) {
				print(DOLLAR);
			} else {
				if (((Enum<?>) val).toString().equals(NULL)) {
					print(DOLLAR);
				} else {
					print(DOT);
					print(val.toString());
					print(DOT);
				}
			}
		}
	}
}