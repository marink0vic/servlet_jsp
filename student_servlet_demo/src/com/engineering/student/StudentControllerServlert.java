package com.engineering.student;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


@WebServlet("/StudentControllerServlet")
public class StudentControllerServlert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDao studentDao;
	
	@Resource(name="jdbc/web_student_tracker")
	private DataSource dataSource;

	@Override
	public void init() throws ServletException {
		super.init();
		try {
			studentDao = new StudentDao(dataSource);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("command");
		if (action == null) action = "LIST";
		switch (action) {
		case "ADD":
			addStudent(request, response);
			break;
		case "LOAD":
			loadStudent(request, response);
			break;
		case "UPDATE":
			updateStudent(request, response);
			break;
		case "LIST":
			listStudents(request, response);
			break;
		case "DELETE":
			deleteStudent(request, response);
			break;
		default:
			listStudents(request, response);
		}
		
	}

	private void addStudent(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		Student student = new Student(name, lastName, email);
		try {
			studentDao.saveStudentToDatabase(student);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		listStudents(request, response);
	}
	
	private void loadStudent(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("studentId"));
		try {
			Student student = studentDao.loadStudent(id);
			request.setAttribute("selected_student", student);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/update-student-form.jsp");
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void updateStudent(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("studentId"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		Student s = new Student(firstName, lastName, email);
		s.setId(id);
		try {
			studentDao.updateStudent(s);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		listStudents(request, response);
	}
	
	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("studentId"));
		try {
			studentDao.deleteStudent(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		listStudents(request, response);
	}

	private void listStudents(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<Student> students = studentDao.getStudentsFromDatabase();
			request.setAttribute("student_list", students);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/list-students.jsp");
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
