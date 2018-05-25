package basic;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//�Ϲ������� ���ڱ������ ����ϵ� �׸��̳� �̷��� ���ڰ� �ƴѰ�쿡 ����Ʈ������� ����ϴ°��� �����ϴ�.

public class BufferedIOTest01 {
	public static void main(String[] args) {
		//������� ���� ����� ���� Buffered ��Ʈ���� �̿��Ѵ�.
		try {
			//��¿� ����� �Ǵ� ��Ʈ�� ����
			FileOutputStream fout = new FileOutputStream("D:/D_Other/bufferTest.txt");
			
			//������ ũ�Ⱑ 5�� ���۽�Ʈ�� ��ü ����
			//������ ũ�⸦ �������� ������ �⺻������ 8192�� �����ȴ�.
			BufferedOutputStream bout = new BufferedOutputStream(fout, 5);
			
			for (int i = '1'; i <='9'; i++) {
				bout.write(i);	//���۸� �̿��� �ڷ� ���		
			}
			bout.flush();	//�۾��� �����ϱ� ������ ���ۿ� �����ִ� �����͸� ��� ����� �־���ϴµ� �� �� flush()�޼��带 ����Ѵ�.
			
			//������ ũ�⸸ŭ �ӽ����� �Ŀ� �Ű��ֱ⶧���� ������ ũ�⺸�� �۰� �����ִ� �����ʹ� �Ű����������� �ִ�.
			//close()�� ���ؼ� �����͵��� �� ���ü��������� �ȳ����°�쵵 �����.
			//�׷��⶧���� flush()�� ����ؼ� ����־���Ѵ�.
			
			bout.close();	//��Ʈ�� �ݱ� (������Ʈ���� �ݾƵ� �ȴ�)
			System.out.println("�۾� ��...");
			
		} catch (IOException e) {
		}
	}

}
