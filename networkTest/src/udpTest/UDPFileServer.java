package udpTest;

import java.io.File;
import java.io.FileOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

//Ŭ���̾�Ʈ�� ������ �����ϸ� 'D:/D_Other/Penguins.jpg'������ ������ �����Ѵ�.
//������ Ŭ���̾�Ʈ�� ������ ������ 'D:/D_Other/test/'������ �����Ѵ�.

public class UDPFileServer {
	public static void main(String[] args) {
		File file = new File("D:/D_Other/test/Penguins.jpg");
		final int BUFFER_SIZE = 1024;
		int port = 8888;
		
		try {
			DatagramSocket socket = new DatagramSocket(port);
			System.out.println("���� ������...");
			
			FileOutputStream fos = new FileOutputStream(file);
			
			byte[] data = new byte[BUFFER_SIZE];			
			
			DatagramPacket inpacket = new DatagramPacket(data, data.length);
			
			System.out.println("���� ���� ����...");
			while(true) {				
				//�����͹ޱ�
				socket.receive(inpacket);
				
				String msg = new String(inpacket.getData(), 0, inpacket.getLength());
				if("end".equals(msg)) {
					break;
				}
				//���� �����͸� ���Ϸ� �����ϱ�
				fos.write(inpacket.getData(), 0, inpacket.getLength());			
			}
			
			System.out.println("���� ���� ��...");
			
			fos.close();
			socket.close();
			
			
		} catch (Exception e) {	}
		
		
		
	}

}
