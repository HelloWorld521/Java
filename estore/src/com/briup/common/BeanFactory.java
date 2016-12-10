package com.briup.common;

import com.briup.dao.ICustomerDao;
import com.briup.dao.IOrderDao;
import com.briup.dao.impl.CustomerDaoImpl;
import com.briup.dao.impl.OrderDaoImpl;
import com.briup.service.ICustomerService;
import com.briup.service.IOrderService;
import com.briup.service.impl.CustomerServiceImpl;
import com.briup.service.impl.OrderServiceImpl;

public class BeanFactory {
	private static ICustomerDao customerDao;
	private static ICustomerService customerService;
	private static IOrderDao orderDao;
	private static IOrderService orderService;
	public static final String CUSTOMERDAO = "customerDao";
	public static final String CUSTOMERSERVICE = "customerService";
	public static final String ORDERDAO = "orderDao";
	public static final String ORDERSERVICE = "orderService";
	
	public static Object getBean(String beanName){
		if(beanName.equals(CUSTOMERDAO)){
			return getCustomerDao();
		}else if(beanName.equals(CUSTOMERSERVICE)){
			return getCustomerService();
		}else if(beanName.equals(ORDERDAO)){
			return getOrderDao();
		}else if(beanName.equals(ORDERSERVICE)){
			return getOrderService();
		}else{
			return null;
		}
	}
	
	private synchronized static ICustomerDao getCustomerDao(){
		if(customerDao == null){
			customerDao = new CustomerDaoImpl();
		}
		return customerDao;
	}
	
	private synchronized static ICustomerService getCustomerService(){
		if(customerService == null){
			customerService = new CustomerServiceImpl();
		}
		return customerService;
	}
	
	private synchronized static IOrderDao getOrderDao(){
		if(orderDao == null){
			orderDao = new OrderDaoImpl();
		}
		return orderDao;
	}
	
	private synchronized static IOrderService getOrderService(){
		if(orderService == null){
			orderService = new OrderServiceImpl();
		}
		return orderService;
	}
}
