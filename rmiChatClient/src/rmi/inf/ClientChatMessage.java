package rmi.inf;

import java.rmi.Remote;
import java.rmi.RemoteException;

// Ŭ���̾�Ʈ�� �������̽� 
public interface ClientChatMessage extends Remote{
	
	/**
	 * ������ ������ �޽����� ����ϴ� �޼���
	 * @param msg
	 * @throws RemoteException
	 */
	public void setMessage(String msg) throws RemoteException;
	
	
	
	
}
