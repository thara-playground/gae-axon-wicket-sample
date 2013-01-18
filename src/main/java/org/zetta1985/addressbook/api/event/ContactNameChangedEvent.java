package org.zetta1985.addressbook.api.event;




/**
 * @author t_hara
 *
 */
public class ContactNameChangedEvent extends AbstractDomainEvent {

	private static final long serialVersionUID = -9158653693746153870L;
	
	private final String newName;

	/**
	 * @param newName
	 */
	public ContactNameChangedEvent(String newName) {
		super();
		this.newName = newName;
	}
	
	/**
	 * @return the newName
	 */
	public String getNewName() {
		return newName;
	}
	
}
