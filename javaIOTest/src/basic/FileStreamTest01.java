package basic;

import java.io.FileInputStream;
import java.io.IOException;

//File��Ʈ���� �̿��� ������ ����� ����

public class FileStreamTest01 {
	public static void main(String[] args) {
		FileInputStream fin = null;
		
		try {
			//�о�� ���ϰ� ����� ����Ʈ ��Ʈ�� ��ü ����
			//���1
			fin = new FileInputStream("D:/D_Other/test.txt");
			
			//���2
//			File file = new  File("D:/D_Other/test.txt");
//			fin = new FileInputStream(file);
			
			int c; //�о�� �����͸� ������ ����
			while((c=fin.read()) != -1) {
				//�о�� �����͸� ȭ�鿡 ����ϱ�
				System.out.print((char)c);
			}
			fin.close(); //��Ʈ���ݱ�
			
		} catch (IOException e) {
//			e.printStackTrace();
			System.out.println("����� �����Դϴ�.");
		}
	}
}
