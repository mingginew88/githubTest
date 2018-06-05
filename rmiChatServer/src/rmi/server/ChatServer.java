package rmi.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import rmi.inf.ClientChatMessage;
import rmi.inf.ServerChatMessage;


//ServerChatMessage인터페이스를 구현한 서버용 객체
public class ChatServer extends UnicastRemoteObject implements ServerChatMessage{
	
	//접속한 클라이언트의 객체를 저장할 리스트변수 선언
	private ArrayList<ClientChatMessage> clientList = new ArrayList<>();
	
	//생성자
	protected ChatServer() throws RemoteException {	}

	
	//접속한 클라이언트 객체를 리스트에 추가하는 메서드 구현
	@Override
	public void setClient(ClientChatMessage ccm) throws RemoteException {
		clientList.add(ccm);
	}
	
	//리스트에 등록된 모든 클라이언트에게 메시지를 전달하는 메서드 구현
	@Override
	public void setMessage(String msg) throws RemoteException {
		for (ClientChatMessage ccm : clientList) {
			ccm.setMessage(msg);
		}
		
	}
	
	public static void main(String[] args) {
		try {
			//서버용 객체 생성
			ServerChatMessage server = new ChatServer();
			
			//생성된 서버용 객체를 Registry에 등록한다.
			Registry reg = LocateRegistry.createRegistry(1099); //기본 포트로 설정
			reg.rebind("chat", server);
			
			System.out.println("채팅 서버 가동중...");
			
		} catch (RemoteException e) { }
		
		
		
	}
	
	
	
	
	
}
