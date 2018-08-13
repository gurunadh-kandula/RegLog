package com.jda.listener;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


/**
 * Servlet implementation class SessionCounterListener
 */

public class SessionCounterListener implements HttpSessionListener {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private static int totalActiveSessions;
	
	  public static int getTotalActiveSession(){
		return totalActiveSessions;
	  }
		
	  @Override
	  public void sessionCreated(HttpSessionEvent arg0) {
		totalActiveSessions++;
		System.out.println("sessionCreated - add one session into counter");
	  }

	  @Override
	  public void sessionDestroyed(HttpSessionEvent arg0) {
		totalActiveSessions--;
		System.out.println("sessionDestroyed - deduct one session from counter");
	  }	

}
