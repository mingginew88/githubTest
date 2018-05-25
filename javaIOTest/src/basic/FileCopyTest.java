package basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopyTest {
	public static void main(String[] args) {
		
		try {
			File fis = new File("D:/D_Other/Chrysanthemum.jpg");
			InputStream is = new FileInputStream(fis);			
			
			int c;			
			
			File fos = new File("D:/D_Other/¿¬½À¿ë/Chrysanthemum.jpg");
			OutputStream os = new FileOutputStream(fos);
			
			byte[] temp = new byte[1024];
			
			while((c=is.read(temp)) != -1){
				os.write(temp, 0, c);
			}
			
			is.close();
			os.close();

		} catch (IOException e) {
		}
		
		
	}
}
