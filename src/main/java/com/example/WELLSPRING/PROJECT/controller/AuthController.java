package com.example.WELLSPRING.PROJECT.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.WELLSPRING.PROJECT.entity.User;
import com.example.WELLSPRING.PROJECT.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final UserService service;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return service.register(user);
    }
    
    // ADMIN only
    @PostMapping("/admin/create")
    public User createAdmin(@RequestBody User user) {
        return service.createAdmin(user);
    }
}
