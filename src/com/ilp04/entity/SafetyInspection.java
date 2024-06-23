package com.ilp04.entity;

import java.time.LocalDate;

public class SafetyInspection {
	private String inspectionid;
	private LocalDate inspectiondate;
	private String result;
	private SafetyIncident SafetyIncidentId;
	private Employee inspectedEmployee;
	private Employee createdBy;
	private Employee updatedBy;
	public SafetyInspection(String inspectionid, LocalDate inspectiondate, String result,
			SafetyIncident safetyIncidentId, Employee inspectedEmployee, Employee createdBy, Employee updatedBy) {
		super();
		this.inspectionid = inspectionid;
		this.inspectiondate = inspectiondate;
		this.result = result;
		SafetyIncidentId = safetyIncidentId;
		this.inspectedEmployee = inspectedEmployee;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}
	public SafetyInspection() {
		// TODO Auto-generated constructor stub
	}
	public String getInspectionid() {
		return inspectionid;
	}
	public void setInspectionid(String inspectionid) {
		this.inspectionid = inspectionid;
	}
	public LocalDate getInspectiondate() {
		return inspectiondate;
	}
	public void setInspectiondate(LocalDate inspectiondate) {
		this.inspectiondate = inspectiondate;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public SafetyIncident getSafetyIncidentId() {
		return SafetyIncidentId;
	}
	public void setSafetyIncidentId(SafetyIncident safetyIncidentId) {
		SafetyIncidentId = safetyIncidentId;
	}
	public Employee getInspectedEmployee() {
		return inspectedEmployee;
	}
	public void setInspectedEmployee(Employee inspectedEmployee) {
		this.inspectedEmployee = inspectedEmployee;
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
