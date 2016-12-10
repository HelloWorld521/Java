package com.briup.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.bean.Customer;
import com.briup.bean.OrderLine;
import com.briup.bean.Orderform;
import com.briup.bean.ShoppingCart;
import com.briup.common.BeanFactory;
import com.briup.common.exception.OrderServiceException;
import com.briup.service.IOrderService;
public class SaveOrderServlet extends HttpServlet {
	private IOrderService service =
		(IOrderService)BeanFactory.getBean(BeanFactory.ORDERSERVICE);
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Customer cust = 
			(Customer)session.getAttribute("customer");
		ShoppingCart cart = 
			(ShoppingCart) session.getAttribute("cart");
		Orderform orderform = new Orderform();
		orderform.setCost(cart.getCost());
		orderform.setCust(cust);
		orderform.setOrderDate(new Date());
		Collection<OrderLine> lines = 
				cart.getMap().values();
		List<OrderLine> list = 
				new ArrayList<>(lines);
				orderform.setOrderLines(list);
		for(OrderLine l:list){
			l.setOrderform(orderform);
		}
		try {
			service.saveOrder(orderform);
			
			response.sendRedirect("user/order.jsp");
		} catch (OrderServiceException e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
