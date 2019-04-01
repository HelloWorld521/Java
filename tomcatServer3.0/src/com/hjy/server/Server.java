package com.hjy.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

import com.hjy.serverThread.ServerThread;

public class Server {
	@SuppressWarnings("unused")
	private ServerSocket server;
	private int port;
	private static Properties prop;
	static{
		prop = new Properties();
		try {
			prop.load(new FileInputStream(new File("src/source/property.properties")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//初始化，创建服务器
	public void init(){
		try {
			port = Integer.parseInt(prop.getProperty("port"));
			server = new ServerSocket(port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void receive(){
		try {
			Socket client = server.accept();
			ServerThread thread = new ServerThread(client);
			thread.start();
			thread.join();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Server() {
	}

	public static void main(String[] args) {
		//拿到server对象
		Server server2 = new Server();
		//创建服务器
		server2.init();
		while(true){
			server2.receive();
		}
	}

}
