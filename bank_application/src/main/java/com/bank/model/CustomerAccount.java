package com.bank.model;


public class CustomerAccount {
	private int customerId, accountId;
	private String name, password, username, email, dob, approved, createDate;
	private double balance;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int id) {
		this.customerId = id;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public double getBalance() {
		return balance;
	}

	public void setBalance(double bal) {
		this.balance = bal;
	}

	public String getApproved() {
		return approved;
	}

	public void setApproved(String approved) {
		this.approved = approved;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Customer " + name + " has balance $" + balance + " in account";
	}
	
	/**
	 * Print detailed info about the customer
	 * @return
	 */
	public String detailedString() {
		return "Customer "+customerId+" Name: "+name+", acount ID: "+accountId+", balance: "+balance;
	}
}
