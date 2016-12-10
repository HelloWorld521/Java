package com.briup.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Book implements Serializable{

	private Long id;
	private String name;
	private Double price;
	private Set<OrderLine> orderLines = new HashSet<OrderLine>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Set<OrderLine> getOrderLines() {
		return orderLines;
	}
	public void setOrderLines(Set<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}
	
}
