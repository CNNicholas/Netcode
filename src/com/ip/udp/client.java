package com.ip.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class client {
	public static void main(String[] args) throws Exception {
		System.out.println("接收方启动--------->");
		DatagramSocket client = new DatagramSocket(9999);
		
		byte[] rongqi = new byte[1024*60];
		
		DatagramPacket packet = new DatagramPacket(rongqi,0,rongqi.length);
		
		client.receive(packet);
		
		byte[] datas = packet.getData();
		int len = packet.getLength();
		int post = packet.getPort();
		
		System.out.println(new String(datas,0,len)+"来自："+post);
		
		
		
	}
}
