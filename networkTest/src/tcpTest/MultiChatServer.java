package tcpTest;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MultiChatServer {
	// 대화명, 클라이언트의 Socket정보를 저장하는 Map 선언(대화방 역할)
	Map<String, Socket> clients;
	
	//생성자
	public MultiChatServer() {
		//대화방용 Map을 동기화해서 생성
		clients = Collections.synchronizedMap(new HashMap<String, Socket>());
	}
	
	//대화방에 있는 전체 사용자에게 메시지를 전송하는 메서드
	public void sendToAll(String msg) {
		// 대화방에 접속한 사용자의 대화명 리스트 추출(key값 구하기)
		Iterator<String> it = clients.keySet().iterator();
		
		while(it.hasNext()) { //사용자 수 만큼 반복
			try {
				String name = it.next(); //대화명(key값 얻기)
				Socket userSocket = clients.get(name); //사용자의 소켓얻기
				
				DataOutputStream out = new DataOutputStream(
					userSocket.getOutputStream()
				);
				
				out.writeUTF(msg);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	
	//서버 시작 메서드
	public void chatServerStart() {
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		try {
			serverSocket = new ServerSocket(7777);
			System.out.println("서버가 시작되었습니다.");
			
			while(true) {
				socket = serverSocket.accept();
				
				System.out.println("[" + socket.getInetAddress() + "]에서 접속했습니다.");
				
				//서버에서 클라이언트로 메시지를 전송하는 Thread생성
				ServerReceiver th = new ServerReceiver(socket);
				th.start();
				
			}
		} catch (Exception e) {
		} finally {
			if(serverSocket!=null) {
				try { serverSocket.close(); } catch(IOException e) { }
			}
		}
	}



	public static void main(String[] args) {
		new MultiChatServer().chatServerStart();
	}
	
	//서버용 Thread ==> 서버에서 클라이언트로 메시지를 전송할 Thread
	class ServerReceiver extends Thread {
		private Socket socket;
		private DataInputStream din;
		private DataOutputStream dos;
		
		//생성자
		public ServerReceiver(Socket socket) {
			this.socket = socket;
			
			try {
				//클라이언트 소켓에서 데이터를 수신할 InputStream생성
				din = new DataInputStream(socket.getInputStream());
				
				//클라이언트 소켓으로 데이터를 송신할 OutputStream생성
				dos = new DataOutputStream(socket.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		
		@Override
		public void run() {
			String name = "";
			
			try {
				//클라이언트는 접속이 성공하면 처음에 대화명을 보낸다.
				//이 대화명을 읽어온다.
				name = din.readUTF();
				
				//새로운 클라이언트가 접속하면 다른 모든 사용자에게 대화방 참여메시지를 전송한다.
				sendToAll(name + "님이 입장하셨습니다.");
				
				//대화명과 클라이언트 소켓을 대화방 Map에 저장한다.
				clients.put(name, socket);
				
				System.out.println("현재 서버 접속자 수 : " + clients.size() + "명");
				
				//이후에는 클라이언트가 보내온 메시지를 다른 모든 사용자에게 보내준다.
				while(din != null) {
					sendToAll (din.readUTF());
				}
				
			} catch (IOException e) {
			} finally {
				// finally절이 실행된다는 것은 클라이언트가 접속을 끊었다는 의미이다.
				// 즉, 대화방을 나갔다.
				
				sendToAll(name + "님이 나가셨습니다.");
				
				//대화방 Map에서 삭제
				clients.remove(name);
				System.out.println("[" + socket.getInetAddress() + "]에서 접속해제...");
				System.out.println("현재 서버 접속자 수 : " + clients.size() + "명");
				
			}
			
			
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	

}
