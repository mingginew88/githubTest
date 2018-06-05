package tcpTest;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer02 {
	
	//�����͸� �޴� Ŭ������ �����͸� ������ Ŭ������ ���� �����ϰ� ��Ŭ�������� ������� �۵���Ų��.
	public static void main(String[] args) {		
		try {
			//���������� �����, Ŭ���̾�Ʈ�� �����ϸ� ������ ������Ʈ�� �޴� Ŭ������
			//�����͸� ������ Ŭ������ �� ������ �Ѱ��ְ� �����带 �۵���Ų��.
			ServerSocket server = new ServerSocket(7777);
			System.out.println("������ �غ�Ǿ����ϴ�...");
			
			Socket socket = server.accept();
			
			Sender sender = new Sender(socket);
			Receiver receiver = new Receiver(socket);
			
			sender.start();
			receiver.start();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
