package org.zetta1985.addressbook.api;

/**
 * @author t_hara
 *
 */
public class ContactNameAlreadyTakenException extends RuntimeException {

	private static final long serialVersionUID = -487235599997893369L;

	/**
	 * @param newContactName
	 */
	public ContactNameAlreadyTakenException(String newContactName) {
		super(newContactName);
	}

	
}
