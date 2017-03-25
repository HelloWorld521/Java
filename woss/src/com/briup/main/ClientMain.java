package com.briup.main;

import java.util.Properties;

import com.briup.client.Client;
import com.briup.client.Gather;
import com.briup.client.imp.ClientImp;
import com.briup.client.imp.GatherImp;
import com.briup.common.Backup;
import com.briup.common.Configuration;
import com.briup.common.Log;
import com.briup.common.imp.ConfigurationImp;

/**
 * @author Chen
 * 客户端启动
 * */
public class ClientMain {
	public static void main(String[] args) throws Exception {
		Configuration cfig = new ConfigurationImp();
		Client client = cfig.getClient();
		Gather gather = cfig.getGather();
		client.send(gather.gather());
	}
}
