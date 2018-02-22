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
import com.sushant.login.services.UserDetailsDAO;

/**
 * Servlet implementation class UpdateUserServlet
 */

public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateUserServlet() {
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
//		IdentityDAO identityDAO = new IdentityDAO();
		UserDetailsdto userDetailDTO = new UserDetailsdto();
		UserDetailsdto ud = new UserDetailsdto();
		
		HttpSession session = request.getSession();
		ud=(UserDetailsdto)session.getAttribute("user");
		String id = request.getParameter("userId");
		int ids = Integer.valueOf(id);
		String name = request.getParameter("userName");
		String password = request.getParameter("password");
		String dname = request.getParameter("displayName");
		System.out.println("dname--->"+dname);
		userDetailDTO.setName(dname);
		userDetailDTO.setUserName(name);
		userDetailDTO.setPassword(password);
		userDetailDTO.setUserId(ids);
		System.out.println("dnameo--->"+userDetailDTO.getName());
		UserDetailsDAO udao = new UserDetailsDAO();
		if((name.equals(ud.getUserName())&&password.equals(ud.getPassword()))&&!(dname.equals(ud.getName())))
				{
					userDetailDTO.setValidUser(true);
					IdentityDAO.update(userDetailDTO);
					List<UserDetailsdto> ud1 = IdentityDAO.getAllRecords();
					session.setAttribute("allUsers", ud1);
					request.getRequestDispatcher("viewusers.jsp").forward(request, response);
				}
		
	
		else if (udao.validateUser(name, password)) {
			userDetailDTO.setValidUser(true);
			IdentityDAO.update(userDetailDTO);
			List<UserDetailsdto> ud1 = IdentityDAO.getAllRecords();
			session.setAttribute("allUsers", ud1);
			request.getRequestDispatcher("viewusers.jsp").forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("adduser-error.jsp");
			rd.forward(request, response);
		}

	}

}
