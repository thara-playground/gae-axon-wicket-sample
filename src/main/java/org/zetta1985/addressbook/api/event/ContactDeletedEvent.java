package org.zetta1985.addressbook.api.event;

import org.axonframework.domain.AggregateDeletedEvent;

/**
 * @author t_hara
 *
 */
public class ContactDeletedEvent extends AbstractDomainEvent implements
		AggregateDeletedEvent {

	/**  */
	private static final long serialVersionUID = 7020700039797563617L;

}
