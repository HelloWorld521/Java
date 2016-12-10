package com.briup.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.bean.ShoppingCart;

public class ModifiCartServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookid = request.getParameter("productid");
		String number = request.getParameter("number");
		HttpSession session = request.getSession();
		ShoppingCart cart = 
			(ShoppingCart) session.getAttribute("cart");
		cart.modifyLine(Long.parseLong(bookid),
						Long.parseLong(number));
		response.sendRedirect("shopcart.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
