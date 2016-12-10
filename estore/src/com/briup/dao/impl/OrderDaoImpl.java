package com.briup.dao.impl;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.ibatis.session.SqlSession;

import com.briup.bean.Book;
import com.briup.bean.BookMapper;
import com.briup.bean.OrderLine;
import com.briup.bean.OrderLineMapper;
import com.briup.bean.Orderform;
import com.briup.bean.OrderformMapper;
import com.briup.common.MybatisSessionFactory;
import com.briup.dao.IOrderDao;

public class OrderDaoImpl implements IOrderDao{

	@Override
	public void saveOrder(Orderform order) throws Exception {
		SqlSession session = MybatisSessionFactory.getSession();
		OrderformMapper om = 
		session.getMapper(OrderformMapper.class);
		om.insertOrderform(order);
	}
	@Override
	public void deleteOrder(Long orderid) throws Exception {
		
	}

	@Override
	public Map<Long, Orderform> findAllOrder(Long customerid) throws Exception {
		return null;
	}

	@Override
	public Orderform findOrderById(Long orderid) throws Exception {
		return null;
	}
	@Override
	public Map<Long, Book> findAllBook() throws Exception {
		SqlSession session = MybatisSessionFactory.getSession();
		BookMapper bm = 
				session.getMapper(BookMapper.class);
		List<Book> books = bm.selectBooks();
		Map<Long, Book> map = new TreeMap<>();
		for(Book b:books){
			map.put(b.getId(), b);
		}
		return map;
	}

	@Override
	public void saveOrderLine(OrderLine line) {
		SqlSession session = MybatisSessionFactory.getSession();
		OrderLineMapper om = 
			session.getMapper(OrderLineMapper.class);
		om.insertOrderline(line);
	}
	

}
