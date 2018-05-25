package basic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteArrayIOTest01 {
	public static void main(String[] args) {
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
		byte[] outSrc = null;
		
		//입출력용 스트림 객체 선언 및 생성
		ByteArrayInputStream input = null;
		ByteArrayOutputStream output = null;
		
		input = new ByteArrayInputStream(inSrc);
		output = new ByteArrayOutputStream();
		
		int data;//읽어온 자료를 저장할 변수
		
		//read()메서드는 더이상 읽어올 자료가 없으면  -1을 반환한다.
		while ( (data = input.read()) != -1 ){
			//읽어온 자료는 data변수에 저장되어 있고,
			//이 변수를 사용하는 부분을 이곳에 기술하면 된다.
			output.write(data); 	//출력하기
		}
		
		//출력된 스트림값을 배열로 변환한다.
		outSrc = output.toByteArray();
		
		try {
			input.close();	//사용이 끝난 스트림 닫기
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("inSrc=> " + Arrays.toString(inSrc));
		System.out.println("outSrc=> " + Arrays.toString(outSrc));		
		
	}
}
