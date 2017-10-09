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
	
	
	
	public static CustomerDetail getAllCustomerDetail(String id,String city) {
		System.out.println("inside getAllCustomerDetail---->");
		SessionFactory sessionFactory = SingleTon.getSF();
		Session session = sessionFactory.openSession();
		int status = 0;
		Criteria criteria=session.createCriteria(CustomerDetail.class);
		Criterion id1 = Restrictions.eq("id", id);
		Criterion city1 = Restrictions.eq("city", city);
		LogicalExpression andExp = Restrictions.and(id1, city1);
		criteria.add(andExp);
		CustomerDetail customerDetail=null;
		List result = criteria.list();
		Iterator iterator = result.iterator();
		String name="";
		String email="";
		String accountno="";
		String city2="";
		int id2=0;
		while (iterator.hasNext()) {
			customerDetail = (CustomerDetail) iterator.next();
			System.out.println("user name is--> " + customerDetail.getName());
			name = customerDetail.getName();
			System.out.println("user id is--> " + customerDetail.getId());
			id2 = customerDetail.getId();
			email=customerDetail.getEmail();
			accountno=customerDetail.getAccountno();
			city2=customerDetail.getCity();
		}
		session.close();
		System.out.println("outside getAllCustomerDetail---->");
		return customerDetail;
	}
	/*public static String insertCustomerDetail() {
		System.out.println("inside insertCustomerDetail");
		String query="INSERT INTO `banking_application`.`customer_detail` (`name`, `email`,`accountno`,`city`, `inputby`) VALUES (?,?,?,?,?)";
		return query;
	}

	public static String getAllCustomerDetail() {
		String query="SELECT * FROM `banking_application`.`customer_detail` WHERE city=? and inputby=?";
		return query;
	}
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
