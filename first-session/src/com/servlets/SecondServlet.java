package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			HttpSession session = request.getSession();
			String parametar=request.getParameter("txt");
			String param2 = request.getParameter("jack_black");
			String sessionParam = (String) session.getAttribute("jack");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet servlet2</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Servlet servlet2: <br/> parametar=" +
			parametar +
			"<br/> param2 (iz request-a)=" + param2 +
			"<br/> param3 (iz sesije)=" + sessionParam + "</h1>");
			out.println("</body>");
			out.println("</html>");
			} finally {
			out.close();
			}
	}
}
