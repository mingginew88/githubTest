package basic;

import java.io.File;

public class FileTest01 {
	public static void main(String[] args) {
		//File객체 만들기 연습
		
		//1. new File(String 파일 또는 경로)
		//	==> 디렉토리와 디렉토리 사이 또는 디렉토리와 파일명 사이의 구분 문자는 "\\"를 사용하거나 "/"를 사용할 수 있다.
		
		File file = new File("D:\\D_Other\\test.txt");
		System.out.println(file.getName() + "은");
		System.out.println("파일? : " + file.isFile());
		System.out.println("디렉토리? : " + file.isDirectory());
		System.out.println();
		
		File file2 = new File("D:/D_Other");
		System.out.println(file2.getName() + "은");
		System.out.println("파일? : " + file2.isFile());
		System.out.println("디렉토리? : " + file2.isDirectory());
		System.out.println();
		
		//2. new File(File parent, String child)
		//		==> 'parent'디렉토리 안에 있는 'child'파일을 갖는다.
		File file3 = new File(file2, "test.txt");
		System.out.println(file3.getName() + "은");
		System.out.println("파일? : " + file3.isFile());
		System.out.println("디렉토리? : " + file3.isDirectory());
		System.out.println();
		
		//3. new File(String parent, String child)
		//		==> 'parent'디렉토리 안에 있는 'child'파일을 갖는다.
		File file4 = new File("D:/D_Other", "test.txt");
		System.out.println(file4.getName() + "은");
		System.out.println("파일? : " + file4.isFile());
		System.out.println("디렉토리? : " + file4.isDirectory());
		System.out.println();
		
		System.out.println("파일의 크기 : " + file4.length());
		System.out.println();
				
		
		
		
		
		
		
	}
}
