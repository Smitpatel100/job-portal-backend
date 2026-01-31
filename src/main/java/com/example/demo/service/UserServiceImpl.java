package com.example.demo.service;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.LoginResponse;
import com.example.demo.dto.UserRequestDTO;
import com.example.demo.dto.UserResponseDTO;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JwtUtil;

@Service
public class UserServiceImpl implements UserServices{
	private final UserRepository userRepo;
	private final BCryptPasswordEncoder passwordEncoder;
	private final JwtUtil jwtUtil;

	

	public UserServiceImpl(UserRepository userRepo, BCryptPasswordEncoder encoder,JwtUtil jwtUtil) {
		super();
		this.userRepo = userRepo;
		this.passwordEncoder = encoder;
	    this.jwtUtil = jwtUtil;
	}
	
	

	@Override
    public UserResponseDTO register(UserRequestDTO dto) {

        if (userRepo.findByEmail(dto.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email already exists");
        }

        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setRole(Role.CANDIDATE);

        User saved = userRepo.save(user);

        return new UserResponseDTO(
                saved.getId(),
                saved.getName(),
                saved.getEmail(),
                saved.getRole().name()
        );
    }

	@Override
	public List<UserResponseDTO> getAllUsers() {
	    return userRepo.findAll()
	            .stream()
	            .map(user -> new UserResponseDTO(
	                    user.getId(),
	                    user.getName(),
	                    user.getEmail(),
	                    user.getRole().name()
	            ))
	            .toList();
	}




	@Override
	public LoginResponse login(LoginRequest request) {
		User user = userRepo.findByEmail(request.getEmail())
				.orElseThrow(() ->new RuntimeException("user not found"));
		
		if(!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
			throw new IllegalArgumentException("Invalid password");

		}
		String token = jwtUtil.generateToken(
		        user.getEmail(),
		        user.getRole().name()
		);
		return new LoginResponse(token);
	}

}
