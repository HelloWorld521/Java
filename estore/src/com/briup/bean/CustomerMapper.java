package com.briup.bean;

public interface CustomerMapper {
	void insertCustomer(Customer c);
	Customer selectCustomerByName(String name);
}
