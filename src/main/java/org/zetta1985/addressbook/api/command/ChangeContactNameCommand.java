package org.zetta1985.addressbook.api.command;

import org.apache.commons.lang.StringUtils;
import org.axonframework.util.Assert;


/**
 * @author t_hara
 *
 */
public class ChangeContactNameCommand extends AbstractOrderCommand {

	private static final long serialVersionUID = 5336388646381411923L;
	
	private String contactNewName;

	/**
	 * @return the contactNewName
	 */
	public String getContactNewName() {
		return contactNewName;
	}

	/**
	 * @param contactNewName the contactNewName to set
	 */
	public void setContactNewName(String contactNewName) {
		Assert.isTrue(StringUtils.isNotBlank(contactNewName), "New name for contact should contain text");
		this.contactNewName = contactNewName;
	}
	
	
}
