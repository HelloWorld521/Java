package com.hjy.serverThread;

import java.io.File;
import java.io.IOException;
import java.net.Socket;

import com.hjy.request.Request;
import com.hjy.response.Response;

public class ServerThread extends Thread{
	private Socket client;
	public ServerThread() {}
	public ServerThread(Socket client){
		this.client = client;
	}
	@Override
	public void run() {
		Request request = new Request(client);
		Response response = new Response(client);
		response.forward(request.getUrl());
	}

}
