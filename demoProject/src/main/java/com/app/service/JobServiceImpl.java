package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IJobDao;
import com.app.pojo.Jobs;

@Service
@Transactional
public class JobServiceImpl implements IJobService {

	@Autowired
	private IJobDao dao;
	@Override
	public List<Jobs> getAllJobs() {
		return dao.findAll();
	}
	@Override
	public Optional<Jobs> getJobById(int jobId) {
		
		return dao.findById(jobId);
	}
	
}
