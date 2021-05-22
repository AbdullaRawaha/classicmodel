package ecom.classicmodel.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ecom.classicmodel.dao.ShoppingDAO;
import ecom.classicmodel.model.Shopping;

@WebServlet(urlPatterns = { "/shopping" })
public class ShoppingServlet extends HttpServlet {

	ShoppingDAO shoppingDAO = new ShoppingDAO();

	Shopping shopping;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<Shopping> shoppingList = shoppingDAO.shopping();

		shoppingList.add(shopping);

		request.getSession().setAttribute("Shopping", shopping);

		RequestDispatcher rd = request.getRequestDispatcher("/jsp/shopping.jsp");

		rd.forward(request, response);

	}

}
