package com.briup.server.imp;

import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Collection;

import org.apache.log4j.Logger;

import com.briup.common.Backup;
import com.briup.common.Configuration;
import com.briup.common.ConfigurationAWare;
import com.briup.common.Log;
import com.briup.common.imp.BackupImp;
import com.briup.common.imp.ConfigurationImp;
import com.briup.common.imp.LogImp;
import com.briup.model.BIDR;
import com.briup.server.DBStore;

public class ServerThread extends Thread{
	private Socket client;
	private Backup back;
	private Logger logger;
	private DBStore dbStore;
	public ServerThread(){}
	public ServerThread(Socket client,Logger logger,DBStore dbStore){
		this.client = client;
		this.logger = logger;
		this.dbStore = dbStore;
	}
	@Override
	public void run() {
		try {
			ObjectInputStream ois = new ObjectInputStream(client.getInputStream());
			logger.info("开始接受数据...");
			Collection<BIDR> bidrs = (Collection<BIDR>) ois.readObject();
			logger.info("接受完成，数据大小为："+bidrs.size());
			dbStore.saveToDB(bidrs);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
