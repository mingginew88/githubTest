package basic.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import basic.inf.RemoteInterface;
import basic.vo.FileInfoVO;
import basic.vo.TestVO;

//서비스를 제공받는 쪽의 프로젝트는 서버쪽의 '인터페이스'와 'VO객체'가  만들어진 패키지와 같은 구조로 되어야한다.

public class RemoteClient {
	public static void main(String[] args) {
		try {
			//RMI서비스를 사용하는 순서
			
			//등록된 서비스를 찾기위해 Registry객체를 생성한다.
			Registry reg = LocateRegistry.getRegistry("localhost", 8888);
			
			//등록된 서비스객체를 얻어온다.
			//형식) Registry객체변수.lookup("서버에서등록한Alias명");
			RemoteInterface inf = (RemoteInterface) reg.lookup("server");
			
			//이제부터 얻어온 서비스객체의 메서드를 호출해서 사용할 수 있다.
			int a = inf.doRemotePrint("안녕하세요");
			System.out.println("반환값 : " + a);
			System.out.println();
			
			//-----------------------------------------------------------			
			ArrayList<String> list = new ArrayList<>();
			list.add("사과");
			list.add("배");
			list.add("복숭아");
			list.add("딸기");
			list.add("수박");
			
			inf.doPrintList(list);
			
			System.out.println("doPrintList호출 끝...");
			System.out.println();
			
			
			//-----------------------------------------------------------
			TestVO vo = new TestVO();
			vo.setTestId("dditMan");
			vo.setTestNum(1234);
			
			inf.doPrintVo(vo);
			System.out.println("doPrintVo()호출 끝...");
			
			
			//-----------------------------------------------------------			
			System.out.println();
			System.out.println("파일 전송 작업 시작");
			
			File[] files = new File[2];
			files[0] = new File("D:/D_Other/Penguins.jpg");
			files[1] = new File("D:/D_Other/Chrysanthemum.jpg");
			
			FileInfoVO[] finfo = new FileInfoVO[files.length];
			
			//파일의 내용을 읽어와 FileInfoVO의 byte[]에 저장한 후 전송한다.
			for (int i = 0; i < files.length; i++) {
				//파일 길이 구하기  ==> 바이트배열 크기를 정하기 위해
				int len = (int) files[i].length(); 
				FileInputStream fin = new FileInputStream(files[i]);
				byte[] data = new byte[len];
				fin.read(data);  //파일 내용을 읽어 byte[]배열에 저장
				
				finfo[i] = new FileInfoVO();
				finfo[i].setFilename(files[i].getName());
				finfo[i].setFiledata(data);
			}
			
			inf.doTransFile(finfo);
			System.out.println("파일 전송 끝...");
			
			
			
			
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}






