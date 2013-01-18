package org.axonframework.guice;

import org.axonframework.eventhandling.EventBus;
import org.zetta1985.framework.axon.Subscriber;

/**
 * @author t_hara
 *
 */
public interface EventSubscriber extends Subscriber<EventBus>{
	
	/**
	 * @inheritDoc
	 */
	void subscribe(EventBus eventBus);
}
