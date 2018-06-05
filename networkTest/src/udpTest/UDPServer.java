package udpTest;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
	UDP방식 : 비연결 지향적, 비신뢰적(데이터가 순서대로 도착한다는 보장을 못한다.)
			TCP보다 빠르다.
			
	DatagramSocket, DatagramPacket을 사용한다.
		- DatagramSocket ==> 데이터 송수신 연결과 관련된 클래스(우체부)
		- DatagramPacket ==> 주고받을 데이터와 관련된 클래스 (소포, 편지)
						 ==> 수신을 위한 생성자와 송신을 위한 생성자가 구분되어 있다.
						 
	TCP의 경우는 Stream을 이용하여 데이터를 주고 받지만, 
	UDP는 Datagram을 이용하여 데이터를 송수신한다.
 */

//다른 사용자가 보낸 메시지를 받아서 다시 돌려주는 프로그램
public class UDPServer {
	public static void main(String[] args) {
		try {
			//통신할 포트번호를 지정하여 소켓을 생성한다.
			DatagramSocket socket = new DatagramSocket(8888);
			System.out.println("서버 실행 중...");
			
			//수신용(입력), 송신용(출력) 패킷변수 선언
			DatagramPacket inpacket, outpacket;
			
			while(true) {
				//데이터가 저장될 byte형 배열 선언
				byte[] bMsg = new byte[512];
				
				//수신용 패킷 객체 생성
				// ==> 데이터가 저장될 byte형 배열과 길이를 지정한다.
				inpacket = new DatagramPacket(bMsg, bMsg.length);
				
				//데이터 수신하기
				//데이터가 올 떄까지 기다린다.
				socket.receive(inpacket); //수신도니 데이터는 inpacket에 저장된다.
				
				//수신 받은 패킷에서 상대방의 주소, 포트번호등을 알 수 있다.
				InetAddress address = inpacket.getAddress(); 	//주소정보
				int port = inpacket.getPort(); 					//포트번호
				
				System.out.println("상대방의 IP와 포트번호 => " + address + " : " + port);
				
				//상대방이 보낸 메시지 출력
				//getData() ==> 상대방이 보낸 데이터 (byte형 배열)
				//getLength() ==> 수신된 데이터의 실제 길이
				String msg = new String(inpacket.getData(), 0, inpacket.getLength());  //실제 담긴 갯수. 아래보다 정확하고 나은 문장임.
				//String msg = new String(inpacket.getData()).trim(); 
				System.out.println("상대방이 보낸 메시지 : " + msg);
				
				//------------------------------------------------------------------------여기까지가 수신
				
				//상대방에게 메시지 보내기(수신받은 메시지를 그대로 송신)
				
				//송신용 패킷 생성
				// ==> 전송할 데이터 저장된 byte형 배열, 전송할 자료의 길이, 상대방 주소(InetAddress객체형), 상대방 포트번호
				outpacket = new DatagramPacket(msg.getBytes(), msg.getBytes().length, address, port);
				
				//송신하기
				socket.send(outpacket); //outpacket을 전송한다.
				
			}
			
		} catch (Exception e) {	}
		
	}

}
