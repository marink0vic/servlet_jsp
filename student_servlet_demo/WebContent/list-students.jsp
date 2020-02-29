<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Student tracker app</title>
		<link type="text/css" rel="stylesheet" href="CSS/style.css">
	</head>
	<body>
		<div id="wrapper">
			<div id="header">
				<h2>FooBar University</h2>
			</div>
		</div>
		
		<div id="container">
			<div id="content">
			<input type="button" value="Add Student" onclick="window.location.href='add-student-form.jsp'"
			class="add-student-button"/>
				<table>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Action</th>
					</tr>
					<!-- JSTL code -->
					 <c:forEach var = "tempStudent" items = "${student_list}">
					 <c:url var="tempLink" value="StudentControllerServlet">
					 	<c:param name="command" value="LOAD"/>
					 	<c:param name="studentId" value="${tempStudent.id}"/>
					 </c:url>
					 
					 <c:url var="deleteLink" value="StudentControllerServlet">
					 	<c:param name="command" value="DELETE"/>
					 	<c:param name="studentId" value="${tempStudent.id}"/>
					 </c:url>
						<tr>
							<td>${tempStudent.firstName}</td>
							<td>${tempStudent.lastName}</td>
							<td>${tempStudent.email}</td>
							<td>
							<a href="${tempLink}">Update</a>
							|
							<a href="${deleteLink}">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</body>
</html>