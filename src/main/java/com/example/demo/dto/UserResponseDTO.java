package com.example.demo.dto;

public class UserResponseDTO {
    private Long id;
    private String name;
    private String email;
    private String role;
	public UserResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserResponseDTO(Long id, String name, String email, String role) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.role = role;
	}
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getRole() {
		return role;
	}
    
}

