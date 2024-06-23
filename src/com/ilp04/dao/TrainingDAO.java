package com.ilp04.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import com.ilp04.entity.Employee;
import com.ilp04.entity.SafetyIncident;
import com.ilp04.entity.Training;
import com.ilp04.service.EmployeeImpl;
import com.ilp04.service.SafetyIncidentImpl;

public class TrainingDAO {

	// get connection

	public Connection getConnection() {
		String connectionURL = "jdbc:mysql://localhost:3306/workplace_safety";
		String userName = "root";
		String password = "global@123";
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(connectionURL, userName, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return connection;

	}

	// close the connection
	public Connection closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public ArrayList<Training> getTrainingDetails(Connection connection) {
		ArrayList<Training> trainingList = new ArrayList<Training>();
		Statement statement;
		ResultSet resultSet;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from training");
			while (resultSet.next()) {
				String trainingId = resultSet.getString(1);
				LocalDate trainingDate = resultSet.getDate(2).toLocalDate();
				String description = resultSet.getString(3);
				String incidentId = resultSet.getString(4);
				String createdBy = resultSet.getString(5);
				String updatedBy = resultSet.getString(6);

				SafetyIncident safetyincident = SafetyIncidentImpl.getIncident(incidentId);
				Employee employee1 = EmployeeImpl.getEmployee(createdBy);
				Employee employee2 = EmployeeImpl.getEmployee(updatedBy);
				Training training = new Training(trainingId, trainingDate, description, safetyincident, employee1,
						employee2);
				trainingList.add(training);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return trainingList;

	}

	public int insertIntoTraning(Training training, Connection connection) {

		PreparedStatement preparedStatement = null;
		int rowsAffected = 0;

		try {

			String insertQuery = "INSERT INTO training (trainingid,trainingdate,trainingDescription,safetyincidentid,created_by,updated_by ) VALUES (?, ?, ?, ?, ?,?)";

			preparedStatement = connection.prepareStatement(insertQuery);
			preparedStatement.setString(1, training.getTrainingId());
			String formattedDate = training.getTrainingDate().toString();
			preparedStatement.setDate(2, Date.valueOf(formattedDate));
			preparedStatement.setString(3, training.getTrainingDescription());
			preparedStatement.setString(4, training.getSafetyIncidentId().getIncidentId());
			preparedStatement.setString(5, training.getCreatedBy().getEmployeeId());
			preparedStatement.setString(6, training.getUpdatedBy().getEmployeeId());
			rowsAffected = preparedStatement.executeUpdate();
			System.out.println("Rows affected: " + rowsAffected);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rowsAffected;

	}

	public int updateIntoTraning(Training training, Connection connection) {
		PreparedStatement preparedStatement = null;
		int rowsAffected = 0;

		try {

			String insertQuery = "update training set trainingdate=?,trainingDescription=?,safetyincidentid=?,created_by=?,updated_by=? where trainingid=? ";

			preparedStatement = connection.prepareStatement(insertQuery);
			preparedStatement.setString(6, training.getTrainingId());
			String formattedDate = training.getTrainingDate().toString();
			preparedStatement.setDate(1, Date.valueOf(formattedDate));
			preparedStatement.setString(2, training.getTrainingDescription());
			preparedStatement.setString(3, training.getSafetyIncidentId().getIncidentId());
			preparedStatement.setString(4, training.getCreatedBy().getEmployeeId());
			preparedStatement.setString(5, training.getUpdatedBy().getEmployeeId());
			rowsAffected = preparedStatement.executeUpdate();
			System.out.println("Rows affected: " + rowsAffected);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rowsAffected;

	}

}
