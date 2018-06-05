package tcpTest;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class MultiChatClient {
	
	
	//클라이언트 시작 메서드
	public void chatClientStart() {
		Scanner scan = new Scanner(System.in);
		String userName = null;
		
		System.out.println("대화명 입력 : ");
		userName = scan.next();
		
		Socket socket = null;
		String serverIP = "192.168.207.130";  //127.0.0.1
		
		//cmd 접속 후 d: ->  이 파일이 있는 bin파일 주소까지 입력 -> java + 이파일의 패키지명.클래스명 입력		
		
		try {
			socket = new Socket(serverIP, 7777);
			System.out.println("서버에 연결되었습니다.");
			
			//메시지 전송용 Thread 생성
			ClientSender sender = new ClientSender(socket, userName);
			
			//메시지 수신용 Thread 생성
			ClientReceiver receiver = new ClientReceiver(socket);
			
			sender.start();
			receiver.start();
			
		} catch (Exception e) {
		}
	}
	
	public static void main(String[] args) {
		new MultiChatClient().chatClientStart();
		
	}
	
	//메시지 전송용 Thread
	class ClientSender extends Thread {
		private Socket socket;
		private DataOutputStream dos;
		private String name;
		private Scanner scan = new Scanner(System.in);
		
		//생성자
		public ClientSender(Socket socket, String name) {
			this.socket = socket;
			this.name = name;
			try {
				dos = new DataOutputStream(socket.getOutputStream());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		@Override
		public void run() {
			try {
				//처음 시작할 때는 자신의 대화명을 서버로 전송한다.
				if(dos!=null) {
					dos.writeUTF(name);
				}
				
				while(dos!=null) {
					//키보드로 입력한 데이터를 서버로 전송한다.
					dos.writeUTF("[" + name + "] " + scan.nextLine());
				}
				
			}catch(Exception e) {}
			
		}
		
		
	}
	
	
	//메시지 수신용 Thread
	class ClientReceiver extends Thread {
		private Socket socket;
		private DataInputStream din;
		
		//생성자
		public ClientReceiver(Socket socket) {
			this.socket = socket;
			try {
				din = new DataInputStream(socket.getInputStream());
			} catch (Exception e) {	}
			
		}
		
		@Override
		public void run() {
			while(din!=null) {
				try {
					//서버로부터 수신된 데이터를 출력
					System.out.println(din.readUTF());
					
				} catch (IOException e) {
				}
			}
		}
		
		
		
		
		
		
		
		
	}
	
	
	
	

}
