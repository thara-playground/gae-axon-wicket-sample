package org.zetta1985.framework.transaction;

import org.slim3.datastore.Datastore;
import org.slim3.datastore.GlobalTransaction;

/**
 * @author t_hara
 */
public class Slim3TransactionManager {

	public Slim3Session beginTransaction() {
		GlobalTransaction gtx = Datastore.beginGlobalTransaction();
		Slim3Session newSession = new Slim3Session(gtx);
		return newSession;
	}
	
	public void commit(Slim3Session session) {
		GlobalTransaction gtx = session.currentTransaction();
		if (gtx.isActive()) {
			session.persistence();
			gtx.commit();
		}
	}

	public void rollaback(Slim3Session session) {
		GlobalTransaction gtx = session.currentTransaction();
		if (gtx.isActive()) {
			gtx.rollback();
		}
	}
}
