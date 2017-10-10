package com.bridgelabz.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
 * @author Pooja View account through pop-up
 *
 */
@WebServlet("/AccountView")
public class AccountView extends HttpServlet{
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 * @param request
	 * @param response
	 * Getting all the customers of the perticular city and a perticular user 
	 */
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		List<CustomerDetail> obj = new ArrayList<CustomerDetail>();
		System.out.println("inside AccountView");
		String city= request.getParameter("city");
		HttpSession session = request.getSession();
		String id = session.getAttribute("id").toString();
		System.out.println(id+" :id8324 "+city+" :city");
		response.setContentType("text/html");
		try {
			CustomerDetail customerdetail = new CustomerDetail();
			customerdetail.setCity(city);
			customerdetail.setInputby(id);
			obj=(List<CustomerDetail>) HomeDAO.getAllCustomerDetail(id,city);
			System.out.println("Current array list is:"+obj);
		}catch(Exception se) {
			se.printStackTrace();
		}
		request.setAttribute("list",obj );
		RequestDispatcher dispatcher= request.getRequestDispatcher("accountview.jsp");
		dispatcher.forward(request, response);
	}
}
