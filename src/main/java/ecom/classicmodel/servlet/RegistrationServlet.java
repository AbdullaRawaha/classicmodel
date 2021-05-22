package ecom.classicmodel.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ecom.classicmodel.dao.RegistrationDAO;
import ecom.classicmodel.model.Customer;

@WebServlet(urlPatterns = { "/registration" }) 

public class RegistrationServlet extends HttpServlet {

	RegistrationDAO registrationDAO = new RegistrationDAO();

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		Customer customer = new Customer();

		customer.setFirstName(request.getParameter("FirstName"));
		customer.setLastName(request.getParameter("LastName"));
		customer.setMobileNumber(request.getParameter("MobileNumber"));
		customer.setEmailID(request.getParameter("EmailID"));
		customer.setUserName(request.getParameter("UserName"));

		String userName = request.getParameter("UserName");

		boolean available = registrationDAO.availibility(userName);

		if (available == true) {
			
			out.print("Sorry, UserName is already Taken please try another UserName");

			RequestDispatcher rd = request.getRequestDispatcher("/jsp/registration.jsp");

			rd.forward(request, response);

			out.close();

		} else {

			customer.setPassword(request.getParameter("Password"));

			registrationDAO.registration(customer);

			Cookie ck = new Cookie("name", customer.getUserName());
			ck.setMaxAge(60 * 60 * 24 * 365 * 10);
			response.addCookie(ck);

			RequestDispatcher rd = request.getRequestDispatcher("/jsp/account.jsp");

			rd.forward(request, response);

			out.close();

		}

	}
}
