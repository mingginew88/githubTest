package basic;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
	// InetAddress 클래스 ==> IP주소를 다루기 위한 클래스
	
	
	public static void main(String[] args) throws UnknownHostException {
		// www.naver.com의 ip정보 가져오기
		
		InetAddress naverIP = InetAddress.getByName("www.naver.com");
		
		System.out.println("Host Name : " + naverIP.getHostName());
		System.out.println("Host Address : " + naverIP.getHostAddress());
		System.out.println("====================================================== ");
		
		// 자신의 컴퓨터의 IP정보 가져오기
		InetAddress localIP = InetAddress.getLocalHost();
		System.out.println("내컴의 Host Nam : " + localIP.getHostName());
		System.out.println("내컴의 Host Address : " + localIP.getHostAddress());
		System.out.println("====================================================== ");
		
		//IP주소가 여러개인 호스트의 정보가져오기
		InetAddress[] navers = InetAddress.getAllByName("www.naver.com");
		System.out.println("개수 : " + navers.length);
		
		for (InetAddress nIP : navers) {
			System.out.println(nIP.getHostName());
			System.out.println(nIP.getHostAddress());
		}
		
		
		
	}
	
	
	//하나의 호스트명에 여러개의 아이피를 연결해 쓸수 있다.
	
	

}
