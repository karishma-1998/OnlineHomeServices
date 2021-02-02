package com.app.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private Integer customerId;
	@Column(length = 30)
	private String firstName;
	@Column(length = 30)
	private String lastname;
	@Column(length = 30, unique = true)
	@NotNull(message = "Email must be unique")
	private String email;
	@Column(length = 10)
	@Length(message = "Mobile number must be 10 digit only")
	private String mobileNo;
	@Column(length = 30)
	@NotEmpty(message = "Password cannot be empty")
	private String password;
	@Enumerated(EnumType.STRING)
	private Role role;

	private String address;
	private String state;
	private String city;
	private String pincode;
	private String country;

	public Customer() {
		super();
	}

	public Customer(Integer customerId, String firstName, String lastname, String email, String mobileNo,
			String password, Role role, String address, String state, String city, String pincode, String country) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastname = lastname;
		this.email = email;
		this.mobileNo = mobileNo;
		this.password = password;
		this.role = role;
		this.address = address;
		this.state = state;
		this.city = city;
		this.pincode = pincode;
		this.country = country;

	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastname=" + lastname + ", email="
				+ email + ", mobileNo=" + mobileNo + ", password=" + password + ", role=" + role + ", address="
				+ address + ", state=" + state + ", city=" + city + ", pincode=" + pincode + ", country=" + country
				+ "]";
	}

}
