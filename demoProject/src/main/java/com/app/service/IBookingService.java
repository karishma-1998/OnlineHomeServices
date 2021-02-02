package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.pojo.Booking;
import com.app.pojo.Jobs;

public interface IBookingService {
	Booking createBooking(Booking transientBooking);
	List<Booking> getAllBooking();
	void deleteBooking(int bookingId);
	Optional<Jobs> getJobById(int jobId);
	List<Booking> getAllBookingByStatus();
	List<Booking> getAllBookingByStatusDone();
	Booking updateBooking(int id);
	
}
