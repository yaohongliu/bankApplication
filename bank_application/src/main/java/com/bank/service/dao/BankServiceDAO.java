package com.bank.service.dao;

import java.util.List;

import com.bank.exception.BusinessException;
import com.bank.model.Customers;
import com.bank.model.Account;
import com.bank.model.Employee;
import com.bank.model.Transaction;

public interface BankServiceDAO {
	
	public List<Customers> getCustomerInfo() throws BusinessException;
	public int createAccout(Account account) throws BusinessException;
	public List<Account> getAccountInfo() throws BusinessException;
}
