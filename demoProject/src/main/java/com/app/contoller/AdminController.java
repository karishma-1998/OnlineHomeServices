package com.app.contoller;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.dto.ResponseDTO;
import com.app.pojo.AssignBooking;
import com.app.pojo.Booking;
import com.app.pojo.Customer;
import com.app.pojo.Jobs;
import com.app.pojo.Workers;
import com.app.service.IAdminService;
import com.app.service.IBookingService;
import com.app.service.IWorkerService;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private IAdminService service;
	
	@Autowired
	private IBookingService bService;
	
	@Autowired
	private IWorkerService wService;

	public AdminController() {
		System.out.println("in ctor of " + getClass().getName());
	}

	@GetMapping("/jobs")
	public ResponseEntity<?> listOfJobs() {
		System.out.println("In list of jobs");
		List<Jobs> jobs = service.getAlljobs();
		if (jobs.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(jobs, HttpStatus.OK);
	}

	@GetMapping("/customer")
	public ResponseEntity<?> listOfCustomer() {
		System.out.println("In list of Customer");
		List<Customer> cust = service.getAllCustomer();
		if (cust.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(cust, HttpStatus.OK);
	}
	
	@GetMapping("/workerByJobId/{jobId}")
	public ResponseEntity<?> listOfWorkerbyJobId(@PathVariable int jobId) {
		System.out.println("In list of listOfWorker by job Id");
		List<Workers> workers =wService.getWorkerById(jobId) ;
		if (workers.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(workers, HttpStatus.OK);
	}
	@GetMapping("/bookings")
	public ResponseEntity<?> listOfBooking() {
		System.out.println("In list of booking");
		List<Booking> bookings = bService.getAllBookingByStatus() ;
		//List<Booking> bookings=bService.getAllBooking();
		if (bookings.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(bookings, HttpStatus.OK);
	}
	
	@GetMapping("/bookingsDone")
	public ResponseEntity<?> listOfBookingDone() {
		System.out.println("In list of booking");
		List<Booking> bookings = bService.getAllBookingByStatusDone() ;
		//List<Booking> bookings=bService.getAllBooking();
		if (bookings.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(bookings, HttpStatus.OK);
	}
	@PostMapping("/addjob")
	public ResponseEntity<?> AddJobs(@RequestBody Jobs newJob) {
		System.out.println("in create jobs " + newJob);
		try {
			Jobs job = service.addJob(newJob);
			return new ResponseEntity<>(job, HttpStatus.OK);
		} catch (RuntimeException e) {
			e.printStackTrace();

			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping("/addNewBooking")
	public ResponseEntity<?> AddNewBooking(@RequestBody @Valid AssignBooking assBooking) {
		System.out.println("in create jobs " + assBooking);
		try {
			AssignBooking book=service.addNewBooking(assBooking);
			return new ResponseEntity<>(book, HttpStatus.OK);
		} catch (RuntimeException e) {
			e.printStackTrace();

			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/{JobId}")
	public ResponseEntity<?> deleteJobDetails(@PathVariable int JobId) {
		System.out.println("in delete emp " + JobId);
		// check if emp exists
		try {
			Jobs deleteJob = service.deleteJob(JobId);
			return new ResponseEntity<>(deleteJob, HttpStatus.OK);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@DeleteMapping("/delete/{workerid}")
	public String removeworker(@PathVariable int workerid) {
		System.out.println("inremove worker " + workerid);
		return service.removeWorker(workerid);
	}

	@GetMapping("/workers")
	public ResponseEntity<?> listOfWorkers() {
		System.out.println("In list of workers");
		List<Workers> workers = service.getAllWorkers();
		if (workers.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(workers, HttpStatus.OK);
	}

	@PutMapping("/{jobId}")
	public ResponseEntity<?> updateJobDetails(@PathVariable int jobId, @RequestBody @Valid Jobs detachedPojo) {
		System.out.println("in update funds " + jobId + " " + detachedPojo);
		Jobs updateJob = service.updateJob(jobId, detachedPojo);
		if (updateJob == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(updateJob, HttpStatus.OK);

	}

	// add in worker controller
	@PutMapping("/update/{workerId}")
	public ResponseEntity<?> updateWorkerDetails(@PathVariable int workerId, @RequestBody @Valid Workers detachedPojo) {
		System.out.println("in update funds " + workerId + " " + detachedPojo);
		Workers updateWorker = service.updateWorker(workerId, detachedPojo);
		if (updateWorker == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(updateWorker, HttpStatus.OK);

	}

	@GetMapping("/{customerId}")
	public ResponseEntity<?> getBookingOfCustomer(@PathVariable int customerId) {
		System.out.println("getbooking of customer");
		List<Booking> booking = service.getBookingOfCustomer(customerId);
		if (booking.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(booking, HttpStatus.OK);
	}

	@PostMapping("/upload")
	public ResponseDTO fileUploadWithParams(@RequestParam String dtls, @RequestParam MultipartFile imageFile) {
		System.out.println("data " + dtls + " " + imageFile.getOriginalFilename());
		try {
			// un marshalling json--> java
			Jobs job = new ObjectMapper().readValue(dtls, Jobs.class);
			job.setImage(imageFile.getBytes());
			job.setImageContentType(imageFile.getContentType());

			// imageFile.transferTo(new File(location, imageFile.getOriginalFilename()));
			// System.out.println("user dtls " + u);
			service.addJob(job);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseDTO("File uploaded :" + imageFile.getOriginalFilename() + " @ ", LocalDateTime.now());
	}
	

}
