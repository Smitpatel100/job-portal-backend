package com.example.demo.service;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.LoginResponse;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserServices{
	private final UserRepository userRepo;
	private final BCryptPasswordEncoder passwordEncoder;
	

	public UserServiceImpl(UserRepository userRepo, BCryptPasswordEncoder encoder) {
		super();
		this.userRepo = userRepo;
		this.passwordEncoder = encoder;
	}
	
	

	@Override
	public User saveUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepo.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}



	@Override
	public LoginResponse login(LoginRequest request) {
		User user = userRepo.findByEmail(request.getEmail())
				.orElseThrow(() ->new RuntimeException("user not found"));
		
		if(!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
				throw new RuntimeException("invalid password");
		}
		return new LoginResponse("login successful");
	}

}
