package com.briup.server.imp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.briup.server.imp.ServerThread;
import com.briup.common.Backup;
import com.briup.common.Configuration;
import com.briup.common.ConfigurationAWare;
import com.briup.common.Log;
import com.briup.common.imp.ConfigurationImp;
import com.briup.common.imp.LogImp;
import com.briup.server.DBStore;
import com.briup.server.Server;

public class ServerImp implements Server,ConfigurationAWare{
	private Log log ;
	private Logger logger;
	private ServerSocket ss;
	private String port;
	private DBStore dbStore;
	@Override
	public void setConfiguration(Configuration configuration) {
		log = configuration.getLogger();
		logger = log.getServerLogger();
		dbStore = configuration.getDBStore();
	}
	
	@Override
	public void init(Properties properties) {
			port = properties.getProperty("port");
	}

	@Override
	public void revicer() throws Exception {
		ss = new ServerSocket(Integer.parseInt(port));
		logger.info("服务器已启动，等待连接...");
		while(true){
			Socket client = ss.accept();
			logger.info("连接成功，正在接受数据...");
			ServerThread thread = new ServerThread(client,logger,dbStore);
			thread.start();
			thread.join();
		}
	}

	@Override
	public void shutdown() {
		if(ss!=null){
			try {
				ss.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	
}
