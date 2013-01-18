package org.zetta1985.framework.axon;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.axonframework.unitofwork.DefaultUnitOfWork;

/**
 * @author t_hara
 */
public class LoggingUnitOfWork extends DefaultUnitOfWork {

	private static Logger logger = Logger.getLogger(LoggingUnitOfWork.class.getName());
	
	/**
	 * @inheritDoc
	 */
	@Override
	protected void doStart() {
		super.doStart();
		if (logger.isLoggable(Level.FINE)) logger.log(Level.FINE, "start : UnitOfWork");
	}
	
	/**
	 * @inheritDoc
	 */
	@Override
	protected void doCommit() {
		super.doCommit();
		if (logger.isLoggable(Level.FINE)) logger.log(Level.FINE, "commit : UnitOfWork");
	}
	
	/**
	 * @inheritDoc
	 */
	@Override
	protected void doRollback(Throwable cause) {
		super.doRollback(cause);
		if (logger.isLoggable(Level.INFO)) logger.log(Level.INFO, "rollback : UnitOfWork");
	}
}
