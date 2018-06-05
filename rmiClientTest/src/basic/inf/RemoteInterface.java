package basic.inf;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import basic.vo.FileInfoVO;
import basic.vo.TestVO;


// ���񽺸� �����ϴ� RMI�� �������̽��� Remote�� ����ؼ� �ۼ��Ѵ�.
public interface RemoteInterface extends Remote{
	//�� �������̽����� ����ȴ� ��� �޼���� RemoteException�� throws�ؾ��Ѵ�.
	
	
	/**
	 * ���ڿ��� �Ű������� �����ؼ� �������� ����ϴ� �޼���
	 * @param str
	 * @return - �������� ��ȯ
	 * @throws RemoteException
	 */
	public int doRemotePrint(String str) throws RemoteException;
	
	
	/**
	 * list���� �Ű������� �����ؼ� �������� �ش� ����Ʈ�� ������ ����ϴ� �޼���
	 * @param list
	 * @throws RemoteException
	 */
	public void doPrintList(ArrayList<String> list) throws RemoteException;
	
	
	/**
	 * VO��ü�� �Ű������� �����ؼ� �������� �ش� VO������ ����ϴ� �޼���
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








