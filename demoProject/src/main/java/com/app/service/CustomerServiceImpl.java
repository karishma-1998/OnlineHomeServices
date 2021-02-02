package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ICustomerDao;
import com.app.dao.ICustomerLoginDao;
import com.app.pojo.Customer;

@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService {

	@Autowired(required = true)
	private ICustomerLoginDao dao;

	@Autowired(required = true)
	private ICustomerDao cdao;
	
	@Override
	public Customer validateCustomer(String email, String password) {
		return dao.findByEmailAndPassword(email, password);
	}

	@Override
	public Customer addCustomer(Customer transientCustomer) {
		// TODO Auto-generated method stub
		return cdao.save(transientCustomer);
	}

	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return cdao.findAll();
	}
	
	

}
