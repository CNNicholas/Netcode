package com.ip.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException {
		System.out.println("------������------");
		ServerSocket server = new ServerSocket(8888);
		Socket client = server.accept();
		System.out.println("--------�Ѿ���������--------");
		//���������� �ϴ�
		DataInputStream dis = new DataInputStream(client.getInputStream());
		System.out.println(dis.readUTF());
		//���������� ����
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		dos.writeUTF("���������ص�����");
		
		dis.close();
		client.close();
	}
}
