package com.bridgeit.SingleTon;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author bridgeit Using of SessionFactory
 *
 */
public class SingleTon {

	public SingleTon() {
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
