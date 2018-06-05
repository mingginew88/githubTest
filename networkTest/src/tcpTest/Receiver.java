package tcpTest;

import java.io.DataInputStream;
import java.net.Socket;

//소켓에서 메시지를 받아서 화면에 출력하는 역할만 담당한다.
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
