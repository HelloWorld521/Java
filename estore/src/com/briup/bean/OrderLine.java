package com.briup.bean;

import java.io.Serializable;

public class OrderLine implements Serializable{

	private Long id;
	private Long num;
	//与book的关系   多对一
	private Book book;
	//与orderform的关系 多对一
	private Orderform order;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getNum() {
		return num;
	}
	public void setNum(Long num) {
		this.num = num;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Orderform getOrderform() {
		return order;
	}
	public void setOrderform(Orderform order) {
		this.order = order;
	}
	
}
