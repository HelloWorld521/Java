package com.briup.common.imp;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.briup.common.Configuration;
import com.briup.common.ConfigurationAWare;
import com.briup.common.Log;

public class LogImp implements Log,ConfigurationAWare{
	private Logger logger;
	private String logPropertiesLocation;
	private String clientLoggerName;
	private String serverLoggerName;
	@Override
	public void init(Properties properties) {
		//读取配置
		System.out.println(properties);
		logPropertiesLocation = properties.getProperty("logPropertiesLocation");
		serverLoggerName = properties.getProperty("serverLoggerName");
		clientLoggerName = properties.getProperty("clientLoggerName");
		logger = logger.getRootLogger();
		try {
			properties.load(new FileReader(logPropertiesLocation));
			PropertyConfigurator.configure(properties);
			System.out.println(properties);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Logger getClientLogger() {
		Logger clientLogger = logger.getLogger(clientLoggerName);
		return clientLogger;
	}

	@Override
	public Logger getServerLogger() {
		Logger serverLogger = logger.getLogger(serverLoggerName);
		return serverLogger;
	}

	@Override
	public void setConfiguration(Configuration configuration) {
		// TODO Auto-generated method stub
		
	}

		

}
