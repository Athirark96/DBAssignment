package com.ilp04.utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import com.ilp04.entity.Employee;
import com.ilp04.entity.SafetyIncident;
import com.ilp04.entity.Training;
import com.ilp04.service.EmployeeImpl;
import com.ilp04.service.SafetyIncidentImpl;
import com.ilp04.service.SafetyInspectionImpl;
import com.ilp04.service.TrainingImpl;
import com.ilp04.service.TrainingService;

public class TrainingUtility {

	public static void main(String[] args) {
		char ch;
		do {
			System.out.println("TRAINING .....");
			System.out.println("1.Display  2.Insert  3.Update");
			Scanner scanner = new Scanner(System.in);
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				getAllTrainingDetails();
				break;
			case 2:

				insertTrainingDetails();
				break;

			case 3:
				updateTrainingDetails();
				break;

			}
			System.out.println("Want to continue(y/n) : ");
			ch = scanner.next().charAt(0);

		} while (ch == 'y');

	}

	private static void updateTrainingDetails() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Training Id : ");
		String id = scanner.nextLine();
		System.out.println("Enter the traning Date : ");
		String trainingDateStr = scanner.nextLine();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate trainingDate = LocalDate.parse(trainingDateStr, formatter);
		System.out.println("Enter the Training Description : ");
		String description = scanner.nextLine();
		System.out.println("Enter the Training given to Incident id  : ");
		String incidentid = scanner.nextLine();
		System.out.println("Enter the incident created by : ");
		String inspectionCreate = scanner.nextLine();
		System.out.println("Enter the incident updated by : ");
		String inspectionUpdate = scanner.nextLine();
		

		SafetyIncident safetyincident = SafetyIncidentImpl.getIncident(incidentid);
		Employee employee1 = EmployeeImpl.getEmployee(inspectionCreate);
		Employee employee2 = EmployeeImpl.getEmployee(inspectionUpdate);
		Training training  = new Training(id,trainingDate,description,safetyincident,employee1,employee2);
		

		TrainingImpl trainingService = new TrainingImpl();
		trainingService.updateIntoTraining(training);
		
		
	}

	private static void insertTrainingDetails() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Training Id : ");
		String id = scanner.nextLine();
		System.out.println("Enter the traning Date : ");
		String trainingDateStr = scanner.nextLine();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate trainingDate = LocalDate.parse(trainingDateStr, formatter);
		System.out.println("Enter the Training Description : ");
		String description = scanner.nextLine();
		System.out.println("Enter the Training given to Incident id  : ");
		String incidentid = scanner.nextLine();
		System.out.println("Enter the incident created by : ");
		String inspectionCreate = scanner.nextLine();
		System.out.println("Enter the incident updated by : ");
		String inspectionUpdate = scanner.nextLine();
		

		SafetyIncident safetyincident = SafetyIncidentImpl.getIncident(incidentid);
		Employee employee1 = EmployeeImpl.getEmployee(inspectionCreate);
		Employee employee2 = EmployeeImpl.getEmployee(inspectionUpdate);
		Training training  = new Training(id,trainingDate,description,safetyincident,employee1,employee2);
		

		TrainingImpl trainingService = new TrainingImpl();
		trainingService.insertIntoTraining(training);
		
		
		
		
		
	}

	private static void getAllTrainingDetails() {
		TrainingImpl trainingService = new TrainingImpl();
		ArrayList<Training> trainingList = trainingService.getTrainingDetails();
		for (Training training : trainingList) {
			System.out.println("Training ID : " + training.getTrainingId());
			System.out.println("Training Date : " + training.getTrainingDate());
			System.out.println("Training Description : " + training.getTrainingDescription());
			System.out.println("Training given to Incident  : " + training.getSafetyIncidentId().getIncidentId());
			System.out.println("Training Created By : " + training.getCreatedBy().getEmployeeId());
			System.out.println("Training Updated By : " + training.getUpdatedBy().getEmployeeId());
		}

	}

}
