<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index page</title>
</head>
<body>
<form action="SessionServlet" action="GET">
	<label>Enter product and add to chart</label>
	<input type="text" name="product"/>
	<br><br>
	<input type="submit" value="Add to chart">
</form>
<hr>
	<p>Selected products:</p> 
	<ol>
		<%
		    @SuppressWarnings("unchecked")
			List<String> products = (List<String>) request.getAttribute("products");
			if (products != null) {
				for(String temp : products){
					out.println("<li>" + temp + "</li>");
				}
			}
		%>
	</ol>
</body>
</html>