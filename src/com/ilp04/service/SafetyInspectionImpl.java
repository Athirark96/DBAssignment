package com.ilp04.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.ilp04.dao.SafetyIncidentDAO;
import com.ilp04.dao.SafetyInspectionDAO;
import com.ilp04.entity.SafetyInspection;




public class SafetyInspectionImpl implements SafetyInspectionService {

	public ArrayList<SafetyInspection> getAllSafetyInspection() {
		ArrayList<SafetyInspection> SafetyInspectionList = new ArrayList<SafetyInspection>();
		SafetyInspectionDAO safetyInspectionDAO = new SafetyInspectionDAO();
		Connection connection = safetyInspectionDAO.getConnection();
		SafetyInspectionList =safetyInspectionDAO.getAllSafetyInspection(connection);
		
		return SafetyInspectionList;
	}

	public void insertIntoSafetyInspection(SafetyInspection inspection) {
		
		SafetyInspectionDAO safetyInspectionDAO = new SafetyInspectionDAO();
		Connection connection =safetyInspectionDAO.getConnection();
		int rowsInserted = safetyInspectionDAO.insertIntoSafetyInspection(inspection, connection);
		safetyInspectionDAO.closeConnection(connection);
		if (rowsInserted > 0) {
			System.out.println("Inspection inserted successfully!");
		} else {
			System.out.println("Failed to insert Inspection.");
		}
	}

	public void updateIntoSafetyInspection(SafetyInspection inspection) {
		
		
		SafetyInspectionDAO safetyInspectionDAO = new SafetyInspectionDAO();
		Connection connection =safetyInspectionDAO.getConnection();
		int rowsInserted = safetyInspectionDAO.updateIntoSafetyInspection(inspection, connection);
		safetyInspectionDAO.closeConnection(connection);
		if (rowsInserted > 0) {
			System.out.println("Inspection updated successfully!");
		} else {
			System.out.println("Failed to update Inspection.");
		}
		
	}

	
}
