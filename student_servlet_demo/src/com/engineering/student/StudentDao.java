package com.engineering.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class StudentDao {
	private DataSource dataSource;
	
	public StudentDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public List<Student> getStudentsFromDatabase() throws SQLException {
		List<Student> students = new ArrayList<>();
		Connection connection = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM student ORDER BY last_name";
			connection = dataSource.getConnection();
			st = connection.prepareStatement(sql);
			rs = st.executeQuery();
			
			while (rs.next()) {
				Student s = new Student(rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"));
				int id = rs.getInt("id");
				s.setId(id);
				students.add(s);
			}
		} finally {
			  close(connection, st, rs);
		}
		return students;
	}
	
	private void close(Connection connection, PreparedStatement st, ResultSet rs) {
		try {
			if (rs != null) rs.close();
			if (st != null) st.close();
			if (connection != null) 
				connection.close(); // this doesn't close db connection, but puts it back to connection pool
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
