package com.ip.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("------�ͻ���------");
		Socket client = new Socket("localhost",8888);
		//�ͻ��˷��� �ϴ�
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		String data = "�ͻ��˷��͵�����";
		dos.writeUTF(data);
		//�ͻ��˽��� ����
		DataInputStream dis = new DataInputStream(client.getInputStream());
		System.out.println(dis.readUTF());
		
		dos.flush();
		dos.close();
		client.close();
		
	}
}
