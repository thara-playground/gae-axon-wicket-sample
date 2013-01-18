package org.zetta1985.addressbook.query;

import java.util.List;

import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Key;

/**
 * @author t_hara
 *
 */
public class ContactRepositoryImpl implements ContactRepository{

	/**
	 * @inheritDoc
	 */
	@Override
	public List<AddressEntry> findAllAddressesForContact(String contactId) {
		
		return Datastore.query(Keys.META)
			.filter(Keys.META.identifier.equal(contactId))
			.asList();
	}

	/**
	 * @inheritDoc
	 */
	@Override
	public List<AddressEntry> findAllAddressesInCityForContact(String name,
			String city) {

		return Datastore.query(Keys.META)
			.filterInMemory(Keys.META.name.contains(name))
			.filterInMemory(Keys.META.city.contains(city))
			.limit(250).asList();
	}

	/**
	 * @inheritDoc
	 */
	@Override
	public List<ContactEntry> findAllContacts() {
		
		return Datastore.query(Keys.CONTACT)
			.sort(Keys.CONTACT.name.asc)
			.limit(250)
			.asList();
	}

	/**
	 * @inheritDoc
	 */
	@Override
	public ContactEntry loadContactDetails(String contactId) {
		
		Key key = Keys.createKey(contactId);
		return Datastore.get(Keys.CONTACT, key);
	}

}
