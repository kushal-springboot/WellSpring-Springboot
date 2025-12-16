package com.example.WELLSPRING.PROJECT.service;

import org.springframework.stereotype.Service;

import com.example.WELLSPRING.PROJECT.entity.Waist;
import com.example.WELLSPRING.PROJECT.repository.WaistRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WaistService {
	 private final WaistRepository repo;

	    public Waist calculateRisk(Waist waist) {

	        if (waist.getWaistSize() < 80)
	            waist.setRiskLevel("LOW RISK");
	        else if (waist.getWaistSize() < 100)
	            waist.setRiskLevel("MODERATE RISK");
	        else
	            waist.setRiskLevel("HIGH RISK");

	        return repo.save(waist);
	    }
}
