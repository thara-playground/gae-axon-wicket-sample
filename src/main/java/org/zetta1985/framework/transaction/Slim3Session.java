package org.zetta1985.framework.transaction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections.IteratorUtils;
import org.slim3.datastore.GlobalTransaction;

import com.google.appengine.api.datastore.Key;

/**
 * @author t_hara
 */
public class Slim3Session {

	private GlobalTransaction gtx;
	
	private final List<Object> storedModels = new ArrayList<Object>();
	
	private final List<Key> deletedKeys = new ArrayList<Key>();
	
	/**
	 * @param gtx
	 */
	Slim3Session(GlobalTransaction gtx) {
		super();
		this.gtx = gtx;
	}

	/**
	 * @return the globalTransaction
	 */
	public GlobalTransaction currentTransaction() {
		return gtx;
	}
	
	public boolean isActive() {
		return gtx.isActive();
	}
	
	/**
	 * @inheritDoc
	 */
	public void delete(Key key) {
		deletedKeys.add(key);
	}


	/**
	 * @inheritDoc
	 */
	@SuppressWarnings("unchecked")
	public void delete(Iterable<Key> keys) {
		Iterator<Key> iter = keys.iterator();
		List list = IteratorUtils.toList(iter);
		deletedKeys.addAll(list);
	}

	/**
	 * @inheritDoc
	 */
	public void delete(Key... keys) {
		deletedKeys.addAll(Arrays.asList(keys));
	}

	/**
	 * @inheritDoc
	 */
	public void put(Object model) {
		storedModels.add(model);
	}


	/**
	 * @inheritDoc
	 */
	@SuppressWarnings("unchecked")
	public void put(Iterable<?> models) {
		Iterator<?> iter = models.iterator();
		List list = IteratorUtils.toList(iter);
		storedModels.addAll(list);
	}

	/**
	 * @inheritDoc
	 */
	public void put(Object... models) {
		storedModels.addAll(Arrays.asList(models));
	}
	
	void persistence() {
		if (storedModels.size() > 0) gtx.put(storedModels);
		if (deletedKeys.size() > 0) gtx.delete(deletedKeys);
	}
}
