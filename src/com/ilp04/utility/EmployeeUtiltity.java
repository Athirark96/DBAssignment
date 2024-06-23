package com.ilp04.utility;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import com.ilp04.entity.Employee;
import com.ilp04.entity.Workstation;
import com.ilp04.service.EmployeeImpl;
import com.ilp04.service.EmployeeService;
import com.ilp04.service.WorkstationImpl;
import com.ilp04.service.WorkstationService;



public class EmployeeUtiltity {

	public static void main(String[] args) {
		char ch;
		do {
			System.out.println("EMPLOYEE .....");
			System.out.println("1.Display  2.Insert  3.Update");
			Scanner scanner = new Scanner(System.in);
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				getAllEmployee();
				break;
			case 2:

				insertEmployee();
				break;

			case 3:
				updateEmployee();
				break;

			}
			System.out.println("Want to continue(y/n) : ");
			ch = scanner.next().charAt(0);

		} while (ch == 'y');

	}
	private static void updateEmployee() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Employee id : ");
		String employeeId = scanner.nextLine();
		System.out.println("Enter the Employee First Name : ");
		String employeeFirstName = scanner.nextLine();
		System.out.println("Enter the Employee Last Name : ");
		String employeeLastName = scanner.nextLine();
		System.out.println("Enter the Employee Phone : ");
		String employeePhone = scanner.nextLine();
		System.out.println("Enter the Employee WorkstationID : ");
		String employeeWorkstation = scanner.nextLine();
		Workstation workstation = WorkstationImpl.getWorkstation(employeeWorkstation);
		
		Employee employee = new Employee(employeeId,employeeFirstName,employeeLastName,employeePhone,workstation);
		EmployeeService employeeservice = new EmployeeImpl();
		employeeservice.updateEmployee(employee);
		
		
	}
	private static void getAllEmployee() {
		
		 EmployeeService  employeeservice = new EmployeeImpl();
		 ArrayList<Employee> employeeList = employeeservice.getAllEmployee();
			for (Employee employee : employeeList) {
				System.out.println("Employee  ID : " + employee.getEmployeeId());
				System.out.println("Employee  Name : " + employee.getFirstName());
				System.out.println("Employee  Workstation : " + employee.getWorkstation().getWorkstationId());
				
			}
		
	}
	

	private static void insertEmployee() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Employee id : ");
		String employeeId = scanner.nextLine();
		System.out.println("Enter the Employee First Name : ");
		String employeeFirstName = scanner.nextLine();
		System.out.println("Enter the Employee Last Name : ");
		String employeeLastName = scanner.nextLine();
		System.out.println("Enter the Employee Phone : ");
		String employeePhone = scanner.nextLine();
		System.out.println("Enter the Employee WorkstationID : ");
		String employeeWorkstation = scanner.nextLine();
		Workstation workstation = WorkstationImpl.getWorkstation(employeeWorkstation);
		
		Employee employee = new Employee(employeeId,employeeFirstName,employeeLastName,employeePhone,workstation);
		EmployeeService employeeservice = new EmployeeImpl();
		employeeservice.insertIntoEmployee(employee);
		
	}




}


