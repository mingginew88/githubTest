package rmi.inf;

import java.rmi.Remote;
import java.rmi.RemoteException;

//������ �������̽�
public interface ServerChatMessage extends Remote{
	
	/**
	 * ������ Ŭ���̾�Ʈ ��ü�� ����Ʈ�� �߰��ϴ� �޼���
	 * @param ccm
	 * @throws RemoteException
	 */
	public void setClient(ClientChatMessage ccm) throws RemoteException;
	
	/**
	 * ����Ʈ�� ��ϵ� ��� Ŭ���̾�Ʈ���� �޽����� �����ϴ� �޼���
	 * @param msg
	 * @throws RemoteException
	 */
	public void setMessage(String msg) throws RemoteException;
	
	
	
	
	
	
	
	
}
