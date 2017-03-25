
package com.briup.common.imp;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.briup.client.Client;
import com.briup.client.Gather;
import com.briup.common.Backup;
import com.briup.common.Configuration;
import com.briup.common.ConfigurationAWare;
import com.briup.common.Log;
import com.briup.common.WossModule;
import com.briup.server.DBStore;
import com.briup.server.Server;

public class ConfigurationImp implements Configuration{
	private static Map<String,WossModule> map = new HashMap<String,WossModule>();
	static{
		//解析config.xml
		//1.创建SAXReader对象
		try{
			SAXReader reader = new SAXReader();//构建解析器
			//2.读取配置文件xml
			Document document = reader.read(new File("src/config.xml"));
			//3.获取根节点
			Element root = document.getRootElement();
			//4.获取子节点
			List<Element> elements = root.elements();
			for(Element element : elements){
				String value = element.attribute("class").getValue();//全类名
				//通过反射取得对象
				WossModule module = (WossModule) Class.forName(value).newInstance();
				//对象保存到map集合   控制所有对象
				map.put(element.getName(), module);//key为xml文件中元素的名字，value为对应的实例
				//properties	保存可变数据 
				Properties properties = new Properties();
				List<Element> elements2 = element.elements();
				for(Element element2 : elements2){
					String tagName = element2.getName(); //获取子元素名字
					String tagValue = element2.getTextTrim(); //获取子元素的文本
					properties.setProperty(tagName, tagValue);
				}
				//所有对象初始化    
				module.init(properties);//将所有类初始化
			}
			//将所有的实例转化为ConfifurationAware类型，方便模块使用
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public ConfigurationImp() {
		for(WossModule module : map.values()){
			if(module instanceof ConfigurationAWare){
				ConfigurationAWare aware = (ConfigurationAWare) module;
				aware.setConfiguration(this);
			}
		}
	}

	@Override
	public Log getLogger() {
		return (Log) map.get("logger");
	}

	@Override
	public Backup getBackup() {
		return (Backup) map.get("backup");
	}

	@Override
	public Gather getGather() {
		return (Gather) map.get("gather");
	}

	@Override
	public Client getClient() {
		return (Client) map.get("client");
	}

	@Override
	public Server getServer() {
		return (Server) map.get("server");
	}

	@Override
	public DBStore getDBStore() {
		return (DBStore) map.get("dbStore");
	}

}
