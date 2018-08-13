package com.jda.servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jda.model.User;
import com.jda.servlet.repository.Repo;



/**
 * Servlet implementation class LogServlet
 */
@WebServlet("/LogServlet")
public class LogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Repo rep=new Repo();
		boolean bool;
		try {
			bool = rep.checkDatabase(email,password);
			if(bool)
		    {
		   	 System.out.println("success");
		   	 User user=rep.getUser(email, password);
		   	 System.out.println(user.getName());
		   	HttpSession session=request.getSession();  
		   	 session.setAttribute("user", user);
		        //RequestDispatcher req=request.getRequestDispatcher("home");
			     //req.include(request, response);
		   	 response.sendRedirect("home");
		    }
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	    
	   
	}

}
