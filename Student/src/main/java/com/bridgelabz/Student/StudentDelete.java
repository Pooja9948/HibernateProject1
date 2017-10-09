package com.bridgelabz.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class StudentDelete 
{
    public static void main( String[] args )
    {
    	StudentProgram se=new StudentProgram();
		se.setId(30);
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		s.delete(se);
		s.beginTransaction();
		s.save(se);
		//student object state is persistent
		s.getTransaction().commit();
		//student object will move databasde
		s.evict(se);
		//student object will be remove from persistent
		//then gc will collect your student object
		s.close();
		sf.close();
    }
}
