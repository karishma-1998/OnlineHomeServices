package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.pojo.Workers;

public interface ILoginDao extends JpaRepository<Workers, Integer>{

	@Query("select w from Workers w where w.email=:email and w.password=:password")
	Workers validate(String email,String password);
}
