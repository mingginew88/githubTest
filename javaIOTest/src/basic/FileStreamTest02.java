package basic;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileStreamTest02 {
	public static void main(String[] args) {
		try {
			//��¿� ��Ʈ�� ��ü ����
			FileOutputStream fout = new FileOutputStream("D:/D_Other/out.txt");
			
			for (char i = 'A'; i <= 'Z'; i++) {
				fout.write(i);	//���Ͽ� ���� �۾�
			}
			fout.close();		//�۾��Ϸ��� ��Ʈ�� �ݱ�
			System.out.println("��� �۾� �Ϸ�");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
