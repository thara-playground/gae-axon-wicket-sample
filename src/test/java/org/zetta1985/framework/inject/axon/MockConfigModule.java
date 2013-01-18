package org.zetta1985.framework.inject.axon;

import java.util.Set;

import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.SimpleCommandBus;
import org.axonframework.eventhandling.EventBus;
import org.axonframework.eventhandling.SimpleEventBus;
import org.axonframework.guice.CommandSubscriber;
import org.axonframework.guice.EventSubscriber;

import com.google.inject.AbstractModule;
import com.google.inject.Injector;
import com.google.inject.Provides;
import com.google.inject.Singleton;

/**
 * @author t_hara
 *
 */
public class MockConfigModule extends AbstractModule {

	/**
	 * @inheritDoc
	 */
	@Override
	protected void configure() {
		//
	}

	@Provides
	@Singleton
	public CommandBus provideCommandBus(Injector injector, Set<CommandSubscriber> subscribers) {
		SimpleCommandBus commandBus = new SimpleCommandBus();
		
		for (CommandSubscriber commandSubscriber : subscribers) {
			commandSubscriber.subscribe(commandBus);
		}
		
		return commandBus;
	}
	
	@Provides
	@Singleton
	public EventBus provideEventBus(Injector injector, Set<EventSubscriber> subscribers) {
		SimpleEventBus eventBus = new SimpleEventBus();
		
		for (EventSubscriber eventSubscriber : subscribers) {
			eventSubscriber.subscribe(eventBus);
		}
		
		return eventBus;
	}
}
