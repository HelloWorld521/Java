package com.briup.common;
/**
 * 当某模块实现了该接口，那么配置模块在初始化该模块的同时会将自身的引用传递给该模块。
 * @author briup
 * @version 1.0 2010-9-14
 */
public interface ConfigurationAWare {
	/**
	 * 该方法用于传递配置模块
	 * @param configuration 传递的配置模块
	 */
	public void setConfiguration(Configuration configuration);
}