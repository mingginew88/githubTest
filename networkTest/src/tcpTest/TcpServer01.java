package tcpTest;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer01 {
	// TCP 소켓 통신예제(서버용)
	public static void main(String[] args) {
		try {
			//TCP소켓 통신을 위해 ServerSocket객체를 생성한다.
			ServerSocket server = new ServerSocket(7777);
			System.out.println("서버 실행중...");
			
			//클라이언트의 요청을 기다리고, 요청이 들어오면 클라이언트와 연결된 Socket객체를 생성해서 반환한다.
			Socket socket = server.accept();
			
			//이 이후에 연결이 완료되면 할일을 작성한다.
			
			System.out.println(socket.getInetAddress() + "에 연결되었습니다.");
			System.out.println("port : " + socket.getPort());
			
			//클라이언트에게 메시지 보내기
			//OutputStream을 구성하여 전송한다. (Socket에서 OutputStream객체를 구한다.)
			OutputStream out = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(out);
			
			//메시지 보내기
			dos.writeUTF("환영합니다....");
			System.out.println("메시지를 보냈습니다.");
			
			dos.close();
			
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
