package com.app.contoller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.LoginDto;
import com.app.dto.ResponseDTO;
import com.app.pojo.Customer;
import com.app.service.ICustomerService;

@CrossOrigin(origins ="http://localhost:4200")
@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired(required = true)
	private ICustomerService service;
	
	public CustomerController()
	{
		System.out.println("in customer controller");
	}
	
	@GetMapping("/customers")
	public ResponseEntity<?> listOfCustomers()
	{
		System.out.println("In list of customer");
		List<Customer> customer=service.getAllCustomer();
		if(customer.isEmpty())
		{
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(customer,HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> validateCustomerCredentials(@RequestBody @Valid LoginDto login)
	{
		System.out.println("in login "+ login.getEmail());
		System.out.println("in login "+ login.getPassword());
	Customer c=service.validateCustomer(login.getEmail(), login.getPassword());
		if(c!=null)
		{
			System.out.println("in login credentials return ");
			return new ResponseEntity<>(new ResponseDTO("success", "Login Successfull", c),HttpStatus.OK);
					
		}else
		{
			System.out.println("in login null return ");
			return new ResponseEntity<>(new ResponseDTO("failure","Invalid Email and Password",login),HttpStatus.NO_CONTENT);				
		}
	}
	
	@PostMapping("/registercustomer")
	public ResponseEntity<?> addCustomer(@RequestBody @Valid Customer newCustomer) {
		System.out.println("in create jobs " + newCustomer);
		try {
			Customer customer =service.addCustomer(newCustomer);
			return new ResponseEntity<>(customer, HttpStatus.OK);
		} 
		catch (RuntimeException e)
		{
			e.printStackTrace();
			
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


}
