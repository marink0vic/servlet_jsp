package com.student.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.student.db.Db;
import com.student.entity.User;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Db database;
	
	@Resource(name="jdbc/student_form")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		try {
			database = new Db(dataSource);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String message = "";
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		if (username.isEmpty() || password.isEmpty()) {
			message = "You didn't fill all fields";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		String address = "userdata.jsp";
		
		try {
			user = database.loginUser(user);
			if (user.getUsername().equals("")) {
				message = "Not valid data. Try again";
				request.setAttribute("message", message);
				address = "index.jsp";
			} else {
				session.setAttribute("user", user);
			}
		} catch (SQLException e) {
			session.invalidate();
			String errorMessage = e.getMessage();
			request.setAttribute("errormsg", errorMessage);
			address = "error.jsp";
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	
	}

}
