package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	@PostMapping
	public Job createJob(@RequestBody Job j) {
		return jobser.createJob(j);
	}
    
	@GetMapping
	public List<Job> getAllJobs() {
		return jobser.getAllJobs();
	}

}
