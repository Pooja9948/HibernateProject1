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
import com.bridgelabz.pojo.UserDetails;

public class BankDAO {

	/**
	 * @param email
	 * @param password
	 * @return
	 * checking the email and password 
	 */
	public static UserDetails login(String email, String password) {
		SessionFactory sessionFactory = SingleTon.getSF();
		Session session = sessionFactory.openSession();
		int status = 0;
		Criteria criteria = session.createCriteria(UserDetails.class);
		Criterion email1 = Restrictions.eq("email", email);
		Criterion password1 = Restrictions.eq("password", password);
		LogicalExpression andExp = Restrictions.and(email1, password1);
		criteria.add(andExp);
		UserDetails userDetails = null;
		List result = criteria.list();
		Iterator iterator = result.iterator();
		String name = "";
		int id = 0;
		while (iterator.hasNext()) {
			userDetails = (UserDetails) iterator.next();
			System.out.println("user name is--> " + userDetails.getName());
			name = userDetails.getName();
			System.out.println("user id is--> " + userDetails.getId());
			id = userDetails.getId();
		}
		session.close();
		return userDetails;

	}

	/**
	 * @param userDetails
	 * @return
	 * inserting all the data of user to the database
	 */
	public static int registration(UserDetails userDetails) {
		SessionFactory sessionFactory = SingleTon.getSF();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		int status = 0;
		try {
			transaction = session.beginTransaction();
			status = (int) session.save(userDetails);
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

}
