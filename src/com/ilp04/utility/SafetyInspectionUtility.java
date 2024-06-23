package com.ilp04.utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import com.ilp04.entity.Employee;
import com.ilp04.entity.SafetyIncident;
import com.ilp04.entity.SafetyInspection;
import com.ilp04.service.EmployeeImpl;
import com.ilp04.service.SafetyIncidentImpl;
import com.ilp04.service.SafetyInspectionImpl;

public class SafetyInspectionUtility {

	public static void main(String[] args) {
		char ch;
		do {
			System.out.println("SAFETY INSPECTION .....");
			System.out.println("1.Display  2.Insert  3.Update");
			Scanner scanner = new Scanner(System.in);
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				getAllSafetyInspection();
				break;
			case 2:

				insertSafetyInspection();
				break;

			case 3:
				updateSafetyInspection();
				break;

			}
			System.out.println("Want to continue(y/n) : ");
			ch = scanner.next().charAt(0);

		} while (ch == 'y');

	}

	private static void updateSafetyInspection() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the inspectionid to get updated : ");
		String inspectionId = scanner.nextLine();
		System.out.println("Enter the incidentDate : ");
		String inspectionDateStr = scanner.nextLine();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate inspectionDate = LocalDate.parse(inspectionDateStr, formatter);
		System.out.println("Enter the incident result as (pass,fail,pending) : ");
		String inspectionResult = scanner.nextLine();
		System.out.println("Enter the Safety Incident id to get inspected  : ");
		String inspectionIncidentId = scanner.nextLine();
		System.out.println("Enter the Safety Incident id  inspected by employee id  : ");
		String inspectionEmployeeId = scanner.nextLine();
		System.out.println("Enter the incident created by : ");
		String inspectionCreate = scanner.nextLine();
		System.out.println("Enter the incident updated by : ");
		String inspectionUpdate = scanner.nextLine();
		
		SafetyIncident safetyincident = SafetyIncidentImpl.getIncident(inspectionIncidentId);
		Employee employee =  EmployeeImpl.getEmployee(inspectionEmployeeId);
		Employee employee1 = EmployeeImpl.getEmployee(inspectionCreate);
		Employee employee2 = EmployeeImpl.getEmployee(inspectionUpdate);
		SafetyInspection inspection = new SafetyInspection(inspectionId,inspectionDate,inspectionResult,safetyincident,
				employee,employee1,employee2);
		
		SafetyInspectionImpl safetyInspectionService = new SafetyInspectionImpl();
		safetyInspectionService.updateIntoSafetyInspection(inspection);
		
	}

	private static void insertSafetyInspection() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the inspectionid : ");
		String inspectionId = scanner.nextLine();
		System.out.println("Enter the incidentDate : ");
		String inspectionDateStr = scanner.nextLine();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate inspectionDate = LocalDate.parse(inspectionDateStr, formatter);
		System.out.println("Enter the incident result as (pass,fail,pending) : ");
		String inspectionResult = scanner.nextLine();
		System.out.println("Enter the Safety Incident id to get inspected  : ");
		String inspectionIncidentId = scanner.nextLine();
		System.out.println("Enter the Safety Incident id  inspected by employee id  : ");
		String inspectionEmployeeId = scanner.nextLine();
		System.out.println("Enter the incident created by : ");
		String inspectionCreate = scanner.nextLine();
		System.out.println("Enter the incident updated by : ");
		String inspectionUpdate = scanner.nextLine();
		
		SafetyIncident safetyincident = SafetyIncidentImpl.getIncident(inspectionIncidentId);
		Employee employee =  EmployeeImpl.getEmployee(inspectionEmployeeId);
		Employee employee1 = EmployeeImpl.getEmployee(inspectionCreate);
		Employee employee2 = EmployeeImpl.getEmployee(inspectionUpdate);
		SafetyInspection inspection = new SafetyInspection(inspectionId,inspectionDate,inspectionResult,safetyincident,
				employee,employee1,employee2);
		
		SafetyInspectionImpl safetyInspectionService = new SafetyInspectionImpl();
		safetyInspectionService.insertIntoSafetyInspection(inspection);
		
	}

	private static void getAllSafetyInspection() {
		SafetyInspectionImpl safetyInspectionService = new SafetyInspectionImpl();
		ArrayList<SafetyInspection> safetyinspectionList = safetyInspectionService.getAllSafetyInspection();
		for (SafetyInspection safetyinspection : safetyinspectionList) {
			System.out.println("Safety Inspection ID : " + safetyinspection.getInspectionid());
			System.out.println("Safety Inspection Date : " + safetyinspection.getInspectiondate());
			System.out.println("Safety Inspection Result : " + safetyinspection.getResult());
			System.out.println(
					"Safety Inspection for Incident : " + safetyinspection.getSafetyIncidentId().getIncidentId());
			System.out.println("Safety Inspection By : " + safetyinspection.getInspectedEmployee().getEmployeeId());
			System.out.println("Safety Inspection Created By : " + safetyinspection.getCreatedBy().getEmployeeId());
			System.out.println("Safety Inspection Updated By  : " + safetyinspection.getUpdatedBy().getEmployeeId());

		}

	}

}
