package com.bank.service.dao;

import java.util.List;

import com.bank.exception.BusinessException;
import com.bank.model.CustomerAccount;
import com.bank.model.Employee;
import com.bank.model.Transaction;

public interface BankServiceDAO {
	
	public CustomerAccount getCustomerByUsernameAndPassword(String username, String password) throws BusinessException;
	
	public Employee employeeLogin(String username, String password) throws BusinessException;

	public List<CustomerAccount> getAllCustomerInfo() throws BusinessException;

	public CustomerAccount getCustomerByEmail(String email) throws BusinessException;
	
	public CustomerAccount getCustomerById(int customerId) throws BusinessException;

	public int createAccount(CustomerAccount customer) throws BusinessException;

	public double getBalanceByCustomerId(int customerId) throws BusinessException;

	public void deposit(double amount, CustomerAccount customer) throws BusinessException;

	public void withdraw(double amount, CustomerAccount customer) throws BusinessException;
	
	public List<Transaction> viewTransactionTable() throws BusinessException;
	
	public void approveAccount(int customerId) throws BusinessException;

}
