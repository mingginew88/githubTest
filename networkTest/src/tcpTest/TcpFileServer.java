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
	
	//���� ���� �޼���
	public void serverRun() {
		//������ ���� ���� ����
		File file = new File("D:/D_Other/������/Penguins.jpg");
		
		try {
			serverSocket = new ServerSocket(7777);
			System.out.println("������ �غ�Ǿ����ϴ�...");
			
			socket = serverSocket.accept();
			
			System.out.println("�ٿ�ε� ����...");
			//������ ������ ������ �����ϱ�
			if(!file.exists()) {
				file.createNewFile();
			}
			
			//������ InputStream��ü ���
			is = socket.getInputStream();
			
			//���� ����� FileOutputStream��ü ����
			fos = new FileOutputStream(file);
			
			//���� �����͸� �����ϰ� ����� ���� ����
			byte[] tmp = new byte[1024];
			int len = 0;
			while( (len = is.read(tmp)) != -1 ) { //Ŭ���̾�Ʈ�� ���� ������ �б�
				// �о�� �����͸� ���Ͽ� �����ϱ�
				fos.write(tmp, 0, len);				
			}
			
			System.out.println("���� �ٿ�ε� �Ϸ�...");
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// ����ߴ� �ڿ� �ݱ�
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
