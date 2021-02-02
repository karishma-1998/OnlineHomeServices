package com.app.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "workers")
public class Workers{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "worker_id")
	private Integer workerId;
	@Column(length = 30)
	private String firstName;
	@Column(length = 30)
	private String lastname;
	@Column(unique = true)
	@NotNull(message = "Email must be not be null")
	private String email;

	@Column(length = 10)
	private String mobileNo;

	private String password;

	private String address;
	private String state;
	private String city;
	private String pincode;
	private String country;

	//@ManyToOne
	//@JoinColumn(name = "job_id")
	//@JsonIgnore
	@NotNull(message = "Must Provide the JobName")
	private Integer jobId;

//	@OneToOne(mappedBy = "worker", cascade = CascadeType.ALL)
//	@JsonIgnoreProperties("worker")
//	private Booking booking;

	@Enumerated(EnumType.STRING)
	private OnLeave onLeave;

//	@OneToOne(mappedBy = "worker",cascade = CascadeType.ALL)
//	@JsonIgnoreProperties("worker")
//	private Address adr;

//	@OneToOne(mappedBy = "worker", cascade = CascadeType.ALL)
//	@JsonIgnoreProperties("worker")
//	private Feedback feedback;

	public Workers() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Workers(Integer workerId, String firstName, String lastname, String email, String mobileNo, String password,
			String address, String state, String city, String pincode, String country, int jobId, 
			OnLeave onLeave) {
		super();
		this.workerId = workerId;
		this.firstName = firstName;
		this.lastname = lastname;
		this.email = email;
		this.mobileNo = mobileNo;
		this.password = password;
		this.address = address;
		this.state = state;
		this.city = city;
		this.pincode = pincode;
		this.country = country;
		this.jobId = jobId;
		
		this.onLeave = onLeave;
		
	}



	public Integer getWorkerId() {
		return workerId;
	}

	public void setWorkerId(Integer workerId) {
		this.workerId = workerId;
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

	//@JsonIgnore
	public int getJobId() {
		return jobId;
	}

	//@JsonProperty
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	/*
	 * public Booking getBooking() { return booking; }
	 * 
	 * public void setBooking(Booking booking) { this.booking = booking; }
	 */

	public OnLeave getOnLeave() {
		return onLeave;
	}

	public void setOnLeave(OnLeave onLeave) {
		this.onLeave = onLeave;
	}

//	public Address getAdr() {
//		return adr;
//	}
//
//	public void setAdr(Address adr) {
//		this.adr = adr;
//	}

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


	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Workers [workerId=" + workerId + ", firstName=" + firstName + ", lastname=" + lastname + ", email="
				+ email + ", mobileNo=" + mobileNo + ", password=" + password + ", address=" + address + ", state="
				+ state + ", city=" + city + ", pincode=" + pincode + ", country=" + country + ", job=" + jobId
			    + ", onLeave=" + onLeave + "]";
	}

}
