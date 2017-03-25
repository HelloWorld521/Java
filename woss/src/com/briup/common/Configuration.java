package com.briup.common;

import com.briup.client.Client;
import com.briup.client.Gather;
import com.briup.server.DBStore;
import com.briup.server.Server;


/**
* Configuration接口提供了配置模块的规范。
* 配置模块通过某种配置方式将Logger、BackUP、Gather、Client、Server、DBStore等模块的实现类进行实例化，
* 并且将其所需要配置信息予以传递。通过配置模块可以获得各个模块的实例。
* 
* @author briup
* @version 1.0 2010-9-14
*/
public interface Configuration {
	/**
	 * 获取<tt>日志</tt>模块的实例
	 */
	public Log getLogger();
	/**
	 * 获取<tt>备份</tt>模块的实例
	 */
	public Backup getBackup();
	/**
	 * 获取<tt>采集</tt>模块的实例
	 */
	public Gather getGather();
	/**
	 * 获取<tt>客户端</tt>的实例
	 */
	public Client getClient();
	/**
	 * 获取<tt>服务器端</tt>的实例
	 */
	public Server getServer();
	/**
	 * 获取<tt>入库</tt>模块的实例
	 */
	public DBStore getDBStore();
	
}
