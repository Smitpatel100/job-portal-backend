package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserServiceImpl;
import com.example.demo.service.UserServices;

@RestController
@RequestMapping("/api/users")
public class UserController {
private final UserServices userser;


public UserController(UserServices userser) {
	super();
	this.userser = userser;
}

@PostMapping
public User createUser(@RequestBody User u) {
	return userser.saveUser(u);
}

@GetMapping
public List<User> getUsers(){
	return userser.getAllUsers();
}
}
