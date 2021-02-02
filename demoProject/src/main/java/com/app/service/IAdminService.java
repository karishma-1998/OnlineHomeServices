package com.app.service;

import java.util.List;

import com.app.pojo.AssignBooking;
import com.app.pojo.Booking;
import com.app.pojo.Customer;
import com.app.pojo.Jobs;
import com.app.pojo.Workers;

public interface IAdminService {
	List<Jobs> getAlljobs();
	List<Customer> getAllCustomer();
	Jobs deleteJob(int JobId);
	Jobs addJob(Jobs transientJobs);
	List<Workers> getAllWorkers();
	String removeWorker(int workerId);
	Workers addWorker(Workers transientWorkers);
	Jobs updateJob(int jobId,Jobs detachedPojo);
	Workers updateWorker(int workerId,Workers detachedPojo);
	//Jobs updateJob(int jobId,Jobs detachedPojo);
	 List<Booking> getBookingOfCustomer(int customerId);
	 
	 AssignBooking addNewBooking(AssignBooking transientJobs);
}
