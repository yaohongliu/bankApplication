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
	public List<CustomerAccount> getAllCustomerInfo() throws BusinessException {
		List<CustomerAccount> customerList = new ArrayList<>();
		try (Connection connection = PostgresqlConnection.getConnection()) {
			String sql = "select * from bankapplication.t_customers";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				CustomerAccount customer = new CustomerAccount();
				customer.setCustomerId(resultSet.getInt("customer_id"));
				customer.setName(resultSet.getString("customer_name"));
				customer.setEmail(resultSet.getString("customer_email"));
				customer.setPassword(resultSet.getString("customer_password"));
				customer.setUsername(resultSet.getString("customer_login"));
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
			cust_preparedStatement.setString(1, customer.getName());
			cust_preparedStatement.setString(2, customer.getEmail());
			cust_preparedStatement.setString(3, customer.getUsername());
			cust_preparedStatement.setString(4, customer.getPassword());
			cust_preparedStatement.setString(5, customer.getDob());
			cust_preparedStatement.executeUpdate();

			String sql_account = "insert into bankapplication.t_account "
					+ "(account_id, customer_id, balance, create_date, approved)"
					+ " values (default, (select max(t_customer.customer_id) from bankapplication.t_customer), ?, ?::date, false);";

			PreparedStatement acctPreparedStatement = connection.prepareStatement(sql_account);
			acctPreparedStatement.setDouble(1, customer.getBalance());
			acctPreparedStatement.setString(2, new Date().toString());

			n = acctPreparedStatement.executeUpdate();

			Date date = new Date();
			String trans_sql = "insert into bankapplication.t_transaction (transaction_id, from_account, to_account, amount, transaction_time) "
					+ "values (default, (select max(t_account.account_id) from bankapplication.t_account), "
					+ "(select max(t_account.account_id) from bankapplication.t_account), ?, ?::date);";
			PreparedStatement transactionPreparedStatement = connection.prepareStatement(trans_sql);
			transactionPreparedStatement.setDouble(1, customer.getBalance());
			transactionPreparedStatement.setString(2, date.toString());
			transactionPreparedStatement.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal error occured contact SYSADMIN");
		}
		return n;
	}

	@Override
	public void deposit(double amount, String email) throws BusinessException {
		CustomerAccount account = getCustomerByEmail(email);
		System.out.println("Customer id: " + account.getCustomerId());
		System.out.println("Status: " + account.getApproved());
		if (account.getApproved().equals("t")) {
			String sql = "update bankapplication.t_account set balance = ? where customer_id = ?;";
			try (Connection connection = PostgresqlConnection.getConnection()) {
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setDouble(1, account.getBalance() + amount);
				ps.setInt(2, account.getCustomerId());
				ps.executeUpdate();

			} catch (ClassNotFoundException | SQLException e) {
				throw new BusinessException("Internal error occured contact SYSADMIN ");
			}
		} else {
			throw new BusinessException("Your account is not yet approved!");
		}
	}

	@Override
	public CustomerAccount getBalanceByEmail(String email) throws BusinessException {
		CustomerAccount account = null;

		try (Connection connection = PostgresqlConnection.getConnection()) {
			String sql = "select balance from bankapplication.t_account where customer_email = ?;";

			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet resultSet = ps.executeQuery();

			if (resultSet.next()) {
				account = new CustomerAccount();
				// account.setAccount_id(resultSet.getInt("account_id"));
				// account.setCustomer_id(resultSet.getInt("customer_id"));
				account.setBalance(resultSet.getDouble("balance"));
				// account.setCreate_date(resultSet.getString("create_date"));
				// account.setCustomer_name(resultSet.getString("customer_name"));
				// account.setApproved(resultSet.getString("approved"));
				account.setEmail(email);
			} else {
				throw new BusinessException("No account found with this email: " + email);
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error occured contact SYSADMIN ");
		}
		return account;
	}

	@Override
	public CustomerAccount getCustomerByEmail(String email) throws BusinessException {
		CustomerAccount account = null;

		try (Connection connection = PostgresqlConnection.getConnection()) {
			String sql = "select * from bankapplication.t_customer inner join bankapplication.t_account on "
					+ "(bankapplication.t_customer.customer_id = bankapplication.t_account.customer_id) where "
					+ "bankapplication.t_customer.customer_email = ?;";

			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, email);

			ResultSet resultSet = ps.executeQuery();
			if (resultSet.next()) {
				account = new CustomerAccount();
				account.setAccountId(resultSet.getInt("account_id"));
				account.setCustomerId(resultSet.getInt("customer_id"));
				account.setBalance(resultSet.getDouble("balance"));
				account.setCreateDate(resultSet.getString("create_date"));
				account.setName(resultSet.getString("customer_name"));
				account.setApproved(resultSet.getString("approved"));
			} else {
				throw new BusinessException("No account found with this email");
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error occured contact SYSADMIN ");
		}

		return account;
	}

	@Override
	public void withdraw(double amount, String email) throws BusinessException {
		CustomerAccount account = getCustomerByEmail(email);
		System.out.println("Customer id: " + account.getCustomerId());
		System.out.println("Status: " + account.getApproved());
		if (account.getApproved().equals("t")) {
			String sql = "update bankapplication.t_account set balance = ? where customer_id = ?;";
			try (Connection connection = PostgresqlConnection.getConnection()) {
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setDouble(1, account.getBalance() - amount);
				ps.setInt(2, account.getCustomerId());
				ps.executeUpdate();

			} catch (ClassNotFoundException | SQLException e) {
				throw new BusinessException("Internal error occured contact SYSADMIN ");
			}
		} else {
			throw new BusinessException("Your account is not yet approved!");
		}

	}

}
