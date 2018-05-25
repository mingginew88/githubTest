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
		
		//입출력용 스트림 객체 선언 및 생성
		ByteArrayInputStream input = new ByteArrayInputStream(inSrc);
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		
		try {
			while(input.available() > 0){		//available()메서드 - 읽어올수 있는 byte수를 반환해준다.
//				input.read(temp);		//배열 크기만큼씩 읽어와 배열에 저장한다.
//				output.write(temp); 	//배열의 전체를 출력한다.
				
				int len = input.read(temp);		//실제 읽어온 byte수를 반환
				//temp배열의 내용중에서 0번째부터 len의 개수만큼 쓰기한다.
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
