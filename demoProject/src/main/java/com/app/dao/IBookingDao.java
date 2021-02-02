package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.pojo.Booking;

public interface IBookingDao extends JpaRepository<Booking, Integer> {
	@Query("select b from Booking b where b.bookingStatus='WORKPENDING'")
	List<Booking> findAllBookingByStatus();
	
	@Query("select b from Booking b where b.bookingStatus='WORKDONE'")
	List<Booking> findAllBookingByStatusDone();
}
