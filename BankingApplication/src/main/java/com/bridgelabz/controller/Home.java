package com.bridgelabz.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.bridgelabz.DAO.HomeDAO;
import com.bridgelabz.pojo.CustomerDetail;

/**
 * @author pooja user home page
 *
 */
public class Home extends HttpServlet {
	/*  @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 *  @param request
	 *  @param response
	 *  In this doPost() we are adding and taking the data of a perticular id in the database.
	 *  if servlet get id then it will go to the if condition update the data else add the data
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println(" inside home class");
		String customer_detailid = request.getParameter("id");

		String name = "";
		String email = "";
		String accountno = "";
		String city = "";
		System.out.println("customer_detailid : " + customer_detailid);
		/*FOR EDITING CUSTOMER*/
		if (customer_detailid != null) {
			System.out.println("inside if");
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			System.out.println("inside update data class");
			System.out.println("id : " + customer_detailid);
			try {
				JSONObject obj = updateAccount(Integer.parseInt(customer_detailid));
				System.out.println("fwehdf--->"+obj.toJSONString());
				out.print(obj.toJSONString());
			} catch (Exception se) {
				se.printStackTrace();
			}
		} 

		/*FOR ADDING CUSTOMER*/
		else {
			System.out.println("inside else");
			HttpSession session = request.getSession();
			String id = session.getAttribute("id").toString();
			response.setContentType("text/html");
			try {
				name = request.getParameter("name");
				email = request.getParameter("email");
				accountno = request.getParameter("accountno");
				city = request.getParameter("city");
				CustomerDetail customerdetail = new CustomerDetail();
				customerdetail.setName(name);
				customerdetail.setEmail(email);
				customerdetail.setAccountno(accountno);
				customerdetail.setCity(city);
				customerdetail.setInputby(id);
				HomeDAO.insertCustomerDetail(customerdetail);
				System.out.println("outside else------->");
			} catch (Exception se) {
				se.printStackTrace();
			} finally {
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
			System.out.println(request);
		}
		request.setAttribute("name", name);
		request.getAttribute("name");

		request.setAttribute("email", email);
		request.getAttribute("email");

		request.setAttribute("accountno", accountno);
		request.setAttribute("city", city);



	}

	/**
	 * @param customer_detailid
	 * @return obj of JSONObject
	 * Here we are retrieving the perticular id data and save in a JSONObject
	 */
	public static JSONObject updateAccount(int customer_detailid) {
		JSONObject obj = new JSONObject();
		try {
			System.out.println("before rs");
			CustomerDetail customerdetail = new CustomerDetail();
			customerdetail=HomeDAO.getCustomerDetail(customer_detailid);
			System.out.println("name " + customerdetail.getName() + "email " + customerdetail.getEmail() + "accountno " + customerdetail.getAccountno() + "city " + customerdetail.getCity());
			obj.put("name", customerdetail.getName());
			obj.put("email", customerdetail.getEmail());
			obj.put("city", customerdetail.getCity());
			obj.put("accountno", customerdetail.getAccountno());
			JSONArray array = new JSONArray();
			array.add(obj);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return obj;
	}
}
