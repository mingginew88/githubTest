package basic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteArrayIOTest01 {
	public static void main(String[] args) {
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
		byte[] outSrc = null;
		
		//����¿� ��Ʈ�� ��ü ���� �� ����
		ByteArrayInputStream input = null;
		ByteArrayOutputStream output = null;
		
		input = new ByteArrayInputStream(inSrc);
		output = new ByteArrayOutputStream();
		
		int data;//�о�� �ڷḦ ������ ����
		
		//read()�޼���� ���̻� �о�� �ڷᰡ ������  -1�� ��ȯ�Ѵ�.
		while ( (data = input.read()) != -1 ){
			//�о�� �ڷ�� data������ ����Ǿ� �ְ�,
			//�� ������ ����ϴ� �κ��� �̰��� ����ϸ� �ȴ�.
			output.write(data); 	//����ϱ�
		}
		
		//��µ� ��Ʈ������ �迭�� ��ȯ�Ѵ�.
		outSrc = output.toByteArray();
		
		try {
			input.close();	//����� ���� ��Ʈ�� �ݱ�
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("inSrc=> " + Arrays.toString(inSrc));
		System.out.println("outSrc=> " + Arrays.toString(outSrc));		
		
	}
}
