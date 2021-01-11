package com.bank.service.dao;

import java.sql.SQLException;
import java.util.List;

import com.bank.exception.BusinessException;
import com.bank.model.CustomerAccount;
import com.bank.model.Employee;
import com.bank.model.Transaction;

public interface BankServiceDAO {
	
	public List<CustomerAccount> getAllCustomerInfo() throws BusinessException;
	public CustomerAccount getCustomerByEmail(String email) throws BusinessException, ClassNotFoundException, SQLException;
	public int createAccount(CustomerAccount customer) throws BusinessException;
	public List<CustomerAccount> getAccountInfo() throws BusinessException;
	public void deposit(double amount, String email) throws ClassNotFoundException, BusinessException, SQLException;
	
}
