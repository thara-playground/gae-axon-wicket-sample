package org.zetta1985.addressbook.api.command;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.util.Assert;
import org.zetta1985.addressbook.api.AddressType;

/**
 * @author t_hara
 *
 */
public class RegisterAddressCommand extends AbstractOrderCommand {

	private static final long serialVersionUID = 4454333444656912691L;

	@NotNull
	private AddressType addressType;
	
	@NotEmpty
	private String streetAndNumber;
	
	@NotEmpty
	private String zipCode;
	
	@NotEmpty
	private String city;
	
	/**
	 * @param type the type to set
	 */
	public void setAddressType(AddressType type) {
		Assert.notNull(type, "An Address type must be provided.");
		this.addressType = type;
	}

	/**
	 * @param streetAndNumber the streetAndNumber to set
	 */
	public void setStreetAndNumber(String streetAndNumber) {
		this.streetAndNumber = streetAndNumber;
	}

	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the type
	 */
	public AddressType getAddressType() {
		return addressType;
	}

	/**
	 * @return the streetAndNumber
	 */
	public String getStreetAndNumber() {
		return streetAndNumber;
	}

	/**
	 * @return the zipCode
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	

	
}
