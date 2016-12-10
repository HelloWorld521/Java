package com.briup.service.impl;

import org.apache.ibatis.session.SqlSession;

import com.briup.bean.Customer;
import com.briup.common.BeanFactory;
import com.briup.common.MybatisSessionFactory;
import com.briup.common.exception.CustomerServiceException;
import com.briup.dao.ICustomerDao;
import com.briup.service.ICustomerService;

public class CustomerServiceImpl 
implements ICustomerService{
	private ICustomerDao dao = 
		(ICustomerDao) BeanFactory.getBean(BeanFactory.CUSTOMERDAO);
	@Override
	public void register(Customer customer) throws CustomerServiceException {
		SqlSession session = 
				MybatisSessionFactory.getSession();
		//根据用户名查询用户
		try {
			Customer cus = 
				dao.findCustomerByName(
						customer.getName());
			if(cus!=null){
				throw new CustomerServiceException("用户名已被占用");
			}
			dao.saveCustomer(customer);
			session.commit();
		} catch(CustomerServiceException e){
			e.printStackTrace();
			session.rollback();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
	}

	@Override
	public Customer login(String name, String password) throws CustomerServiceException {
		try {
			Customer cus = 
				dao.findCustomerByName(name);
			if(cus==null){
				throw new CustomerServiceException("当前用户名无效");
			}else{
				if(password.equals(cus.getPassword())){
					return cus;
				}else{
					throw new CustomerServiceException("密码不正确");
				}
			}
			
		}catch (CustomerServiceException e) {
			e.printStackTrace();
			throw e;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void update(Customer customer) throws CustomerServiceException {
		
	}

}
