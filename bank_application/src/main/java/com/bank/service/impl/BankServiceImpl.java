package com.bank.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bank.dao.dbutil.PostgresqlConnection;
import com.bank.exception.BusinessException;
import com.bank.model.Customers;
import com.bank.service.BankServices;

public class BankServiceImpl implements BankServices{

	@Override
	public List<Customers> getCustomerInfo() throws BusinessException {
		// TODO Auto-generated method stub
		List<Customers> customerList=new ArrayList<>();
		try (Connection connection = PostgresqlConnection.getConnection()) {
			String sql="select id,name,age,gender,address,contact,city, state, email,dob from roc_revature.player";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Customers customer =new Customers();
				customer.setId(resultSet.getInt("id"));
				customer.setName(resultSet.getString("name"));
				customer.setAge(resultSet.getInt("age"));
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
				throw new BusinessException("No Players in the DB so far");
			}
		}catch (ClassNotFoundException | SQLException e) {
			System.out.println(e); // Take off this line when app is live
			throw new BusinessException("Internal error occured contact SYSADMIN ");
		}
		return customerList;
	
	}
	
	
}
