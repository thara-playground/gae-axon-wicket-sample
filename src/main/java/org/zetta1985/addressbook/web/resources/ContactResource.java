package org.zetta1985.addressbook.web.resources;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.zetta1985.addressbook.api.command.ChangeContactNameCommand;
import org.zetta1985.addressbook.api.command.CreateContactCommand;
import org.zetta1985.addressbook.api.command.RemoveContactCommand;
import org.zetta1985.addressbook.query.ContactEntry;
import org.zetta1985.addressbook.query.ContactRepository;
import org.zetta1985.framework.CommandDispatcher;

import com.google.inject.Inject;

/**
 * @author t_hara
 */
@Path("contact")
public class ContactResource {

	@Inject
	ContactRepository contactRepository;
	
	@Inject
	CommandDispatcher commandDispacher;
	
	@GET
	public List<ContactEntry> list() {
		List<ContactEntry> allContacts = contactRepository.findAllContacts();
		return allContacts;
	}
	
	@PUT
	public void createContact(@FormParam("newContactName") String newContactName) {
		CreateContactCommand command = new CreateContactCommand();
		command.setNewContactName(newContactName);
		commandDispacher.dispatch(command);
	}
	
	@POST
	@Path("/{identifier}")
	public void editContact(@PathParam("identifier") String identifier,
			@FormParam("newContactName") String newContactName) {
		ChangeContactNameCommand command = new ChangeContactNameCommand();
		command.setContactId(identifier);
		command.setContactNewName(newContactName);
		commandDispacher.dispatch(command);
	}
	
	@DELETE
	@Path("/{contactId}")
	public void removeContact(@PathParam("contactId") String contactId) {
		RemoveContactCommand command = new RemoveContactCommand();
		command.setContactId(contactId);
		commandDispacher.dispatch(command);
	}
}
