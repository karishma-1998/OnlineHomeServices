package com.app.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.app.pojo.AssignBooking;
import com.app.pojo.Customer;
import com.app.pojo.Workers;

public interface IWorkerService {
	Workers addWorker(Workers transientWorkers);
	//Workers getWokerHistory(int workerId);
	
	@Query("select w from Workers w where w.email=:email and w.password=:password")
	Workers  validate(String email,String password);
	
	List<Workers> getWorkerById(int jobId);
	
	List<AssignBooking> getAllBookingByWorkerId(int workerId);
	
	AssignBooking updateStatus(int id,AssignBooking deatchedPojo);
	
	List<Customer> getCustomerById(int customerId);
}
