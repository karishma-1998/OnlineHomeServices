package com.app.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.app.pojo.Customer;

public interface ICustomerService {
//List<Customer> getAllCustomers();

//List<Jobs> getAllJobs();
	@Query("select c from Customer c where c.email=:email and c.password=:password")
	Customer validateCustomer(String email, String password);
	
	Customer addCustomer(Customer transientCustomer);
	List<Customer> getAllCustomer();
	
}
