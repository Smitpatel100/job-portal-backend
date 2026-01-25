package com.example.demo.dto;

public class JobApplicationResponseDTO {
   private long applicationId;
   private long jobId;
   private long candidateId;
   private String status;
   public JobApplicationResponseDTO() {
	super();
   }
   public JobApplicationResponseDTO(long applicationId, long jobId, long candidateId, String status) {
	super();
	this.applicationId = applicationId;
	this.jobId = jobId;
	this.candidateId = candidateId;
	this.status = status;
   }
   public long getApplicationId() {
	return applicationId;
   }
   public void setApplicationId(long applicationId) {
	this.applicationId = applicationId;
   }
   public long getJobId() {
	return jobId;
   }
   public void setJobId(long jobId) {
	this.jobId = jobId;
   }
   public long getCandidateId() {
	return candidateId;
   }
   public void setCandidateId(long candidateId) {
	this.candidateId = candidateId;
   }
   public String getStatus() {
	return status;
   }
   public void setStatus(String status) {
	this.status = status;
   }
   
   
}
