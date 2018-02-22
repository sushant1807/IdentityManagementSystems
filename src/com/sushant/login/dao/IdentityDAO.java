package com.sushant.login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sushant.login.dto.UserDetailsdto;
import com.sushant.login.logger.*;


public class IdentityDAO {
	
	private static final Logger LOGGER = new Logger(IdentityDAO.class);

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			con = DriverManager.getConnection("jdbc:derby://localhost:1527/sushant;create=true", "root", "root");
		} catch (Exception e) {
			LOGGER.error("error in connections method :" + e.getMessage());
		}
		return con;
	}

	public static int create(UserDetailsdto u) {
		int status = 0;
		try {
			Connection con = getConnection();
			PreparedStatement ps = con
					.prepareStatement("insert into user_details(userId,userName,password,displayName) values(?,?,?,?)");
			ps.setInt(1, u.getUserId());
			ps.setString(2, u.getUserName());
			ps.setString(3, u.getPassword());
			ps.setString(4, u.getName());
			status = ps.executeUpdate();
		} catch (Exception e) {
			LOGGER.error("error in save method :" + e.getMessage());
		}
		return status;
	}

	public static int update(UserDetailsdto u) {
		int status = 0;
		try {
			Connection con = getConnection();
			PreparedStatement ps = con
					.prepareStatement("update user_details set userName=?,password=?,displayName=? where userId=?");
			ps.setString(1, u.getUserName());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getName());
			ps.setInt(4, u.getUserId());
			status = ps.executeUpdate();
		} catch (Exception e) {
			LOGGER.error("error in update method :" + e.getMessage());
		}
		return status;
	}

	public static int  delete(UserDetailsdto u) {
		int status = 0 ;
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("delete from user_details where userId=?");
			ps.setInt(1, u.getUserId());
			status = ps.executeUpdate();
		} catch (Exception e) {
			LOGGER.error("error in delete method :" + e.getMessage());
		}
		return status;
	}

	public static List<UserDetailsdto> getAllRecords() {
		List<UserDetailsdto> list = new ArrayList<UserDetailsdto>();

		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select * from user_details");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				UserDetailsdto u = new UserDetailsdto();
				u.setUserId(rs.getInt("userId"));
				u.setUserName(rs.getString("userName"));
				u.setPassword(rs.getString("password"));
				u.setName(rs.getString("displayName"));
				list.add(u);
			}
		} catch (Exception e) {
			LOGGER.error("error in viewUsers method :" + e.getMessage());
		}
		return list;
	}

	public static UserDetailsdto getRecordById(int id) {
		UserDetailsdto u = null;
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select * from user_details where userId=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				u = new UserDetailsdto();
				u.setUserId(rs.getInt("userId"));
				u.setUserName(rs.getString("userName"));
				u.setPassword(rs.getString("password"));
				u.setName(rs.getString("displayName"));
			}
		} catch (Exception e) {
			LOGGER.error("error in List method :" + e.getMessage());
		}
		return u;
	}
}
