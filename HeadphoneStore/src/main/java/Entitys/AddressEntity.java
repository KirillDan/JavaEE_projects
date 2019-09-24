package Entitys;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: AddressEntity
 *
 */
@Entity
public class AddressEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	public AddressEntity() {
	}
	public AddressEntity(String sity,String street,int house,int apartment,String phoneNumber, String zipCode, String comment) {
		this.setSity(sity);
		this.setStreet(street);
		this.setHouse(house);
		this.setApartment(apartment);
		this.setPhoneNumber(phoneNumber);
		this.setZipCode(zipCode);
		this.setComment(comment);
	}
	
	public Long getAddressId() {
		return addressId;
	}

	public String getSity() {
		return sity;
	}
	public void setSity(String sity) {
		this.sity = sity;
	}

	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}

	public int getHouse() {
		return house;
	}
	public void setHouse(int house) {
		this.house = house;
	}

	public int getApartment() {
		return apartment;
	}
	public void setApartment(int apartment) {
		this.apartment = apartment;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

	@Id @GeneratedValue
	private Long addressId;
	
	private String sity;
	private String street;
	private int house;
	private int apartment;
	private String phoneNumber;
	private String zipCode;
	private String comment;
   
}
