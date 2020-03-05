package com.quiz;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/QuizHandlerServlet")
public class QuizHandlerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		QuizBean quizBean = (QuizBean) session.getAttribute("quizBean");
		String address = "quiz.jsp";
		
		if ((quizBean == null) || (quizBean.isFinished() == true)) {
			// start quiz
			quizBean = new QuizBean();
			session.setAttribute("quizBean", quizBean);
		} else {
			// somewhere in the middle of a quiz
			int userAnswer = 0;
			boolean ok = true;
			try {
				userAnswer = Integer.parseInt(request.getParameter("answer"));
			} catch (NumberFormatException nfe) {
				ok = false;
			}
			
			if (ok && (quizBean.checkAnswer(userAnswer) == true)) {
				quizBean.incrementScore();
			}
			
			quizBean.setCurrentIndex(quizBean.getCurrentIndex() + 1);
			if (quizBean.isFinished() == true) {
				address = "score.jsp";
			}
		}
		response.sendRedirect(address);
		//all object are kept in session
		//so it is better to work with sendRedirect();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
