package javaiotest;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class JavaIOTest05 {
	public static void main(String[] args) {
		try {
			FileOutputStream fos = new FileOutputStream("D:/D_Other/test.dat");
			DataOutputStream dos = new DataOutputStream(fos);
			
			dos.writeInt(200);
			dos.writeFloat(3.141592f);
			dos.writeBoolean(false);
			dos.writeUTF("문자열");
			
			System.out.println("작업 끝");
			
			dos.close();
			
			FileInputStream fis = new FileInputStream("D:/D_Other/test.dat");
			DataInputStream dis = new DataInputStream(fis);
			System.out.println(dis.readInt());
			System.out.println(dis.readFloat());
			System.out.println(dis.readBoolean());
			System.out.println(dis.readUTF());
			
			dis.close();			
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
