<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Application</title>
</head>
<body>
<h3>${message}</h3><br/><br/>
<table width="40%" border="3">
<tr><td width="50%"> Username:</td>
<td>${user.username} </td></tr>
<tr><td>Name:</td>
<td>${user.firstName}</td></tr>
<tr><td>Last Name:</td>
<td>${user.lastName}</td></tr>
<tr><td>Email:</td>
<td>${user.email}</td></tr>
<tr><td>Phone:</td>
<td>${user.phone}</td></tr>
</table><br/>
<a href="promena.jsp">Change Data</a>
<a href="logout">Logout</a>
</body>
</html>