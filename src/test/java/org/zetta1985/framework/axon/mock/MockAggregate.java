package org.zetta1985.framework.axon.mock;

import org.axonframework.domain.AggregateIdentifier;
import org.zetta1985.framework.axon.Aggregate;

/**
 * @author t_hara
 *
 */
@SuppressWarnings("serial")
public class MockAggregate extends Aggregate {

	/**
	 * @param identifier
	 */
	public MockAggregate(AggregateIdentifier identifier) {
		super(identifier);
	}

	/**
	 * @param identifier
	 */
	public MockAggregate(AggregateIdentifier identifier, String name) {
		super(identifier);
		apply(new MockCreatedEvent(name));
	}

}
