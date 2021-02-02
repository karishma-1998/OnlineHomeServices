package com.app.pojo;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "assign_booking")
public class AssignBooking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull(message = "must provide booking id")
	private Integer bookingId;
	
	@NotNull(message = "must provide worker id")
	private Integer workerId;
	
	@NotNull(message = "must provide customer id")
	private Integer customerId;

	@NotNull(message = "must provide job id")
	private Integer jobId;

	@Enumerated(EnumType.STRING)
	private BookingStatus bookingStatus;

	public AssignBooking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AssignBooking(Integer id, Integer bookingId, Integer workerId, Integer customerId, Integer jobId,
			BookingStatus bookingStatus) {
		super();
		this.id = id;
		this.bookingId = bookingId;
		this.workerId = workerId;
		this.customerId = customerId;
		this.jobId = jobId;
		this.bookingStatus = bookingStatus;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	public Integer getWorkerId() {
		return workerId;
	}

	public void setWorkerId(Integer workerId) {
		this.workerId = workerId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getJobId() {
		return jobId;
	}

	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}

	public BookingStatus getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(BookingStatus bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	@Override
	public String toString() {
		return "AssignBooking [id=" + id + ", bookingId=" + bookingId + ", workerId=" + workerId + ", customerId="
				+ customerId + ", jobId=" + jobId + ", bookingStatus=" + bookingStatus + "]";
	}

}
