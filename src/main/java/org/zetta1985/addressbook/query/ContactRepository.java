package org.zetta1985.addressbook.query;

import java.util.List;


/**
 * @author t_hara
 * 
 */
public interface ContactRepository {

	/**
	 * Returns a list with all the contacts
	 * 
	 * @return List of contacts
	 */
	List<ContactEntry> findAllContacts();

	/**
	 * Returns a list of addresses for the contact with the specified contact
	 * identifier
	 * 
	 * @param contactId
	 *            UUID of the contact to find addresses for
	 * @return List of found addresses for the contact
	 */
	List<AddressEntry> findAllAddressesForContact(String contactId);

	/**
	 * Returns a list of addresses for the specified city and or contact name.
	 * If one of the provided parameters is null, it is not used for the query.
	 * 
	 * @param name
	 *            String representing the name of the contact
	 * @param city
	 *            String representing the city of an address of the contact
	 * @return List containing the found addresses
	 */
	List<AddressEntry> findAllAddressesInCityForContact(String name, String city);

	/**
	 * Returns the contact details for the contact with the provided UUID
	 * 
	 * @param contactId
	 *            UUID required field containing the contact identifier
	 * @return Contact belonging to the provided identifier
	 */
	ContactEntry loadContactDetails(String contactId);
}
