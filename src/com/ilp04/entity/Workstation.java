package com.ilp04.entity;

public class Workstation {

	private String workstationId;
	private String workstationName;
	public Workstation(String workstationId, String workstationName) {
		super();
		this.workstationId = workstationId;
		this.workstationName = workstationName;
	}
	public Workstation() {
		// TODO Auto-generated constructor stub
	}
	public String getWorkstationId() {
		return workstationId;
	}
	public void setWorkstationId(String workstationId) {
		this.workstationId = workstationId;
	}
	public String getWorkstationName() {
		return workstationName;
	}
	public void setWorkstationName(String workstationName) {
		this.workstationName = workstationName;
	}
	
	
	
}
