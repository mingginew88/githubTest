package basic.inf;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import basic.vo.FileInfoVO;
import basic.vo.TestVO;


// 서비스를 제공하는 RMI용 인터페이스는 Remote를 상속해서 작성한다.
public interface RemoteInterface extends Remote{
	//이 인터페이스에서 선언된느 모든 메서드는 RemoteException을 throws해야한다.
	
	
	/**
	 * 문자열을 매개변수로 전달해서 서버에서 출력하는 메서드
	 * @param str
	 * @return - 정수값을 반환
	 * @throws RemoteException
	 */
	public int doRemotePrint(String str) throws RemoteException;
	
	
	/**
	 * list값을 매개변수로 전달해서 서버에서 해당 리스트의 값들을 출력하는 메서드
	 * @param list
	 * @throws RemoteException
	 */
	public void doPrintList(ArrayList<String> list) throws RemoteException;
	
	
	/**
	 * VO객체를 매개변수로 전달해서 서버에서 해당 VO정보를 출력하는 메서드
	 * @param vo
	 * @throws RemoteException
	 */
	public void doPrintVo(TestVO vo) throws RemoteException;
	
	
	/**
	 * 
	 * @param fileVo
	 * @throws RemoteException
	 */
	public void doTransFile(FileInfoVO[] fileVo) throws RemoteException;
	
	
	
	
	
	
	
	
	

}








