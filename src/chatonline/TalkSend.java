package chatonline;
/**
 * UDP���
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;


public class TalkSend implements Runnable{
	private String toID;
	private int toPort;
	private BufferedReader reader;
	private DatagramSocket client; //�����˿�
	
	public TalkSend(int port,String toID,int toPort){
		this.toID = toID;
		this.toPort = toPort;
		try {
			reader = new BufferedReader(new InputStreamReader(System.in));
			client = new DatagramSocket(port);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("���Ͷ˳�ʼ��ʧ�ܣ�");
		}

	}

	@Override
	public void run() {
		while(true) {
			String data = null;
			try {
				data = reader.readLine();
				byte[] datas = data.getBytes();
				DatagramPacket packet =new DatagramPacket(datas,0,datas.length,
						new InetSocketAddress(this.toID,this.toPort));
				client.send(packet);
				if(data.equals("exit")) {
					break;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("����ʧ�ܣ�");
			}


		}
		client.close();
	}

}
