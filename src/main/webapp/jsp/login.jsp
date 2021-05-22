<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>

	<form action="/shoppingapp/login" method="post">

	<b>Enter the UserName :</b>
	<input type="text" name="UserName" />
	<br>
	<b>Enter the Password :</b>
	<input type="password" name="Password"/>
	<br>

	<br>
	<input type="submit" name="lOGIN" >
</form>
</body>
</html>