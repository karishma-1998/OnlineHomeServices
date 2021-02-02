package com.app.contoller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ImageDTO;
import com.app.pojo.Booking;
import com.app.pojo.Jobs;
import com.app.service.IBookingService;
import com.app.service.IJobService;

@CrossOrigin(origins ="http://localhost:4200")
@RestController
@RequestMapping("/booking")
public class BookingController {
	@Autowired
	private IBookingService service;
	@Autowired
	private IJobService jService;
	
	
	public BookingController()
	{
		System.out.println("in customer controller");
	}
	
	@GetMapping("/services/{jobId}")
	public ResponseEntity<?> downloadImage(@PathVariable int jobId) throws IOException {
		System.out.println("in img download " + jobId);
		Jobs u = jService.getJobById(jobId).get();
//		Path path = Paths.get(location, imgName);
		ImageDTO img = new ImageDTO();
		// img.setName(imgName);
		img.setData(u.getImage());
		img.setType(u.getImageContentType());
//		System.out.println(img.getType());

		return new ResponseEntity<>(img, HttpStatus.OK);

	}
	
	@GetMapping("/bookings")
	public ResponseEntity<?> listOfBookings()
	{
		System.out.println("In list of booking");
		List<Booking> booking=service.getAllBooking();
		if(booking.isEmpty())
		{
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(booking,HttpStatus.OK);
	}

	@PostMapping("/createbooking")
	public ResponseEntity<?> createBooking(@RequestBody @Valid Booking newBooking) {
		System.out.println("in create booking " + newBooking);
		try {
			Booking booking =service.createBooking(newBooking);
			return new ResponseEntity<>(booking, HttpStatus.OK);
		} 
		catch (RuntimeException e)
		{
			e.printStackTrace();
			
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{jobId}")
	public ResponseEntity<?> getJobById(@PathVariable int jobId)
	{
		System.out.println("in job id");
		try {
			Optional<Jobs> j=service.getJobById(jobId);
			return new ResponseEntity<>(j,HttpStatus.OK);
		}
		catch(RuntimeException e){
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
