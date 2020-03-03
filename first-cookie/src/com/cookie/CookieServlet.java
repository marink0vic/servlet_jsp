package com.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieServlet
 */
@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		boolean newuser = true;
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("olduser")) {
					newuser = false;
					break;
				}
			}
		} 
		String title = "";
		if(newuser) {
			Cookie cookie = new Cookie("olduser", "yes");
			cookie.setMaxAge(60*60*24);
			response.addCookie(cookie);
			title = "welcome new user";
		}
		else {
			title = "Nice to see you again";
		}
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			out.println("<html>");
			out.println("<head>");
			out.println("<title>" + title + "</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>" + title + "</h1>");
			out.println("</body>");
			out.println("</html>");
		} finally {
			out.close();
		}
	}

}
