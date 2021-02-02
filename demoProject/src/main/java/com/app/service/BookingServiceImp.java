package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IBookingDao;
import com.app.dao.IJobDao;
import com.app.pojo.Booking;
import com.app.pojo.BookingStatus;
import com.app.pojo.Jobs;
import java.util.*;

@Service
@Transactional
public class BookingServiceImp implements IBookingService {

	@Autowired(required = true)
	private IBookingDao dao;
	@Autowired
	private IJobDao jobDao;
	
	@Override
	public Booking createBooking(Booking transientBooking) {
		
		return dao.save(transientBooking);
	}


	@Override
	public List<Booking> getAllBooking() {
		
		return  dao.findAll();
	}

	@Override
	public void deleteBooking(int bookingId) {
		dao.deleteById(bookingId);

	}


	@Override
	public Optional<Jobs> getJobById(int jobId) {
		// TODO Auto-generated method stub
		return jobDao.findById(jobId);
	}


	@Override
	public List<Booking> getAllBookingByStatus() {
		// TODO Auto-generated method stub
		return dao.findAllBookingByStatus();
	}


	@Override
	public Booking updateBooking(int id) {
		// TODO Auto-generated method stub
		Booking existingBooking=dao.findById(id).get();
		if(existingBooking!=null)
		{
			existingBooking.setBookingStatus(BookingStatus.WORKDONE);
			dao.save(existingBooking);
			return existingBooking;
		}
		return null;
	}


	@Override
	public List<Booking> getAllBookingByStatusDone() {
		// TODO Auto-generated method stub
		return dao.findAllBookingByStatusDone();
	}

}
