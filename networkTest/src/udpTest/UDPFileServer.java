package udpTest;

import java.io.File;
import java.io.FileOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

//클라이언트가 서버에 접속하면 'D:/D_Other/Penguins.jpg'파일을 서버로 전송한다.
//서버는 클라이언트가 전송한 파일을 'D:/D_Other/test/'폴더에 저장한다.

public class UDPFileServer {
	public static void main(String[] args) {
		File file = new File("D:/D_Other/test/Penguins.jpg");
		final int BUFFER_SIZE = 1024;
		int port = 8888;
		
		try {
			DatagramSocket socket = new DatagramSocket(port);
			System.out.println("서버 연결중...");
			
			FileOutputStream fos = new FileOutputStream(file);
			
			byte[] data = new byte[BUFFER_SIZE];			
			
			DatagramPacket inpacket = new DatagramPacket(data, data.length);
			
			System.out.println("파일 수신 시작...");
			while(true) {				
				//데이터받기
				socket.receive(inpacket);
				
				String msg = new String(inpacket.getData(), 0, inpacket.getLength());
				if("end".equals(msg)) {
					break;
				}
				//받은 데이터를 파일로 저장하기
				fos.write(inpacket.getData(), 0, inpacket.getLength());			
			}
			
			System.out.println("파일 수신 끝...");
			
			fos.close();
			socket.close();
			
			
		} catch (Exception e) {	}
		
		
		
	}

}
