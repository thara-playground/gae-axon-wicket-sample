package org.zetta1985.addressbook.api.event;

import org.zetta1985.addressbook.api.Address;
import org.zetta1985.addressbook.api.AddressType;

/**
 * @author t_hara
 *
 */
public class AddressChangedEvent extends AddressRegisteredEvent {

	private static final long serialVersionUID = -1265933812518670767L;

	/**
	 * @param type
	 * @param address
	 */
	public AddressChangedEvent(AddressType type, Address address) {
		super(type, address);
		// TODO Auto-generated constructor stub
	}

}
