package basic;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

//문자기반의 출력용 파일 스트림 연습

//사용자가 입력한 내용을 그대로 파일로 저장하기

public class FileWriterTest01 {
	public static void main(String[] args) {
		try {
			//콘솔(표준 입출력장치)과 연결된 입력문자 스트림 생성
			//InputStreamReader클래스 => 문자기반의 스트림을 바이트기반의 스트림으로 변환해 준다.
			InputStreamReader isr = new InputStreamReader(System.in);
			
			//출력용 문자기반 스트림 생성
			FileWriter fw = new FileWriter("D:/D_Other/testChar.txt");
			System.out.println("아무거나 입력하세요.");
			System.out.println("입력의 끝은 Ctrl + Z키 입니다.");
			
			int c;
			//콘솔에서 입력할 때 입력의 끝 표시는 Ctrl + Z 키를 누르면 된다. 그러면 read()메서드가  -1을 반환한다.
			while((c=isr.read()) != -1){
				fw.write(c);	//콘솔에서 입력받은 자료 출력하기
			}
			fw.flush();
			isr.close();
			fw.close();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
