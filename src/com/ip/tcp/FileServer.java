package com.ip.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

	

/**
 * 存储文件
 * 创建服务器
 * 1、指定端口 使用ServerSocket创建服务器
 * 2、阻塞式等待连接 accept
 * 3、操作: 输入输出流操作
 * 4、释放资源 
 * @author 朱致宇1999
 *
 */
public class FileServer {
	public static void main(String[] args) throws IOException {
		System.out.println("服务器");
		ServerSocket server = new ServerSocket(8888);
		Socket client = server.accept();
		System.out.println("已经建立连接");
		
		InputStream is= new BufferedInputStream(client.getInputStream());
		OutputStream os= new BufferedOutputStream(new FileOutputStream("src/tcp.txt"));
		
		byte[] flush = new byte[1024];
		
		int len = -1;
		while((len = is.read(flush))!=-1) {
			os.write(flush,0,len);
		}
		os.flush();
		
		is.close();
		os.close();
		
		client.close();
		
		server.close();
	}
}
