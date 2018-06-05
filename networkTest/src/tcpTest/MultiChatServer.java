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
	// ��ȭ��, Ŭ���̾�Ʈ�� Socket������ �����ϴ� Map ����(��ȭ�� ����)
	Map<String, Socket> clients;
	
	//������
	public MultiChatServer() {
		//��ȭ��� Map�� ����ȭ�ؼ� ����
		clients = Collections.synchronizedMap(new HashMap<String, Socket>());
	}
	
	//��ȭ�濡 �ִ� ��ü ����ڿ��� �޽����� �����ϴ� �޼���
	public void sendToAll(String msg) {
		// ��ȭ�濡 ������ ������� ��ȭ�� ����Ʈ ����(key�� ���ϱ�)
		Iterator<String> it = clients.keySet().iterator();
		
		while(it.hasNext()) { //����� �� ��ŭ �ݺ�
			try {
				String name = it.next(); //��ȭ��(key�� ���)
				Socket userSocket = clients.get(name); //������� ���Ͼ��
				
				DataOutputStream out = new DataOutputStream(
					userSocket.getOutputStream()
				);
				
				out.writeUTF(msg);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	
	//���� ���� �޼���
	public void chatServerStart() {
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		try {
			serverSocket = new ServerSocket(7777);
			System.out.println("������ ���۵Ǿ����ϴ�.");
			
			while(true) {
				socket = serverSocket.accept();
				
				System.out.println("[" + socket.getInetAddress() + "]���� �����߽��ϴ�.");
				
				//�������� Ŭ���̾�Ʈ�� �޽����� �����ϴ� Thread����
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
	
	//������ Thread ==> �������� Ŭ���̾�Ʈ�� �޽����� ������ Thread
	class ServerReceiver extends Thread {
		private Socket socket;
		private DataInputStream din;
		private DataOutputStream dos;
		
		//������
		public ServerReceiver(Socket socket) {
			this.socket = socket;
			
			try {
				//Ŭ���̾�Ʈ ���Ͽ��� �����͸� ������ InputStream����
				din = new DataInputStream(socket.getInputStream());
				
				//Ŭ���̾�Ʈ �������� �����͸� �۽��� OutputStream����
				dos = new DataOutputStream(socket.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		
		@Override
		public void run() {
			String name = "";
			
			try {
				//Ŭ���̾�Ʈ�� ������ �����ϸ� ó���� ��ȭ���� ������.
				//�� ��ȭ���� �о�´�.
				name = din.readUTF();
				
				//���ο� Ŭ���̾�Ʈ�� �����ϸ� �ٸ� ��� ����ڿ��� ��ȭ�� �����޽����� �����Ѵ�.
				sendToAll(name + "���� �����ϼ̽��ϴ�.");
				
				//��ȭ��� Ŭ���̾�Ʈ ������ ��ȭ�� Map�� �����Ѵ�.
				clients.put(name, socket);
				
				System.out.println("���� ���� ������ �� : " + clients.size() + "��");
				
				//���Ŀ��� Ŭ���̾�Ʈ�� ������ �޽����� �ٸ� ��� ����ڿ��� �����ش�.
				while(din != null) {
					sendToAll (din.readUTF());
				}
				
			} catch (IOException e) {
			} finally {
				// finally���� ����ȴٴ� ���� Ŭ���̾�Ʈ�� ������ �����ٴ� �ǹ��̴�.
				// ��, ��ȭ���� ������.
				
				sendToAll(name + "���� �����̽��ϴ�.");
				
				//��ȭ�� Map���� ����
				clients.remove(name);
				System.out.println("[" + socket.getInetAddress() + "]���� ��������...");
				System.out.println("���� ���� ������ �� : " + clients.size() + "��");
				
			}
			
			
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	

}
