package com.example.demo.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.UserRequestDTO;
import com.example.demo.dto.UserResponseDTO;
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

@PostMapping("/register")
public ApiResponse<UserResponseDTO> register(@RequestBody UserRequestDTO dto) {
    return new ApiResponse<>(
            true,
            "User registered successfully",
            userser.register(dto)
    );
}


@GetMapping
@PreAuthorize("hasRole('ADMIN')")
public ApiResponse<List<UserResponseDTO>> getUsers() {
    return new ApiResponse<>(
            true,
            "Users fetched successfully",
            userser.getAllUsers()
    );
}

}
