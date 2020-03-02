package com.session;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		List<String> products = (List<String>) session.getAttribute("previousProducts");
		
		if (products == null) {
			products = new ArrayList<>();
			session.setAttribute("previousProducts", products);
		}
		
		String product = request.getParameter("product");
		products.add(product);
		
		request.setAttribute("products", products);
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

}
