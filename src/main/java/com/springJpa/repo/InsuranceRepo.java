package com.springJpa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springJpa.entity.InsuranceEntity;

public interface InsuranceRepo extends JpaRepository<InsuranceEntity, Integer> {

	
	@Query(value="select distinct(planName) from InsuranceEntity")
	public List<String> getPlanName();
	
	
	@Query(value="select distinct(planStatus) from InsuranceEntity")
	public List<String> getPlanStatus();
}
