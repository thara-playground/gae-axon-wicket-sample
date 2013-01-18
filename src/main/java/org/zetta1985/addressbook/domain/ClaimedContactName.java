package org.zetta1985.addressbook.domain;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Datastore;
import org.slim3.datastore.Model;

import com.google.appengine.api.datastore.Key;


/**
 * @author t_hara
 *
 */
@Model(schemaVersion=1)
public class ClaimedContactName {
	
	/**
	 * @param contactName
	 * @return
	 */
	public static Key createKey(String contactName) {
		return Datastore.createKey(ClaimedContactName.class, contactName);
	}

	@Attribute(primaryKey=true)
	private Key key;
	
	private String contactName;

	/**
	 * @param contactName
	 */
	public ClaimedContactName(String contactName) {
		super();
		this.contactName = contactName;
	}
	
	/**
	 * @return the contactName
	 */
	public String getContactName() {
		return contactName;
	}
	
	/**
	 * @param contactName the contactName to set
	 */
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	
	public ClaimedContactName() {
		//
	}

	/**
	 * @return the key
	 */
	public Key getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(Key key) {
		this.key = key;
	}

}
