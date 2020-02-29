<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Simple Calculator</title>
</head>
<body>
<h1>Calculator</h1>
<form action="SimpleCalculator" method=GET>
	   	First number: <input type="text" name="firstNumber">
	    <br><br>
	    Second number: <input type="text" name="secondNumber">
	    <br><br>
	    Country: 
	        <select name="action">
		    	<option>+</option>
		    	<option>-</option>
		    	<option>*</option>
		    	<option>/</option>
	    	</select>
	    <br><br>
	    
	    <input type="submit" value="Submit">
   </form>
   <h3>Result is: ${result}</h3>
</body>
</html>