package org.zetta1985.addressbook.domain;

/**
 * @author t_hara
 * 
 */
public interface ContactNameRepository {

	/**
	 * Claims the provided contact name, if the name is not available anymore
	 * false is returned
	 * 
	 * @param contactName
	 *            String containing the contact name to claim
	 * @return boolean indicating whether the claim was successful
	 */
	boolean claimContactName(String contactName);

	/**
	 * Release the claim for the provided name
	 * 
	 * @param contactName
	 *            String containing the name to release the claim for
	 */
	void cancelContactName(String contactName);
}
