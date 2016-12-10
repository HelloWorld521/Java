package com.briup.web.listener;

import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.briup.bean.Book;
import com.briup.common.BeanFactory;
import com.briup.common.exception.OrderServiceException;
import com.briup.service.IOrderService;

public class ContextListener 
implements ServletContextListener{
	private IOrderService service = 
		(IOrderService)BeanFactory.getBean(
				BeanFactory.ORDERSERVICE);
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		try {
			Map<Long, Book> map =
				service.listAllBook();
			sce.getServletContext()
				.setAttribute("books", map);
		} catch (OrderServiceException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

}
