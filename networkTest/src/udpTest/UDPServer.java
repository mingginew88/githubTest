package udpTest;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
	UDP��� : �񿬰� ������, ��ŷ���(�����Ͱ� ������� �����Ѵٴ� ������ ���Ѵ�.)
			TCP���� ������.
			
	DatagramSocket, DatagramPacket�� ����Ѵ�.
		- DatagramSocket ==> ������ �ۼ��� ����� ���õ� Ŭ����(��ü��)
		- DatagramPacket ==> �ְ���� �����Ϳ� ���õ� Ŭ���� (����, ����)
						 ==> ������ ���� �����ڿ� �۽��� ���� �����ڰ� ���еǾ� �ִ�.
						 
	TCP�� ���� Stream�� �̿��Ͽ� �����͸� �ְ� ������, 
	UDP�� Datagram�� �̿��Ͽ� �����͸� �ۼ����Ѵ�.
 */

//�ٸ� ����ڰ� ���� �޽����� �޾Ƽ� �ٽ� �����ִ� ���α׷�
public class UDPServer {
	public static void main(String[] args) {
		try {
			//����� ��Ʈ��ȣ�� �����Ͽ� ������ �����Ѵ�.
			DatagramSocket socket = new DatagramSocket(8888);
			System.out.println("���� ���� ��...");
			
			//���ſ�(�Է�), �۽ſ�(���) ��Ŷ���� ����
			DatagramPacket inpacket, outpacket;
			
			while(true) {
				//�����Ͱ� ����� byte�� �迭 ����
				byte[] bMsg = new byte[512];
				
				//���ſ� ��Ŷ ��ü ����
				// ==> �����Ͱ� ����� byte�� �迭�� ���̸� �����Ѵ�.
				inpacket = new DatagramPacket(bMsg, bMsg.length);
				
				//������ �����ϱ�
				//�����Ͱ� �� ������ ��ٸ���.
				socket.receive(inpacket); //���ŵ��� �����ʹ� inpacket�� ����ȴ�.
				
				//���� ���� ��Ŷ���� ������ �ּ�, ��Ʈ��ȣ���� �� �� �ִ�.
				InetAddress address = inpacket.getAddress(); 	//�ּ�����
				int port = inpacket.getPort(); 					//��Ʈ��ȣ
				
				System.out.println("������ IP�� ��Ʈ��ȣ => " + address + " : " + port);
				
				//������ ���� �޽��� ���
				//getData() ==> ������ ���� ������ (byte�� �迭)
				//getLength() ==> ���ŵ� �������� ���� ����
				String msg = new String(inpacket.getData(), 0, inpacket.getLength());  //���� ��� ����. �Ʒ����� ��Ȯ�ϰ� ���� ������.
				//String msg = new String(inpacket.getData()).trim(); 
				System.out.println("������ ���� �޽��� : " + msg);
				
				//------------------------------------------------------------------------��������� ����
				
				//���濡�� �޽��� ������(���Ź��� �޽����� �״�� �۽�)
				
				//�۽ſ� ��Ŷ ����
				// ==> ������ ������ ����� byte�� �迭, ������ �ڷ��� ����, ���� �ּ�(InetAddress��ü��), ���� ��Ʈ��ȣ
				outpacket = new DatagramPacket(msg.getBytes(), msg.getBytes().length, address, port);
				
				//�۽��ϱ�
				socket.send(outpacket); //outpacket�� �����Ѵ�.
				
			}
			
		} catch (Exception e) {	}
		
	}

}
