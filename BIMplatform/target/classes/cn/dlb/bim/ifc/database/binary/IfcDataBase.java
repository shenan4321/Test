package cn.dlb.bim.ifc.database.binary;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;

import cn.dlb.bim.ifc.database.IfcModelDbException;
import cn.dlb.bim.ifc.emf.OidProvider;

public interface IfcDataBase extends OidProvider {
	public EClassifier getEClassifier(String packageName, String classifierName);
	public Short getCidOfEClass(EClass eClass);
	public EClass getEClassForCid(short cid);
	public EClass getEClassForOid(long oid) throws IfcModelDbException;
	public Integer newRevisionId();
	public void updateDataBase();
}
