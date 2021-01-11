package com.bank.service.dao;

import java.util.List;

import com.bank.exception.BusinessException;
import com.bank.model.CustomerAccount;
import com.bank.model.Employee;
import com.bank.model.Transaction;

public interface BankServiceDAO {
	
	public List<CustomerAccount> getCustomerByName() throws BusinessException;
	public List<CustomerAccount> getCustomerByID() throws BusinessException;
	public List<CustomerAccount> getCustomerByEmail() throws BusinessException;
	public int createAccount(CustomerAccount customer) throws BusinessException;
	public List<CustomerAccount> getAccountInfo() throws BusinessException;
	
}
