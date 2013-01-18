package org.zetta1985.framework.axon.mock;

import org.axonframework.domain.DomainEvent;

/**
 * @author t_hara
 *
 */
@SuppressWarnings("serial")
public class MockCreatedEvent extends DomainEvent {

	private String name;

	public String getContactIdentifier() {
		return getAggregateIdentifier().toString();
	}
	
	/**
	 * @param name
	 */
	public MockCreatedEvent(String name) {
		super();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
