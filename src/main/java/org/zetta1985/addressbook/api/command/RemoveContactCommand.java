package org.zetta1985.addressbook.api.command;

import org.springframework.util.Assert;

/**
 * @author t_hara
 *
 */
public class RemoveContactCommand extends AbstractOrderCommand {

	private static final long serialVersionUID = 566208758992686355L;
	
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
		Assert.hasText(contactId, "Cannot remove a contact with an empty id");
		
		this.contactId = contactId;
	}
}
