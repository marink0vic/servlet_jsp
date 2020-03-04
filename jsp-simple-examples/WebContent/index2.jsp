<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Unesite podatke o osobi:</h3>
<form action="prikaz.jsp" method="post">
<table>
<tr>
<td>Ime:</td>
<td><input type="text" name="ime"/></td>
</tr>
<tr>
<td>Prezime:</td>
<td><input type="text" name="prezime"/></td>
</tr>
<tr>
<td>E-posta:</td>
<td><input type="text" name="email"/></td>
</tr>
<tr>
<td>Telefon:</td>
<td><input type="text" name="telefon"/></td>
</tr>
<tr>
<td>Adresa:</td>
<td><input type="text" name="adresa"/></td>
</tr>
<tr>
<td>Zanimanje:</td>
<td><input type="text" name="zanimanje"/></td>
</tr>
</table>
<input type="submit" value="Posalji">
</form>
</body>
</html>