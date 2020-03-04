<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<jsp:useBean id="korisnik" class="beans.Korisnik" scope="session"/>
<jsp:setProperty name="korisnik" property="*"/>
<body>
	<table>
		<tr>
			<td>Ime:</td>
			<td>${korisnik.ime}</td>
		</tr>
		<tr>
			<td>Prezime:</td>
			<td>${korisnik.prezime}</td>
		</tr>
		<tr>
			<td>e-mail:</td>
			<td>${korisnik.email}</td>
		</tr>
		<tr>
			<td>Telefon:</td>
			<td>${korisnik.telefon}</td>
		</tr>
		<tr>
			<td>Adresa:</td>
			<td>${korisnik.adresa}</td>
		</tr>
		<tr>
			<td>Zanimanje:</td>
			<td>${korisnik.zanimanje}</td>
		</tr>
	</table>
</body>
</html>