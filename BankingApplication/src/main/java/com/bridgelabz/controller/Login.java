package com.bridgelabz.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelabz.DAO.BankDAO;
import com.bridgelabz.pojo.CustomerDetail;
import com.bridgelabz.pojo.UserDetails;

public class Login extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("hrtgefadqhfd");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String email= request.getParameter("email");
		System.out.println(email);
	    String password= request.getParameter("password");
	    int value=1;
	    String uname="";
	    int id=0;
	    try {
	    	UserDetails userdetail=new UserDetails();
	    	userdetail.setEmail(email);
	    	userdetail.setPassword(password);
	    	
	    	userdetail=BankDAO.login(email,password);
	    	
	        if(userdetail!=null){
	        	id=userdetail.getId();
	        	uname=userdetail.getName();
	        	value++;
	        }else{
	        	value--;
	        }
	    }catch (Exception e) {
	    	e.printStackTrace();
		}
	   
	    if(value==2){
	    	HttpSession session = request.getSession();
	    	System.out.println(uname);
	    	System.out.println(id+" 4565347");
		    session.setAttribute("uname", uname);
		    session.setAttribute("id", id);
		    String s =(String) session.getAttribute("uname");
		    System.out.println(s);
		    CustomerDetail cs = new CustomerDetail();
		    cs.setName((String) request.getAttribute("name"));
		    cs.setCity((String) request.getAttribute("city"));
		    request.setAttribute("detail",cs );
		    response.sendRedirect("home.jsp");
		    
	    }else{
	    	RequestDispatcher dispatcher= request.getRequestDispatcher("login.jsp");
		    dispatcher.forward(request, response);
	    }
	}
}
