package org.zetta1985.framework.inject.axon;

import java.util.Set;

import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.SimpleCommandBus;
import org.axonframework.guice.CommandSubscriber;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class MockCommandBusProvider implements Provider<CommandBus>{

	@Inject
	Set<CommandSubscriber> subscribers;

	/**
	 * @inheritDoc
	 */
	@Override
	public CommandBus get() {
		
		SimpleCommandBus commandBus = new SimpleCommandBus();
		
		for (CommandSubscriber subscriber : subscribers) {
			subscriber.subscribe(commandBus);
		}
		
		return commandBus;
	}
}