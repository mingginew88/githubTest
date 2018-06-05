package tcpTest;

import java.net.Socket;

public class TcpClient02 {
	public static void main(String[] args) {
		try {
			//서버와 연결할 소켓객체를 생성하고 서버와 연결되면
			//데이터를 보내는 클래스와 데이터를 받는 클래스에 소켓을 넘겨주고 쓰레드를 시작한다.
			
			//자기자신 컴퓨트를 나타내는 방법
			//1. IP주소
			//2. localhost
			//3. 127.0.0.1
			
			Socket socket = new Socket("192.168.207.137", 7777);  //localhost 대신에 다른 주소 적어주면 다른컴퓨터 연결가능
			
			System.out.println("서버에 접속했습니다...");
			
			Sender sender = new Sender(socket);
			Receiver receiver = new Receiver(socket);
			
			sender.start();
			receiver.start();		
		} catch (Exception e) {	}
	}

}
