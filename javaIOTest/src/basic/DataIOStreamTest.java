package basic;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
	자바에서 사용하는 자료형(int, float, boolean등)에 맞게
	데이터를 입출력하는 보조 스트림
	=> DataInputStream(입력), DataOutputStream(출력)
*/


public class DataIOStreamTest {

	public static void main(String[] args) {
		try {
			// 자료형에 맞게 저장하기
			FileOutputStream fout = new FileOutputStream("D:/D_Other/test.dat");
			
			DataOutputStream dos = new DataOutputStream(fout);
			
			dos.writeInt(200);			// 정수형으로 데이터 출력하기
			dos.writeFloat(3.1415f);	// 실수형으로 출력
			dos.writeBoolean(false);	// 논리형으로 출력
			dos.writeUTF("문자열");		// String형으로 출력
			
			System.out.println("출력 작업 끝...");
			System.out.println();
			
			dos.close();
			
			//===================================================
			// 출력한 자료 읽어오기
			
			FileInputStream fin = new FileInputStream("D:/D_Other/test.dat");
			DataInputStream din = new DataInputStream(fin);
			
			// 자료를 읽어오는 순서는 저장한 순서와 같은 순서로 읽어온다.
			System.out.println("정수형 자료 : " + din.readInt());
			System.out.println("실수형 자료 : " + din.readFloat());
			System.out.println("논리형 자료 : " + din.readBoolean());
			System.out.println("문자열 자료 : " + din.readUTF());
			
			din.close();

		} catch (IOException e) {
			// TODO: handle exception
		}

	}

}
