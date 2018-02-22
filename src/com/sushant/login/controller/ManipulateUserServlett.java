package com.sushant.login.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sushant.login.dao.IdentityDAO;
import com.sushant.login.dto.UserDetailsdto;

/**
 * Servlet implementation class ManipulateUserServlett
 */

public class ManipulateUserServlett extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManipulateUserServlett() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		HttpSession session = request.getSession();

		String check = request.getParameter("delete");
		System.out.println("Check--->" + check);
		List<String> value = Arrays.asList(check.split(","));

		if (value.get(0).equalsIgnoreCase("Edit")) {

			UserDetailsdto ud = IdentityDAO.getRecordById(Integer.valueOf(value.get(1)));
			session.setAttribute("user", ud);
			session.setAttribute("update", true);
			request.getRequestDispatcher("editform.jsp").forward(request, response);
		} else if (value.get(0).equalsIgnoreCase("Delete")) {
			UserDetailsdto ud1 = new UserDetailsdto();
			ud1.setUserId(Integer.valueOf(value.get(1)));
			int a = IdentityDAO.delete(ud1);
			List<UserDetailsdto> ud = IdentityDAO.getAllRecords();
			session.setAttribute("allUsers", ud);
			request.getRequestDispatcher("viewusers.jsp").forward(request, response);
		}
	}

}
