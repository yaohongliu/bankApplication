package com.bank.service.dao;

import java.util.List;

import com.bank.exception.BusinessException;
import com.bank.model.CustomerAccount;

public interface BankServiceDAO {

	public List<CustomerAccount> getAllCustomerInfo() throws BusinessException;

	public CustomerAccount getCustomerByEmail(String email) throws BusinessException;

	public int createAccount(CustomerAccount customer) throws BusinessException;

	public CustomerAccount getBalanceByEmail(String email) throws BusinessException;

	public void deposit(double amount, String email) throws BusinessException;

	public void withdraw(double amount, String email) throws BusinessException;

}
