package com.student.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.student.entity.User;

public class Db {

	private DataSource dataSource;
	
	public Db(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public User loginUser(User user) throws SQLException {
		User returnedUser = new User();
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = "SELECT * FROM user_info WHERE username=? AND password=?";
		
		try {
			con = dataSource.getConnection();
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				String username = resultSet.getString("username");
				String password = resultSet.getString("password");
				String phone = resultSet.getString("phone");
				String firstName = resultSet.getString("first_name");
				String lastName = resultSet.getString("last_name");
				String email = resultSet.getString("email");
				returnedUser = new User(username, password, firstName, lastName, email, phone);
			}
		} catch (SQLException e) {
			throw new SQLException();
		} finally {
			close(con, preparedStatement, resultSet);
		}
		return returnedUser;
	}

	private void close(Connection con, PreparedStatement preparedStatement, ResultSet resultSet) {
		try {
			if (resultSet != null)
				resultSet.close();
			if (preparedStatement != null)
				preparedStatement.close();
			if (con != null) 
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
