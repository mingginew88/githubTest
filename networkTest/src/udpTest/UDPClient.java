package udpTest;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClient {
	public static void main(String[] args) {
		//수신용, 송신용 패킷 변수 선언
		DatagramPacket inpacket, outpacket;
		
		Scanner scan = new Scanner(System.in);
		
		//수신받은 데이터가 저장될 byte형 배열 선언
		byte[] bMsg = new byte[512];
		
		try {
			//전송할수있는 UDP소켓 생성
			DatagramSocket socket = new DatagramSocket();
			
			//받을 곳의 주소 설정(상대방 주소 설정)
			InetAddress address = InetAddress.getByName("localhost");
			//InetAddress address = InetAddress.getByName("127.0.0.1");
			//InetAddress address = InetAddress.getByName("192.168.207.130");
			
			while(true) {
				//전송할 메시지 입력 받기
				System.out.println("보낼 메시지 입력 : ");
				String msg = scan.nextLine();
				
				if("/end".equals(msg)) { 	//작업 중지 여부 확인
					break;
				}
				
				//전송할 패킷 생성
				outpacket = new DatagramPacket(msg.getBytes(), msg.getBytes().length, address, 8888);
				
				//전송
				socket.send(outpacket);
				
				//------------------------------------------------------------------
				
				//서버에서 되돌아온 데이터 받아서 출력하기
				
				//수신용 패킷 생성
				inpacket = new DatagramPacket(bMsg, bMsg.length);
				
				//수신
				socket.receive(inpacket);
				
				
				System.out.println("서버의 응답 : " + new String(inpacket.getData(), 0, inpacket.getLength()));
				//System.out.println("서버의 응답 : " + new String(inpacket.getData()).trim());
				System.out.println();
			}
			
			System.out.println("통신 끝...");
			socket.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		
		
		
		
	}

}
