package rmi.inf;

import java.rmi.Remote;
import java.rmi.RemoteException;

//서버용 인터페이스
public interface ServerChatMessage extends Remote{
	
	/**
	 * 접속한 클라이언트 객체를 리스트에 추가하는 메서드
	 * @param ccm
	 * @throws RemoteException
	 */
	public void setClient(ClientChatMessage ccm) throws RemoteException;
	
	/**
	 * 리스트에 등록된 모든 클라이언트에게 메시지를 전달하는 메서드
	 * @param msg
	 * @throws RemoteException
	 */
	public void setMessage(String msg) throws RemoteException;
	
	
	
	
	
	
	
	
}
