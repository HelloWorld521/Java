package com.briup.web.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.bean.Book;
import com.briup.bean.OrderLine;
import com.briup.bean.ShoppingCart;

public class AddOrderLineServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookid = request.getParameter("bookid");
		ServletContext context = getServletContext();
		Map<Long, Book> books =
			(Map<Long, Book>) context.getAttribute("books");
		Book book = books.get(Long.parseLong(bookid));
		OrderLine line = new OrderLine();
		line.setBook(book);
		line.setNum(1L);
		HttpSession session = request.getSession();
		ShoppingCart sc = 
			(ShoppingCart)session.getAttribute("cart");
		sc.addOrderline(line);
		response.sendRedirect("shopcart.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
