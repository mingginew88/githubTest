package basic;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

//���ڱ���� ��¿� ���� ��Ʈ�� ����

//����ڰ� �Է��� ������ �״�� ���Ϸ� �����ϱ�

public class FileWriterTest01 {
	public static void main(String[] args) {
		try {
			//�ܼ�(ǥ�� �������ġ)�� ����� �Է¹��� ��Ʈ�� ����
			//InputStreamReaderŬ���� => ���ڱ���� ��Ʈ���� ����Ʈ����� ��Ʈ������ ��ȯ�� �ش�.
			InputStreamReader isr = new InputStreamReader(System.in);
			
			//��¿� ���ڱ�� ��Ʈ�� ����
			FileWriter fw = new FileWriter("D:/D_Other/testChar.txt");
			System.out.println("�ƹ��ų� �Է��ϼ���.");
			System.out.println("�Է��� ���� Ctrl + ZŰ �Դϴ�.");
			
			int c;
			//�ֿܼ��� �Է��� �� �Է��� �� ǥ�ô� Ctrl + Z Ű�� ������ �ȴ�. �׷��� read()�޼��尡  -1�� ��ȯ�Ѵ�.
			while((c=isr.read()) != -1){
				fw.write(c);	//�ֿܼ��� �Է¹��� �ڷ� ����ϱ�
			}
			fw.flush();
			isr.close();
			fw.close();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
