package com.example.WELLSPRING.PROJECT.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.WELLSPRING.PROJECT.dto.HealthRequest;
import com.example.WELLSPRING.PROJECT.entity.Bmi;
import com.example.WELLSPRING.PROJECT.entity.DietPlan;
import com.example.WELLSPRING.PROJECT.entity.User;
import com.example.WELLSPRING.PROJECT.entity.Waist;
import com.example.WELLSPRING.PROJECT.repository.UserRepository;
import com.example.WELLSPRING.PROJECT.service.BmiService;
import com.example.WELLSPRING.PROJECT.service.DietPlanService;
import com.example.WELLSPRING.PROJECT.service.WaistService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/health")
public class HealthController {
	private final BmiService bmiService;
    private final WaistService waistService;
    private final DietPlanService dietPlanService;
    private final UserRepository userRepository; // ✅ ADDED

    @PostMapping("/calculate")
    public DietPlan calculate(
            @RequestBody HealthRequest request,
            @AuthenticationPrincipal UserDetails userDetails) {

        // ✅ FETCH USER FROM DB (FIX)
        User user = userRepository
                .findByUsername(userDetails.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // ✅ BMI
        Bmi bmi = new Bmi();
        bmi.setHeight(request.getHeight());
        bmi.setWeight(request.getWeight());
        bmi.setUser(user);

        // ✅ WAIST
        Waist waist = new Waist();
        waist.setWaistSize(request.getWaistSize());
        waist.setUser(user);

        // ✅ SAVE BMI & WAIST
        Bmi savedBmi = bmiService.calculate(bmi);
        Waist savedWaist = waistService.calculateRisk(waist);

        // ✅ GENERATE DIET PLAN
        return dietPlanService.generateFromBmiAndWaist(savedBmi, savedWaist, user);
    }
}
