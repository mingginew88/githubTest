package rmi.inf;

import java.rmi.Remote;
import java.rmi.RemoteException;

// 클라이언트용 인터페이스 
public interface ClientChatMessage extends Remote{
	
	/**
	 * 서버가 보내온 메시지를 출력하는 메서드
	 * @param msg
	 * @throws RemoteException
	 */
	public void setMessage(String msg) throws RemoteException;
	
	
	
	
}
