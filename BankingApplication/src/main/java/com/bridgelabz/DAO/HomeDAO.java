package com.bridgelabz.DAO;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

import com.bridgeit.SingleTon.SingleTon;
import com.bridgelabz.pojo.CustomerDetail;
import com.bridgelabz.pojo.UserDetails;

public class HomeDAO {
	
	public static int insertCustomerDetail(CustomerDetail customerdetail) {
		System.out.println("inside insertCustomerDetail---->");
		SessionFactory sessionFactory = SingleTon.getSF();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		int status = 0;
		try {
			transaction = session.beginTransaction();
			status = (int) session.save(customerdetail);
			transaction.commit();
			status = 1;
			return status;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (session != null)
					session.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return status;
	}
	
	
	
	public static List<CustomerDetail> getAllCustomerDetail(String id,String city) {
		System.out.println("inside getAllCustomerDetail---->"+id);
		SessionFactory sessionFactory = SingleTon.getSF();
		Session session = sessionFactory.openSession();
		Criteria criteria=session.createCriteria(CustomerDetail.class);
		criteria.add(Restrictions.eq("inputby", id));
		criteria.add(Restrictions.eq("city", city));
		List<CustomerDetail> customerList = criteria.list();
		//System.out.println(customerList);
		return customerList;
	}
	public static CustomerDetail getCustomerDetail(int id){
		System.out.println("inside updateCustomerDetail---->");
		SessionFactory sessionFactory = SingleTon.getSF();
		Session session = sessionFactory.openSession();
		Criteria criteria=session.createCriteria(CustomerDetail.class);
		criteria.add(Restrictions.eq("id", id));
		CustomerDetail customerList=null;
		List result = criteria.list();
		Iterator iterator = result.iterator();
		String name = "";
		String email = "";
		String city = "";
		String accountno = "";

		int id1 = 0;
		while (iterator.hasNext()) {
			customerList = (CustomerDetail) iterator.next();
			System.out.println("user name is--> " + customerList.getName());
			name = customerList.getName();
			System.out.println("user id is--> " + customerList.getId());
			id1 = customerList.getId();
			email = customerList.getEmail();
			city = customerList.getCity();
			accountno = customerList.getAccountno();
		}
		session.close();
		return customerList;
	}
	/*
	public static String updateCustomerDetail(){
		System.out.println("inside updateCustomerDetail11111111111111111111");
		String query="UPDATE `banking_application`.`customer_detail` SET name=? , email=? , accountno=? ,city=? WHERE customer_detailid=?";
		return query;
	}
	public static String getCustomerDetail(){
		String query="SELECT * FROM `banking_application`.`customer_detail` WHERE customer_detailid=?";
		return query;
	}

	public static String deleteCustomer() {
		String query="DELETE FROM `banking_application`.`customer_detail` WHERE customer_detailid=?";
		return query;
	}*/
}
