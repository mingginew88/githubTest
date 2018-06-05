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

//���񽺸� �����޴� ���� ������Ʈ�� �������� '�������̽�'�� 'VO��ü'��  ������� ��Ű���� ���� ������ �Ǿ���Ѵ�.

public class RemoteClient {
	public static void main(String[] args) {
		try {
			//RMI���񽺸� ����ϴ� ����
			
			//��ϵ� ���񽺸� ã������ Registry��ü�� �����Ѵ�.
			Registry reg = LocateRegistry.getRegistry("localhost", 8888);
			
			//��ϵ� ���񽺰�ü�� ���´�.
			//����) Registry��ü����.lookup("�������������Alias��");
			RemoteInterface inf = (RemoteInterface) reg.lookup("server");
			
			//�������� ���� ���񽺰�ü�� �޼��带 ȣ���ؼ� ����� �� �ִ�.
			int a = inf.doRemotePrint("�ȳ��ϼ���");
			System.out.println("��ȯ�� : " + a);
			System.out.println();
			
			//-----------------------------------------------------------			
			ArrayList<String> list = new ArrayList<>();
			list.add("���");
			list.add("��");
			list.add("������");
			list.add("����");
			list.add("����");
			
			inf.doPrintList(list);
			
			System.out.println("doPrintListȣ�� ��...");
			System.out.println();
			
			
			//-----------------------------------------------------------
			TestVO vo = new TestVO();
			vo.setTestId("dditMan");
			vo.setTestNum(1234);
			
			inf.doPrintVo(vo);
			System.out.println("doPrintVo()ȣ�� ��...");
			
			
			//-----------------------------------------------------------			
			System.out.println();
			System.out.println("���� ���� �۾� ����");
			
			File[] files = new File[2];
			files[0] = new File("D:/D_Other/Penguins.jpg");
			files[1] = new File("D:/D_Other/Chrysanthemum.jpg");
			
			FileInfoVO[] finfo = new FileInfoVO[files.length];
			
			//������ ������ �о�� FileInfoVO�� byte[]�� ������ �� �����Ѵ�.
			for (int i = 0; i < files.length; i++) {
				//���� ���� ���ϱ�  ==> ����Ʈ�迭 ũ�⸦ ���ϱ� ����
				int len = (int) files[i].length(); 
				FileInputStream fin = new FileInputStream(files[i]);
				byte[] data = new byte[len];
				fin.read(data);  //���� ������ �о� byte[]�迭�� ����
				
				finfo[i] = new FileInfoVO();
				finfo[i].setFilename(files[i].getName());
				finfo[i].setFiledata(data);
			}
			
			inf.doTransFile(finfo);
			System.out.println("���� ���� ��...");
			
			
			
			
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






