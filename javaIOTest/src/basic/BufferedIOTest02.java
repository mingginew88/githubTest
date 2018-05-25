package basic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedIOTest02 {
	public static void main(String[] args) {
		//문자 기반의 Buffered스트림 예제
		//우리가 작성한 자바 소스 파일을 읽어와 출력하기
		
		try {
			//문자 기반의 파일 입력용 스트림 생성
			
			//파일 경로를 상대 경로로 지정할 때 현재 자바파일의 위치는 '이클립스'에서는 프로젝트 폴더위치가 현재 위치가 된다.
			FileReader fr = new FileReader("./src/basic/ByteArrayIOTest01.java");
			
			BufferedReader br = new BufferedReader(fr);
			
			String temp = "";
			for (int i = 1; (temp = br.readLine()) != null ; i++) {
				System.out.printf("%4d : %s\n", i, temp);
			}			
			br.close();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
