package com.jda.servlet.repository;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jda.model.User;

import java.sql.Connection;

public class Repo {
	private Connection connect = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	private Statement statement = null;

	public void readDataBase(User user) throws Exception {
		try {
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Setup the connection with the DB
			connect = DriverManager.getConnection("jdbc:mysql://10.0.0.160/db10007?" + "user=u10007&password=qqdDbor60y");

			// PreparedStatements can use variables and are more efficient
			preparedStatement = connect.prepareStatement("insert into  db10007.userdata values (?, ?, ?, ? )");
			// "myuser, webpage, datum, summary, COMMENTS from feedback.comments");
			// Parameters start with 1
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setString(4, user.getPhonenumber());
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}

	}

	public boolean checkDatabase(String email, String password) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		// Setup the connection with the DB
		connect = DriverManager.getConnection("jdbc:mysql://10.0.0.160/db10007?" + "user=u10007&password=qqdDbor60y");
		statement = connect.createStatement();
		resultSet = statement.executeQuery(" select * from  db10007.userdata where email='" + email + "';");
		if (resultSet.next()) {
			if (resultSet.getString(3).equals(password)) {
				System.out.println("right pasword");
				return true;
			} else {
				System.out.println("wrong password");
				return false;
			}
		}
		return false;

	}

	/*
	 * public String getUsername(String email, String password) throws
	 * ClassNotFoundException, SQLException {
	 * Class.forName("com.mysql.cj.jdbc.Driver"); // Setup the connection with
	 * the DB connect =
	 * DriverManager.getConnection("jdbc:mysql://10.0.0.160/db10007?" +
	 * "user=u10007&password=qqdDbor60y"); statement = connect.createStatement();
	 * resultSet =
	 * statement.executeQuery(" select * from  db10007.userdata where email='" +
	 * email + "';"); if (resultSet.next()) { if
	 * (resultSet.getString(3).equals(password)) {
	 * System.out.println("right pasword"); return resultSet.getString(1); } else
	 * { System.out.println("wrong password"); return "wrong"; } }
	 * 
	 * return "notfound";
	 * 
	 * }
	 */
	public User getUser(String email, String password) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		// Setup the connection with the DB
		connect = DriverManager.getConnection("jdbc:mysql://10.0.0.160/db10007?" + "user=u10007&password=qqdDbor60y");
		statement = connect.createStatement();
		resultSet = statement.executeQuery(" select * from  db10007.userdata where email='" + email + "';");
		if (resultSet.next()) {
			if (resultSet.getString(3).equals(password)) {
				return createUser(resultSet);
			} else {
				return null;
			}
		}
		return null;

	}

	public User createUser(ResultSet resultSet) throws SQLException {
		User user = new User();
		user.setName(resultSet.getString(1));
		user.setEmail(resultSet.getString(2));
		user.setPassword(resultSet.getString(3));
		user.setPhonenumber(resultSet.getString(4));
		return user;

	}

	private void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {

		}
	}
}
