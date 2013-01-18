package org.zetta1985.addressbook.api.event;

import org.zetta1985.addressbook.api.AddressType;

/**
 * @author t_hara
 *
 */
public class AddressRemovedEvent extends AbstractDomainEvent {

	/**  */
	private static final long serialVersionUID = -7382344569034077638L;
	
	private final AddressType type;

	/**
	 * @param type
	 */
	public AddressRemovedEvent(AddressType type) {
		super();
		this.type = type;
	}
	
	/**
	 * @return the type
	 */
	public AddressType getType() {
		return type;
	}
}
