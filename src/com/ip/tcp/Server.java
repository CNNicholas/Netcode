package com.ip.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException {
		System.out.println("------服务器------");
		ServerSocket server = new ServerSocket(8888);
		Socket client = server.accept();
		System.out.println("--------已经建立连接--------");
		//服务器接受 上传
		DataInputStream dis = new DataInputStream(client.getInputStream());
		System.out.println(dis.readUTF());
		//服务器发送 下载
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		dos.writeUTF("服务器返回的数据");
		
		dis.close();
		client.close();
	}
}
