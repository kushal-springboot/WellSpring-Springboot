package com.example.WELLSPRING.PROJECT.controller;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.WELLSPRING.PROJECT.entity.DietPlan;
import com.example.WELLSPRING.PROJECT.service.DietPlanService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/diet")
public class DietController {

	private final DietPlanService service;

    // USER → view own diet plans
    @GetMapping("/my")
    public List<DietPlan> myPlans(
            @AuthenticationPrincipal UserDetails userDetails) {

        return service.getPlansForUser(userDetails.getUsername());
    }

    // ADMIN → view all diet plans
    @GetMapping("/admin/all")
    public List<DietPlan> allPlans() {
        return service.getAllPlans();
    }
}
