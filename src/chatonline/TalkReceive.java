package chatonline;
/**
 * UDP±à³Ì
 */
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class TalkReceive implements Runnable{
	private String from;
	private DatagramSocket client;
	
	public TalkReceive(int port,String from) {
		this.from = from;
		try {
			client = new DatagramSocket(port);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		while(true) {
			byte[] container =new byte[1024*60];
			DatagramPacket packet = new DatagramPacket(container,0,container.length);
			try {
				client.receive(packet);
				byte[]  datas =packet.getData();
				int len = packet.getLength();
				String data = new String(datas,0,len);
				System.out.println(from+":"+data);
				
				if(data.equals("exit")) {
					break;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 

		}
		client.close();
	}

}
