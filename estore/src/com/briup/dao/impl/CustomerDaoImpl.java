package com.briup.dao.impl;

import org.apache.ibatis.session.SqlSession;

import com.briup.bean.Customer;
import com.briup.bean.CustomerMapper;
import com.briup.common.MybatisSessionFactory;
import com.briup.dao.ICustomerDao;

public class CustomerDaoImpl 
implements ICustomerDao{

	@Override
	public void saveCustomer(Customer customer) throws Exception {
		SqlSession session = MybatisSessionFactory.getSession();
		CustomerMapper cm = 
			session.getMapper(CustomerMapper.class);
		cm.insertCustomer(customer);
	}

	@Override
	public void updateCustomer(Customer customer) {
	}

	@Override
	public Customer findCustomerByName(String name) throws Exception {
		SqlSession session = MybatisSessionFactory.getSession();
		CustomerMapper cm = 
			session.getMapper(CustomerMapper.class);
		return cm.selectCustomerByName(name);
	}
}
