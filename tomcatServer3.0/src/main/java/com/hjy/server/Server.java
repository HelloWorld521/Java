package com.hjy.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ResourceBundle;

import com.hjy.serverThread.ServerThread;

public class Server {
	@SuppressWarnings("unused")
	private ServerSocket server;
	private static int port;

	static{
		ResourceBundle serverConfig = ResourceBundle.getBundle("config/server");
		port = Integer.parseInt(serverConfig.getString("port"));
	}

	//初始化，创建服务器
	public void init() throws IOException {
		server = new ServerSocket(port);
		System.out.println("The server is running at "+ server.getLocalSocketAddress());
	}
	public void receive(){
		try {
			System.out.println("waiting client come to connect server!");
			Socket client = server.accept();
			System.out.println("client coming ...");
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

	public static void main(String[] args) throws IOException {
		//拿到server对象
		Server server = new Server();
		//创建服务器
		server.init();
		while(true){
			server.receive();
		}
	}

}
