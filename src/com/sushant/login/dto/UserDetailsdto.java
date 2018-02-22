package com.sushant.login.dto;

public class UserDetailsdto {
	private int userId;
	private String userName;
	private String password;
	private String displayName;

	private boolean validUser;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return displayName;
	}

	public void setName(String name) {
		this.displayName = name;
	}

	public boolean isValidUser() {
		return validUser;
	}

	public void setValidUser(boolean validUser) {
		this.validUser = validUser;
	}
}
