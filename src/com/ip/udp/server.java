package com.ip.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
//F��������
public class server {
	public static void main(String[] args) throws Exception {
		System.out.println("���ͷ�����----->");
		DatagramSocket server = new DatagramSocket(8888);	
		String data = "123456789";
		byte[] datas = data.getBytes();
		
		DatagramPacket packet = new DatagramPacket(datas, 0,datas.length,
				new InetSocketAddress("localhost",9999));
		server.send(packet);
		
		server.close();
	}
}
