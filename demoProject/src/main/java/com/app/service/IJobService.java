package com.app.service;

import java.util.List;

import com.app.pojo.Jobs;

public interface IJobService {
	List<Jobs> getAllJobs();
	java.util.Optional<Jobs> getJobById(int jobId);
}
