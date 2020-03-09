<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student login form</title>
</head>
<body>
	<h3>${(message !=null) ? message : "Welcome!"}</h3>
	<br />
	<br />
	<form action="LoginServlet" method="POST">
		<table>
			<tr>
				<td>Username:</td>
				<td><input type="text" name="username"
					value="${user.username}" size="20" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password"
					value="${user.password}" size="20" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Login" /></td>
				<td><input type="reset" value="Reset data" /></td>
			</tr>
		</table>
	</form>
</body>
</html>