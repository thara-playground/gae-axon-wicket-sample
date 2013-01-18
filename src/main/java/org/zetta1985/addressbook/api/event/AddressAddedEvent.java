package org.zetta1985.addressbook.api.event;

import org.zetta1985.addressbook.api.Address;
import org.zetta1985.addressbook.api.AddressType;

/**
 * @author t_hara
 *
 */
public class AddressAddedEvent extends AddressRegisteredEvent {

	private static final long serialVersionUID = -2043581254693698960L;

	/**
	 * @param type
	 * @param address
	 */
	public AddressAddedEvent(AddressType type, Address address) {
		super(type, address);
		// TODO Auto-generated constructor stub
	}

}
