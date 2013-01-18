package org.zetta1985.framework.axon.mock;

import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.annotation.AnnotationCommandHandlerAdapter;
import org.axonframework.guice.CommandSubscriber;
import org.axonframework.repository.Repository;

import com.google.inject.Inject;

/**
 * @author t_hara
 *
 */
public class MockCommandSubscriber implements CommandSubscriber {

	Repository<MockAggregate> repos;
	
	/**
	 * @param repos
	 */
	@Inject
	public MockCommandSubscriber(Repository<MockAggregate> repos) {
		super();
		this.repos = repos;
	}

	/**
	 * @inheritDoc
	 */
	@Override
	public void subscribe(CommandBus commandBus) {
		MockCommandHandler handler = new MockCommandHandler(repos);
		commandBus.subscribe(MockCreateCommand.class, new AnnotationCommandHandlerAdapter(handler, commandBus));
	}

}
