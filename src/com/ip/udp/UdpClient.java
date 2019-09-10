package com.ip.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * 基本流程: 发送端
 * 1、使用DatagramSocket  指定端口 创建发送端
 * 2、准备数据 一定转成字节数组
 * 3、 封装成DatagramPacket 包裹，需要指定目的地
 * 4、发送包裹send​(DatagramPacket p) * 
 * 5、释放资源
 * 
 *
 */
public class UdpClient {

	public static void main(String[] args) throws Exception {
		System.out.println("发送方启动中.....");
		 // 1、使用DatagramSocket  指定端口 创建发送端
		DatagramSocket client =new DatagramSocket(8888);
		 //2、准备数据 一定转成字节数组
		String data = "java hello world！！";
		byte[] datas = data.getBytes();
		 //3、 封装成DatagramPacket 包裹，需要指定目的地
		DatagramPacket packet =new DatagramPacket(datas,0,datas.length,
				new InetSocketAddress("localhost",6666));
		//4、发送包裹send​(DatagramPacket p) 
		client.send(packet);
		
		byte [] rongqi = new byte[1024*60];
		DatagramPacket packetin = new DatagramPacket(rongqi,0,rongqi.length);
		client.receive(packetin); //阻塞式
		
		 byte[]  datasin =packetin.getData();
		 int len = packetin.getLength();
		 System.out.println(new String(datasin,0,len));
		// 5、释放资源
		client.close();
	}

}
