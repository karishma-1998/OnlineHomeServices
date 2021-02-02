package com.app.contoller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.LoginDto;
import com.app.dto.ResponseDTO;
import com.app.pojo.AssignBooking;
import com.app.pojo.Customer;
import com.app.pojo.Workers;
import com.app.service.IWorkerService;

@CrossOrigin(origins ="http://localhost:4200")
@RestController
@RequestMapping("/worker")
public class WorkerController {
	@Autowired
	private IWorkerService service;
	
	public WorkerController() {
		// TODO Auto-generated constructor stub
		System.out.println("in worker controller");
	}
	
	@GetMapping("/{workerId}")
	public ResponseEntity<?> getBookingByWorkerId(@PathVariable int workerId) {
		System.out.println("in get Booking  details by WorkerId");
	try {
			List<AssignBooking> book=service.getAllBookingByWorkerId(workerId);
			return new ResponseEntity<>(book, HttpStatus.OK);
		} catch (RuntimeException e) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@PostMapping("/registerworker")
	public ResponseEntity<?> AddWorker(@RequestBody @Valid Workers newWorker) {
		System.out.println("in create jobs " + newWorker);
		try {
			Workers worker = service.addWorker(newWorker);
			return new ResponseEntity<>(worker, HttpStatus.CREATED);
		} 
		catch (RuntimeException e)
		{
			e.printStackTrace();
			
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
//	@GetMapping("/{workerId}")
//	public ResponseEntity<?> getWorkerHistory(@PathVariable int workerId) {
//		System.out.println("in get worker details");
//		try {
//			Workers worker = service.getWokerHistory(workerId);
//			return new ResponseEntity<>(worker, HttpStatus.OK);
//		} catch (RuntimeException e) {
//			
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//	}
	
	
	@PostMapping("/login")
	public ResponseEntity<?> ValidateWorker(@RequestBody @Valid LoginDto login)
	{
		System.out.println("in login "+ login.getEmail());
		System.out.println("in login "+ login.getPassword());
	Workers worker=service.validate(login.getEmail(), login.getPassword());
		if(worker==null)
		{
			System.out.println("in login null return ");
			return new ResponseEntity<>(new ResponseDTO("failure","Invalid email and password",login),HttpStatus.NO_CONTENT);			
		}else
		{
			System.out.println("in login credentials return ");
			return new ResponseEntity<>(new ResponseDTO("success", "Login Successfull",worker),HttpStatus.OK);			
		}
	}
	
	@PutMapping("/{assignBookId}")
	public ResponseEntity<?> updateJobDetails(@PathVariable int assignBookId, @RequestBody @Valid AssignBooking detachedPojo) {
		System.out.println("in update funds " + assignBookId + " " + detachedPojo);
		AssignBooking updateBooking = service.updateStatus(assignBookId, detachedPojo);
		if (updateBooking == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(updateBooking, HttpStatus.OK);

	}
	
	@GetMapping("/customer/{custId}")
	public ResponseEntity<?> getCustomerById(@PathVariable int custId) {
		System.out.println("in get customer  details by Id");
	try {
			List<Customer> c=service.getCustomerById(custId);
			return new ResponseEntity<>(c, HttpStatus.OK);
		} catch (RuntimeException e) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
