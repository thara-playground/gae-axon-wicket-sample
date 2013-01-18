package org.axonframework.guice;

import org.axonframework.commandhandling.CommandBus;
import org.zetta1985.framework.axon.Subscriber;

/**
 * @author t_hara
 *
 */
public interface CommandSubscriber extends Subscriber<CommandBus>{
	
	/**
	 * @inheritDoc
	 */
	void subscribe(CommandBus commandBus);
}
