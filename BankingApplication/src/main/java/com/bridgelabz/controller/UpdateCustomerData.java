package com.bridgelabz.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.DAO.BankDAO;
import com.bridgelabz.DAO.HomeDAO;
@WebServlet("/UpdateCustomerData")
public class UpdateCustomerData extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PreparedStatement preparestatement=null;
		Connection connection=null;
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		System.out.print("hello");
		String id = req.getParameter("id1");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String accountno = req.getParameter("accountno");
		String city = req.getParameter("city");
		
		System.out.println("------update---->"+id);
		System.out.println("------update---name->"+name);
		System.out.println("------update-email-->"+email);
		System.out.println("------update-accountno-->"+accountno);
		System.out.println("------update--city-->"+city);
		//String updatequery=HomeDAO.updateCustomerDetail();
		try {
	    	//connection=BankDAO.getConnection(); 
	    	System.out.println("Got connection");
	    	//preparestatement = connection.prepareStatement(updatequery);

			preparestatement.setString(1, name);
			preparestatement.setString(2, email);
			preparestatement.setString(3, accountno);
			preparestatement.setString(4, city);
			preparestatement.setString(5, id);
			System.out.println("Executing update");
			int rowsUpdated = preparestatement.executeUpdate();
			System.out.println("*****************Updated "+rowsUpdated);
	        
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
		RequestDispatcher dispatcher = req.getRequestDispatcher("home.jsp");
		dispatcher.forward(req, resp);
	}

}
