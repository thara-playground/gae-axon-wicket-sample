package org.zetta1985.addressbook.api.event;




/**
 * @author t_hara
 *
 */
public class ContactCreatedEvent extends AbstractDomainEvent {

	private static final long serialVersionUID = 361743246313733205L;
	
	private final String name;

	/**
	 * @param name
	 */
	public ContactCreatedEvent(String name) {
		super();
		this.name = name;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
}
