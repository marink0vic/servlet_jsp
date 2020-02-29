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
	
	public void saveStudentToDatabase(Student student) throws SQLException {
		Connection connection = null;
		PreparedStatement st = null;
		
		try {
			String query = "INSERT INTO student(first_name, last_name, email) VALUES(?, ?, ?)";
			connection = dataSource.getConnection();
			st = connection.prepareStatement(query);
			st.setString(1, student.getFirstName());
			st.setString(2, student.getLastName());
			st.setString(3, student.getEmail());
			st.executeUpdate();
		} finally {
			  close(connection, st, null);
		}
		
	}
	
	public Student loadStudent(int id) throws SQLException {
		Connection connection = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		Student student = new Student();
		try {
			String query = "SELECT * FROM student WHERE id = ?";
			connection = dataSource.getConnection();
			st = connection.prepareStatement(query);
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				student.setId(id);
				student.setFirstName(rs.getString("first_name"));
				student.setLastName(rs.getString("last_name"));
				student.setEmail(rs.getString("email"));
			}
		} finally {
			  close(connection, st, rs);
		}
		return student;
	}
	
	public void updateStudent(Student s) throws SQLException {
		Connection connection = null;
		PreparedStatement st = null;
		try {
			String query = "UPDATE student SET first_name = ?, last_name = ?, email = ? WHERE id = ?";
			connection = dataSource.getConnection();
			st = connection.prepareStatement(query);
			st.setString(1, s.getFirstName());
			st.setString(2, s.getLastName());
			st.setString(3, s.getEmail());
			st.setInt(4, s.getId());
			st.executeUpdate();
		} finally {
			  close(connection, st, null);
		}
		
	}
	
	public void deleteStudent(int id) throws SQLException {
		Connection connection = null;
		PreparedStatement st = null;
		try {
			String query = "DELETE FROM student WHERE id = ?";
			connection = dataSource.getConnection();
			st = connection.prepareStatement(query);
			st.setInt(1, id);
			st.executeUpdate();
		} finally {
			close(connection, st, null);
		}
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
