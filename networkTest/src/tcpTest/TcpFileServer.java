package tcpTest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpFileServer {
	private ServerSocket serverSocket;
	private Socket socket;
	private InputStream is;
	private FileOutputStream fos;
	
	//서버 시작 메서드
	public void serverRun() {
		//저장할 파일 정보 설정
		File file = new File("D:/D_Other/연습용/Penguins.jpg");
		
		try {
			serverSocket = new ServerSocket(7777);
			System.out.println("서버가 준비되었습니다...");
			
			socket = serverSocket.accept();
			
			System.out.println("다운로드 시작...");
			//저장할 파일이 없으면 생성하기
			if(!file.exists()) {
				file.createNewFile();
			}
			
			//소켓의 InputStream객체 얻기
			is = socket.getInputStream();
			
			//파일 저장용 FileOutputStream객체 생성
			fos = new FileOutputStream(file);
			
			//파일 데이터를 저장하고 출력할 변수 선언
			byte[] tmp = new byte[1024];
			int len = 0;
			while( (len = is.read(tmp)) != -1 ) { //클라이언트가 보낸 데이터 읽기
				// 읽어온 데이터를 파일에 저장하기
				fos.write(tmp, 0, len);				
			}
			
			System.out.println("파일 다운로드 완료...");
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 사용했던 자원 닫기
			if(fos!=null) {
				try {fos.close();} catch (IOException e2) {	}
			}
			
			if(is!=null) {
				try {is.close();} catch (IOException e2) { }
			}
			
			if(socket!=null) {
				try {socket.close();} catch (IOException e2) { }
			}
			
			if(serverSocket!=null) {
				try {serverSocket.close();} catch (IOException e2) { }
			}
		}
	}
	
	
	public static void main(String[] args) {
		new TcpFileServer().serverRun();
		
	}

}
