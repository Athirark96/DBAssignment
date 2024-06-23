package com.ilp04.entity;

import java.time.LocalDate;

public class Training
{
	
	private String trainingId;
	private LocalDate trainingDate;
	private String trainingDescription;
	private SafetyIncident safetyIncidentId;
	private Employee createdBy;
	private Employee updatedBy;
	public Training(String trainingId, LocalDate trainingDate, String trainingDescription,
			SafetyIncident safetyIncidentId, Employee createdBy, Employee updatedBy) {
		super();
		this.trainingId = trainingId;
		this.trainingDate = trainingDate;
		this.trainingDescription = trainingDescription;
		this.safetyIncidentId = safetyIncidentId;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}
	public String getTrainingId() {
		return trainingId;
	}
	public void setTrainingId(String trainingId) {
		this.trainingId = trainingId;
	}
	public LocalDate getTrainingDate() {
		return trainingDate;
	}
	public void setTrainingDate(LocalDate trainingDate) {
		this.trainingDate = trainingDate;
	}
	public String getTrainingDescription() {
		return trainingDescription;
	}
	public void setTrainingDescription(String trainingDescription) {
		this.trainingDescription = trainingDescription;
	}
	public SafetyIncident getSafetyIncidentId() {
		return safetyIncidentId;
	}
	public void setSafetyIncidentId(SafetyIncident safetyIncidentId) {
		this.safetyIncidentId = safetyIncidentId;
	}
	public Employee getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Employee createdBy) {
		this.createdBy = createdBy;
	}
	public Employee getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(Employee updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	
	
}
