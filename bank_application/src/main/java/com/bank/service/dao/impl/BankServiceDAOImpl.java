package com.bank.service.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bank.dao.dbutil.PostgresqlConnection;
import com.bank.exception.BusinessException;
import com.bank.model.Account;
import com.bank.model.Customers;
import com.bank.model.Employee;
import com.bank.model.Transaction;
import com.bank.service.dao.BankServiceDAO;

public class BankServiceDAOImpl implements BankServiceDAO {

	@Override
	public List<Customers> getCustomerInfo() throws BusinessException {
		List<Customers> customerList = new ArrayList<>();
		try (Connection connection = PostgresqlConnection.getConnection()) {
			String sql="select customer_id,customer_name,address,contact,customer_email,dob,customer_login,customer_password from bankapplication.customers";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Customers customer =new Customers();
				customer.setId(resultSet.getInt("customer_id"));
				customer.setCustomer_name(resultSet.getString("customer_name"));
				customer.setContact(resultSet.getLong("contact"));
				customer.setAddress(resultSet.getString("address"));
				customer.setCustomer_password(resultSet.getString("customer_password"));
				customer.setCustomer_login(resultSet.getString("customer_login"));
				customer.setEmail(resultSet.getString("customer_email"));
				customer.setDob(resultSet.getDate("dob"));
				customerList.add(customer);
			}
			if(customerList.size()==0)
			{
				throw new BusinessException("No customer in database so far");
			}
		}catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error occured contact SYSADMIN ");
		}
		return customerList;
		
	}

	@Override
	public int createAccout(Account account) throws BusinessException {
		int n = 0;
		try(Connection connection = PostgresqlConnection.getConnection()){
			String sql = "insert into bankapplication.account(account_id, date_open, customer_id, balance) values(?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1,account.getAccount_id());
			preparedStatement.setInt(2, account.getCustomer_id());
			preparedStatement.setDouble(3, account.getBalance());
			preparedStatement.setDate(4, new java.sql.Date(account.getOpen_date().getTime()));//util.Data to sql.Date
			
			n = preparedStatement.executeUpdate();	
			
		}catch(ClassNotFoundException | SQLException e){
			System.out.println(e);
			throw new BusinessException("Internal error occured contact SYSADMIN");
		}
		return n;
	}

	@Override
	public List<Account> getAccountInfo() throws BusinessException {
		List<Account> accountList = new ArrayList<>();
		try (Connection connection = PostgresqlConnection.getConnection()) {
			String sql="select account_id, date_open, customer_id, balance from bankapplication.account";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Account account =new Account();
				account.setAccount_id(resultSet.getInt("account_id"));
				account.setCustomer_id(resultSet.getInt("customer_id"));
				account.setBalance(resultSet.getDouble("balance"));
				account.setOpen_date(resultSet.getDate("date_open"));
				accountList.add(account);
			}
			if(accountList.size()==0)
			{
				throw new BusinessException("No account in database so far");
			}
		}catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error occured contact SYSADMIN ");
		}
		return accountList;
	}


	

}
