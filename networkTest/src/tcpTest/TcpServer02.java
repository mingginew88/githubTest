package tcpTest;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer02 {
	
	//데이터를 받는 클래스와 데이터를 보내는 클래스를 따로 구성하고 이클래스들을 쓰레드로 작동시킨다.
	public static void main(String[] args) {		
		try {
			//서버소켓을 만들고, 클라이언트가 접속하면 소켓을 만들어데이트를 받는 클래스와
			//데이터를 보내는 클래스에 이 소켓을 넘겨주고 쓰레드를 작동시킨다.
			ServerSocket server = new ServerSocket(7777);
			System.out.println("서버가 준비되었습니다...");
			
			Socket socket = server.accept();
			
			Sender sender = new Sender(socket);
			Receiver receiver = new Receiver(socket);
			
			sender.start();
			receiver.start();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
