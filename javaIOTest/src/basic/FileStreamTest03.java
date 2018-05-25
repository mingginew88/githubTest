package basic;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/*
	�ѱ��� ����� ���� �о����
	(�ѱ��� ���ڵ��� �����ؼ� �о�´�.)
*/

public class FileStreamTest03 {

	public static void main(String[] args) {
		try {
			FileInputStream fin1 = new FileInputStream("D:/D_Other/test_ansi.txt");
			
			FileInputStream fin2 = new FileInputStream("D:/D_Other/test_utf8.txt");
			// ����Ʈ ��� ��Ʈ���� ���ڱ�� ��Ʈ������ ��ȯ�� �ִ� ������Ʈ�� => InputStreamReader(�Է�), OutputStreamWriter(���)
			
			/*
			InputStreamReader��ü�� ������ ���ڵ� ����� ������ �� �ִ�.
				- MS949 => �������� �⺻ �ѱ� ���ڵ� ���(ANSI���)
				- UTF-8 => �����ڵ� utf-8 ���ڵ� ���
				- US-ASCII => ���� ���� ���ڵ� ���
			*/
			
			
			// ������Ʈ�� ��ü�� ������ ���� ����� �Ǵ� ��Ʈ���� �������� �Ű������� �־ �����ؾ� �Ѵ�.
//			InputStreamReader isr = new InputStreamReader(fin1);
//			InputStreamReader isr = new InputStreamReader(fin2);
			
			// ���ڵ� ����� �����ؼ� ��ü ����
			InputStreamReader isr = new InputStreamReader(fin1, "MS949");
//			InputStreamReader isr = new InputStreamReader(fin2, "UTF-8");
			
			int c;
			while((c=isr.read())!=-1){
				System.out.print((char)c);
			}
			
			isr.close();
			
		} catch (IOException e) {
		}

	}

}
