package com.briup.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.bean.Customer;
import com.briup.bean.ShoppingCart;
import com.briup.common.BeanFactory;
import com.briup.common.exception.CustomerServiceException;
import com.briup.service.ICustomerService;

public class LoginServlet extends HttpServlet {
	private ICustomerService service = 
			(ICustomerService) BeanFactory.getBean(BeanFactory.CUSTOMERSERVICE);
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String name = request.getParameter("userid");
		String password= request.getParameter("password");
		try {
			Customer cus = 
				service.login(name, password);
			HttpSession session = request.getSession();
			session.setAttribute("customer", cus);
			response.sendRedirect("index.jsp");
		} catch (CustomerServiceException e) {
			e.printStackTrace();
			request.setAttribute("message", e.getMessage());
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
