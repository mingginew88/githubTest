package javaiotest;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class JavaIOTest03 {
	public static void main(String[] args) {
		 try {
			 FileOutputStream fos = new FileOutputStream("D:/D_Other/bufferTest.txt");
			 
			 BufferedOutputStream bos = new BufferedOutputStream(fos);
			 
			 for (int i = '1'; i <= '9'; i++) {
				bos.write(i);
			}
			 bos.flush();
			 bos.close();
			 System.out.println("ÀÛ¾÷ ³¡.");		 
			 
		} catch (IOException e) {
		}
		
		 
		 try {
			FileReader fr = new FileReader("./src/basic/ByteArrayIOTest01.java");
			BufferedReader br = new BufferedReader(fr);
			
			String temp = "";
			for (int i = 0; (temp = br.readLine())!= null ; i++) {
				System.out.printf("%4s : %s\n", i , temp);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 	 
	}

}
