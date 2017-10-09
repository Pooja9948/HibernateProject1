package com.bridgelabz.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.DAO.BankDAO;
import com.bridgelabz.pojo.CustomerDetail;

public class UpdateData extends HttpServlet{
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		System.out.println("inside update data class");
		int customer_detailid= Integer.parseInt(request.getParameter("id"));
		System.out.println("id : "+customer_detailid);
		PreparedStatement preparestatement=null;
		Connection connection=null;
		//String selectquery=HomeDAO.updateUserDetail();
		try {
	    	//connection=BankDAO.getConnection();
	    	//preparestatement = connection.prepareStatement(selectquery);
	    	CustomerDetail customerdetail = new CustomerDetail();
	    	customerdetail.setId(customer_detailid);
	    	preparestatement.setInt(2, customerdetail.getId());
	    	preparestatement.executeUpdate();
		}catch(SQLException se) {
	         se.printStackTrace();
	      } finally {
	         try {
	            if(preparestatement!=null)
	            	preparestatement.close();
	            
	         }catch(SQLException se2) {
	        	 se2.printStackTrace();
	         }
	         try {
	            if(connection!=null)
	            connection.close();
	         } catch(SQLException se) {
	            se.printStackTrace();
	         }
	      }
		System.out.println("abcdefghijk");
	    RequestDispatcher dispatcher= request.getRequestDispatcher("home.jsp");
	    dispatcher.forward(request, response);
	}
}
