package com.sushant.login.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sushant.login.dao.IdentityDAO;
import com.sushant.login.dto.UserDetailsdto;
import com.sushant.login.logger.*;
import com.sushant.login.services.UserDetailsDAO;

/**
 * Servlet implementation class AddIdentityServlet
 */
@WebServlet("/AddIdentityServlet")
public class AddIdentityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger logger = new Logger(AddIdentityServlet.class);

	int a;

	/* UserDetailsdto userDetailDTO = new UserDetailsdto(); */

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddIdentityServlet() {
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
		String view = request.getParameter("view");
		HttpSession session = request.getSession();
		IdentityDAO identity = new IdentityDAO();
		if (view.equals("view")) {
			List<UserDetailsdto> ud = IdentityDAO.getAllRecords();
			session.setAttribute("allUsers", ud);
			request.getRequestDispatcher("viewusers.jsp").forward(request, response);
		} else {
			UserDetailsdto userDetailDTO = new UserDetailsdto();

			String id = request.getParameter("userID");
			int ids = Integer.valueOf(id);
			String name = request.getParameter("userName");
			String password = request.getParameter("password");
			String dname = request.getParameter("displayName");
			userDetailDTO.setName(dname);
			userDetailDTO.setUserName(name);
			userDetailDTO.setPassword(password);
			userDetailDTO.setUserId(ids);

			UserDetailsDAO udao = new UserDetailsDAO();

			if (udao.validateUser(name, password)) {
				userDetailDTO.setValidUser(true);
				int a = identity.create(userDetailDTO);
				RequestDispatcher rd = request.getRequestDispatcher("adduser-success.jsp");
				rd.forward(request, response);
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("adduser-error.jsp");
				rd.forward(request, response);
			}
		}
	}

}
