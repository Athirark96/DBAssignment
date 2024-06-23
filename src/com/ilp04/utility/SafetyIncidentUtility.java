package com.ilp04.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.ilp04.entity.Employee;
import com.ilp04.entity.SafetyIncident;
import com.ilp04.entity.Workstation;
import com.ilp04.service.EmployeeImpl;
import com.ilp04.service.EmployeeService;
import com.ilp04.service.SafetyIncidentImpl;
import com.ilp04.service.WorkstationImpl;
import com.ilp04.service.WorkstationService;

public class SafetyIncidentUtility {
	public static void main(String[] args) {
		char ch;
		do {
			System.out.println("SAFETY INCIDENT .....");
			System.out.println("1.Display  2.Insert  3.Update 4.Get Incident Details");
			Scanner scanner = new Scanner(System.in);
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				getAllSafetyIncident();
				break;
			case 2:

				insertSafetyIncident();
				break;

			case 3:
				updateSafetyIncident();
				break;
			case 4:
				checkIncidentDetails();
				break;

			}
			System.out.println("Want to continue(y/n) : ");
			ch = scanner.next().charAt(0);

		} while (ch == 'y');

	}

	private static void checkIncidentDetails() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Date to get the details : ");
		String incidentDateStr = scanner.nextLine();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate incidentDate = LocalDate.parse(incidentDateStr, formatter);
		SafetyIncidentImpl safetyIncidentService = new SafetyIncidentImpl();
		ArrayList<SafetyIncident> safetyincidentList = safetyIncidentService.getSafetyIncident(incidentDate);
		
 
		for(SafetyIncident incident : safetyincidentList) {
			System.out.println("Safety Incident description : "+incident.getDescription());
			System.out.println("Safety Incident Inspected By  : "+incident.getFirstName()+" "+incident.getLastName());
			System.out.println("Safety Incident Result : "+incident.getResult());
			
			
		}

	}

	private static void updateSafetyIncident() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the incidentid : ");
		String incidentId = scanner.nextLine();
		System.out.println("Enter the incidentdate : ");
		String incidentDateStr = scanner.nextLine();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate incidentDate = LocalDate.parse(incidentDateStr, formatter);
		System.out.println("Enter the incident description : ");
		String incidentDescription = scanner.nextLine();
		System.out.println("Enter the incident Workstation ID : ");
		String incidentWorkstationId = scanner.nextLine();
		System.out.println("Enter the incident created by : ");
		String incidentCreate = scanner.nextLine();
		System.out.println("Enter the incident updated by : ");
		String incidentUpdate = scanner.nextLine();
		Workstation workstation = WorkstationImpl.getWorkstation(incidentWorkstationId);
		Employee employee1 = EmployeeImpl.getEmployee(incidentCreate);
		Employee employee2 = EmployeeImpl.getEmployee(incidentUpdate);
		SafetyIncident safetyincident = new SafetyIncident(incidentId, incidentDate, incidentDescription, workstation,
				employee1, employee2);

		SafetyIncidentImpl safetyIncidentService = new SafetyIncidentImpl();
		safetyIncidentService.updateSafetyIncident(safetyincident);
	}

	private static void insertSafetyIncident() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the incidentid : ");
		String incidentId = scanner.nextLine();
		System.out.println("Enter the incidentdate : ");
		String incidentDateStr = scanner.nextLine();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate incidentDate = LocalDate.parse(incidentDateStr, formatter);
		System.out.println("Enter the incident description : ");
		String incidentDescription = scanner.nextLine();
		System.out.println("Enter the incident Workstation ID : ");
		String incidentWorkstationId = scanner.nextLine();
		System.out.println("Enter the incident created by : ");
		String incidentCreate = scanner.nextLine();
		System.out.println("Enter the incident updated by : ");
		String incidentUpdate = scanner.nextLine();
		Workstation workstation = WorkstationImpl.getWorkstation(incidentWorkstationId);
		Employee employee1 = EmployeeImpl.getEmployee(incidentCreate);
		Employee employee2 = EmployeeImpl.getEmployee(incidentUpdate);
		SafetyIncident safetyincident = new SafetyIncident(incidentId, incidentDate, incidentDescription, workstation,
				employee1, employee2);

		SafetyIncidentImpl safetyIncidentService = new SafetyIncidentImpl();
		safetyIncidentService.insertIntoSafetyIncident(safetyincident);

	}

	private static void getAllSafetyIncident() {

		SafetyIncidentImpl safetyIncidentService = new SafetyIncidentImpl();
		ArrayList<SafetyIncident> safetyincidentList = safetyIncidentService.getAllSafetyIncident();
		for (SafetyIncident safetyincident : safetyincidentList) {
			System.out.println("SafetyIncident ID : " + safetyincident.getIncidentId());
			System.out.println("SafetyIncident Date : " + safetyincident.getIncidentDate());
			System.out.println("SafetyIncident Descirption : " + safetyincident.getDescription());
			System.out.println("SafetyIncident Workstation  : " + safetyincident.getWorkstation().getWorkstationId());
			System.out.println("SafetyIncident Created By : " + safetyincident.getCreatedBy().getEmployeeId());
			System.out.println("SafetyIncident Updated By : " + safetyincident.getUpdatedBy().getEmployeeId());

		}

	}

}
