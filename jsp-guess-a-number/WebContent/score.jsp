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
	<h3>Thanks for taking part in our quiz</h3>
	<p>
		Your score is:
		<jsp:getProperty name="quizBean" property="score" />
	</p>
	<br /> Click
	<a href="QuizHandler"> here </a> if you want to start again
</body>
</html>