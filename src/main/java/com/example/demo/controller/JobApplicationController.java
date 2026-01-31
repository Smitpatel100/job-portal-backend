package com.example.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.JobApplicationResponseDTO;
import com.example.demo.entity.JobApplication;
import com.example.demo.service.JobAppService;

@RestController
@RequestMapping("/api/application")
public class JobApplicationController {

	 private final JobAppService jobser;

	 public JobApplicationController(JobAppService jobser) {
		super();
		this.jobser = jobser;
	 }
	 
	    @PreAuthorize("hasRole('CANDIDATE')")
	    @PostMapping
	    public JobApplicationResponseDTO apply(@RequestBody JobApplication app) {
			return jobser.apply(app);
	    }
		
	 }
