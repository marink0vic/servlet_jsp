<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<h1>This is the login page</h1>

<form action="ThirdServlet" action="GET">
	<label>Enter your name</label>
	<input type="text" name="name"/>
	<br><br>
	<input type="submit" value="Submit">
</form>
<h3>Name entered to upper case: ${upperName} </h3>
</body>
</html>