package com.ilp04.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.ilp04.entity.Employee;
import com.ilp04.entity.Workstation;

public class EmployeeDAO {

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

	public ArrayList<Employee> getAllEmployee(Connection connection) {
	
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		Statement statement;
		ResultSet resultSet;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from employee");
			while (resultSet.next()) {
				String employeeId = resultSet.getString(1);
				String employeeFirstName = resultSet.getString(2);
				String employeeLastName =  resultSet.getString(3);
				String employeePhone = resultSet.getString(4);
				String employeeWorkstation  = resultSet.getString(5);
				
				  // Assuming you have a method to fetch Workstation object by ID
                Workstation workstation = fetchWorkstationById(connection, employeeWorkstation);
                // Create Employee object with associated Workstation
                Employee employee = new Employee(employeeId, employeeFirstName, employeeLastName, employeePhone, workstation);
                employeeList.add(employee);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employeeList;
	}

	private Workstation fetchWorkstationById( Connection connection,String employeeWorkstation) {
		Statement statement = null;
        ResultSet resultSet = null;
        Workstation workstation = null;

        try {
            String sqlQuery = "SELECT * FROM workstation WHERE workstationid = '" + employeeWorkstation + "'";
            try {
				statement = connection.createStatement();
				 resultSet = statement.executeQuery(sqlQuery);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
           

            try {
				if (resultSet.next()) {
				    String id = resultSet.getString("workstationid");
				    String name = resultSet.getString("workstationName");
				    workstation = new Workstation(id, name);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } finally {
            // Close resources
            if (resultSet != null) {
                try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
            if (statement != null) {
                try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        }

        return workstation;
	}

	public int insertIntoEmployee(Employee employee, Connection connection) {
		PreparedStatement preparedStatement = null;
		int rowsAffected = 0;

		try {
			
			String insertQuery = "INSERT INTO employee (employeeid,firstname,lastname,phone,workstationid) VALUES (?, ?, ?, ?, ?)";

			preparedStatement = connection.prepareStatement(insertQuery);
			preparedStatement.setString(1,employee.getEmployeeId());
			preparedStatement.setString(2, employee.getFirstName());
			preparedStatement.setString(3, employee.getLastName());
			preparedStatement.setString(4, employee.getPhone());
			preparedStatement.setString(5, employee.getWorkstation().getWorkstationId());
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

	public int updateEmployee(Employee employee, Connection connection) {
		
		PreparedStatement preparedStatement = null;
		int rowsAffected = 0;

		try {
			
			String updateQuery = "UPDATE employee SET firstname =?,lastname =?,phone=?,workstationid=? WHERE employeeid = ?";
			preparedStatement = connection.prepareStatement(updateQuery);
			preparedStatement.setString(5,employee.getEmployeeId());
			preparedStatement.setString(1, employee.getFirstName());
			preparedStatement.setString(2, employee.getLastName());
			preparedStatement.setString(3, employee.getPhone());
			preparedStatement.setString(4, employee.getWorkstation().getWorkstationId());
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

	public Employee getEmployee(Connection connection, String createdBy) {
		
		Employee employee = new Employee();
		int rowsAffected;
		ResultSet resultSet;
		String updateQuery = "select * from employee where employeeid = ? ";
        
        
        try {
        	PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
			preparedStatement.setString(1,createdBy);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String employeeId = resultSet.getString(1);
				String employeeFirstName = resultSet.getString(2);
				String employeeLastName =  resultSet.getString(3);
				String employeePhone = resultSet.getString(4);
				String employeeWorkstation  = resultSet.getString(5);
				
                Workstation workstations = fetchWorkstationById(connection, employeeWorkstation);
               employee = new Employee(employeeId, employeeFirstName, employeeLastName, employeePhone, workstations);		
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return employee;
       
	}

	

}
