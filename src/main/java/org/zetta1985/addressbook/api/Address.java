package org.zetta1985.addressbook.api;

/**
 * @author t_hara
 * 
 */
public class Address {

	private String streetAndNumber;
	private String zipCode;
	private String city;

	public Address(String streetAndNumber, String zipCode, String city) {
		this.streetAndNumber = streetAndNumber;
		this.zipCode = zipCode;
		this.city = city;
	}

	public String getStreetAndNumber() {
		return streetAndNumber;
	}

	public String getZipCode() {
		return zipCode;
	}

	public String getCity() {
		return city;
	}
	
	public Address() {
		// for XStream
	}
}
