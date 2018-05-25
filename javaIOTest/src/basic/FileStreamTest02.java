package basic;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileStreamTest02 {
	public static void main(String[] args) {
		try {
			//출력용 스트림 객체 생성
			FileOutputStream fout = new FileOutputStream("D:/D_Other/out.txt");
			
			for (char i = 'A'; i <= 'Z'; i++) {
				fout.write(i);	//파일에 쓰기 작업
			}
			fout.close();		//작업완료후 스트림 닫기
			System.out.println("출력 작업 완료");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
