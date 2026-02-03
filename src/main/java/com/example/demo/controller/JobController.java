package com.example.demo.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ApiResponse;
import com.example.demo.entity.Job;
import com.example.demo.service.JobService;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

	private final JobService jobser;

	public JobController(JobService jobser) {
		super();
		this.jobser = jobser;
	}
	
	@PreAuthorize("hasRole('EMPLOYER')")
	@PostMapping
	public ApiResponse<Job> createJob(@RequestBody Job j) {
	    return new ApiResponse<>(
	            true,
	            "Job created successfully",
	            jobser.createJob(j)
	    );
	}

    
    @GetMapping
    public ApiResponse<List<Job>> getAllJobs() {
        return new ApiResponse<>(
                true,
                "Jobs fetched successfully",
                jobser.getAllJobs()
        );
    }


}
