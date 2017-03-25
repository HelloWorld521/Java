package com.briup.client.imp;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.briup.client.Client;
import com.briup.common.Backup;
import com.briup.common.Configuration;
import com.briup.common.ConfigurationAWare;
import com.briup.common.Log;
import com.briup.common.imp.BackupImp;
import com.briup.common.imp.ConfigurationImp;
import com.briup.common.imp.LogImp;
import com.briup.model.BIDR;

public class ClientImp implements Client,ConfigurationAWare{
	private String port;
	private String ip;
	private Socket client ;  
	private Backup back;
	private Log log;
	private Logger logger;
	private String bakFileName;
	
	@Override
	public void init(Properties properties) {
		port = properties.getProperty("port");
		ip = properties.getProperty("ip");
		bakFileName = properties.getProperty("bakFileName");
	}

	@Override
	public void send(Collection<BIDR> collection) throws Exception {
		try {
			client = new Socket(ip,Integer.parseInt(port));
			ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
			logger.info("开始向服务器发送数据...");
			Collection coll = (Collection) back.load(bakFileName);
			if(coll!=null){
				logger.info("加载未完成的数据备份");
				collection.addAll(coll);
				back.deleteBackup(bakFileName);
			}
			oos.writeObject(collection);
			oos.flush();
			logger.info("采集数据发送完成");
		} catch (Exception e) {
			e.printStackTrace();
			back.backup(bakFileName, collection);
			logger.error("出现异常,成功备份数据");
		}
	}

	@Override
	public void setConfiguration(Configuration cfig) {
		back = cfig.getBackup();
		log = cfig.getLogger();
		logger = log.getClientLogger();
	}
}
