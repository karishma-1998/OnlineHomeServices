package com.app.pojo;

import java.time.LocalDate;

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
@Table(name = "booking_table")
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "booking_id")
	private Integer bookingId;

//	@OneToOne
//	@JoinColumn(name = "job_id")
//	//@MapsId
//	@JsonIgnoreProperties("booking")
	@NotNull(message = "must provide job id")
	private Integer jobId;

//	@OneToOne
//	@JoinColumn(name = "worker_id")
//	//@MapsId
//	@JsonIgnoreProperties("booking")
//	private Workers worker;

//	@OneToOne
//	@JoinColumn(name = "customer_id")
//	//@MapsId
//	@JsonIgnoreProperties("booking")
	@NotNull(message = "must provide customer id")
	private Integer customerId;

//	@OneToOne
//	@JoinColumn(name = "payment_id")
//	//@MapsId
//	@JsonIgnoreProperties("booking")
//	private Payment payment;

	@Enumerated(EnumType.STRING)
	private PaymentStatus paymentStatus;

	@Enumerated(EnumType.STRING)
	private BookingStatus bookingStatus;

	private LocalDate bookingDate;

	//@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate serviceBookDate;

	public Booking() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("in constructor " + getClass().getName());
	}

	public Booking(Integer bookingId, Integer jobId, Integer customerId, PaymentStatus paymentStatus,
			BookingStatus bookingStatus, LocalDate bookingDate, LocalDate serviceBookDate) {
		super();
		this.bookingId = bookingId;
		this.jobId = jobId;
		this.customerId = customerId;
		this.paymentStatus = paymentStatus;
		this.bookingStatus = bookingStatus;
		this.bookingDate = bookingDate;
		this.serviceBookDate = serviceBookDate;
	}

	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	public Integer getJobId() {
		return jobId;
	}

	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public BookingStatus getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(BookingStatus bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public LocalDate getServiceBookDate() {
		return serviceBookDate;
	}

	public void setServiceBookDate(LocalDate serviceBookDate) {
		this.serviceBookDate = serviceBookDate;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", jobId=" + jobId + ", customerId=" + customerId
				+ ", paymentStatus=" + paymentStatus + ", bookingStatus=" + bookingStatus + ", bookingDate="
				+ bookingDate + ", serviceBookDate=" + serviceBookDate + "]";
	}

}
