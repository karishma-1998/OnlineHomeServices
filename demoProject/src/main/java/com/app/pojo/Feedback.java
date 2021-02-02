package com.app.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "feedback")
public class Feedback {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="feedback_id")
	private Integer feedbackId;

	@Column(length = 100)
	private String email;

	@Column(length = 20)
	private Integer rating;

	private String suggestion;

	
	private Integer customerId;

	
	private Integer workerId;

	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Feedback(Integer feedbackId, String email, Integer rating, String suggestion, Integer customer,
			Integer worker) {
		super();
		this.feedbackId = feedbackId;
		this.email = email;
		this.rating = rating;
		this.suggestion = suggestion;
		this.customerId = customer;
		this.workerId = worker;
	}

	public Integer getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(Integer feedbackId) {
		this.feedbackId = feedbackId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getSuggestion() {
		return suggestion;
	}

	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}

	

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getWorkerId() {
		return workerId;
	}

	public void setWorkerId(Integer workerId) {
		this.workerId = workerId;
	}

	@Override
	public String toString() {
		return "Feedback [feedbackId=" + feedbackId + ", email=" + email + ", rating=" + rating + ", suggestion="
				+ suggestion + ", customer=" + customerId + ", worker=" + workerId + "]";
	}

}