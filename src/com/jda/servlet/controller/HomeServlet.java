package com.jda.servlet.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jda.model.User;

public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 * 
	 *      /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		/*if (session == null) {
       System.out.println("session finished");
		} else {*/
			User user = (User) session.getAttribute("user");
			String name = user.getName();
			System.out.println(name);
	      request.setAttribute("name", name);
			//response.sendRedirect("home.jsp");
         RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
			rd.forward(request, response);
		//}
		return;
	}

}
