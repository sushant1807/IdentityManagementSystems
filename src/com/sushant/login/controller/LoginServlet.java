package com.sushant.login.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sushant.login.services.UserDetailsDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userName = null;
	private String password = null;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// getting the input from user
		userName = request.getParameter("userName");
		password = request.getParameter("password");

		// simple validation
		if ((userName != null && !userName.isEmpty()) && (password != null && !password.isEmpty())) {

			// defining the object for AuthenticationService
			// AuthenticationService service = new AuthenticationService();

			// dispatching the result based on the outcome
			// validating the user input
			UserDetailsDAO dao = new UserDetailsDAO();
			System.out.println(dao.validateUser(userName, password));

			// calling the validate user method

			if (!dao.validateUser(userName, password)) {

				HttpSession session = request.getSession();

				RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");

				// setting user details object in session based on the valid outcome
				session.setAttribute("userDetails", userName);
				session.setAttribute("authenticated ", true);

				dispatcher.forward(request, response);

			} else {

				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");

				// setting error message
				request.setAttribute("errorMessage", "you have given invalid username or password");

				dispatcher.forward(request, response);

			}

		} else {

			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");

			// setting error message
			request.setAttribute("errorMessage", "please make sure username or password is not empty ");

			dispatcher.forward(request, response);

		}
	}
}
