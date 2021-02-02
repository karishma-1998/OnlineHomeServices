package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.app.pojo.Booking;
import com.app.pojo.Customer;
import com.app.pojo.Jobs;
import com.app.pojo.Workers;

@Repository
public class AdminImp implements IAdminDao {
	@PersistenceContext//JPA annotation
	private EntityManager mgr;

	@Override
	public List<Jobs> getAlljobs() {
		String jpql="select p from Jobs p";
		return mgr.createQuery(jpql, Jobs.class).getResultList();
	}

	@Override
	public Jobs deleteJob(int JobId) {
		//String mesg="Job deletion failed";
		Jobs j=mgr.find(Jobs.class,  JobId);
		if(j!=null)
		{
			mgr.remove(j);
			//mesg="job delete successfull";
		}
		return j;
	}

	@Override
	public Jobs addJob(Jobs transientJobs) {
		mgr.persist(transientJobs);
		return transientJobs;
	}

	@Override
	public List<Workers> getAllWorkers() {
		String jpql="select w from Workers w";
		return mgr.createQuery(jpql, Workers.class).getResultList();
	}

	@Override
	public String removeWorker(int workerId) {
		String mesg="worker remove failed";
		Workers w=mgr.find(Workers.class,workerId);
		if(w!=null)
		{
			mgr.remove(w);
			mesg="Worker remove successfull";
		}
		
		
		return mesg;
		
		
	}

	@Override
	public Workers addWorker(Workers transientWorkers) {
		
		mgr.persist(transientWorkers);
		return transientWorkers;
	}

	@Override
	public Jobs updateJob(int jobId,Jobs detachedPojo) {
		return mgr.merge(detachedPojo);
	}

	@Override
	public Jobs getJobById(int jobId) {
		return mgr.find(Jobs.class, jobId);
	}

	@Override
	public List<Customer> getAllCustomer() {
		String jpql="select c from Customer c";
		return mgr.createQuery(jpql, Customer.class).getResultList();
	}

	@Override
	public Workers updateWorker(int workerId, Workers detachedPojo) {
		// TODO Auto-generated method stub
		return mgr.merge(detachedPojo);
	}

	@Override
	public List<Booking> getBookingOfCustomer(int customerId) {
		String jpql = "select b from Booking b where b.customerId=:customerId";
		return mgr.createQuery(jpql,Booking.class).setParameter("customerId", customerId).getResultList();
	}
	

	
	
	/*@Override
	public String updateJob(int JobId, String JobName) {
		String jpql="select j from Jobs j where j. "
		
	}*/
	
	
	
	
	/*@Override
	//public String admin_login(String email, String password) {
		
		
		return null;
	}*/

}
