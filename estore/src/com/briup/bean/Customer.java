package com.briup.bean;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Customer {
	private long id;
	private String name;
	private String password;
	private String zip;
	private String address;
	private String telephone;
	private String email;
	private Set<Orderform> orders = new HashSet<Orderform>();
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Set<Orderform> getOrders() {
		return orders;
	}
	public void setOrders(Set<Orderform> orders) {
		this.orders = orders;
	}
	
	
	
}
