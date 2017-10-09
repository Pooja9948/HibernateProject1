package com.bridgelabz.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.bridgelabz.DAO.BankDAO;
import com.bridgelabz.pojo.UserDetails;

//@WebServlet("/Registration")
public class Registration extends HttpServlet{
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
	    try {
	    	System.out.println("inside servlet------->");
	    	String name= request.getParameter("name");
	        String email= request.getParameter("email");
		    String password= request.getParameter("password");
		    String mobileno= request.getParameter("mobileno");
	        UserDetails userdetail=new UserDetails();	
	        userdetail.setName(name);
	        userdetail.setEmail(email);
	        userdetail.setPassword(password);
	        userdetail.setMobileno(mobileno);
	        BankDAO.registration(userdetail);
	        
	        System.out.println("outside servlet------->");
	        
	    }catch(Exception se) {
	         se.printStackTrace();
	      } finally {
	         try {
	          
	         } catch(Exception se) {
	            se.printStackTrace();
	         }
	      }
	    RequestDispatcher dispatcher= request.getRequestDispatcher("login.jsp");
	    dispatcher.include(request, response);
	}
}
