package com.briup.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.briup.bean.Customer;
import com.briup.common.BeanFactory;
import com.briup.common.MybatisSessionFactory;
import com.briup.common.exception.CustomerServiceException;
import com.briup.service.ICustomerService;

public class RegisterServlet extends HttpServlet {
	private ICustomerService service = 
		(ICustomerService) BeanFactory.getBean(BeanFactory.CUSTOMERSERVICE);
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("userid");
		String password = request.getParameter("password");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String street1 = request.getParameter("street1");
		String zip = request.getParameter("zip");
		String telephone = request.getParameter("cellphone");
		String email = request.getParameter("email");
		Customer cus = new Customer();
		cus.setName(name);
		cus.setAddress(province+";"+city+";"+street1);
		cus.setEmail(email);
		cus.setPassword(password);
		cus.setTelephone(telephone);
		cus.setZip(zip);
		try {
			service.register(cus);
			response.sendRedirect("login.jsp");
		} catch (CustomerServiceException e) {
			e.printStackTrace();
			request.setAttribute("message", e.getMessage());
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
