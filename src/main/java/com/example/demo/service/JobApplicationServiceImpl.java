package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.dto.JobApplicationResponseDTO;
import com.example.demo.entity.JobApplication;
import com.example.demo.repository.JobApplicationRepository;

@Service
public class JobApplicationServiceImpl implements JobAppService{

	private final JobApplicationRepository jobrepo;
	
	
	public JobApplicationServiceImpl(JobApplicationRepository jobrepo) {
		this.jobrepo = jobrepo;
	}


	@Override
	public JobApplicationResponseDTO apply(JobApplication app) {
		JobApplication saved = jobrepo.save(app);
		
		return new JobApplicationResponseDTO(
				saved.getId(),
				saved.getJob().getId(),
				saved.getCandidate().getId(),
				saved.getStatus().name()
				);
	}

}
