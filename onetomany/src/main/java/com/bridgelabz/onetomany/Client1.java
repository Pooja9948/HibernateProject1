package com.bridgelabz.onetomany;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.HashSet;
import java.util.Set;
public class Client1 {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();
	    Transaction trans = session.getTransaction();
	    trans.begin();
	    Employee emp1 = new Employee();
	    emp1.setEmployeeId(1);
	    emp1.setEmployeeName("S N Rao");
	 
	    Employee emp2 = new Employee();
	    emp2.setEmployeeId(2);
	    emp2.setEmployeeName("Sumathi");
		
	    Employee emp3 = new Employee();
	    emp3.setEmployeeId(3);
	    emp3.setEmployeeName("Sasi");
	    Set <Employee> emps = new HashSet<Employee>();
	    emps.add(emp1);   		               // add Employee object to Set
	    emps.add(emp2);
	    emps.add(emp3);
	    Dept dept = new Dept();
	    dept.setDeptId(1234);
	    dept.setDeptName("Production");
	    dept.setEmployees(emps);  	               // add Set object to Dept object
	    session.persist(dept);
	    
	    trans.commit();
	    /*session.beginTransaction();
	    session.save(dept);
	    trans.commit();*/
	    session.close();
	    System.out.println("Records inserted");
	}

}
