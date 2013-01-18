package org.zetta1985.addressbook.web.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.zetta1985.addressbook.api.AddressType;
import org.zetta1985.addressbook.api.command.RegisterAddressCommand;
import org.zetta1985.addressbook.api.command.RemoveAddressCommand;
import org.zetta1985.addressbook.query.AddressEntry;
import org.zetta1985.addressbook.query.ContactRepository;
import org.zetta1985.addressbook.web.resources.grid.GridData;
import org.zetta1985.addressbook.web.resources.grid.GridRecord;
import org.zetta1985.addressbook.web.resources.grid.GridRecordBuilder;
import org.zetta1985.framework.CommandDispatcher;
import org.zetta1985.framework.domain.ListLoader;
import org.zetta1985.framework.domain.PaginatedList;
import org.zetta1985.framework.domain.PagingCriteria;

import com.google.inject.Inject;

/**
 * @author t_hara
 */
@Path("contact/{contactId}/address")
public class ContactAddressResource {

	@Inject
	ContactRepository contactRepository;
	
	@Inject
	CommandDispatcher commandDispacher;
	
	@GET
	public List<AddressEntry> listAddresses(@PathParam("contactId") String contactId) {
		List<AddressEntry> addresses = contactRepository.findAllAddressesForContact(contactId);
		return addresses;
	}
	
	@GET
	@Path("/grid")
	@Produces("application/json")
	public GridData getGridAddresses(@PathParam("contactId") String contactId,
			@QueryParam("page") int page,
			@QueryParam("rows") int rows,
			@QueryParam("sidx") String sortedIndex,
			@QueryParam("sord") String sortedOrder) {
		
		PagingCriteria criteria = new PagingCriteria(page, rows, sortedIndex, 
				sortedOrder == null ? true : sortedOrder.equals("asc"));
		
		final List<AddressEntry> addresses = contactRepository.findAllAddressesForContact(contactId);
		ListLoader<AddressEntry> loader = new ListLoader<AddressEntry>() {
			@Override
			public int allCount() {
				return addresses.size();
			}
			@Override
			public List<AddressEntry> load(int from, int to) {
				return addresses;
			}
		};
		
		PaginatedList<AddressEntry> list = new PaginatedList<AddressEntry>(loader);
		list.load(criteria);
		
		return new GridData(list, new GridRecordBuilder<AddressEntry>() {
			@Override
			public GridRecord<? extends Object> create(AddressEntry src) {
				return new GridRecord<Object>(src.getKey().getId())
					.append(src.getAddressType())
					.append(src.getStreetAndNumber())
					.append(src.getZipCode())
					.append(src.getCity());
			}
		});
	}
	
	@PUT
	@Consumes("application/json")
	public void createAddress(@PathParam("contactId") String contactId, AddressEntry address) {

		RegisterAddressCommand command = new RegisterAddressCommand();
		command.setContactId(contactId);
        command.setAddressType(address.getAddressType());
        command.setCity(address.getCity());
        command.setStreetAndNumber(address.getStreetAndNumber());
        command.setZipCode(address.getZipCode());
        
		commandDispacher.dispatch(command);
	}
	
	@DELETE
	@Path("/{addressType}")
	public void deleteAddress(
			@PathParam("contactId") String contactId,
			@PathParam("addressType") AddressType addressType) {
		
		RemoveAddressCommand command = new RemoveAddressCommand();
		command.setContactId(contactId);
		command.setAddressType(addressType);
		
		commandDispacher.dispatch(command);
	}
}
