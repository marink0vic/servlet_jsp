<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<head>
   <title>Update Student</title>
   <link type="text/css" rel="stylesheet" href="CSS/style.css">
   <link type="text/css" rel="stylesheet" href="CSS/add-student-style.css">
</head>

<body>
	<div id="wrapper">
      <div id="header">
		<h2>FooBar Univercity</h2>
	  </div>
	</div>
	
	<div id="container">
	    <h3>Update Student</h3>
		<form action="StudentControllerServlet" method="GET">
			<input type="hidden" name="command" value="UPDATE" />
			<input type="hidden" name="studentId" value="${selected_student.id}" />
			<table>
				<tbody>
					<tr>
						<td><label>First Name:</label></td>
						<td><input type="text" name="firstName" value="${selected_student.firstName}"/></td>
					</tr>
					<tr>
						<td><label>Last Name:</label></td>
						<td><input type="text" name="lastName" value="${selected_student.lastName}"/></td>
					</tr>
					<tr>
						<td><label>Email:</label></td>
						<td><input type="text" name="email" value="${selected_student.email}"/></td>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Update" class="save"/></td>
					</tr>
				</tbody>
			</table>
		</form>
		
		<div style="clear:both;">
			<a href="StudentControllerServlet">Back to list</a>
		</div>
	</div>
	
	
</body>
</html>