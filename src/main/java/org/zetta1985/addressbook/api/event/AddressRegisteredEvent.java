package org.zetta1985.addressbook.api.event;

import org.zetta1985.addressbook.api.Address;
import org.zetta1985.addressbook.api.AddressType;

/**
 * @author t_hara
 * 
 */
@SuppressWarnings("serial")
public abstract class AddressRegisteredEvent extends AbstractDomainEvent {

	private final AddressType type;
	private final Address address;
	/**
	 * @param type
	 * @param address
	 */
	public AddressRegisteredEvent(AddressType type, Address address) {
		super();
		this.type = type;
		this.address = address;
	}
	/**
	 * @return the type
	 */
	public AddressType getType() {
		return type;
	}
	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}
	
	
}
