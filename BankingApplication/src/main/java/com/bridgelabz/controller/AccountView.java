package com.bridgelabz.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelabz.DAO.BankDAO;
import com.bridgelabz.DAO.HomeDAO;
import com.bridgelabz.pojo.CustomerDetail;
@WebServlet("/AccountView")
public class AccountView extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		 List<CustomerDetail> obj = new ArrayList<CustomerDetail>();
		System.out.println("inside AccountView");
		String city= request.getParameter("city");
		HttpSession session = request.getSession();
		String id = session.getAttribute("id").toString();
		System.out.println(id+" :id8324 "+city+" :city");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
	    try {
	    	CustomerDetail customerdetail = new CustomerDetail();
	    	customerdetail.setCity(city);
			customerdetail.setInputby(id);
			customerdetail=HomeDAO.getAllCustomerDetail(id,city);
			/*preparestatement.setString(1, customerdetail.getCity());
	        preparestatement.setString(2, customerdetail.getInputby());
	        resultset=preparestatement.executeQuery();*/
	       
	        /*while(customerdetail.nex){
	        	CustomerDetail customerdetail1 = new CustomerDetail();
	        	customerdetail.getInt("id");
	        	customerdetail.getString("name");
	        	customerdetail.getString("email");
	        	customerdetail.getString("account_number");
	        	customerdetail.getString("city");*/
	        	obj.add(customerdetail);
	        	
	        response.sendRedirect("accountview.jsp");
	       //}
	       
	        System.out.println("Current array list is:"+obj);
	    }catch(Exception se) {
	         se.printStackTrace();
	      } finally {
	         
	      }
	    request.setAttribute("list",obj );
	    RequestDispatcher dispatcher= request.getRequestDispatcher("accountview.jsp");
	    dispatcher.forward(request, response);
	}
}
