package com.bank.model;


import java.util.Date;

public class Customers {
	private int id;
	private long contact;
	private String customer_name, address, customer_password, customer_login, email;
	private Date dob;
	
	public Customers() {
		//constructor
	}

	public Customers(int id, long contact, String customer_name, String address, String customer_password, String customer_login,
			String email, Date dob) {
		super();
		this.id = id;
		this.contact = contact;
		this.customer_name = customer_name;
		this.address = address;
		this.customer_password = customer_password;
		this.customer_login = customer_login;
		this.email = email;
		this.dob = dob;
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name= customer_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCustomer_password() {
		return customer_password;
	}

	public void setCustomer_password(String customer_password) {
		this.customer_password = customer_password;
	}

	public String getCustomer_login() {
		return customer_login;
	}

	public void setCustomer_login(String customer_login) {
		this.customer_login = customer_login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Customer [ID = " +id+", Name = "+customer_name+", dob = "+dob+", Contact = "+contact+", Email = "+email
				+", Address= "+address+ ", customer_login = "+customer_login +", customer_password = "+customer_password+" ]";
	}
	
	
}
