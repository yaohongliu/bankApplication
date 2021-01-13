package com.bank.dao.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class PostgresqlConnection {

	private static Connection connection;
	private static Logger log = Logger.getLogger(PostgresqlConnection.class);

	private PostgresqlConnection() {

	}
	
	/**
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		log.info("Attempting to connect to Postgres DB......");
		Class.forName("org.postgresql.Driver");
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String username = "postgres";
		String password = "China@28";
		connection = DriverManager.getConnection(url, username, password);
		log.info("Successfully connected to DB! :) ");
		return connection;
	}
}
