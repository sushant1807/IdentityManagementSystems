package com.sushant.login.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sushant.login.dao.IdentityDAO;
import com.sushant.login.dto.UserDetailsdto;

/**
 * Servlet implementation class DeleteIdentityServlet
 */
@WebServlet("/DeleteIdentityServlet")
public class DeleteIdentityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	IdentityDAO identityDAO = new IdentityDAO();
	UserDetailsdto userDetailDTO = new UserDetailsdto();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteIdentityServlet() {
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
		IdentityDAO.delete(userDetailDTO);
		response.sendRedirect("");
	}

}
