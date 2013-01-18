package org.zetta1985.addressbook.api.command;

import java.io.Serializable;

/**
 * @author t_hara
 *
 */
public abstract class AbstractOrderCommand implements Serializable{

	/**  */
	private static final long serialVersionUID = -6782757729183123107L;
	
	private String contactId;

	/**
	 * @return the contactId
	 */
	public String getContactId() {
		return contactId;
	}

	/**
	 * @param contactId the contactId to set
	 */
	public void setContactId(String contactId) {
		this.contactId = contactId;
	}
	
}
