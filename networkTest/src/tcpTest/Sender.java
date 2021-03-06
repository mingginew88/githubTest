package tcpTest;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

//이 클래스는 소켓을 통해서 메시지를 보내는 역할만 담당한다.
public class Sender extends Thread{
	private Socket socket;
	private DataOutputStream dos;
	private String name;
	
	public Sender(Socket socket) {
		super();
		this.socket = socket;
		name = "[" + socket.getInetAddress() + " : " + socket.getPort() + "]";
		
		try {
			dos = new DataOutputStream(socket.getOutputStream());
		} catch (Exception e) {	}
	}


	@Override
	public void run() {
		Scanner scan = new Scanner(System.in);
		while(dos!=null) {
			try {
				dos.writeUTF(name + " > " + scan.nextLine());
			} catch (IOException e) {
				dos = null;
			}
		}
	}
}





