package com.briup.service;

import java.util.Map;

import com.briup.bean.Book;
import com.briup.bean.OrderLine;
import com.briup.bean.Orderform;
import com.briup.common.exception.OrderServiceException;

public interface IOrderService {
	//保存订单
	void saveOrder(Orderform order) throws OrderServiceException;
	//删除订单
	void delOrder(Long orderid) throws OrderServiceException;
	//查找用户所有订单
	Map<Long,Orderform> listAllOrder(Long customerid) throws OrderServiceException;
	//查找单个订单
	Orderform findOrderById(Long orderid) throws OrderServiceException;
	//查找所有书籍
	Map<Long,Book> listAllBook() throws OrderServiceException;
	void saveOrderLine(OrderLine line);
}
