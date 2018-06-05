package tcpTest;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class MultiChatClient {
	
	
	//Ŭ���̾�Ʈ ���� �޼���
	public void chatClientStart() {
		Scanner scan = new Scanner(System.in);
		String userName = null;
		
		System.out.println("��ȭ�� �Է� : ");
		userName = scan.next();
		
		Socket socket = null;
		String serverIP = "192.168.207.130";  //127.0.0.1
		
		//cmd ���� �� d: ->  �� ������ �ִ� bin���� �ּұ��� �Է� -> java + �������� ��Ű����.Ŭ������ �Է�		
		
		try {
			socket = new Socket(serverIP, 7777);
			System.out.println("������ ����Ǿ����ϴ�.");
			
			//�޽��� ���ۿ� Thread ����
			ClientSender sender = new ClientSender(socket, userName);
			
			//�޽��� ���ſ� Thread ����
			ClientReceiver receiver = new ClientReceiver(socket);
			
			sender.start();
			receiver.start();
			
		} catch (Exception e) {
		}
	}
	
	public static void main(String[] args) {
		new MultiChatClient().chatClientStart();
		
	}
	
	//�޽��� ���ۿ� Thread
	class ClientSender extends Thread {
		private Socket socket;
		private DataOutputStream dos;
		private String name;
		private Scanner scan = new Scanner(System.in);
		
		//������
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
				//ó�� ������ ���� �ڽ��� ��ȭ���� ������ �����Ѵ�.
				if(dos!=null) {
					dos.writeUTF(name);
				}
				
				while(dos!=null) {
					//Ű����� �Է��� �����͸� ������ �����Ѵ�.
					dos.writeUTF("[" + name + "] " + scan.nextLine());
				}
				
			}catch(Exception e) {}
			
		}
		
		
	}
	
	
	//�޽��� ���ſ� Thread
	class ClientReceiver extends Thread {
		private Socket socket;
		private DataInputStream din;
		
		//������
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
					//�����κ��� ���ŵ� �����͸� ���
					System.out.println(din.readUTF());
					
				} catch (IOException e) {
				}
			}
		}
		
		
		
		
		
		
		
		
	}
	
	
	
	

}
