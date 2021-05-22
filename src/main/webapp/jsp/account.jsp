<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Account Page</title>
</head>
<body>

	<%@ page import="ecom.classicmodel.model.Customer"%>



	<h3 align="center">

		<%
			Customer customer = (Customer) request.getSession().getAttribute("Customer");
		%>

		<%
			Cookie ck[] = request.getCookies();

		for (Cookie cookie : ck) {

			if (cookie.getName().equals("name")) {

				out.print("Welcome ! " + cookie.getValue() + " have Successfully Registered/logedIn");
			}

		}
		%>

	</h3>

	<table align="Center" border="1">
		<tr>

			<td align="center" colspan="2" style="font-size: 30px"><b>Customer
					Profile</b></td>
		</tr>
		<tr>
			<td align="left">FirstName:</td>
			<td align="left">
				<%
					out.println(customer.getFirstName());
				%>
			</td>
		</tr>
		<tr>
			<td align="left">LastName:</td>
			<td align="left">
				<%
					out.println(customer.getLastName());
				%>
			</td>
		</tr>
		<tr>
			<td align="left">MobileNumber:</td>
			<td align="left">
				<%
					out.println(customer.getMobileNumber());
				%>
			</td>
		</tr>
		<tr>
			<td align="left">EmailID:</td>
			<td align="left">
				<%
					out.println(customer.getEmailID());
				%>
			</td>
		</tr>
		<tr>
			<td align="left">UserName:</td>
			<td align="left">
				<%
					out.println(customer.getUserName());
				%>
			</td>
		</tr>




	</table>


	<div>
		<br> <a href="/shoppingapp/jsp/update.jsp">Click here to
			Update Your Profile</a>
	</div>

	<div>
		<br> <a href="/shoppingapp/jsp/shopping.jsp">Click here for
			Shopping</a>
	</div>










</body>