package com.example.demo.service;

import com.example.demo.dto.JobApplicationResponseDTO;
import com.example.demo.entity.JobApplication;

public interface JobAppService {
	JobApplicationResponseDTO apply(JobApplication app);
}
