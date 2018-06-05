package udpTest;

import java.io.File;
import java.io.FileInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class UDPFileClient {
	public static void main(String[] args) {
		File file = new File("D:/D_Other/Penguins.jpg");		
		final int BUFFER_SIZE = 1024;
		
		try {			
			DatagramSocket socket = new DatagramSocket();
			InetAddress address = InetAddress.getByName("localhost");
			int port = 8888;
			
			byte[] data = new byte[BUFFER_SIZE];
			FileInputStream fis = new FileInputStream(file);
			int len = 0;
			DatagramPacket outpacket;
			
			while((len=fis.read(data)) != -1) { //파일읽기
				//패킷 구성
				outpacket = new DatagramPacket(data, len, address, port);
				socket.send(outpacket);  //전송
			}
			//파일전송이 끝났다는 신호
			String msg = "end";
			outpacket = new DatagramPacket(msg.getBytes(), msg.getBytes().length, address, port);
			socket.send(outpacket);
			
			System.out.println("전송 끝...");
			fis.close();
			socket.close();
			
			
			
		} catch (Exception e) {
		}		
	}

}
