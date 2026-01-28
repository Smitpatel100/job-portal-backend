package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.LoginResponse;
import com.example.demo.entity.User;

public interface UserServices{
User saveUser(User user);
List<User> getAllUsers();
LoginResponse login(LoginRequest request);
}
