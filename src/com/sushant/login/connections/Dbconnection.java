package com.sushant.login.connections;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Dbconnection {

	private static Properties properties;

	private static InputStream inputStream;
	private static Connection conn;

	static {
//		properties = intializeProperties();
	}

	
	public static Connection getconnection() {
		
//		final String ConnectionString = properties.getProperty("URL");
//		final String username = properties.getProperty("USER");
//		final String password = properties.getProperty("PASSWORD");
		
		final String ConnectionString = "jdbc:derby://localhost:1527/sushant;create=true";
		final String username = "root";
		final String password = "root";
		

		try {
			
//			Class.forName(properties.getProperty("DRIVER"));
			Class.forName("org.apache.derby.jdbc.ClientDriver");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		
		try {
			conn = DriverManager.getConnection(ConnectionString, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;

	}

	private static Properties intializeProperties() {
		
		properties=new Properties();

		try {
			inputStream = new FileInputStream(System.getProperty("conf"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Issue while loading the property from system property: conf");
			e.printStackTrace();
		}

		if (inputStream != null) {
			try {
				properties.load(inputStream);
				System.out.println("prop loaded successfully");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
		} else {
			System.out.println("Input stream could not be loaded from both system property or the resource folder in the "
							+ "project space");
		}

		// TODO Auto-generated method stub
		return properties;
	}

}
