package com.bridgelabz.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bridgelabz.DAO.HomeDAO;
import com.bridgelabz.pojo.CustomerDetail;

/**
 * @author Pooja delete the customer through id
 *
 */
@WebServlet("/DeleteCustomer")
public class DeleteCustomer extends HttpServlet{
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 * @param req
	 * @param resp
	 * Deleting the data of a perticular customer using id
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		System.out.println(" inside DeleteCustomer class");
		int customer_detailid = Integer.parseInt(req.getParameter("id"));
		System.out.println(" customer_detailid "+customer_detailid);
		try {
	    	CustomerDetail customerdetail = new CustomerDetail();
			customerdetail.setId(customer_detailid);
			HomeDAO.deleteCustomerDetail(customerdetail);
		}catch(Exception se) {
	         se.printStackTrace();
	    } 
	}
}
