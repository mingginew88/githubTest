package tcpTest;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class TcpClient01 {
	public static void main(String[] args) {	
		try {
			String serverIp = "192.168.207.130";
			System.out.println(serverIp + "������ �������Դϴ�.");			

			//���ϰ�ü�� �����ϸ鼭 ������ �����û�� ������.
			Socket socket = new Socket(serverIp, 7777);
			
			//������ ����� ���� �۾� ������ �ۼ��Ѵ�.
			System.out.println("������ ����Ǿ����ϴ�.");
			
			//�������� ������ �޽��� �ޱ�
			//�޽����� �ޱ����ؼ� InputStream��ü�� ���Ѵ�. (Socket��ü���� InputStream��ü�� ���Ѵ�.)
			InputStream is = socket.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			
			//���� �޽��� ����Ѵ�.
			System.out.println("�����κ��� ���� �޽��� : " + dis.readUTF());
			
			//��Ʈ���ݱ�
			dis.close();			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
