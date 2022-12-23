package com.telemedicine.patient;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ApptDao {
	
	public boolean validate (ApptBean apptbean) throws ClassNotFoundException {
		boolean status = false;
		
		 
		
		try { 
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/telemedicine","root","Sql@123456");
			System.out.println("Connection established successfully.");
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO appointment_reservation");
			preparedStatement.setInt(1, 1111);
			preparedStatement.setString(2, apptbean.getApptDate());
			preparedStatement.setInt(3, 1234);
			preparedStatement.setInt(4, 14510);
			
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			status = rs.next();
			
		} catch (SQLException e) {
			System.out.print("didn't connect");
			System.out.print(e.getErrorCode());
		}
		
		return status;
	}


}
