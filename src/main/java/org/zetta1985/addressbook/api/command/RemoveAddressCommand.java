package org.zetta1985.addressbook.api.command;

import org.springframework.util.Assert;
import org.zetta1985.addressbook.api.AddressType;

/**
 * @author t_hara
 *
 */
public class RemoveAddressCommand extends AbstractOrderCommand {

	private static final long serialVersionUID = 926851503360995011L;
	
	private AddressType addressType;

	/**
	 * @return the addressType
	 */
	public AddressType getAddressType() {
		return addressType;
	}

	/**
	 * @param addressType the addressType to set
	 */
	public void setAddressType(AddressType addressType) {
		Assert.notNull(addressType, "The address type cannot be null");
		
		this.addressType = addressType;
	}
}
