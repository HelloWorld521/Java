package com.briup.common;

import java.util.Properties;

import org.apache.log4j.Logger;


public interface Log extends WossModule{
	
	
	@Override	
	public void init(Properties properties);
	/**
	 * 获取客户端的日志记录器
	 * @return 记录器
	 */
	public  Logger getClientLogger();
	
	/**
	 * 获取服务器端的日志记录器
	 * @return 记录器
	 */
	public  Logger getServerLogger();
}
