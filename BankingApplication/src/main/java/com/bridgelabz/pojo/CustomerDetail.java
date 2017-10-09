package com.bridgelabz.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "customer_detail")
public class CustomerDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "customerGenerator")
	@GenericGenerator(name = "customerGenerator", strategy = "native")
	private int id;

	private String name;
	private String email;

	@Column(name = "account_number")
	private String accountno;
	private String city;
	private String inputby;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAccountno() {
		return accountno;
	}

	public void setAccountno(String accountno) {
		this.accountno = accountno;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getInputby() {
		return inputby;
	}

	public void setInputby(String inputby) {
		this.inputby = inputby;
	}

	@Override
	public String toString() {
		return "CustomerDetail [id=" + id + ", name=" + name + ", email=" + email + ", accountno=" + accountno
				+ ", city=" + city + ", inputby=" + inputby + "]";
	}
	

}
