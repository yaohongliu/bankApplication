package com.bank.model;

import java.util.Date;

public class Transaction {

	private int fromAccount, toAccount, transactionId;
	private double amount;
	private Date time;

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transaction(int fromAccount, int toAccount, int transactionId, double amount, Date time) {
		super();
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.transactionId = transactionId;
		this.amount = amount;
		this.time = time;
	}

	public int getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(int fromAccount) {
		this.fromAccount = fromAccount;
	}

	public int getToAccount() {
		return toAccount;
	}

	public void setToAccount(int toAccount) {
		this.toAccount = toAccount;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
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
		return "Transaction [ID = " + transactionId + ", Amount = " + amount + ", From Account: " + fromAccount
				+ " to Account: " + toAccount + " at: " + time + " ]";
	}

}
