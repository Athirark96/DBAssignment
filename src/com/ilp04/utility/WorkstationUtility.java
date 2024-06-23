package com.ilp04.utility;

import java.util.ArrayList;
import java.util.Scanner;
import com.ilp04.entity.Workstation;
import com.ilp04.service.WorkstationImpl;
import com.ilp04.service.WorkstationService;

public class WorkstationUtility {

	public static void main(String[] args) {

		char ch;
		do {
			System.out.println("WORKSTATION .....");
			System.out.println("1.Display  2.Insert  3.Update");
			Scanner scanner = new Scanner(System.in);
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				getAllWorkstation();
				break;
			case 2:

				insertWorkstation();
				break;

			case 3:
				updateWorkstation();
				break;

			}
			System.out.println("Want to continue(y/n) : ");
			ch = scanner.next().charAt(0);

		} while (ch == 'y');

	}

	private static void updateWorkstation() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Workstation code to update : ");
		String workstationId = scanner.nextLine();
		scanner.nextLine();
		System.out.println("Entert the workstation name to get updated : ");
		String workstationName = scanner.nextLine();
		scanner.nextLine();
		Workstation workstation = new Workstation(workstationId, workstationName);
		WorkstationService workstationservice = new WorkstationImpl();
		workstationservice.updateWorkstation(workstation);

	}

	private static void insertWorkstation() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the workstation id : ");
		String workstationId = scanner.nextLine();
		scanner.nextLine();
		System.out.println("Enter the workstation Name : ");
		String workstationName = scanner.nextLine();
		scanner.nextLine();

		Workstation workstation = new Workstation(workstationId, workstationName);
		WorkstationService workstationservice = new WorkstationImpl();
		workstationservice.insertIntoCustomer(workstation);
	}

	private static void getAllWorkstation() {
		// TODO Auto-generated method stub

		WorkstationService workstationservice = new WorkstationImpl();
		ArrayList<Workstation> workstationList = workstationservice.getAllWorkstation();
		for (Workstation workstation : workstationList) {
			System.out.println("Workstation ID : " + workstation.getWorkstationId());
			System.out.println("Workstation Name : " + workstation.getWorkstationName());
		}

	}

}
