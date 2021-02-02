package com.app.dao;
import java.util.List;
import com.app.pojo.*;
public interface IAdminDao {
	//String admin_login(String email,String password);
	List<Jobs> getAlljobs();
	List<Customer> getAllCustomer();
	List<Workers> getAllWorkers();
	Jobs addJob(Jobs transientJobs);
	Jobs deleteJob(int JobId);
	Jobs updateJob(int jobId,Jobs detachedPojo);
	Jobs getJobById(int jobId);
	Workers updateWorker(int workerId,Workers detachedPojo);
	String removeWorker(int workerId);
	Workers addWorker(Workers transientWorkers);
	//String updateJob(int JobId,String JobName);
	public List<Booking> getBookingOfCustomer(int customerId);
}
