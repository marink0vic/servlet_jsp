package com.counter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletCounter
 */
@WebServlet("/ServletCounter")
public class ServletCounter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int counter;
	private String fileLocation = "D:\\\\servlet_jsp\\\\counter-servlet\\\\WebContent\\\\counter.txt";

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		File f = new File(fileLocation);
		
		try {
			if (!(f.exists()))
				f.createNewFile();
			FileReader fileReader = new FileReader(f);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String start = bufferedReader.readLine();
			if (start != null)
				counter = Integer.parseInt(start);
			return;
		} catch (IOException e) {
			e.printStackTrace();
		}
		counter = 0;
	}

	public void destroy() {
		saveState();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		counter++;
		try {
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Brojac poziva</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("Od kad je sveta i veka, ovaj servlet je pozvan " + counter + " puta.");
		out.println("<a href=\"ServletCounter\">klikni ponovo</a>");
		out.println("</body>");
		out.println("</html>");
		}
		finally{
		out.close();
		}
	}

	private void saveState() {
		try {
			File file = new File(fileLocation);
			FileWriter fileWriter = new FileWriter(file);
			String stanje = Integer.toString(counter);
			fileWriter.write(stanje, 0, stanje.length());
			fileWriter.close();
			return;
		} catch (IOException e) { 
			e.printStackTrace();
	    }
	}

}
