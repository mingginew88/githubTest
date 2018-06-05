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

// RMI���񽺸� �����ϴ� Ŭ������ UnicastRemoteObject�� ����ϰ� �ۼ��� �������̽��� �����Ͽ� �ۼ��Ѵ�.
public class RemoteServer extends UnicastRemoteObject implements RemoteInterface{
	
	// RMI���񽺸� �����ϴ� Ŭ������ �����ڵ� RemoteException�� throws�ؾ��Ѵ�.
	protected RemoteServer() throws RemoteException { }

	
	public static void main(String[] args) {
		try {
			//RMI���񽺸� �����ϴ� ����
			
			//�������̽��� ������ ��ü ����
			RemoteInterface inf = new RemoteServer();
			
			//�������̽��� ������ ��ü�� Ŭ���̾�Ʈ���� ã�� �� �ֵ��� �����ϱ�
			
			//��ü�� ����ϱ� ���� Registry��ü�� �����Ѵ�.
			//��Ʈ��ȣ�� �����ϸ� �⺻������ 1099�� �����ȴ�.
			Registry reg = LocateRegistry.createRegistry(8888);
			
			// Registry��ü�� ���񽺸� �����ϴ� ��ü���
			// ����) Registry��ü����.rebind("��ü��Alias", ��ü����)
			// '��ü�� Alias' ==> Ŭ���̾�Ʈ���� �ش� ���񽺸� ã�� �� ���ȴ�.
			// '��ü����' 	 ==> ���񽺸� �����ϴ� ��ü�� �ν��Ͻ�
			reg.rebind("server", inf);
			
			System.out.println("������ �غ�Ǿ����ϴ�.");
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
	}


	@Override
	public int doRemotePrint(String str) throws RemoteException {
		System.out.println();
		System.out.println("Ŭ���̾�Ʈ���� ������ �޽��� : " + str);
		System.out.println("����� ��Ĩ�ϴ�.");
		
		return 100;
	}


	@Override
	public void doPrintList(ArrayList<String> list) throws RemoteException {
		System.out.println();
		System.out.println("List���� ����ϱ�");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("List��� ��..");
		
	}


	@Override
	public void doPrintVo(TestVO vo) throws RemoteException {
		System.out.println();
		System.out.println("VO��ü ���� ����ϱ�");
		System.out.println("testId :" + vo.getTestId());
		System.out.println("testNum : " + vo.getTestNum());
		System.out.println("VO��ü ��� ��...");
		
		
	}


	@Override
	public void doTransFile(FileInfoVO[] fileVo) throws RemoteException {
		FileOutputStream fout = null;
		String dir = "d:/D_Other/download/"; //������ ����� ����
		System.out.println("���� ���� ����");
		try {
			for (int i = 0; i < fileVo.length; i++) {
				fout = new FileOutputStream(dir + fileVo[i].getFilename());
				
				//Ŭ���̾�Ʈ���� ������ ���� ������(byte���迭)�� �����Ѵ�.
				fout.write(fileVo[i].getFiledata());
				fout.flush();
				fout.close();
			}
		} catch (IOException e) { }
		
	}

}







