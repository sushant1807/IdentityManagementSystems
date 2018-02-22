package com.sushant.login.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sushant.login.connections.Dbconnection;

public class UserDetailsDAO {
public Boolean validateUser(String userName, String password) {
		
		// getting the connection from DBUtils
		final Connection connection = Dbconnection.getconnection(); 
		Boolean b = true;
		
		String sql_query = "SELECT * FROM USER_DETAILS WHERE USERNAME = ? AND PASSWORD = ?";
		
//		UserDetailsdto userDetails = new UserDetailsdto();
		
		try {  
			
			PreparedStatement stmt = connection.prepareStatement(sql_query);
			
			stmt.setString(1, userName);
			stmt.setString(2, password);
			
			// executing the query
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				if ((userName.equals(rs.getString("userName"))) && password.equals(rs.getString("password"))) {
					b = false;
					return b;
				} else {
					b = true;
					return b;
				}			
			}
			
		} catch(Exception e) {
			
			System.out.println(e.getMessage());
		}
		
		return b;
	}
}
