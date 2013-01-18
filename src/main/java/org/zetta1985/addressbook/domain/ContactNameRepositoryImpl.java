package org.zetta1985.addressbook.domain;

import org.slim3.datastore.GlobalTransaction;
import org.zetta1985.framework.transaction.Slim3Session;
import org.zetta1985.framework.transaction.Slim3SessionManager;
import org.zetta1985.framework.transaction.Transactional;

import com.google.appengine.api.datastore.Key;
import com.google.inject.Inject;

/**
 * @author t_hara
 *
 */
@Transactional
public class ContactNameRepositoryImpl implements ContactNameRepository {

	@Inject
	Slim3SessionManager sessionManager;
	
	/**
	 * @inheritDoc
	 */
	@Override
	public void cancelContactName(String contactName) {
		Slim3Session session = sessionManager.currentSession();
		GlobalTransaction gtx = session.currentTransaction();
		
		Key key = ClaimedContactName.createKey(contactName);
		ClaimedContactName claimedContactName = gtx.get(ClaimedContactName.class, key);
		session.delete(claimedContactName.getKey());
	}

	/**
	 * @inheritDoc
	 */
	@Override
	public boolean claimContactName(String contactName) {
		Slim3Session session = sessionManager.currentSession();
		
		ClaimedContactName entity = new ClaimedContactName(contactName);
		entity.setKey(ClaimedContactName.createKey(contactName));
		session.put(entity);
		return true;
	}

}
