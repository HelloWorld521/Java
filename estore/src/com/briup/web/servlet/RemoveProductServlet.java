package com.briup.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.bean.ShoppingCart;

public class RemoveProductServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long bookid = 
		Long.parseLong(request.getParameter("productid"));
		ShoppingCart sc = 
			(ShoppingCart) request.getSession()
						.getAttribute("cart");
		
		sc.dropLine(bookid);
		response.sendRedirect("shopcart.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
