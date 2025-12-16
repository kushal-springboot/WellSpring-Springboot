package com.example.WELLSPRING.PROJECT.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.WELLSPRING.PROJECT.entity.Bmi;
import com.example.WELLSPRING.PROJECT.entity.DietPlan;
import com.example.WELLSPRING.PROJECT.entity.User;
import com.example.WELLSPRING.PROJECT.entity.Waist;
import com.example.WELLSPRING.PROJECT.repository.DietPlanRepository;

import lombok.RequiredArgsConstructor;



@Service
@RequiredArgsConstructor
public class DietPlanService {
	  private final DietPlanRepository repo;

	    // ✅ GENERATE DIET PLAN USING SAVED BMI & WAIST
	    public DietPlan generateFromBmiAndWaist(Bmi bmi, Waist waist, User user) {

	        String bmiStatus = bmi.getBmiStatus();
	        String waistRisk = waist.getRiskLevel();

	        DietPlan plan = new DietPlan();
	        plan.setUser(user);

	        if ("UNDERWEIGHT".equals(bmiStatus)) {
	            plan.setPlanType("WEIGHT GAIN");
	            plan.setBreakfast("Milk + Banana");
	            plan.setLunch("Rice + Dal");
	            plan.setDinner("Chapati + Paneer");

	        } else if ("NORMAL".equals(bmiStatus) && "LOW RISK".equals(waistRisk)) {
	            plan.setPlanType("MAINTAIN");
	            plan.setBreakfast("Oats + Fruits");
	            plan.setLunch("Chapati + Veg");
	            plan.setDinner("Soup");

	        } else {
	            plan.setPlanType("WEIGHT LOSS");
	            plan.setBreakfast("Fruits");
	            plan.setLunch("Salad");
	            plan.setDinner("Soup");
	        }

	        return repo.save(plan);
	    }

	    // USER → view own diet plans
	    public List<DietPlan> getPlansForUser(String username) {
	        return repo.findByUserUsername(username);
	    }

	    // ADMIN → view all diet plans
	    public List<DietPlan> getAllPlans() {
	        return repo.findAll();
	    }
}
