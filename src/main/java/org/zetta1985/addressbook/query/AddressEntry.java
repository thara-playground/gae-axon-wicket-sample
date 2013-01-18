package org.zetta1985.addressbook.query;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;
import org.zetta1985.addressbook.api.AddressType;

import com.google.appengine.api.datastore.Key;

/**
 * @author t_hara
 *
 */
@Model(schemaVersion = 1)
public class AddressEntry implements Serializable{
	
	private static final long serialVersionUID = 3390369253507656774L;

	@Attribute(primaryKey = true)
	private Key key;

	private String identifier;
	
	private String name;

	@NotNull
	private AddressType addressType;
	
	@NotNull
	@Size(min=5)
	private String streetAndNumber;

	@NotNull
	@Size(min=3)
	private String zipCode;

	@NotNull
	@Size(min=2)
	private String city;


	/**
	 * @return the identifier
	 */
	public String getIdentifier() {
		return identifier;
	}

	/**
	 * @param identifier the identifier to set
	 */
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

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
		this.addressType = addressType;
	}

	/**
	 * @return the streetAndNumber
	 */
	public String getStreetAndNumber() {
		return streetAndNumber;
	}

	/**
	 * @param streetAndNumber the streetAndNumber to set
	 */
	public void setStreetAndNumber(String streetAndNumber) {
		this.streetAndNumber = streetAndNumber;
	}

	/**
	 * @return the zipCode
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the key
	 */
	public Key getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(Key key) {
		this.key = key;
	}

	
}
