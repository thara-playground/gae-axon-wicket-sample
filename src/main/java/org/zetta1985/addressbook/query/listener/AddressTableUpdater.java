package org.zetta1985.addressbook.query.listener;

import java.util.List;

import org.axonframework.domain.AggregateIdentifier;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.slim3.datastore.Datastore;
import org.slim3.datastore.GlobalTransaction;
import org.zetta1985.addressbook.api.Address;
import org.zetta1985.addressbook.api.event.AddressAddedEvent;
import org.zetta1985.addressbook.api.event.AddressChangedEvent;
import org.zetta1985.addressbook.api.event.AddressRemovedEvent;
import org.zetta1985.addressbook.api.event.ContactCreatedEvent;
import org.zetta1985.addressbook.api.event.ContactDeletedEvent;
import org.zetta1985.addressbook.api.event.ContactNameChangedEvent;
import org.zetta1985.addressbook.query.AddressEntry;
import org.zetta1985.addressbook.query.ContactEntry;
import org.zetta1985.addressbook.query.Keys;
import org.zetta1985.framework.transaction.Slim3Session;
import org.zetta1985.framework.transaction.Slim3SessionManager;
import org.zetta1985.framework.transaction.Transactional;

import com.google.appengine.api.datastore.Key;
import com.google.inject.Inject;

/**
 * @author t_hara
 *
 */
@Transactional
public class AddressTableUpdater {

	@Inject
	Slim3SessionManager sessionManager;
	
    @EventHandler
    public void handleContactCreatedEvent(ContactCreatedEvent event) {
    	Slim3Session session = sessionManager.currentSession();
    	
    	ContactEntry newEntry = new ContactEntry();
    	newEntry.setKey(Keys.createKey(event.getContactIdentifier()));
    	newEntry.setName(event.getName());
    	session.put(newEntry);
    }
    
    @EventHandler
    public void handleContactNameChangedEvent(ContactNameChangedEvent event) {
    	Slim3Session session = sessionManager.currentSession();
    	GlobalTransaction gtx = session.currentTransaction();
    	
    	String contactId = event.getContactIdentifier();
    	String newName = event.getNewName();
    	
    	Key contactKey = Datastore.createKey(ContactEntry.class, contactId);
		
		ContactEntry contact = gtx.get(Keys.CONTACT, contactKey);
		contact.setName(newName);
    	
    	List<Key> addressKeys = Datastore.query(Keys.META)
    								.filter(Keys.META.identifier.equal(contactId))
    								.asKeyList();

    	if (addressKeys.size() > 0) {
    		List<AddressEntry> addressList = gtx.get(Keys.META, addressKeys);
    		for (AddressEntry address : addressList) {
    			address.setName(newName);	
    		}
    		session.put(addressList);
    	}
    	
    	session.put(contact);
    }
    
    @EventHandler
    public void handleContactDeletedEvent(ContactDeletedEvent event) {
    	Slim3Session session = sessionManager.currentSession();
    	
    	String contactId = event.getContactIdentifier();
    	
    	List<Key> addressKeys = Datastore.query(Keys.META)
		.filter(Keys.META.identifier.equal(contactId)).asKeyList();
    	if (addressKeys.size() > 0) {
    		session.delete(addressKeys);
    	}
    	
    	AggregateIdentifier aggregateId = event.getAggregateIdentifier();
    	session.delete(Datastore.createKey(Keys.CONTACT, aggregateId.asString()));
    }
    
    @EventHandler
    public void handleAddressDeletedEvent(AddressRemovedEvent event) {
    	Slim3Session session = sessionManager.currentSession();
    	
    	List<Key> keys = Datastore.query(Keys.META)
    		.filter(Keys.META.identifier.equal(event.getContactIdentifier()))
    		.filter(Keys.META.addressType.equal(event.getType())).asKeyList();
    	
    	session.delete(keys);
    }
    
    @EventHandler
    public void handleAddressChangedEvent(AddressChangedEvent event) {
    	Slim3Session session = sessionManager.currentSession();
    	GlobalTransaction gtx = session.currentTransaction();
    	
    	AddressEntry a = Datastore.query(Keys.META)
			.filter(Keys.META.identifier.equal(event.getContactIdentifier()))
			.filter(Keys.META.addressType.equal(event.getType())).asSingle();
    	
    	AddressEntry target = gtx.get(Keys.META, a.getKey());
    	
    	Address address = event.getAddress();
    	
		target.setStreetAndNumber(address.getStreetAndNumber());
    	target.setCity(address.getCity());
    	target.setZipCode(address.getZipCode());
    	session.put(target);
    }
    
    @EventHandler
    public void handleAddressAddedEvent(AddressAddedEvent event) {
    	Slim3Session session = sessionManager.currentSession();
    	GlobalTransaction gtx = session.currentTransaction();
    	
		Key contactKey = Keys.createKey(event.getContactIdentifier());
    	ContactEntry contact = gtx.get(Keys.CONTACT, contactKey);
    	
    	AddressEntry entry = new AddressEntry();
    	entry.setKey(Keys.createKey());
		entry.setIdentifier(event.getAggregateIdentifier().asString());
    	entry.setName(contact.getName());
		entry.setAddressType(event.getType());
		
		Address address = event.getAddress();
		entry.setStreetAndNumber(address.getStreetAndNumber());
		entry.setCity(address.getCity());
		entry.setZipCode(address.getZipCode());

		session.put(entry);
    }
}
