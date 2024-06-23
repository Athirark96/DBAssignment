package com.ilp04.service;


import java.sql.Connection;
import java.util.ArrayList;
import com.ilp04.dao.WorkstationDAO;
import com.ilp04.entity.Workstation;

public class WorkstationImpl implements WorkstationService {

	@Override
	public ArrayList<Workstation> getAllWorkstation() {
		ArrayList<Workstation> workstationList = new ArrayList<Workstation>();
		WorkstationDAO workstationDAO = new WorkstationDAO();
		Connection connection = workstationDAO.getConnection();
		workstationList = workstationDAO.getAllWorkstation(connection);
		return workstationList;
	}

	
	

	@Override
	public void insertIntoCustomer(Workstation workstation) {
		
		WorkstationDAO workstationDAO = new WorkstationDAO();
		Connection connection =workstationDAO.getConnection();
		int rowsInserted = workstationDAO.insertIntoWorkstation(workstation, connection);
		workstationDAO.closeConnection(connection);
		if (rowsInserted > 0) {
			System.out.println("Workstation inserted successfully!");
		} else {
			System.out.println("Failed to insert customer.");
		}
		
	}

	@Override
	public void updateWorkstation(Workstation workstation) {
		WorkstationDAO workstationDAO = new WorkstationDAO();
		Connection connection =workstationDAO.getConnection();
//		System.out.println("checking ......"+workstation.getWorkstationName()+ " "+workstation.getWorkstationId());
		int rowsInserted = workstationDAO.updateWorkstation(workstation,connection);
		workstationDAO.closeConnection(connection);
		if (rowsInserted > 0) {
			System.out.println("Workstation updated successfully!");
		} else {
			System.out.println("Failed to update workstation");
		}
	}
	
	




	public static Workstation getWorkstation(String employeeWorkstation) {
		// TODO Auto-generated method stub
		Workstation workstation = new Workstation();
		WorkstationDAO workstationDAO = new WorkstationDAO();
		Connection connection = workstationDAO.getConnection();
		workstation = workstationDAO.getWorkstation(connection,employeeWorkstation);
		return workstation;
		
	}
 

}
