package com.bridgelabz.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.bridgelabz.DAO.BankDAO;
import com.bridgelabz.DAO.HomeDAO;
import com.bridgelabz.pojo.CustomerDetail;

public class Home extends HttpServlet {

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
			// String name= request.getParameter("name");
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			ResultSet resultset = null;
			System.out.println("inside update data class");
			// String customer_detailid= request.getParameter("id");
			System.out.println("id : " + customer_detailid);
			//PreparedStatement preparestatement = null;
			//Connection connection = null;
			//String getquery = HomeDAO.getCustomerDetail();
			int id=Integer.parseInt(customer_detailid);
			try {
				//connection = BankDAO.getConnection();
				//preparestatement = connection.prepareStatement(getquery);
				//CustomerDetail customerdetail = new CustomerDetail();
				//customerdetail.setId(Integer.parseInt(customer_detailid));
				//customerdetail=HomeDAO.getCustomerDetail(id);
				//preparestatement.setInt(1, customerdetail.getId());
				//resultset = preparestatement.executeQuery();
				/*if (resultset.next()) {
					name = resultset.getString(2);
					email = resultset.getString(3);
					accountno = resultset.getString(4);
					city = resultset.getString(5);*/
					
					//System.out.println("name " + customerdetail.getName() + "email " + customerdetail.getEmail() + "accountno " + customerdetail.getAccountno() + "city " + customerdetail.getCity());
					JSONObject obj = updateAccount(Integer.parseInt(customer_detailid));
					
					/*JSONObject obj = new JSONObject();
					obj.put("name", customerdetail.getName());
					obj.put("email", customerdetail.getEmail());
					obj.put("city", customerdetail.getCity());
					obj.put("accountno", customerdetail.getAccountno());
					JSONArray array = new JSONArray();
					array.add(obj);*/
					
					System.out.println("fwehdf--->"+obj.toJSONString());
					//out.println(obj.toJSONString());insertCustomerDetail
					
					out.print(obj.toJSONString());
					
					
				//}
			} catch (Exception se) {
				se.printStackTrace();
			}
		} 
		
		/*FOR ADDING CUSTOMER*/
		else {
			System.out.println("inside else");
			HttpSession session = request.getSession();
			String id = session.getAttribute("id").toString();
			PrintWriter out = response.getWriter();
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

	public static JSONObject updateAccount(int customer_detailid) {
		JSONObject obj = new JSONObject();
		//PreparedStatement preparetatement = null;
		try {
			//preparetatement.setInt(1, customer_detailid);
			//ResultSet rs = preparetatement.executeQuery();
			System.out.println("before rs");
			CustomerDetail customerdetail = new CustomerDetail();
			//customerdetail.setId(Integer.parseInt(customer_detailid));
			customerdetail=HomeDAO.getCustomerDetail(customer_detailid);
			
			/*if (rs.next()) {
				System.out.println("after rs");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String city = rs.getString("city");
				String accountno = rs.getString("accountno");
				System.out.println("sids log " + name + email + city);
			*/	System.out.println("name " + customerdetail.getName() + "email " + customerdetail.getEmail() + "accountno " + customerdetail.getAccountno() + "city " + customerdetail.getCity());
				obj.put("name", customerdetail.getName());
				obj.put("email", customerdetail.getEmail());
				obj.put("city", customerdetail.getCity());
				obj.put("accountno", customerdetail.getAccountno());
				JSONArray array = new JSONArray();
				array.add(obj);
				//preparetatement.close();
			//}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return obj;
	}
}
