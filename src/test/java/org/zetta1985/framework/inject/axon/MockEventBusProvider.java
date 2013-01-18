package org.zetta1985.framework.inject.axon;

import java.util.Set;

import org.axonframework.eventhandling.EventBus;
import org.axonframework.eventhandling.SimpleEventBus;
import org.axonframework.guice.EventSubscriber;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class MockEventBusProvider implements Provider<EventBus>{
	
	@Inject
	Set<EventSubscriber> subscribers;
	
	/**
	 * @inheritDoc
	 */
	@Override
	public EventBus get() {
		SimpleEventBus eventBus = new SimpleEventBus();
		
		for (EventSubscriber subscriber : subscribers) {
			subscriber.subscribe(eventBus);
		}
		
		return eventBus;
	}
}