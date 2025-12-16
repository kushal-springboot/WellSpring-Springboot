package com.example.WELLSPRING.PROJECT.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.WELLSPRING.PROJECT.entity.DietPlan;

public interface DietPlanRepository  extends JpaRepository<DietPlan, Long>  {
	List<DietPlan> findByUserUsername(String username);
}
