package com.calculator;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SimpleCalculator")
public class SimpleCalculator extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int [] numbers = parseNumbers(request);
		if (numbers.length != 0) {
			sendResult(request, response, numbers);
		} else {
			sendResponse(request, response, "Sorry we can't process your data. Check your input");
		}
	}

	private int[] parseNumbers(HttpServletRequest request) {
		int [] parsedNumbers = new int[2];
		try {
			int firstNum = Integer.parseInt(request.getParameter("firstNumber"));
			int secondNum = Integer.parseInt(request.getParameter("secondNumber"));
			parsedNumbers[0] = firstNum;
			parsedNumbers[1] = secondNum;
		} catch (NumberFormatException ex) {
			parsedNumbers = new int[0];
		}
		return parsedNumbers;
	}
	
	private void sendResult(HttpServletRequest request, HttpServletResponse response, int[] numbers) {
		String action = request.getParameter("action");
		String result = "";
		switch (action) {
		case "+":
		{
			result = addTwoNumbers(numbers[0], numbers[1]);
			break;
		}
		case "-":
		{
			result = subTwoNumbers(numbers[0], numbers[1]);
			break;
		}
		case "*":
		{
			result = multiplyTwoNumbers(numbers[0], numbers[1]);
			break;
		}
		case "/":
		{
			result = divideTwoNumbers(numbers[0], numbers[1]);
			break;
		}
		default:
			break;
		}
		sendResponse(request, response, result);
	}
	
	private String addTwoNumbers(int i, int j) {
		return String.valueOf(i + j);
	}
	
	private String subTwoNumbers(int i, int j) {
		return String.valueOf(i - j);
	}
	
	private String multiplyTwoNumbers(int i, int j) {
		return String.valueOf(i * j);
	}
	
	private String divideTwoNumbers(int i, int j) {
		if(j == 0)
			return "Division by 0 is not suported operation";
		return String.valueOf(i / j);
	}

	private void sendResponse(HttpServletRequest request, HttpServletResponse response, String data) {
		request.setAttribute("result", data);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

}
