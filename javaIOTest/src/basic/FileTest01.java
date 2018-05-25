package basic;

import java.io.File;

public class FileTest01 {
	public static void main(String[] args) {
		//File��ü ����� ����
		
		//1. new File(String ���� �Ǵ� ���)
		//	==> ���丮�� ���丮 ���� �Ǵ� ���丮�� ���ϸ� ������ ���� ���ڴ� "\\"�� ����ϰų� "/"�� ����� �� �ִ�.
		
		File file = new File("D:\\D_Other\\test.txt");
		System.out.println(file.getName() + "��");
		System.out.println("����? : " + file.isFile());
		System.out.println("���丮? : " + file.isDirectory());
		System.out.println();
		
		File file2 = new File("D:/D_Other");
		System.out.println(file2.getName() + "��");
		System.out.println("����? : " + file2.isFile());
		System.out.println("���丮? : " + file2.isDirectory());
		System.out.println();
		
		//2. new File(File parent, String child)
		//		==> 'parent'���丮 �ȿ� �ִ� 'child'������ ���´�.
		File file3 = new File(file2, "test.txt");
		System.out.println(file3.getName() + "��");
		System.out.println("����? : " + file3.isFile());
		System.out.println("���丮? : " + file3.isDirectory());
		System.out.println();
		
		//3. new File(String parent, String child)
		//		==> 'parent'���丮 �ȿ� �ִ� 'child'������ ���´�.
		File file4 = new File("D:/D_Other", "test.txt");
		System.out.println(file4.getName() + "��");
		System.out.println("����? : " + file4.isFile());
		System.out.println("���丮? : " + file4.isDirectory());
		System.out.println();
		
		System.out.println("������ ũ�� : " + file4.length());
		System.out.println();
				
		
		
		
		
		
		
	}
}
