package basic;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
	�ڹٿ��� ����ϴ� �ڷ���(int, float, boolean��)�� �°�
	�����͸� ������ϴ� ���� ��Ʈ��
	=> DataInputStream(�Է�), DataOutputStream(���)
*/


public class DataIOStreamTest {

	public static void main(String[] args) {
		try {
			// �ڷ����� �°� �����ϱ�
			FileOutputStream fout = new FileOutputStream("D:/D_Other/test.dat");
			
			DataOutputStream dos = new DataOutputStream(fout);
			
			dos.writeInt(200);			// ���������� ������ ����ϱ�
			dos.writeFloat(3.1415f);	// �Ǽ������� ���
			dos.writeBoolean(false);	// �������� ���
			dos.writeUTF("���ڿ�");		// String������ ���
			
			System.out.println("��� �۾� ��...");
			System.out.println();
			
			dos.close();
			
			//===================================================
			// ����� �ڷ� �о����
			
			FileInputStream fin = new FileInputStream("D:/D_Other/test.dat");
			DataInputStream din = new DataInputStream(fin);
			
			// �ڷḦ �о���� ������ ������ ������ ���� ������ �о�´�.
			System.out.println("������ �ڷ� : " + din.readInt());
			System.out.println("�Ǽ��� �ڷ� : " + din.readFloat());
			System.out.println("���� �ڷ� : " + din.readBoolean());
			System.out.println("���ڿ� �ڷ� : " + din.readUTF());
			
			din.close();

		} catch (IOException e) {
			// TODO: handle exception
		}

	}

}
