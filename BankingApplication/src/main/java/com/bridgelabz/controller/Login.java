package com.bridgelabz.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelabz.DAO.BankDAO;
import com.bridgelabz.pojo.CustomerDetail;
import com.bridgelabz.pojo.UserDetails;

/**
 * @author Pooja user login page
 *
 */
public class Login extends HttpServlet {
	
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 * @param request
	 * @param response
	 * In this servlet , its checking the mailid and password are exists in the database or not.
	 * If it returns true then it will go to home page. putting username and id in the session.
	 * else it will redirect to the same login page
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("hrtgefadqhfd");
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
