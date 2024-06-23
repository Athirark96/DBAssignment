package com.ilp04.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.ilp04.dao.EmployeeDAO;
import com.ilp04.dao.WorkstationDAO;
import com.ilp04.entity.Employee;
import com.ilp04.entity.Workstation;

public class EmployeeImpl implements EmployeeService {

	@Override
	public ArrayList<Employee> getAllEmployee() {
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		EmployeeDAO employeeDAO = new EmployeeDAO();
		Connection connection = employeeDAO.getConnection();
		employeeList = employeeDAO.getAllEmployee(connection);
		return employeeList;
	}

	@Override
	public void insertIntoEmployee(Employee employee) {
		EmployeeDAO employeeDAO = new EmployeeDAO();
		Connection connection =employeeDAO.getConnection();
		int rowsInserted = employeeDAO.insertIntoEmployee(employee, connection);
		employeeDAO.closeConnection(connection);
		if (rowsInserted > 0) {
			System.out.println("employee inserted successfully!");
		} else {
			System.out.println("Failed to insert employee.");
		}
		
	}

	@Override
	public void updateEmployee(Employee employee) {
		EmployeeDAO employeeDAO = new EmployeeDAO();
		Connection connection =employeeDAO.getConnection();
		int rowsInserted = employeeDAO.updateEmployee(employee, connection);
		employeeDAO.closeConnection(connection);
		if (rowsInserted > 0) {
			System.out.println("employee updated successfully!");
		} else {
			System.out.println("Failed to insert employee.");
		}
		
	}

	public static Employee getEmployee(String createdBy) {
		Employee employee = new Employee();
		EmployeeDAO employeeDAO = new EmployeeDAO();
		Connection connection = employeeDAO.getConnection();
		employee = employeeDAO.getEmployee(connection,createdBy);
		return employee;
	}

	

	
}
