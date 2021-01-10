package com.bank.model;

import java.util.Date;

public class Transaction {

	private int from_account, to_account, transaction_id;
	private double amount;
	private Date time;
	
	
	
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Transaction(int from_account, int to_account, int transaction_id, double amount, Date time) {
		super();
		this.from_account = from_account;
		this.to_account = to_account;
		this.transaction_id = transaction_id;
		this.amount = amount;
		this.time = time;
	}


	public int getFrom_account() {
		return from_account;
	}


	public void setFrom_account(int from_account) {
		this.from_account = from_account;
	}


	public int getTo_account() {
		return to_account;
	}


	public void setTo_account(int to_account) {
		this.to_account = to_account;
	}


	public int getTransaction_id() {
		return transaction_id;
	}


	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public Date getTime() {
		return time;
	}


	public void setTime(Date time) {
		this.time = time;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Transaction [ID = " +transaction_id+", Amount = "+amount+", From Account: "+from_account+" to Account: "+to_account+" at: "+time+" ]";
	}
	
	
}
