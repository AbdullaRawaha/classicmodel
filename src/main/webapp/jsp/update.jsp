<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Your Profile</title>
</head>
<body>

<h3 align="center"> Please Edit your Details Here </h3>

<form action = "/shoppingapp/update" method ="post">

New Password :<input type = "password" name = "newPassword"><br>
Confirm Password:<input type = "password" name = "confirmPassword"><br><br>

<input type="submit"
			value="Confirm" />




</form>




</body>
</html>