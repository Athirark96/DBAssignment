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
import com.ilp04.entity.SafetyInspection;
import com.ilp04.service.EmployeeImpl;
import com.ilp04.service.SafetyIncidentImpl;

public class SafetyInspectionDAO {

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

	public ArrayList<SafetyInspection> getAllSafetyInspection(Connection connection) {

		ArrayList<SafetyInspection> safetyInspectionList = new ArrayList<SafetyInspection>();
		Statement statement;
		ResultSet resultSet;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from safety_inspection");
			while (resultSet.next()) {
				String inspectionid = resultSet.getString(1);
				LocalDate inspectionDate = resultSet.getDate(2).toLocalDate();
				String result = resultSet.getString(3);
				String safetyIncidentId = resultSet.getString(4);
				String safetyInspectedEmployee = resultSet.getString(5);
				String createdBy = resultSet.getString(6);
				String updatedBy = resultSet.getString(7);

				SafetyIncident safetyincident = SafetyIncidentImpl.getIncident(safetyIncidentId);
				Employee employee = EmployeeImpl.getEmployee(safetyInspectedEmployee);
				Employee employee1 = EmployeeImpl.getEmployee(createdBy);
				Employee employee2 = EmployeeImpl.getEmployee(updatedBy);

				SafetyInspection inspection = new SafetyInspection(inspectionid, inspectionDate, result, safetyincident,
						employee, employee1, employee2);
				safetyInspectionList.add(inspection);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return safetyInspectionList;
	}

	public int insertIntoSafetyInspection(SafetyInspection inspection, Connection connection) {
		PreparedStatement preparedStatement = null;
		int rowsAffected = 0;

		try {

			String insertQuery = "INSERT INTO safety_inspection (inspectionid,inspectiondate,result,safetyincidentid,inspectedemployeeid,created_by,updated_by ) VALUES (?, ?, ?, ?, ?,?,?)";

			preparedStatement = connection.prepareStatement(insertQuery);
			preparedStatement.setString(1, inspection.getInspectionid());
			String formattedDate = inspection.getInspectiondate().toString();
			preparedStatement.setDate(2, Date.valueOf(formattedDate));
			preparedStatement.setString(3, inspection.getResult());
			preparedStatement.setString(4, inspection.getSafetyIncidentId().getIncidentId());
			preparedStatement.setString(5, inspection.getInspectedEmployee().getEmployeeId());
			preparedStatement.setString(6, inspection.getCreatedBy().getEmployeeId());
			preparedStatement.setString(7, inspection.getUpdatedBy().getEmployeeId());
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

	public int updateIntoSafetyInspection(SafetyInspection inspection, Connection connection) {
		PreparedStatement preparedStatement = null;
		int rowsAffected = 0;

		try {

			String insertQuery = "update safety_inspection set inspectiondate=?,result=?,safetyincidentid=?,inspectedemployeeid=?,created_by=?,updated_by=? where inspectionid=?";

			preparedStatement = connection.prepareStatement(insertQuery);
			preparedStatement.setString(7, inspection.getInspectionid());
			String formattedDate = inspection.getInspectiondate().toString();
			preparedStatement.setDate(1, Date.valueOf(formattedDate));
			preparedStatement.setString(2, inspection.getResult());
			preparedStatement.setString(3, inspection.getSafetyIncidentId().getIncidentId());
			preparedStatement.setString(4, inspection.getInspectedEmployee().getEmployeeId());
			preparedStatement.setString(5, inspection.getCreatedBy().getEmployeeId());
			preparedStatement.setString(6, inspection.getUpdatedBy().getEmployeeId());
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
