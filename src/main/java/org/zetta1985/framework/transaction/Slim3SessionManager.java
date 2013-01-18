package org.zetta1985.framework.transaction;

import org.springframework.util.Assert;

/**
 * @author t_hara
 */
public class Slim3SessionManager {

	private static final ThreadLocal<Slim3Session> SESSION = new ThreadLocal<Slim3Session>();
	
	public Slim3Session currentSession() {
		Slim3Session session = SESSION.get();
		if (session == null) {
			throw new IllegalStateException("session is not available.");
		}
		return session;
	}
	
	public boolean hasSession() {
		return SESSION.get() != null;
	}
	
	void setCurrentSession(Slim3Session session) {
		Assert.notNull(session);
		SESSION.set(session);
	}
	
	
	void clearSession() {
		SESSION.set(null);
	}
}
