package tcpTest;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer01 {
	// TCP ���� ��ſ���(������)
	public static void main(String[] args) {
		try {
			//TCP���� ����� ���� ServerSocket��ü�� �����Ѵ�.
			ServerSocket server = new ServerSocket(7777);
			System.out.println("���� ������...");
			
			//Ŭ���̾�Ʈ�� ��û�� ��ٸ���, ��û�� ������ Ŭ���̾�Ʈ�� ����� Socket��ü�� �����ؼ� ��ȯ�Ѵ�.
			Socket socket = server.accept();
			
			//�� ���Ŀ� ������ �Ϸ�Ǹ� ������ �ۼ��Ѵ�.
			
			System.out.println(socket.getInetAddress() + "�� ����Ǿ����ϴ�.");
			System.out.println("port : " + socket.getPort());
			
			//Ŭ���̾�Ʈ���� �޽��� ������
			//OutputStream�� �����Ͽ� �����Ѵ�. (Socket���� OutputStream��ü�� ���Ѵ�.)
			OutputStream out = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(out);
			
			//�޽��� ������
			dos.writeUTF("ȯ���մϴ�....");
			System.out.println("�޽����� ���½��ϴ�.");
			
			dos.close();
			
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
