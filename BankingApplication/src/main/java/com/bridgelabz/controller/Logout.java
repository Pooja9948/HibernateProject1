package com.bridgelabz.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * @author Pooja user logout
 *
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet{
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 * @param request
	 * @param response
	 * In this servlet we logout from the home page and expiring the session
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		response.setContentType("text/html");
		HttpSession session=request.getSession();
		session.removeAttribute("id");
		session.removeAttribute("uname");
		System.out.println("hello ........");
		session.invalidate();
		RequestDispatcher dispatcher= request.getRequestDispatcher("login.jsp");
	    dispatcher.forward(request, response);
		response.setHeader("Cache-Control", "no-cache,no-store,must-validate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires","0");
		
	}
	
}
