package tcpTest;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class TcpClient01 {
	public static void main(String[] args) {	
		try {
			String serverIp = "192.168.207.130";
			System.out.println(serverIp + "서버에 연결중입니다.");			

			//소켓객체를 생성하면서 서버에 연결요청을 보낸다.
			Socket socket = new Socket(serverIp, 7777);
			
			//서버와 연결된 후의 작업 내용을 작성한다.
			System.out.println("서버에 연결되었습니다.");
			
			//서버에서 보내온 메시지 받기
			//메시지를 받기위해서 InputStream객체를 구한다. (Socket객체에서 InputStream객체를 구한다.)
			InputStream is = socket.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			
			//받은 메시지 출력한다.
			System.out.println("서버로부터 받은 메시지 : " + dis.readUTF());
			
			//스트림닫기
			dis.close();			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
