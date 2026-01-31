package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.LoginResponse;
import com.example.demo.dto.UserRequestDTO;
import com.example.demo.dto.UserResponseDTO;
import com.example.demo.entity.User;

public interface UserServices{
UserResponseDTO register(UserRequestDTO dto);
List<UserResponseDTO> getAllUsers();
LoginResponse login(LoginRequest request);
}
