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
import com.bridgelabz.DAO.HomeDAO;
import com.bridgelabz.pojo.CustomerDetail;
/**
 * @author Pooja Updating the customer data
 *
 */
@WebServlet("/UpdateCustomerData")
public class UpdateCustomerData extends HttpServlet {
	
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 * @param req
	 * @param resp
	 * Updating the data of a perticular id in the database
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("inside UpdateCustomerData class");
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		int id = Integer.parseInt(req.getParameter("id1"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String accountno = req.getParameter("accountno");
		String city = req.getParameter("city");
		try {
	    	System.out.println("Got connection");
	    	HttpSession session = req.getSession();
			String inputby = session.getAttribute("id").toString();
	    	CustomerDetail customerDetail=new CustomerDetail();
	    	customerDetail.setId(id);
	    	customerDetail.setAccountno(accountno);
	    	customerDetail.setCity(city);
	    	customerDetail.setEmail(email);
	    	customerDetail.setName(name);
	    	customerDetail.setInputby(inputby);
	    	HomeDAO.updateCustomerDetail(customerDetail);
	    }catch(Exception se) {
	         se.printStackTrace();
	      }
		RequestDispatcher dispatcher = req.getRequestDispatcher("home.jsp");
		dispatcher.forward(req, resp);
	}

}
