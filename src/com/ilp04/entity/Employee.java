package com.ilp04.entity;

public class Employee {

	private String employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private Workstation workstation;
	public Employee(String employeeId, String firstName, String lastName, String phone,
			Workstation workstation) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.workstation = workstation;
	}

	public Employee(String id, String firstname) {
		// TODO Auto-generated constructor stub
	}

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Workstation getWorkstation() {
		return workstation;
	}
	public void setWorkstation(Workstation workstation) {
		this.workstation = workstation;
	}
	
}
