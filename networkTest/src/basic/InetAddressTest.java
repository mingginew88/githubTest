package basic;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
	// InetAddress Ŭ���� ==> IP�ּҸ� �ٷ�� ���� Ŭ����
	
	
	public static void main(String[] args) throws UnknownHostException {
		// www.naver.com�� ip���� ��������
		
		InetAddress naverIP = InetAddress.getByName("www.naver.com");
		
		System.out.println("Host Name : " + naverIP.getHostName());
		System.out.println("Host Address : " + naverIP.getHostAddress());
		System.out.println("====================================================== ");
		
		// �ڽ��� ��ǻ���� IP���� ��������
		InetAddress localIP = InetAddress.getLocalHost();
		System.out.println("������ Host Nam : " + localIP.getHostName());
		System.out.println("������ Host Address : " + localIP.getHostAddress());
		System.out.println("====================================================== ");
		
		//IP�ּҰ� �������� ȣ��Ʈ�� ������������
		InetAddress[] navers = InetAddress.getAllByName("www.naver.com");
		System.out.println("���� : " + navers.length);
		
		for (InetAddress nIP : navers) {
			System.out.println(nIP.getHostName());
			System.out.println(nIP.getHostAddress());
		}
		
		
		
	}
	
	
	//�ϳ��� ȣ��Ʈ�� �������� �����Ǹ� ������ ���� �ִ�.
	
	

}
