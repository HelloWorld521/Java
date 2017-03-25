package com.briup.common.imp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Properties;

import com.briup.common.Backup;
import com.briup.common.Configuration;
import com.briup.common.ConfigurationAWare;

public class BackupImp implements Backup,ConfigurationAWare{
	private String path;
	@Override
	public void init(Properties properties) {
		path = properties.getProperty("path");
	}

	@Override
	public void backup(String fileName, Object data) throws Exception {
		File file = new File(path,fileName);
		if(file.exists()){
			file.delete();
		}
		file.createNewFile();
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
		out.writeObject(data);
		out.flush();
		out.close();
	}

	@Override
	public Object load(String fileName) throws Exception {
		File file = new File(path,fileName);
		if(!file.exists()){
			return null;
		}
		ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));
		Object data = input.readObject();
		input.close();
		return data;
	}

	@Override
	public void deleteBackup(String fileName) {
		File file = new File(path,fileName);
		if(file.exists()){
			file.delete();
		}
	}

	@Override
	public void setConfiguration(Configuration configuration) {
		// TODO Auto-generated method stub
		
	}
}
