package tcpTest;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

//�� Ŭ������ ������ ���ؼ� �޽����� ������ ���Ҹ� ����Ѵ�.
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





