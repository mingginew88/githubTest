package basic;

import java.io.FileInputStream;
import java.io.IOException;

//File스트림을 이용한 데이터 입출력 연습

public class FileStreamTest01 {
	public static void main(String[] args) {
		FileInputStream fin = null;
		
		try {
			//읽어올 파일과 연결된 바이트 스트림 객체 생성
			//방법1
			fin = new FileInputStream("D:/D_Other/test.txt");
			
			//방법2
//			File file = new  File("D:/D_Other/test.txt");
//			fin = new FileInputStream(file);
			
			int c; //읽어온 데이터를 저장할 변수
			while((c=fin.read()) != -1) {
				//읽어온 데이터를 화면에 출력하기
				System.out.print((char)c);
			}
			fin.close(); //스트림닫기
			
		} catch (IOException e) {
//			e.printStackTrace();
			System.out.println("입출력 오류입니다.");
		}
	}
}
