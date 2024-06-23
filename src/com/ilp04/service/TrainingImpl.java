package com.ilp04.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.ilp04.dao.SafetyIncidentDAO;
import com.ilp04.dao.SafetyInspectionDAO;
import com.ilp04.dao.TrainingDAO;
import com.ilp04.entity.SafetyIncident;
import com.ilp04.entity.Training;





public class TrainingImpl implements TrainingService {

	public ArrayList<Training> getTrainingDetails() {
		ArrayList<Training> trainingList = new ArrayList<Training>();
		TrainingDAO trainingDAO = new TrainingDAO();
		Connection connection = trainingDAO.getConnection();
		trainingList = trainingDAO.getTrainingDetails(connection);
		
		return trainingList;
	}

	public void insertIntoTraining(Training training) {
		TrainingDAO trainingDAO = new TrainingDAO();
		Connection connection =trainingDAO.getConnection();
		int rowsInserted = trainingDAO.insertIntoTraning(training,connection);
		trainingDAO.closeConnection(connection);
		if (rowsInserted > 0) {
			System.out.println("Training inserted successfully!");
		} else {
			System.out.println("Failed to insert Traning.");
		} 
		
		
	}

	public void updateIntoTraining(Training training) {
		TrainingDAO trainingDAO = new TrainingDAO();
		Connection connection =trainingDAO.getConnection();
		int rowsInserted = trainingDAO.updateIntoTraning(training,connection);
		trainingDAO.closeConnection(connection);
		if (rowsInserted > 0) {
			System.out.println("Training updated successfully!");
		} else {
			System.out.println("Failed to update Traning.");
		} 
		
		
	}

	

}
