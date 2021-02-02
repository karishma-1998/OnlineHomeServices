package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.pojo.Customer;

public interface ICustomerDao extends JpaRepository<Customer, Integer> {
	@Query("select c from Customer c where c.customerId=:customerId")
	List<Customer> findByCustomerId(Integer customerId);
}
