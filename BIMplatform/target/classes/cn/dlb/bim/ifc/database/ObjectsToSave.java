package cn.dlb.bim.ifc.database;

import java.util.Iterator;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Iterators;

import cn.dlb.bim.ifc.emf.IdEObject;
import cn.dlb.bim.models.ifc2x3tc1.Ifc2x3tc1Package;
import cn.dlb.bim.models.ifc4.Ifc4Package;

public class ObjectsToSave implements Iterable<IdEObject> {
	private final BiMap<IdEObject, Long> objectsToCommitFirst = HashBiMap.create();
	private final BiMap<IdEObject, Long> objectsToCommitSecond = HashBiMap.create();

	public void put(IdEObject idEObject) {
		getMap(idEObject).forcePut(idEObject, idEObject.getOid());
	}

	public int size() {
		return objectsToCommitFirst.size() + objectsToCommitSecond.size();
	}

	public BiMap<IdEObject, Long> getMap(IdEObject idEObject) {
		if (idEObject.eClass().getEPackage() == Ifc2x3tc1Package.eINSTANCE || idEObject.eClass().getEPackage() == Ifc4Package.eINSTANCE) {
			return objectsToCommitFirst;
		} else {
			return objectsToCommitSecond;
		}
	}

	public boolean containsObject(IdEObject object) {
		return getMap(object).containsKey(object);
	}

	public boolean containsOid(long oid) {
		return objectsToCommitFirst.containsValue(oid) || objectsToCommitSecond.containsValue(oid);
	}

	public IdEObject getByOid(long oid) {
		IdEObject result = objectsToCommitFirst.inverse().get(oid);
		if (result == null) {
			return objectsToCommitSecond.inverse().get(oid);
		}
		return result;
	}

	@Override
	public Iterator<IdEObject> iterator() {
		return Iterators.concat(objectsToCommitFirst.keySet().iterator(), objectsToCommitSecond.keySet().iterator());
	}

	public void clear() {
		objectsToCommitFirst.clear();
		objectsToCommitSecond.clear();
	}

	public void remove(IdEObject object) {
		objectsToCommitFirst.remove(object);
		objectsToCommitSecond.remove(object);
	}
}