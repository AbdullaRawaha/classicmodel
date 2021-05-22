package ecom.classicmodel.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ecom.classicmodel.dao.LoginDAO;
import ecom.classicmodel.model.Customer;

@WebServlet(urlPatterns = { "/classicmodel/login" })

public class LoginServlet extends HttpServlet {
	
	LoginDAO loginDAO = new LoginDAO();

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException  {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String n = request.getParameter("UserName");
		String p = request.getParameter("Password");

		Customer customer = loginDAO.authentication(n, p);

		if (customer != null) {

			request.getSession().setAttribute("Customer", customer);

			RequestDispatcher rd = request.getRequestDispatcher("/jsp/account.jsp");
			rd.forward(request, response);

		} else {
			out.print("Sorry username or password error pleas try again");
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/login.jsp");
			rd.include(request, response);
		}

		out.close();

	}
}
