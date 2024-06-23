package com.ilp04.entity;

import java.sql.Date;
import java.time.LocalDate;


public class SafetyIncident {

	private String incidentId;
	private LocalDate incidentDate;
	private String description;
	private Workstation workstation;
	private Employee createdBy;
	private Employee updatedBy;
	private String firstName;
	private String LastName;
	private String result;
	
	public SafetyIncident(String incidentId, LocalDate incidentDate, String description, Workstation workstation,
			Employee createdBy, Employee updatedBy) {
		super();
		this.incidentId = incidentId;
		this.incidentDate = incidentDate;
		this.description = description;
		this.workstation = workstation;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}
	
	
	public SafetyIncident(String firstName, String lastName, String description,String result) {
		this.firstName=firstName;
		this.LastName=lastName;
		this.description=description;
		this.result = result;
		
	}
	public String getResult() {
		return result;
	}


	public void setResult(String result) {
		this.result = result;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return LastName;
	}


	public void setLastName(String lastName) {
		LastName = lastName;
	}


	public SafetyIncident() {
		// TODO Auto-generated constructor stub
	}


	public String getIncidentId() {
		return incidentId;
	}
	public void setIncidentId(String incidentId) {
		this.incidentId = incidentId;
	}
	public LocalDate getIncidentDate() {
		return incidentDate;
	}
	public void setIncidentDate(LocalDate incidentDate) {
		this.incidentDate = incidentDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Workstation getWorkstation() {
		return workstation;
	}
	public void setWorkstation(Workstation workstation) {
		this.workstation = workstation;
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