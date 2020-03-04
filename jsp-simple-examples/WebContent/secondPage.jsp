<%! int a, b, razlika;
	String prvi, drugi;
%>

<%
  prvi = request.getParameter("firstNumber");
  drugi = request.getParameter("secondNumber");
  a = Integer.parseInt(prvi);
  b = Integer.parseInt(drugi);
  razlika = a - b;
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>
	<%if (razlika < 0) {%>
		Manje
	<%} else if (razlika > 0) {%>
		Vece
	<%} else {%>
		Nula
	<%}%>
</title>
</head>
<body bgcolor="<%if (razlika < 0) {%>
     blue
   <%} else if (razlika > 0) {%>
     green
   <%} else {%>
     red
   <%} %>">
<h2>
  Razlika je
  <%if (razlika < 0) {%>
     manja od nule.
  <%} else if (razlika > 0) {%>
     veca od nule.
  <%} else {%>
     nula.
  <%}%>
</h2>
</body>
</html>