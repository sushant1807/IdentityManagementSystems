package com.sushant.login.services;

public class AuthenticationService {
	public Boolean validateUser(String userName, String password) {

		// defining the dao object
		UserDetailsDAO dao = new UserDetailsDAO();

		// calling the validate user method
		return dao.validateUser(userName, password);
	}
}
