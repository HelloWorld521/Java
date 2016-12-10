package com.briup.web.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.briup.bean.ShoppingCart;

public class SessionListener implements HttpSessionListener {
    public void sessionCreated(HttpSessionEvent se)  { 
    	HttpSession session = se.getSession();
    	ShoppingCart sc = new ShoppingCart();
    	session.setAttribute("cart", sc);
    	System.out.println("session listener");
    }
    public void sessionDestroyed(HttpSessionEvent se)  { 
    }
}
