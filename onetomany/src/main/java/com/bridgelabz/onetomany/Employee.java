package com.bridgelabz.onetomany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
	 private int employeeId;
	 private String employeeName;
	 public Employee() 
	  {
	    // TODO Auto-generated constructor stub
	  }
	 @Id
	 @GeneratedValue
	 @Column(name = "employee_id")
	  public int getEmployeeId() 
	  {
	    return employeeId;
	  }
	  public void setEmployeeId(int employeeId) 
	  {
	    this.employeeId = employeeId;
	  }
	  @Column(name = "employee_name", nullable = false, length=10)
	  public String getEmployeeName() 
	  {
	    return employeeName;
	  }
	  public void setEmployeeName(String employeeName) 
	  {
	    this.employeeName = employeeName;
	  }
}
