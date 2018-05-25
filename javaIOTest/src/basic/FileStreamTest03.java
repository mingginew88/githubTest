package basic;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/*
	한글이 저장된 파일 읽어오기
	(한글의 인코딩을 지정해서 읽어온다.)
*/

public class FileStreamTest03 {

	public static void main(String[] args) {
		try {
			FileInputStream fin1 = new FileInputStream("D:/D_Other/test_ansi.txt");
			
			FileInputStream fin2 = new FileInputStream("D:/D_Other/test_utf8.txt");
			// 바이트 기반 스트림을 문자기반 스트림으로 변환해 주는 보조스트림 => InputStreamReader(입력), OutputStreamWriter(출력)
			
			/*
			InputStreamReader객체는 파일의 인코딩 방식을 지정할 수 있다.
				- MS949 => 윈도우의 기본 한글 인코딩 방식(ANSI방식)
				- UTF-8 => 유니코드 utf-8 인코딩 방식
				- US-ASCII => 영문 전용 인코딩 방식
			*/
			
			
			// 보조스트림 객체를 생성할 때는 기반이 되는 스트림을 생성자의 매개값으로 넣어서 생성해야 한다.
//			InputStreamReader isr = new InputStreamReader(fin1);
//			InputStreamReader isr = new InputStreamReader(fin2);
			
			// 인코딩 방식을 지정해서 객체 생성
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
