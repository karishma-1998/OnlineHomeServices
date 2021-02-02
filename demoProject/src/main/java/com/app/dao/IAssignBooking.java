package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.pojo.AssignBooking;

public interface IAssignBooking extends JpaRepository<AssignBooking, Integer> {
	@Query("select a from AssignBooking a where a.workerId=:workerId")
	List<AssignBooking> findBookingByWorkerId(int workerId);
}
