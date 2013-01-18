package org.zetta1985.addressbook.api.event;

import org.axonframework.domain.DomainEvent;

/**
 * @author t_hara
 *
 */
@SuppressWarnings("serial")
public abstract class AbstractDomainEvent extends DomainEvent {

	public String getContactIdentifier() {
		return getAggregateIdentifier().toString();
	}
}
