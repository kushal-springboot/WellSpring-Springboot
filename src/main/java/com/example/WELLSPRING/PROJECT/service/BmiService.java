package com.example.WELLSPRING.PROJECT.service;

import org.springframework.stereotype.Service;

import com.example.WELLSPRING.PROJECT.entity.Bmi;
import com.example.WELLSPRING.PROJECT.repository.BmiRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BmiService {
	private final BmiRepository repo;

    public Bmi calculate(Bmi bmi) {

        double value = bmi.getWeight() / (bmi.getHeight() * bmi.getHeight());
        bmi.setBmiValue(value);

        if (value < 18.5)
            bmi.setBmiStatus("UNDERWEIGHT");
        else if (value < 25)
            bmi.setBmiStatus("NORMAL");
        else
            bmi.setBmiStatus("OVERWEIGHT");

        return repo.save(bmi);
    }
}
