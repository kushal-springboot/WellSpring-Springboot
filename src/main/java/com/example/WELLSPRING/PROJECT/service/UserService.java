package com.example.WELLSPRING.PROJECT.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.WELLSPRING.PROJECT.entity.User;
import com.example.WELLSPRING.PROJECT.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	 private final UserRepository userRepository;
	    private final PasswordEncoder passwordEncoder;

	    public User register(User user) {
	        user.setPassword(passwordEncoder.encode(user.getPassword())); // ✅ encode
	        user.setRole("ROLE_USER");
	        return userRepository.save(user);
	    }
	    
	    public User createAdmin(User user) {
	        user.setPassword(passwordEncoder.encode(user.getPassword())); // ✅ Works
	        user.setRole("ROLE_ADMIN");
	        return userRepository.save(user);
	    }
}
