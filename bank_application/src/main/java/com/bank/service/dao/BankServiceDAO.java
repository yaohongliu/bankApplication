package com.bank.service.dao;

import java.util.List;

import com.bank.exception.BusinessException;
import com.bank.model.Customers;

public interface BankServiceDAO {
	
	public List<Customers> getCustomerInfo() throws BusinessException;
}
