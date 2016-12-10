package com.briup.dao;

import com.briup.bean.Customer;

public interface ICustomerDao {
	//保存用户
	void saveCustomer(Customer customer) throws Exception;
	//更新用户
	void updateCustomer(Customer customer);
	//查找用户
	Customer findCustomerByName(String name) throws Exception;
}
