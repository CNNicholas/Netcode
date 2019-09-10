package com.ip.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * �ϴ��ļ�
 * �����ͻ���
 * 1����������: ʹ��Socket�����ͻ��� +����ĵ�ַ�Ͷ˿�
 * 2������: �������������
 * 3���ͷ���Դ 
 * @author ������1999
 *
 */
public class FileClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("�ͻ���");
		Socket client = new Socket("localhost",8888);
		
		InputStream is = new BufferedInputStream(new FileInputStream("src/text02.txt"));
		OutputStream os = new BufferedOutputStream(client.getOutputStream());
		
		byte[] flush = new byte[1024];
		int len = -1;
		
		while((len = is.read(flush))!=-1) {
			os.write(flush,0,len);
		}
		os.flush();
		
		is.close();
		os.close();
		
		client.close();
		
	}
}
