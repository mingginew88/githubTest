package basic;

import java.io.FileReader;
import java.io.IOException;

//���ڱ���� ���� �Է� ��Ʈ�� ����
public class FileReaderTest01 {
	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("D:/D_Other/test.txt");
			
			int c;
			
			while( (c=fr.read())!=-1 ){
				System.out.print((char)c);
			}
			fr.close();
		} catch (IOException e) {
		}
	}
}
