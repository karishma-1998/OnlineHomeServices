package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IAdminDao;
import com.app.dao.IAssignBooking;
import com.app.pojo.AssignBooking;
import com.app.pojo.Booking;
import com.app.pojo.Customer;
import com.app.pojo.Jobs;
import com.app.pojo.Workers;
@Service
@Transactional
public class AdminServiceImp implements IAdminService {

		@Autowired
		private IAdminDao dao;
		@Autowired
		private IAssignBooking aDao;
		
	@Override
	public List<Jobs> getAlljobs() {
		// TODO Auto-generated method stub
		return dao.getAlljobs();
	}

	@Override
	public Jobs deleteJob(int JobId) {
		// TODO Auto-generated method stub
		return dao.deleteJob(JobId);
	}

	@Override
	public Jobs addJob(Jobs transientJobs) {
		// TODO Auto-generated method stub
		return dao.addJob(transientJobs);
	}

	@Override
	public List<Workers> getAllWorkers() {
		// TODO Auto-generated method stub
		return dao.getAllWorkers();
	}

	@Override
	public String removeWorker(int workerId) {
		// TODO Auto-generated method stub
		return dao.removeWorker(workerId);
	}

	@Override
	public Workers addWorker(Workers transientWorkers) {
		// TODO Auto-generated method stub
		return dao.addWorker(transientWorkers);
	}

	@Override
	public Jobs updateJob(int jobId,Jobs detachedPojo) {
		// TODO Auto-generated method stub
		Jobs existingJob = dao.getJobById(jobId);
		if (existingJob != null) {
			//properties : qty n date
			existingJob.setJobName(detachedPojo.getJobName());
			existingJob.setJobDescription(detachedPojo.getJobDescription());
			existingJob.setPrice(detachedPojo.getPrice());
			existingJob.setDiscount(detachedPojo.getDiscount());
			return dao.updateJob(jobId,existingJob);
		}
		return null;
	}

	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return dao.getAllCustomer();
	}

	@Override
	public Workers updateWorker(int workerId, Workers detachedPojo) {
		// TODO Auto-generated method stub
		return dao.updateWorker(workerId, detachedPojo);
	}

	@Override
	public List<Booking> getBookingOfCustomer(int customerId) {
		// TODO Auto-generated method stub
		return dao.getBookingOfCustomer(customerId);
	}

	@Override
	public AssignBooking addNewBooking(AssignBooking transientJobs) {
		// TODO Auto-generated method stub
		return aDao.save(transientJobs);
	}

}
