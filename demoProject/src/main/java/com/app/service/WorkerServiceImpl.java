package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IAssignBooking;
import com.app.dao.ICustomerDao;
import com.app.dao.ILoginDao;
import com.app.dao.IWorkerDao;
import com.app.pojo.AssignBooking;
import com.app.pojo.Booking;
import com.app.pojo.Customer;
import com.app.pojo.Workers;

@Service
@Transactional
public class WorkerServiceImpl implements IWorkerService {

	@Autowired
	private IWorkerDao dao;

	@Autowired
	private ILoginDao ldao;
	
	@Autowired
	private IAssignBooking aDao;
	
	@Autowired
	private IBookingService service;
	
	@Autowired
	private ICustomerDao cDao;

	@Override
	public Workers addWorker(Workers transientWorkers) {
		return dao.save(transientWorkers);
	}

	@Override
	public Workers validate(String email, String password) {
		return ldao.validate(email, password);
	}

	@Override
	public List<Workers> getWorkerById(int jobId) {
		// TODO Auto-generated method stub
		return dao.findAllWorkerByJobId(jobId);
	}

	@Override
	public List<AssignBooking> getAllBookingByWorkerId(int workerId) {
		// TODO Auto-generated method stub
		return aDao.findBookingByWorkerId(workerId);
	}

	@Override
	public AssignBooking updateStatus(int id, AssignBooking deatchedPojo) {
		// TODO Auto-generated method stub
		AssignBooking existingBooking=aDao.findById(id).get();
		if(existingBooking!=null) {
			existingBooking.setBookingId(deatchedPojo.getBookingId());
			existingBooking.setCustomerId(deatchedPojo.getCustomerId());
			existingBooking.setJobId(deatchedPojo.getJobId());
			existingBooking.setWorkerId(deatchedPojo.getWorkerId());
			existingBooking.setBookingStatus(deatchedPojo.getBookingStatus());
			Booking booking=service.updateBooking(existingBooking.getBookingId());
			if(booking!=null)
			{
				System.out.println("updated");
			}
			return aDao.save(existingBooking);
		}
		return null;
	}

	@Override
	public List<Customer> getCustomerById(int customerId) {
		List<Customer> c=cDao.findByCustomerId(customerId);
		if(c!=null)
		{
			return c;
		}
		return null;
	}
	

}
