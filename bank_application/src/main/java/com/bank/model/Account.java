package com.bank.model;

import java.util.Date;

public class Account {
	private int account_id, customer_id;
	private Date open_date;
	private double balance;
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(int account_id, int customer_id, Date open_date, double balance) {
		super();
		this.account_id = account_id;
		this.customer_id = customer_id;
		this.open_date = open_date;
		this.balance = balance;
	}

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public Date getOpen_date() {
		return open_date;
	}

	public void setOpen_date(Date open_date) {
		this.open_date = open_date;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
	
		return "Account [ID: " +account_id+" opened at: "+open_date+" from Customer:  "+customer_id+". Current balance: "+balance+" ]";
	}

	
}
