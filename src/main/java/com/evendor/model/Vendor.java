package com.evendor.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.StringJoiner;

@Entity
public class Vendor {

	enum BusinessType {
		PHARMACY,
		GROCERY,
		OTHER
	}

	enum Category {
		WHOLESALE,
		RETAIL
	}

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String phoneNumber;
	private String email;
	private String address;
	private String state;
	private String postalCode;
	private BusinessType businessType;
	private Category category;

	public Vendor() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public BusinessType getBusinessType() {
		return businessType;
	}

	public void setBusinessType(BusinessType businessType) {
		this.businessType = businessType;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", Vendor.class.getSimpleName() + "[", "]")
				.add("id=" + id)
				.add("name='" + name + "'")
				.add("phoneNumber='" + phoneNumber + "'")
				.add("email='" + email + "'")
				.add("address='" + address + "'")
				.add("state='" + state + "'")
				.add("postalCode='" + postalCode + "'")
				.add("businessType=" + businessType)
				.add("category=" + category)
				.toString();
	}
}
