package com.bridgelabz.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.DAO.BankDAO;
import com.bridgelabz.DAO.HomeDAO;
import com.bridgelabz.pojo.CustomerDetail;

@WebServlet("/DeleteCustomer")
public class DeleteCustomer extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		PreparedStatement preparestatement=null;
		Connection connection=null;
		System.out.println(" inside DeleteCustomer class");
		int customer_detailid = Integer.parseInt(req.getParameter("id"));
		System.out.println(" customer_detailid "+customer_detailid);
		//String deletequery=HomeDAO.deleteCustomer();
		try {
	    	//connection=BankDAO.getConnection();
	    	//preparestatement = connection.prepareStatement(deletequery);
	    	CustomerDetail customerdetail = new CustomerDetail();
			customerdetail.setId(customer_detailid);
			preparestatement.setInt(1, customerdetail.getId());
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
	}
}
