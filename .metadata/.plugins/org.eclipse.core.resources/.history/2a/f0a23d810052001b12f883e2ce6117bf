package com.bank.service.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bank.dao.dbutil.PostgresqlConnection;
import com.bank.exception.BusinessException;
import com.bank.model.Customers;
import com.bank.service.dao.BankServiceDAO;

public class BankServiceDAOImpl implements BankServiceDAO {

	@Override
	public List<Customers> getCustomerInfo() throws BusinessException {
		List<Customers> customerList = new ArrayList<>();
		try (Connection connection = PostgresqlConnection.getConnection()) {
			String sql="select id,name,gender,address,contact,city, state, email,dob from bankapplication.customers";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Customers customer =new Customers();
				customer.setId(resultSet.getInt("id"));
				customer.setName(resultSet.getString("name"));
				customer.setGender(resultSet.getString("gender"));
				customer.setContact(resultSet.getLong("contact"));
				customer.setAddress(resultSet.getString("address"));
				customer.setCity(resultSet.getString("city"));
				customer.setState(resultSet.getString("state"));
				customer.setEmail(resultSet.getString("email"));
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

	
	
	
}
