package tcpTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

//클라이언트가 서버에 접속하면 D_Other폴더에 있는 'Penguins.jpg'파일을 서버로 전송한다.

//서버는 클라이언트가 보내온 그림파일을 'D_Other/연습용'폴더에 'Penguins.jpg'이름으로 저장한다.
public class TcpFileClient {
	private Socket socket;
	private OutputStream os;
	private FileInputStream fis;
	
	//클라이언트 시작 메서드
	public void clientRun() {
		//전송할 파일 정보 설정
		File file = new File("D:/D_Other/Penguins.jpg");
		
		try {
			socket = new Socket("localhost", 7777);
			System.out.println("서버에 연결되었습니다.");
			System.out.println("파일 전송을 시작합니다....");
			
			//파일 데이터를 읽어오기 위한 스트림생성
			fis = new FileInputStream(file);
			
			//서버로 전송할 소켓의 OutputStream얻기
			os = socket.getOutputStream();
			
			//데이터를 저장할 변수 선언
			byte[] tmp = new byte[1024];
			int len = 0;
			
			while( (len=fis.read(tmp)) != -1 ) { //파일데이터 읽기
				//서버로 데이터 전송
				os.write(tmp, 0, len);
			}
			
			System.out.println("파일 전송 완료...");
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(fis!=null) {try { fis.close(); } catch(IOException e2) {} }
			if(os!=null) {try { os.close(); } catch(IOException e2) {} }
			if(socket!=null) {try { socket.close(); } catch(IOException e2) {} }
		}
		
	}
	
	public static void main(String[] args) {
		new TcpFileClient().clientRun();
	}

}
