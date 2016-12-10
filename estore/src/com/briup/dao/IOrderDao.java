package com.briup.dao;

import java.util.Map;

import com.briup.bean.Book;
import com.briup.bean.OrderLine;
import com.briup.bean.Orderform;

public interface IOrderDao {
	//保存订单
	void saveOrder(Orderform order) throws Exception;
	//删除订单
	void deleteOrder(Long orderid) throws Exception;
	//查找用户所有订单
	Map<Long,Orderform> findAllOrder(Long customerid) throws Exception;
	//查找单个订单
	Orderform findOrderById(Long orderid) throws Exception;
	//查找所有书籍
	Map<Long,Book> findAllBook() throws Exception;
	
	void saveOrderLine(OrderLine line);
}
