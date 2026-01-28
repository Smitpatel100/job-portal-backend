package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.LoginResponse;
import com.example.demo.service.UserServices;

@RestController
@RequestMapping("/api/auth")

public class AuthController {
    private final UserServices userser;

	public AuthController(UserServices userser) {
		super();
		this.userser = userser;
	}
     
	@PostMapping("/login")
    public LoginResponse Login(@RequestBody LoginRequest req) {
    	    return userser.login(req);
    }
}
