package tcpTest;

import java.io.DataInputStream;
import java.net.Socket;

//���Ͽ��� �޽����� �޾Ƽ� ȭ�鿡 ����ϴ� ���Ҹ� ����Ѵ�.
public class Receiver extends Thread {
	private Socket socket;
	private DataInputStream dis;
	
	public Receiver(Socket socket) {
		super();
		this.socket = socket;
		try {
			dis = new DataInputStream(socket.getInputStream());
		} catch (Exception e) {	}
	}
	
	@Override
	public void run() {
		while(dis!=null) {
			try {
				System.out.println(dis.readUTF());
			} catch (Exception e) {
				dis =null;
			}
		}		
	}
	
	

}
