package com.sushant.login.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sushant.login.dao.IdentityDAO;
import com.sushant.login.dto.UserDetailsdto;
import com.sushant.login.services.UserDetailsDAO;

import java.util.List;

/**
 * Servlet implementation class ViewAddServlet
 */

public class ViewAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewAddServlet() {
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

		String check = request.getParameter("check");
		if (check.equalsIgnoreCase("View")) {
			List<UserDetailsdto> ud = IdentityDAO.getAllRecords();
			session.setAttribute("allUsers", ud);
			request.getRequestDispatcher("viewusers.jsp").forward(request, response);
		}
	}
}
