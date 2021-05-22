<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
</head>
<body>

	<form action="/classicmodel/registration" method="post">

		<h2 align="center">
			<b> !! Please Register with your Details to continue further !!</b>
		</h2>
		<div align="center">
			<b>Enter your FirstName : </b><input type="text" name="FirstName" /><br>
			<b>Enter your LastName : </b><input type="text" name="LastName" /> <br>
			<b>Enter your MobileNumber: </b><input type="text"
				name="MobileNumber" /> <br> <b>Enter your EmailID : </b><input
				type="email" name="EmailID" /><br> <b>Enter your UserName :
			</b><input type="text" name="UserName" /><br> <b>Enter your
				Password : </b><input type="password" name="Password" /><br> <br>
				
			<input type="submit" name="Register">

		</div>






	</form>

</body>
</html>