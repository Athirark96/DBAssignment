package com.ilp04.service;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;

import com.ilp04.dao.EmployeeDAO;
import com.ilp04.dao.SafetyIncidentDAO;
import com.ilp04.entity.Employee;
import com.ilp04.entity.SafetyIncident;

public class SafetyIncidentImpl implements SafetyIncidentService {

	@Override
	public ArrayList<SafetyIncident> getAllSafetyIncident() {
		ArrayList<SafetyIncident> SafetyIncidentList = new ArrayList<SafetyIncident>();
		SafetyIncidentDAO safetyIncidentDAO = new SafetyIncidentDAO();
		Connection connection = safetyIncidentDAO.getConnection();
		SafetyIncidentList = safetyIncidentDAO.getAllSafetyIncident(connection);
		
		return SafetyIncidentList;
	}

	public void insertIntoSafetyIncident(SafetyIncident safetyincident) {
	
		SafetyIncidentDAO safetyIncidentDAO = new SafetyIncidentDAO();
		Connection connection =safetyIncidentDAO.getConnection();
		int rowsInserted = safetyIncidentDAO.insertIntoSafetyIncident(safetyincident, connection);
		safetyIncidentDAO.closeConnection(connection);
		if (rowsInserted > 0) {
			System.out.println("Incident inserted successfully!");
		} else {
			System.out.println("Failed to insert Incident.");
		}
	}

	public void updateSafetyIncident(SafetyIncident safetyincident) {
		SafetyIncidentDAO safetyIncidentDAO = new SafetyIncidentDAO();
		Connection connection =safetyIncidentDAO.getConnection();
		int rowsInserted = safetyIncidentDAO.updateSafetyIncident(safetyincident, connection);
		safetyIncidentDAO.closeConnection(connection);
		if (rowsInserted > 0) {
			System.out.println("Incident updated successfully!");
		} else {
			System.out.println("Failed to updtaed Incident.");
		}
	}

	public static SafetyIncident getIncident(String safetyIncidentId) {
		SafetyIncident safetyIncident = new SafetyIncident();
		SafetyIncidentDAO safetyincidentDAO = new SafetyIncidentDAO();
		Connection connection = safetyincidentDAO.getConnection();
		safetyIncident = safetyincidentDAO.getIncident(connection,safetyIncidentId);
		return safetyIncident;
	}

	public ArrayList<SafetyIncident> getSafetyIncident(LocalDate incidentDate) {
		ArrayList<SafetyIncident> SafetyIncidentList = new ArrayList<SafetyIncident>();
		SafetyIncidentDAO safetyIncidentDAO = new SafetyIncidentDAO();
		Connection connection = safetyIncidentDAO.getConnection();
		SafetyIncidentList = safetyIncidentDAO.getSafetyIncidentWithDate(incidentDate);
		
		return SafetyIncidentList;
		
	}

}
