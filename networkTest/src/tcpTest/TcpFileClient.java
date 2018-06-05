package tcpTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

//Ŭ���̾�Ʈ�� ������ �����ϸ� D_Other������ �ִ� 'Penguins.jpg'������ ������ �����Ѵ�.

//������ Ŭ���̾�Ʈ�� ������ �׸������� 'D_Other/������'������ 'Penguins.jpg'�̸����� �����Ѵ�.
public class TcpFileClient {
	private Socket socket;
	private OutputStream os;
	private FileInputStream fis;
	
	//Ŭ���̾�Ʈ ���� �޼���
	public void clientRun() {
		//������ ���� ���� ����
		File file = new File("D:/D_Other/Penguins.jpg");
		
		try {
			socket = new Socket("localhost", 7777);
			System.out.println("������ ����Ǿ����ϴ�.");
			System.out.println("���� ������ �����մϴ�....");
			
			//���� �����͸� �о���� ���� ��Ʈ������
			fis = new FileInputStream(file);
			
			//������ ������ ������ OutputStream���
			os = socket.getOutputStream();
			
			//�����͸� ������ ���� ����
			byte[] tmp = new byte[1024];
			int len = 0;
			
			while( (len=fis.read(tmp)) != -1 ) { //���ϵ����� �б�
				//������ ������ ����
				os.write(tmp, 0, len);
			}
			
			System.out.println("���� ���� �Ϸ�...");
			
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
