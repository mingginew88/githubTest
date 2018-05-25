package basic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteArrayIOTest02 {
	public static void main(String[] args) {
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
		byte[] outSrc = null;
		byte[] temp = new byte[4];
		
		//����¿� ��Ʈ�� ��ü ���� �� ����
		ByteArrayInputStream input = new ByteArrayInputStream(inSrc);
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		
		try {
			while(input.available() > 0){		//available()�޼��� - �о�ü� �ִ� byte���� ��ȯ���ش�.
//				input.read(temp);		//�迭 ũ�⸸ŭ�� �о�� �迭�� �����Ѵ�.
//				output.write(temp); 	//�迭�� ��ü�� ����Ѵ�.
				
				int len = input.read(temp);		//���� �о�� byte���� ��ȯ
				//temp�迭�� �����߿��� 0��°���� len�� ������ŭ �����Ѵ�.
				output.write(temp,0,len);
				System.out.println("temp => " + Arrays.toString(temp));
			}
			
			outSrc = output.toByteArray();
			
			
			
			System.out.println("inSrc => " + Arrays.toString(inSrc));
			System.out.println("outSrc => " + Arrays.toString(outSrc));
			
			input.close();
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
