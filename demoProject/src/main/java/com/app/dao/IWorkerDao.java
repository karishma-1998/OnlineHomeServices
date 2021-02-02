package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.pojo.Workers;

public interface IWorkerDao extends JpaRepository<Workers, Integer>{
	
	@Query("select w from Workers w where w.jobId=:jobId")
	List<Workers> findAllWorkerByJobId(int jobId);
}
