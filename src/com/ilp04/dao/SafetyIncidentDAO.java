package com.ilp04.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;
import com.ilp04.entity.Employee;
import com.ilp04.entity.SafetyIncident;
import com.ilp04.entity.SafetyInspection;
import com.ilp04.entity.Workstation;
import com.ilp04.service.EmployeeImpl;
import com.ilp04.service.WorkstationImpl;

public class SafetyIncidentDAO {

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

	public ArrayList<SafetyIncident> getAllSafetyIncident(Connection connection) {
		ArrayList<SafetyIncident> safetyIncidentList = new ArrayList<SafetyIncident>();
		Statement statement;
		ResultSet resultSet;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from safety_incident");
			while (resultSet.next()) {
				String incidentId = resultSet.getString(1);
				LocalDate incidentDate = resultSet.getDate(2).toLocalDate();
				String description = resultSet.getString(3);
				String workstationId = resultSet.getString(4);
				String createdBy = resultSet.getString(5);
				String updatedBy = resultSet.getString(6);

				Workstation workstation = WorkstationImpl.getWorkstation(workstationId);
				Employee employee1 = EmployeeImpl.getEmployee(createdBy);
				Employee employee2 = EmployeeImpl.getEmployee(updatedBy);

				SafetyIncident safetyincident = new SafetyIncident(incidentId, incidentDate, description, workstation,
						employee1, employee2);
				safetyIncidentList.add(safetyincident);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return safetyIncidentList;
	}

	public int insertIntoSafetyIncident(SafetyIncident safetyincident, Connection connection) {
		PreparedStatement preparedStatement = null;
		int rowsAffected = 0;

		try {

			String insertQuery = "INSERT INTO safety_incident (incidentid,incidentdate,description , workstationid ,created_by,updated_by ) VALUES (?, ?, ?, ?, ?,?)";

			preparedStatement = connection.prepareStatement(insertQuery);
			preparedStatement.setString(1, safetyincident.getIncidentId());
			String formattedDate = safetyincident.getIncidentDate().toString();
			preparedStatement.setDate(2, Date.valueOf(formattedDate));
			preparedStatement.setString(3, safetyincident.getDescription());
			preparedStatement.setString(4, safetyincident.getWorkstation().getWorkstationId());
			preparedStatement.setString(5, safetyincident.getCreatedBy().getEmployeeId());
			preparedStatement.setString(6, safetyincident.getUpdatedBy().getEmployeeId());

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

	public int updateSafetyIncident(SafetyIncident safetyincident, Connection connection) {
		PreparedStatement preparedStatement = null;
		int rowsAffected = 0;

		try {

			String insertQuery = "update safety_incident set incidentdate=?,description=?, workstationid=? ,created_by=?,updated_by=? where incidentid=?";

			preparedStatement = connection.prepareStatement(insertQuery);
			preparedStatement.setString(6, safetyincident.getIncidentId());
			String formattedDate = safetyincident.getIncidentDate().toString();
			preparedStatement.setDate(1, Date.valueOf(formattedDate));
			preparedStatement.setString(2, safetyincident.getDescription());
			preparedStatement.setString(3, safetyincident.getWorkstation().getWorkstationId());
			preparedStatement.setString(4, safetyincident.getCreatedBy().getEmployeeId());
			preparedStatement.setString(5, safetyincident.getUpdatedBy().getEmployeeId());

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

	public SafetyIncident getIncident(Connection connection, String safetyIncidentId) {
		SafetyIncident safetyincident = new SafetyIncident();
		int rowsAffected;
		ResultSet resultSet;
		String updateQuery = "select * from safety_incident where incidentid = ? ";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
			preparedStatement.setString(1, safetyIncidentId);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String incidentId = resultSet.getString(1);
				LocalDate incidentDate = resultSet.getDate(2).toLocalDate();
				String description = resultSet.getString(3);
				String workstationId = resultSet.getString(4);
				String createdBy = resultSet.getString(5);
				String updatedBy = resultSet.getString(6);

				Workstation workstation = WorkstationImpl.getWorkstation(workstationId);
				Employee employee1 = EmployeeImpl.getEmployee(createdBy);
				Employee employee2 = EmployeeImpl.getEmployee(updatedBy);

				safetyincident = new SafetyIncident(incidentId, incidentDate, description, workstation, employee1,
						employee2);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return safetyincident;
	}

	public ArrayList<SafetyIncident> getSafetyIncidentWithDate(LocalDate incidentDate) {
		ArrayList<SafetyIncident> safetyIncidentList = new ArrayList<SafetyIncident>();
		Statement statement;
		ResultSet resultSet = null;
		Connection connection = null;
		PreparedStatement preparedStatment;

		try {
			connection = getConnection();
			
			String selectquery = "SELECT COUNT(*) FROM safety_incident WHERE incidentdate = ?";
            preparedStatment = connection.prepareStatement(selectquery);
            preparedStatment.setDate(1, Date.valueOf(incidentDate));
            resultSet = preparedStatment.executeQuery();
            resultSet.next();
            int count = resultSet.getInt(1);
            if (count == 0) {
                System.out.println("No incidents found for the given date.");
             // Or throw an exception as needed
            }

			String query = "SELECT si.description, e.firstname, e.lastname,sii.result FROM safety_incident si JOIN safety_inspection sii ON si.incidentid = sii.safetyincidentid JOIN employee e ON sii.inspectedemployeeid = e.employeeid WHERE si.incidentdate = ?";

			 preparedStatment = connection.prepareStatement(query);
			String formattedDate = incidentDate.toString();
			preparedStatment.setDate(1, Date.valueOf(formattedDate));
			resultSet = preparedStatment.executeQuery();

			while (resultSet.next()) {

				SafetyIncident safetyincident = new SafetyIncident();
//				LocalDate incidentDates = resultSet.getDate(1).toLocalDate();
//				safetyincident.setIncidentDate(incidentDates);
				
				String description = resultSet.getString(1);
				Employee employee = new Employee();
				String firstName = resultSet.getString(2);
				String LastName = resultSet.getString(3);
				SafetyInspection inspection = new SafetyInspection();
				String result = resultSet.getString(4);
				
				
				safetyincident.setFirstName(firstName);
				safetyincident.setLastName(LastName);
				safetyincident.setResult(result);
				SafetyIncident safetyincidents = new SafetyIncident(firstName,LastName,description,result);
				safetyIncidentList.add(safetyincidents);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return safetyIncidentList;
	}

}
