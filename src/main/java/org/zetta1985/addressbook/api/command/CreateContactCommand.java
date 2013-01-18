package org.zetta1985.addressbook.api.command;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author t_hara
 * 
 */
public class CreateContactCommand extends AbstractOrderCommand{

	private static final long serialVersionUID = -8002569135182878565L;
	
	@NotNull(message="{error.required},{CreateContactCommand.newContactName}")
	@Size(min=4, max=6)
	private String newContactName;

    /**
     * Set the name for the new Contact. An exception is thrown when the provided name is empty
     *
     * @param newContactName String containing the name for the new contact
     */
    public void setNewContactName(String newContactName) {
        this.newContactName = newContactName;
    }

    /**
     * Returns the name for the new contact
     *
     * @return String containing the name for the new contact
     */
    public String getNewContactName() {
        return newContactName;
    }
}
