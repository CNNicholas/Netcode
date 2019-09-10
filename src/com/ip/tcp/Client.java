package com.ip.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("------客户端------");
		Socket client = new Socket("localhost",8888);
		//客户端发送 上传
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		String data = "客户端发送的请求";
		dos.writeUTF(data);
		//客户端接收 下载
		DataInputStream dis = new DataInputStream(client.getInputStream());
		System.out.println(dis.readUTF());
		
		dos.flush();
		dos.close();
		client.close();
		
	}
}
