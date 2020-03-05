<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="quizBean" type="com.quiz.QuizBean" scope="session" />

	<form name="quiz" action="QuizHandler" method="post">
		<h3>Enjoy our quiz</h3>
		<p>
			Your current score is:
			<jsp:getProperty name="quizBean" property="score" />
		</p>
		<p>Guess next number in array!</p>
		<p><jsp:getProperty name="quizBean" property="currentProblem" />
		</p>
		<p>
			Your answer: <input type="text" name="answer">
		</p>
		<p>
			<input type="submit" value=" sledeci ">
		</p>
	</form>
</body>
</html>