package com.ip.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
//F发送数据
public class server {
	public static void main(String[] args) throws Exception {
		System.out.println("发送方启动----->");
		DatagramSocket server = new DatagramSocket(8888);	
		String data = "123456789";
		byte[] datas = data.getBytes();
		
		DatagramPacket packet = new DatagramPacket(datas, 0,datas.length,
				new InetSocketAddress("localhost",9999));
		server.send(packet);
		
		server.close();
	}
}
