package ecom.classicmodel.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ecom.classicmodel.dao.UpdateDAO;
import ecom.classicmodel.model.Customer;
import ecom.classicmodel.util.AES;


@WebServlet(urlPatterns = { "/update" })
public class UpdateServlet extends HttpServlet{
	
	UpdateDAO updateDAO = new UpdateDAO();
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Customer customer = (Customer) request.getSession().getAttribute("Customer");

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		String newPassword = request.getParameter("newPassword");
		String confirmPassword = request.getParameter("confirmPassword");

		if (newPassword.equals(confirmPassword)) {

		String encrypted = AES.encrypt(newPassword);
			
			updateDAO.updateDetails(encrypted, customer);

			out.print("Password Updated Successfully");

			RequestDispatcher rd = request.getRequestDispatcher("/jsp/login.jsp");

			request.getSession().invalidate();

			rd.forward(request, response);

		} else {

			out.print("Sorry password error pleas try again");
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/changePassword.jsp");
			rd.include(request, response);
		}
	}
}
