package com.example.WELLSPRING.PROJECT.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bmi {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private double height;
	    private double weight;
	    private double bmiValue;
	    private String bmiStatus;

	    @ManyToOne
	    @JoinColumn(name = "user_id") // ✅ IMPORTANT
	    private User user;
}
