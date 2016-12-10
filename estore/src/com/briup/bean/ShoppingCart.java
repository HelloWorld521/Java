package com.briup.bean;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

public class ShoppingCart {
	private Map<Long, OrderLine> map = 
		new TreeMap<Long,OrderLine>();
	
	public Map<Long, OrderLine> getMap() {
		return map;
	}
	public void addOrderline(OrderLine line){
		OrderLine l = 				
				map.get(line.getBook().getId());
		if(l!=null){
			long num = l.getNum()+line.getNum();
			l.setNum(num);
		}else{
			map.put(line.getBook().getId(), line);
		}
	}
	public void modifyLine(Long bookid,Long num){
		OrderLine l = map.get(bookid);
		l.setNum(num);
	}
	public void dropLine(Long bookid){
		map.remove(bookid);
	}
	public double getCost(){
		Collection<OrderLine> lines = 
					map.values();
		double cost = 0;
		for(OrderLine line:lines){
			long num = line.getNum();
			double price = line.getBook().getPrice();
			cost = cost+num*price;
		}
		return cost;
	}
	public OrderLine getLine(Long bookid){
		return map.get(bookid);
	}
	public void dropAll(){
		map.clear();
	}
}
