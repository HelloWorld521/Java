package com.briup.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.briup.bean.Book;
import com.briup.bean.OrderLine;
import com.briup.bean.Orderform;
import com.briup.common.BeanFactory;
import com.briup.common.MybatisSessionFactory;
import com.briup.common.exception.OrderServiceException;
import com.briup.dao.IOrderDao;
import com.briup.service.IOrderService;

public class OrderServiceImpl implements IOrderService{
	private IOrderDao dao = 
		(IOrderDao) BeanFactory.getBean(BeanFactory.ORDERDAO);
	@Override
	public void saveOrder(Orderform order) throws OrderServiceException {
		SqlSession session = 
				MybatisSessionFactory.getSession();
		try {
			dao.saveOrder(order);
			List<OrderLine> lines = 
					order.getOrderLines();
			for(OrderLine line:lines){
				saveOrderLine(line);
			}
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
	}
	@Override
	public void saveOrderLine(OrderLine line) {
		dao.saveOrderLine(line);
	}

	@Override
	public void delOrder(Long orderid) throws OrderServiceException {
		
	}

	@Override
	public Map<Long, Orderform> listAllOrder(Long customerid) throws OrderServiceException {
		return null;
	}

	@Override
	public Orderform findOrderById(Long orderid) throws OrderServiceException {
		return null;
	}

	@Override
	public Map<Long, Book> listAllBook() throws OrderServiceException {
		try {
			Map<Long,Book> map = dao.findAllBook();
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
}
