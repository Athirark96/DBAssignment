package com.ilp04.service;

import java.util.ArrayList;

import com.ilp04.entity.Employee;

public interface EmployeeService {

	public ArrayList<Employee> getAllEmployee();
	public void insertIntoEmployee(Employee employee);
	public void updateEmployee(Employee employee);
}
