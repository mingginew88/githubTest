package javaiotest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class JavaIOTest02 {
	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("D:/D_Other/DB���̺��ڷ�/BUYER.txt");
			int c ;
			while( (c=fr.read())!= -1 ){
				System.out.print((char)c);
			}
			fr.close();
		} catch (IOException e) {			
		}
		
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			
			FileWriter fw = new FileWriter("D:/D_Other/test.txt");
			System.out.println("�Է������  Ctrl + zŰ �Դϴ�.");
			
			int c;
			while((c=isr.read())!=-1){
				fw.write(c);
			}
			fw.flush();
			isr.close();
			fw.close();
			
		} catch (IOException e) {
		}
		
		
		try {
			File fis = new File("D:/D_Other/image.jpg");
			InputStream is = new FileInputStream(fis);
			
			int c;
			
			File fos = new File("D:/D_Other/������/image.jpg");
			OutputStream os = new FileOutputStream(fos);
			
			byte[] temp = new byte[1024];
			
			while((c=is.read(temp)) != -1){
				os.write(temp, 0, c);
			}
			System.out.println("���簡 �Ϸ�Ǿ����ϴ�.");
			is.close();
			os.close();
			
			
			
		} catch (IOException e) {
		}
		
		
		
		
		
	}
	
}
