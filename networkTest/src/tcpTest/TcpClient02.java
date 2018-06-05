package tcpTest;

import java.net.Socket;

public class TcpClient02 {
	public static void main(String[] args) {
		try {
			//������ ������ ���ϰ�ü�� �����ϰ� ������ ����Ǹ�
			//�����͸� ������ Ŭ������ �����͸� �޴� Ŭ������ ������ �Ѱ��ְ� �����带 �����Ѵ�.
			
			//�ڱ��ڽ� ��ǻƮ�� ��Ÿ���� ���
			//1. IP�ּ�
			//2. localhost
			//3. 127.0.0.1
			
			Socket socket = new Socket("192.168.207.137", 7777);  //localhost ��ſ� �ٸ� �ּ� �����ָ� �ٸ���ǻ�� ���ᰡ��
			
			System.out.println("������ �����߽��ϴ�...");
			
			Sender sender = new Sender(socket);
			Receiver receiver = new Receiver(socket);
			
			sender.start();
			receiver.start();		
		} catch (Exception e) {	}
	}

}
