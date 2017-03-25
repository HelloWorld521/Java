package com.briup.main;

import java.util.Properties;

import com.briup.common.imp.ConfigurationImp;
import com.briup.server.Server;

/**
 * @author Chen
 * 服务器启动
 * */
public class ServerMain {
	public static void main(String[] args) throws Exception {
		ConfigurationImp cfig = new ConfigurationImp();
		Server server = cfig.getServer();
		server.revicer();
	}	
}
