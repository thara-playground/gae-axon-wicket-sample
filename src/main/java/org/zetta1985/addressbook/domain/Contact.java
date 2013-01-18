package org.zetta1985.addressbook.domain;

import java.util.HashMap;
import java.util.Map;

import org.axonframework.domain.AggregateIdentifier;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.zetta1985.addressbook.api.Address;
import org.zetta1985.addressbook.api.AddressType;
import org.zetta1985.addressbook.api.event.AddressAddedEvent;
import org.zetta1985.addressbook.api.event.AddressChangedEvent;
import org.zetta1985.addressbook.api.event.AddressRegisteredEvent;
import org.zetta1985.addressbook.api.event.AddressRemovedEvent;
import org.zetta1985.addressbook.api.event.ContactCreatedEvent;
import org.zetta1985.addressbook.api.event.ContactDeletedEvent;
import org.zetta1985.addressbook.api.event.ContactNameChangedEvent;
import org.zetta1985.framework.axon.Aggregate;

/**
 * @author t_hara
 * 
 */
public class Contact extends Aggregate {

	private Map<AddressType, Address> addresses = new HashMap<AddressType, Address>();
	
	private static final long serialVersionUID = 3791586476496694190L;

	/**
	 * 
	 */
	public Contact(AggregateIdentifier identifier) {
		super(identifier);
	}
	
	/**
	 * 
	 */
	public Contact(AggregateIdentifier identifier, String name) {
		super(identifier);
		apply(new ContactCreatedEvent(name));
	}
	
    /**
     * Register the provided address with the provided type. If a contact already has an address of the provided type,
     * that address is changed.
     *
     * @param type    AddressType of the address to add or change
     * @param address Address to add or change
     */
    public void registerAddress(AddressType type, Address address) {
        if (addresses.containsKey(type)) {
            apply(new AddressChangedEvent(type, address));
        } else {
            apply(new AddressAddedEvent(type, address));
        }
    }

    /**
     * Removes the address with the provided type if it exists.
     *
     * @param type AddressType of the address that needs to be removed
     */
    public void removeAddress(AddressType type) {
        if (addresses.containsKey(type)) {
            apply(new AddressRemovedEvent(type));
        }
    }

    /**
     * Change the name of the contact
     *
     * @param name String containing the new name
     */
    public void changeName(String name) {
        apply(new ContactNameChangedEvent(name));
    }

    public void delete() {
    	apply(new ContactDeletedEvent());
    }
    
	@EventHandler
	protected void handleContactCreatedEvent(ContactCreatedEvent event) {
		System.out.println(event.getClass().getSimpleName());
	}
	
    @EventHandler
    protected void handleContactNameChangedEvent(ContactNameChangedEvent event) {
    	System.out.println(event.getClass().getSimpleName());
    }

    @EventHandler
    protected void handleAddressRegisteredEvent(AddressRegisteredEvent event) {
        addresses.put(event.getType(), event.getAddress());
    }

    @EventHandler
    protected void handleAddressRemovedEvent(AddressRemovedEvent event) {
        addresses.remove(event.getType());
    }
}
