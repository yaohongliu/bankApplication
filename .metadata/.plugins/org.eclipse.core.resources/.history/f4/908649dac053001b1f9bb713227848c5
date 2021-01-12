package com.bank.service.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bank.dao.dbutil.PostgresqlConnection;
import com.bank.exception.BusinessException;
import com.bank.model.CustomerAccount;
import com.bank.model.Employee;
import com.bank.model.Transaction;
import com.bank.service.dao.BankServiceDAO;

public class BankServiceDAOImpl implements BankServiceDAO {

	@Override
	public List<CustomerAccount> getCustomerInfo() throws BusinessException {
		List<CustomerAccount> customerList = new ArrayList<>();
		try (Connection connection = PostgresqlConnection.getConnection()) {
			String sql = "select customer_id,customer_name,customer_email,"
					+ "customer_login,customer_password, dob from bankapplication.t_customers";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				CustomerAccount customer = new CustomerAccount();
				customer.setCustomer_id(resultSet.getInt("customer_id"));
				customer.setCustomer_name(resultSet.getString("customer_name"));
				customer.setCustomerEmail(resultSet.getString("customer_email"));
				customer.setCustomer_password(resultSet.getString("customer_password"));
				customer.setCustomer_login(resultSet.getString("customer_login"));
				customer.setDob(resultSet.getString("dob"));
				customerList.add(customer);
			}
			if (customerList.size() == 0) {
				throw new BusinessException("No customer in database so far");
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error occured contact SYSADMIN ");
		}
		return customerList;

	}

	@Override
	public int createAccount(CustomerAccount customer) throws BusinessException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		int n = 0;
		
		try (Connection connection = PostgresqlConnection.getConnection()) {
			String sql_customer = "insert into bankapplication.t_customer "
					+ "(customer_id, customer_name, customer_email, customer_login, customer_password, dob) "
					+ "values (default, ?, ?, ?, ?, ?::date);";
			PreparedStatement cust_preparedStatement = connection.prepareStatement(sql_customer);
			cust_preparedStatement.setString(1, customer.getCustomer_name());
			cust_preparedStatement.setString(2, customer.getCustomerEmail());
			cust_preparedStatement.setString(3, customer.getCustomer_login());
			cust_preparedStatement.setString(4, customer.getCustomer_password());
			cust_preparedStatement.setString(5, customer.getDob());
			cust_preparedStatement.executeUpdate();
			
			String sql_account = "insert into bankapplication.t_account "
					+ "(account_id, customer_id, balance, create_date, approved)"
					+ " values (default, (select max(t_customer.customer_id) from bankapplication.t_customer), ?, ?::date, false);";
			
			PreparedStatement acct_preparedStatement = connection.prepareStatement(sql_account);
			acct_preparedStatement.setDouble(1, customer.getBalance());
			acct_preparedStatement.setString(2, new Date().toString());

			n = acct_preparedStatement.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal error occured contact SYSADMIN");
		}
		return n;
	}

	@Override
	public List<CustomerAccount> getAccountInfo() throws BusinessException {
		List<CustomerAccount> accountList = new ArrayList<>();
		try (Connection connection = PostgresqlConnection.getConnection()) {
			String sql = "select account_id, date_open, customer_id, balance from bankapplication.account";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				CustomerAccount account = new CustomerAccount();
				account.setAccount_id(resultSet.getInt("account_id"));
				account.setCustomer_id(resultSet.getInt("customer_id"));
				account.setBalance(resultSet.getDouble("balance"));
				account.setCreate_date(resultSet.getString("date_open"));
				accountList.add(account);
			}
			if (accountList.size() == 0) {
				throw new BusinessException("No account in database so far");
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error occured contact SYSADMIN ");
		}
		return accountList;
	}

}
