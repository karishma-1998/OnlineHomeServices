package com.app.pojo;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;


@Entity
@Table(name = "jobs")
public class Jobs {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="job_id")
	private Integer JobId;// 1//2
	@Column(length = 30, unique = true)
	
	private String JobName;

	private String JobDescription;

	private Double Price;

	private Double Discount;

	@Lob
	private byte[] image;

	@Column(length = 30)
	private String imageContentType;
	

	public Jobs() {

	}
	
	

	public Jobs(Integer jobId) {
		super();
		JobId = jobId;
	}



	public Jobs(Integer jobId, String jobName, String jobDescription, Double price, 
			Double discount, 
			Booking booking, byte[] image, String imageContentType) {
		super();
		JobId = jobId;
		JobName = jobName;
		JobDescription = jobDescription;
		Price = price;
		Discount = discount;
	//	this.worker = worker;
		//this.booking = booking;
		this.image = image;
		this.imageContentType = imageContentType;
	}

	public Integer getJobId() {
		return JobId;
	}

	public void setJobId(Integer jobId) {
		JobId = jobId;
	}

	public String getJobName() {
		return JobName;
	}

	public void setJobName(String jobName) {
		JobName = jobName;
	}

	public String getJobDescription() {
		return JobDescription;
	}

	public void setJobDescription(String jobDescription) {
		JobDescription = jobDescription;
	}

	public Double getPrice() {
		return Price;
	}

	public void setPrice(Double price) {
		Price = price;
	}

	public Double getDiscount() {
		return Discount;
	}

	public void setDiscount(Double discount) {
		Discount = discount;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getImageContentType() {
		return imageContentType;
	}

	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}

	@Override
	public String toString() {
		return "Jobs [JobId=" + JobId + ", JobName=" + JobName + ", JobDescription=" + JobDescription + ", Price="
				+ Price + ", Discount=" + Discount  + ", image="
				+ Arrays.toString(image) + ", imageContentType=" + imageContentType + "]";
	}

	
}
