package test;

import java.sql.Connection;

import com.sushant.login.connections.Dbconnection;

public class TestDbConnection {

	public static void main(String[] args) {

		Connection con = Dbconnection.getconnection();
		if (con != null) {
			System.out.println("Connection success");
		}

	}

}