package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Job;

public interface JobService {
Job createJob(Job j);
List<Job> getAllJobs();

}
