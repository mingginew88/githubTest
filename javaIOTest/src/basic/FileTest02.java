package basic;

import java.io.File;

public class FileTest02 {
	public static void main(String[] args) {
		//���丮(����) ����� ����
		/*
		 1. mkdir() ==> File��ü�� ��� �� ������ ��ġ�� ���丮�� ����� �ش�.
		 				�߰��� ��ΰ� ��� �̸� ������� �־�� ������ ��ġ�� ���丮�� ���� �� �ִ�.
		 				(��ȯ�� : ����� ����(true), ����(false))
		 
		 2. mkdirs() ==> File��ü�� ��� �� ������ ��ġ�� ���丮�� ����� �ش�.
		 				�߰��� ��ΰ� ������ �߰��� ��ε� ��� ����� �� �Ŀ� ������ ��ġ�� ���丮�� ������ش�.
		 */
		
//		File file1 = new File("D:/D_Other/������");
//		if(file1.mkdir()){
//			//���� ���� �� ó������
//			System.out.println(file1.getName() + "���� ����� ����");
//		}else{
//			//����� �������� �� ó������
//			System.out.println(file1.getName() + "���� ����� ����");
//		}
//		System.out.println();
//		
//		
//		File file2 = new File("D:/D_Other/test/java/src");
//		if(file2.mkdirs()){
//			//���� ���� �� ó������
//			System.out.println(file2.getName() + "����� ����");
//		}else{
//			//����� �������� �� ó������
//			System.out.println(file2.getName() + "����� ����");
//		}
//		System.out.println();
		
		
		//==================================================================
		
		File file3 = new File("D:/D_Other/������");
		File file4 = new File("D:/D_Other/test.txt");
		
		if(file3.exists()){		//�ش� �����̳� ���丮�� ���� ������ true
			System.out.println(file3.getPath() + "�� �����մϴ�.");
			if(file3.isFile()){
				System.out.println("�̰��� �����Դϴ�.");
			}else if(file3.isDirectory()){
				System.out.println("�̰��� �����Դϴ�.");
			}
		}else{
			System.out.println(file3.getAbsolutePath() + "�� �����ϴ�.");
			if(file3.mkdir()){
				System.out.println("���� ����� ����");
			}else{
				System.out.println("���� ����� ����");
			}
		}
		
		
		
		
		
		
		
	}

}
