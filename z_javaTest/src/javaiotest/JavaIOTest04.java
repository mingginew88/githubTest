package javaiotest;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class JavaIOTest04 {
	public static void main(String[] args) {
		byte[] insrc = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		byte[] outsrc = null;
		
		ByteArrayInputStream bis = null;
		ByteArrayOutputStream bos = null;
		
		bis = new ByteArrayInputStream(insrc);
		bos = new ByteArrayOutputStream();
		
		int data;
		
		while ((data = bis.read()) != -1){
			bos.write(data);
		}
		
		outsrc = bos.toByteArray();
		
		try {
			bis.close();
			bos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(Arrays.toString(insrc));
		System.out.println(Arrays.toString(outsrc));
	}

}
