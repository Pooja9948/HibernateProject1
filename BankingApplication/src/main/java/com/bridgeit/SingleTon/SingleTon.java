package com.bridgeit.SingleTon;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SingleTon {

	public SingleTon() {
		// TODO Auto-generated constructor stub
	}

	public static SessionFactory sf;

	public static SessionFactory getSF() {
		System.out.println("sessfa---->");
		if (sf == null) {
			Configuration c = new Configuration();
			c.configure("hibernate.cfg.xml");
			sf=c.buildSessionFactory();
			return sf;
		}
		return sf;
	}

}
