package org.zetta1985.framework.axon.mock;

import org.axonframework.eventhandling.EventBus;
import org.axonframework.eventhandling.annotation.AnnotationEventListenerAdapter;
import org.axonframework.guice.EventSubscriber;

/**
 * @author t_hara
 *
 */
public class MockEventSubscriber implements EventSubscriber{

	/**
	 * @inheritDoc
	 */
	@Override
	public void subscribe(EventBus eventBus) {
		MockEventHandler listener = new MockEventHandler();
		eventBus.subscribe(new AnnotationEventListenerAdapter(listener, eventBus));
		
	}

}
