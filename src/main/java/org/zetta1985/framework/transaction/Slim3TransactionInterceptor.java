package org.zetta1985.framework.transaction;

import org.axonframework.commandhandling.interceptors.TransactionInterceptor;
import org.springframework.util.Assert;

/**
 * @author t_hara
 */
public class Slim3TransactionInterceptor extends TransactionInterceptor<Slim3Session> {

	private final Slim3TransactionManager transactionManager;
	private final Slim3SessionManager sessionManager;
	
	/**
	 * @param transactionManager
	 * @param sessionManager
	 */
	public Slim3TransactionInterceptor(
			Slim3TransactionManager transactionManager,
			Slim3SessionManager sessionManager) {
		super();
		Assert.notNull(transactionManager);
		Assert.notNull(sessionManager);
		
		this.transactionManager = transactionManager;
		this.sessionManager = sessionManager;
	}

	@Override
	protected void commitTransaction(Slim3Session session) {
		transactionManager.commit(session);
	}

	@Override
	protected void rollbackTransaction(Slim3Session session) {
		transactionManager.rollaback(session);
	}

	@Override
	protected Slim3Session startTransaction() {
		Slim3Session session = transactionManager.beginTransaction();
		sessionManager.setCurrentSession(session);
		return session;
	}

}
