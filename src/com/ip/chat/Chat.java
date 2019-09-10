package com.ip.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * ����������: ������
 * Ŀ��: ˽��

 * @author ������1999
 *
 */
public class Chat {
	private static CopyOnWriteArrayList<Channel> all =new CopyOnWriteArrayList<Channel>();
	public static void main(String[] args) throws IOException {
		System.out.println("-----Server-----");
		// 1��ָ���˿� ʹ��ServerSocket����������
		ServerSocket server =new ServerSocket(8888);
		// 2������ʽ�ȴ����� accept
		while(true) {
				Socket  client =server.accept(); 
				System.out.println("һ���ͻ��˽���������");
				Channel c =new Channel(client);
				all.add(c); //�������еĳ�Ա
				new Thread(c).start();			
			}		
		}
		//һ���ͻ�����һ��Channel
		static class Channel implements Runnable{
			private DataInputStream dis;
			private DataOutputStream dos;
			private Socket  client;			
			private boolean isRunning;
			private String name;
			public Channel(Socket  client) {
				this.client = client;
				try {
					dis = new DataInputStream(client.getInputStream());
					dos =new DataOutputStream(client.getOutputStream());
					isRunning =true;
					//��ȡ����
					this.name =receive();
					//��ӭ��ĵ���
					this.send("��ӭ��ĵ���");
					sendOthers(this.name+"��������������",true);
				} catch (IOException e) {
					System.out.println("---1------");
					release();					
				}			
			}
			//������Ϣ
			private String receive() {
				String msg ="";
				try {
					msg =dis.readUTF();
				} catch (IOException e) {
					System.out.println("---2------");
					release();
				}
				return msg;
			}
			//������Ϣ
			private void send(String msg) {
				try {
					dos.writeUTF(msg);
					dos.flush();
				} catch (IOException e) {
					System.out.println("---3------");
					release();
				}
			}
			/**
			 * Ⱥ�ģ���ȡ�Լ�����Ϣ������������
			 * ˽��: Լ�����ݸ�ʽ: @xxx:msg
			 * @param msg
			 */
			private void sendOthers(String msg,boolean isSys) {
				boolean isPrivate = msg.startsWith("@");
				if(isPrivate) { //˽��
					int idx =msg.indexOf(":");
					//��ȡĿ�������
					String targetName = msg.substring(1,idx);
					msg = msg.substring(idx+1);
					for(Channel other: all) {
						if(other.name.equals(targetName)) {//Ŀ��
							other.send(this.name +"���ĵض���˵:"+msg);
							break;
						}
					}
				}else {				
					for(Channel other: all) {
						if(other==this) { //�Լ�
							continue;
						}
						if(!isSys) {
							other.send(this.name +"��������˵:"+msg);//Ⱥ����Ϣ
						}else {
							other.send(msg); //ϵͳ��Ϣ
						}
					}
				}
			}
			//�ͷ���Դ
			private void release() {
				this.isRunning = false;
				Utils.close(dis,dos,client);
				//�˳�
				all.remove(this);
				sendOthers(this.name+"�뿪���ͥ...",true);
			}
			@Override
			public void run() {
				while(isRunning) {
					String msg = receive() ;
					if(!msg.equals("")) {
						//send(msg);
						sendOthers(msg,false);
					}
				}
			}
		}
}