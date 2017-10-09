package com.bridgelabz.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentUpdate {

	public static void main(String[] args) {
		StudentProgram se=new StudentProgram();
		se.setId(10);
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
		se.setName("sweety");
		se.setBranch("it");
		s.beginTransaction();
		s.save(se);
		s.getTransaction().commit();
		s.evict(se);
		//student object will be remove from persistent
		//then gc will collect your student object
		s.close();
		sf.close();
	}

}
