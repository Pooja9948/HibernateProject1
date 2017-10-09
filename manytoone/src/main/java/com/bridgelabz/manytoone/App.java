package com.bridgelabz.manytoone;

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
			Address address = new Address("OMR Road", "Chennai", "TN", "600097");
			//By using cascade=all option the address need not be saved explicitly when the student object is persisted the address will be automatically saved.
            //session.save(address);
			Student student1 = new Student("Eswar", address);
			Student student2 = new Student("Joe", address);
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
