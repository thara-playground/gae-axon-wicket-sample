package org.zetta1985.addressbook.query;

import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Key;

/**
 * @author t_hara
 */
public class Keys {

	public static Key createKey() {
		return Datastore.allocateId(Keys.META);
	}

	public static final AddressEntryMeta META = AddressEntryMeta.get();

	public static Key createKey(String identifier) {
		return Datastore.createKey(Keys.CONTACT, identifier);
	}

	public static final ContactEntryMeta CONTACT = ContactEntryMeta.get();

}
