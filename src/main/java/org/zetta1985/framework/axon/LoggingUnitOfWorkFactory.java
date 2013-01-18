package org.zetta1985.framework.axon;

import org.axonframework.unitofwork.DefaultUnitOfWork;
import org.axonframework.unitofwork.DefaultUnitOfWorkFactory;
import org.axonframework.unitofwork.UnitOfWork;

/**
 * @author t_hara
 */
public class LoggingUnitOfWorkFactory extends DefaultUnitOfWorkFactory {

	/**
	 * @inheritDoc
	 */
	@Override
	public UnitOfWork createUnitOfWork() {
		DefaultUnitOfWork uow = new LoggingUnitOfWork();
		uow.start();
		return uow;
	}
}
