package basic.server;

import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import basic.inf.RemoteInterface;
import basic.vo.FileInfoVO;
import basic.vo.TestVO;

// RMI서비스를 제공하는 클래스는 UnicastRemoteObject를 상속하고 작성한 인터페이스를 구현하여 작성한다.
public class RemoteServer extends UnicastRemoteObject implements RemoteInterface{
	
	// RMI서비스를 제공하는 클래스의 생성자도 RemoteException을 throws해야한다.
	protected RemoteServer() throws RemoteException { }

	
	public static void main(String[] args) {
		try {
			//RMI서비스를 제공하는 순서
			
			//인터페이스를 구현한 객체 생성
			RemoteInterface inf = new RemoteServer();
			
			//인터페이스를 구현한 객체를 클라이언트에서 찾을 수 있도록 설정하기
			
			//객체를 등록하기 위해 Registry객체를 생성한다.
			//포트번호를 생략하면 기본값으로 1099가 설정된다.
			Registry reg = LocateRegistry.createRegistry(8888);
			
			// Registry객체에 서비스를 제공하는 객체등록
			// 형식) Registry객체변수.rebind("객체의Alias", 객체변수)
			// '객체의 Alias' ==> 클라이언트에서 해당 서비스를 찾을 때 사용된다.
			// '객체변수' 	 ==> 서비스를 제공하는 객체의 인스턴스
			reg.rebind("server", inf);
			
			System.out.println("서버가 준비되었습니다.");
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
	}


	@Override
	public int doRemotePrint(String str) throws RemoteException {
		System.out.println();
		System.out.println("클라이언트에서 보내온 메시지 : " + str);
		System.out.println("출력을 마칩니다.");
		
		return 100;
	}


	@Override
	public void doPrintList(ArrayList<String> list) throws RemoteException {
		System.out.println();
		System.out.println("List정보 출력하기");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("List출력 끝..");
		
	}


	@Override
	public void doPrintVo(TestVO vo) throws RemoteException {
		System.out.println();
		System.out.println("VO객체 정보 출력하기");
		System.out.println("testId :" + vo.getTestId());
		System.out.println("testNum : " + vo.getTestNum());
		System.out.println("VO객체 출력 끝...");
		
		
	}


	@Override
	public void doTransFile(FileInfoVO[] fileVo) throws RemoteException {
		FileOutputStream fout = null;
		String dir = "d:/D_Other/download/"; //파일이 저장될 폴더
		System.out.println("파일 저장 시작");
		try {
			for (int i = 0; i < fileVo.length; i++) {
				fout = new FileOutputStream(dir + fileVo[i].getFilename());
				
				//클라이언트에서 전달한 파일 데이터(byte형배열)를 저장한다.
				fout.write(fileVo[i].getFiledata());
				fout.flush();
				fout.close();
			}
		} catch (IOException e) { }
		
	}

}







