package com.bridgelabz.manytomany;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();
	    Transaction trans = session.getTransaction();
		try {
			trans = session.beginTransaction();

			Set<Course> courses = new HashSet<Course>();
			courses.add(new Course("Maths"));
			courses.add(new Course("Computer Science"));
			courses.add(new Course("English"));
			courses.add(new Course("Chemistry"));

			Student student1 = new Student("Eswar", courses);
			Student student2 = new Student("Joe", courses);
			session.save(student1);
			session.save(student2);

			trans.commit();
		} catch (HibernateException e) {
			trans.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

    }
}
