package com.bank.model;

public class Customer {
	private int id;
	private String name, password, login, email, dob;

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(int id, String name, String password, String login, String email, String dob) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.login = login;
		this.email = email;
		this.dob = dob;
	}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}
}
