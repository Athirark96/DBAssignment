package com.ilp04.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ilp04.entity.Workstation;

public class WorkstationDAO {

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

	public ArrayList<Workstation> getAllWorkstation(Connection connection) {
		ArrayList<Workstation> workstationList = new ArrayList<Workstation>();
		Statement statement;
		ResultSet resultSet;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from workstation");
			while (resultSet.next()) {
				String workstationId = resultSet.getString(1);
				String workstationName = resultSet.getString(2);
				Workstation workstation = new Workstation(workstationId, workstationName);
				workstationList.add(workstation);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return workstationList;
	}

	public int insertIntoWorkstation(Workstation workstation, Connection connection) {
		PreparedStatement preparedStatement = null;
		int rowsAffected = 0;

		try {
			String insertQuery = "INSERT INTO workstation (workstationid, workstationName) VALUES (?, ?)";

			preparedStatement = connection.prepareStatement(insertQuery);
			preparedStatement.setString(1, workstation.getWorkstationId());
			preparedStatement.setString(2, workstation.getWorkstationName());

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

	public  int updateWorkstation(Workstation workstation, Connection connection) {
		PreparedStatement preparedStatement = null;
	    int rowsAffected = 0;

	    try {
	    	
	    	System.out.println("checking ......"+workstation.getWorkstationName()+ " "+workstation.getWorkstationId());
	        String updateQuery = "UPDATE workstation SET workstationName = ? WHERE workstationid = ?";
	        preparedStatement = connection.prepareStatement(updateQuery);
	        
	        preparedStatement.setString(1, workstation.getWorkstationName());
	        preparedStatement.setString(2, workstation.getWorkstationId());
	        
	        // Execute the update
	        rowsAffected = preparedStatement.executeUpdate();
	        System.out.println("Rows affected: " + rowsAffected);
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            // Close the PreparedStatement
	            if (preparedStatement != null) {
	                preparedStatement.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return rowsAffected;
	}

	public ArrayList<Workstation> getWorkstation(Connection connection) {
		ArrayList<Workstation> workstationList = new ArrayList<Workstation>();
		Statement statement;
		ResultSet resultSet;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from workstation");
			while (resultSet.next()) {
				String workstationId = resultSet.getString(1);
				String workstationName = resultSet.getString(2);
				Workstation workstation = new Workstation(workstationId, workstationName);
				workstationList.add(workstation);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return workstationList;
	}

	public Workstation getWorkstation(Connection connection, String employeeWorkstation) {
		
		
		Workstation workstation = new Workstation();
		int rowsAffected;
		ResultSet resultSet;
		String updateQuery = "select * from workstation where workstationid = ? ";
        
        
        try {
        	PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
			preparedStatement.setString(1,employeeWorkstation);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String workstationId = resultSet.getString(1);
				String workstationName = resultSet.getString(2);
				workstation = new Workstation(workstationId, workstationName);
			
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
		return workstation;
	}
	
	
}
