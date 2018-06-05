package rmi.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import rmi.inf.ClientChatMessage;
import rmi.inf.ServerChatMessage;


//ServerChatMessage�������̽��� ������ ������ ��ü
public class ChatServer extends UnicastRemoteObject implements ServerChatMessage{
	
	//������ Ŭ���̾�Ʈ�� ��ü�� ������ ����Ʈ���� ����
	private ArrayList<ClientChatMessage> clientList = new ArrayList<>();
	
	//������
	protected ChatServer() throws RemoteException {	}

	
	//������ Ŭ���̾�Ʈ ��ü�� ����Ʈ�� �߰��ϴ� �޼��� ����
	@Override
	public void setClient(ClientChatMessage ccm) throws RemoteException {
		clientList.add(ccm);
	}
	
	//����Ʈ�� ��ϵ� ��� Ŭ���̾�Ʈ���� �޽����� �����ϴ� �޼��� ����
	@Override
	public void setMessage(String msg) throws RemoteException {
		for (ClientChatMessage ccm : clientList) {
			ccm.setMessage(msg);
		}
		
	}
	
	public static void main(String[] args) {
		try {
			//������ ��ü ����
			ServerChatMessage server = new ChatServer();
			
			//������ ������ ��ü�� Registry�� ����Ѵ�.
			Registry reg = LocateRegistry.createRegistry(1099); //�⺻ ��Ʈ�� ����
			reg.rebind("chat", server);
			
			System.out.println("ä�� ���� ������...");
			
		} catch (RemoteException e) { }
		
		
		
	}
	
	
	
	
	
}
