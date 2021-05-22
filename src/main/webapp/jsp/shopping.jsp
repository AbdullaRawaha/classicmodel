<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shopping Application</title>
</head>
<body>
<form action ="/shopping" method ="post">

	<%@ page import="ecom.classicmodel.model.Shopping"%>

 <%
		Shopping shopping = (Shopping) request.getSession().getAttribute("Shopping");
	%>


	<table>
		<tr>
			<td>
				<%
					for (Shopping shop : shopping.getShoppingList()) {
				%>
				<table border="1">
					<tr>
						<td align="left"><b>Card Number :</b></td>
						<td align="right">
							<%
								out.println(shop.getUniq_id());
							%>

						</td>
					</tr>

					<tr>
						<td><b>YearOfExpire:</b></td>
						<td>
							<%
								out.println(shop.getBrand());
							%>
						</td>
					</tr>

					<tr>
						<td><b>Card Name:</b></td>
						<td>
							<%
								out.println(shop.getDiscounted_price());
							%>
						</td>
					</tr>
				</table> <br> <%
 	}
 %>
			</td>
		</tr>




	</table>

</form>
</body>
</html>