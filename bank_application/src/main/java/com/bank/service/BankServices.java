package com.bank.service;

import java.util.List;

import com.bank.exception.BusinessException;
import com.bank.model.Customers;

public interface BankServices {

	public List<Customers> getCustomerInfo() throws BusinessException;
}
