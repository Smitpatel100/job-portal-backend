package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Job;
import com.example.demo.repository.JobRepository;
@Service
public class JobServiceImpl implements JobService{
	
	private final JobRepository jobrepo;
	

	public JobServiceImpl(JobRepository jobrepo) {
		super();
		this.jobrepo = jobrepo;
	}

	@Override
	public Job createJob(Job j) {
		return jobrepo.save(j);
	}

	@Override
	public List<Job> getAllJobs() {
		return jobrepo.findAll();
	}

}
