package com.bridgelabz.onetomany;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
@Entity
@Table(name = "dept")
public class Dept {
	 private int deptId;
	 private String deptName;
	 private Set employees;
	 
	 public Dept() 
	  {
	  }
	 @Id
	 @GeneratedValue
	 @Column(name = "dept_id")
	  public int getDeptId() 
	  {
	    return deptId;
	  }
	  public void setDeptId(int deptId) 
	  {
	    this.deptId = deptId;
	  }
	  @Column(name = "dept_name", nullable = false, length = 100)
	  public String getDeptName() 
	  {
	    return deptName;
	  }
	  public void setDeptName(String deptName) 
	  {
	    this.deptName = deptName;
	  }
	  @OneToMany(cascade = CascadeType.ALL)
		@JoinTable(name = "dept_employee", joinColumns = { @JoinColumn(name = "dept_id") }, inverseJoinColumns = { @JoinColumn(name = "employee_id") })
	  public Set<Employee> getEmployees() 
	  {
	    return employees;
	  }
	  public void setEmployees(Set<Employee> employees) 
	  {
	    this.employees = employees;
	  }
}
