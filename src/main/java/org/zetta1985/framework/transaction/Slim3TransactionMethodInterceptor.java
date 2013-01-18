package org.zetta1985.framework.transaction;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author t_hara
 */
public class Slim3TransactionMethodInterceptor implements MethodInterceptor {

	private Slim3TransactionManager transactionManager;
	private Slim3SessionManager sessionManager;
	
	/**
	 * @param transactionManager
	 * @param sessionManager
	 */
	public Slim3TransactionMethodInterceptor(
			Slim3TransactionManager transactionManager,
			Slim3SessionManager sessionManager) {
		super();
		this.transactionManager = transactionManager;
		this.sessionManager = sessionManager;
	}

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Slim3Session session = transactionManager.beginTransaction();
		try {
			sessionManager.setCurrentSession(session);
			Object result = invocation.proceed();
			transactionManager.commit(session);
			return result;
		} catch (Exception e) {
			transactionManager.rollaback(session);
			throw e;
		} finally {
			sessionManager.clearSession();
		}
	}

}
