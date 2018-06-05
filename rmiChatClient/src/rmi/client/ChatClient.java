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
	
	//생성자
	protected ChatClient() throws RemoteException {	}
	
	//서버에서 보내온 메시지를 출력하는 메서드 구현
	@Override
	public void setMessage(String msg) throws RemoteException {
		System.out.println(msg);
	}
	

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		try {
			//클라이언트용 객체 생성
			ClientChatMessage client = new ChatClient();
			
			//Registry에 등록된 서버용 객체 얻기
			Registry reg = LocateRegistry.getRegistry("localhost", 1099);
			ServerChatMessage server = (ServerChatMessage) reg.lookup("chat");
			
			//서버에 현재 클라이언트 객체를 추가한다.
			server.setClient(client);
			System.out.print("이름 입력 : ");
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
