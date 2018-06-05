package udpTest;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClient {
	public static void main(String[] args) {
		//���ſ�, �۽ſ� ��Ŷ ���� ����
		DatagramPacket inpacket, outpacket;
		
		Scanner scan = new Scanner(System.in);
		
		//���Ź��� �����Ͱ� ����� byte�� �迭 ����
		byte[] bMsg = new byte[512];
		
		try {
			//�����Ҽ��ִ� UDP���� ����
			DatagramSocket socket = new DatagramSocket();
			
			//���� ���� �ּ� ����(���� �ּ� ����)
			InetAddress address = InetAddress.getByName("localhost");
			//InetAddress address = InetAddress.getByName("127.0.0.1");
			//InetAddress address = InetAddress.getByName("192.168.207.130");
			
			while(true) {
				//������ �޽��� �Է� �ޱ�
				System.out.println("���� �޽��� �Է� : ");
				String msg = scan.nextLine();
				
				if("/end".equals(msg)) { 	//�۾� ���� ���� Ȯ��
					break;
				}
				
				//������ ��Ŷ ����
				outpacket = new DatagramPacket(msg.getBytes(), msg.getBytes().length, address, 8888);
				
				//����
				socket.send(outpacket);
				
				//------------------------------------------------------------------
				
				//�������� �ǵ��ƿ� ������ �޾Ƽ� ����ϱ�
				
				//���ſ� ��Ŷ ����
				inpacket = new DatagramPacket(bMsg, bMsg.length);
				
				//����
				socket.receive(inpacket);
				
				
				System.out.println("������ ���� : " + new String(inpacket.getData(), 0, inpacket.getLength()));
				//System.out.println("������ ���� : " + new String(inpacket.getData()).trim());
				System.out.println();
			}
			
			System.out.println("��� ��...");
			socket.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		
		
		
		
	}

}
