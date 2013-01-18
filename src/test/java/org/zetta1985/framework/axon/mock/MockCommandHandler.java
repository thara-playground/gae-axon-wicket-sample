package org.zetta1985.framework.axon.mock;

import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.domain.AggregateIdentifier;
import org.axonframework.domain.UUIDAggregateIdentifier;
import org.axonframework.repository.Repository;

import com.google.inject.Inject;

/**
 * @author t_hara
 *
 */
public class MockCommandHandler {
	
	public static final String SUCCESS = "success";

	private Repository<MockAggregate> repository;

	/**
	 * @param repository
	 */
	@Inject
	public MockCommandHandler(Repository<MockAggregate> repository) {
		super();
		this.repository = repository;
	}
	
	@CommandHandler
	public String handle(MockCreateCommand command) {
		String name = command.getName();
		AggregateIdentifier identifier = new UUIDAggregateIdentifier();
		MockAggregate aggregate = new MockAggregate(identifier, name);
		repository.add(aggregate);
		return SUCCESS;
	}
}
