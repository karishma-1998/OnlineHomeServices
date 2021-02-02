package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.pojo.Customer;


public interface ICustomerLoginDao  extends JpaRepository<Customer, Integer>{
	
	@Query("select c from Customer c where c.email=:email and c.password=:password")
	Customer findByEmailAndPassword(String email,String password);
	

}
