package rmi.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

import rmi.inf.ClientChatMessage;
import rmi.inf.ServerChatMessage;

public class ChatClient extends UnicastRemoteObject implements ClientChatMessage{
	
	//������
	protected ChatClient() throws RemoteException {	}
	
	//�������� ������ �޽����� ����ϴ� �޼��� ����
	@Override
	public void setMessage(String msg) throws RemoteException {
		System.out.println(msg);
	}
	

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		try {
			//Ŭ���̾�Ʈ�� ��ü ����
			ClientChatMessage client = new ChatClient();
			
			//Registry�� ��ϵ� ������ ��ü ���
			Registry reg = LocateRegistry.getRegistry("localhost", 1099);
			ServerChatMessage server = (ServerChatMessage) reg.lookup("chat");
			
			//������ ���� Ŭ���̾�Ʈ ��ü�� �߰��Ѵ�.
			server.setClient(client);
			System.out.print("�̸� �Է� : ");
			String name = scan.nextLine();
			
			while(true) {
				String msg = scan.nextLine();
				server.setMessage(name + " : " + msg);
			}
			
			
			
			
			
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

}
