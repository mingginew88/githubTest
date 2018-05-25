package javaiotest;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class JavaIOTest01 {
	public static void main(String[] args) {
		//File객체 생성
		//new File(String 파일또는 경로)
		
		File file = new File("D:/D_Other");
		
		System.out.println(file.getName());
		System.out.println(file.isFile());
		System.out.println(file.isDirectory());
		System.out.println();
		
		File file2 = new File(file, "test.txt");
		System.out.println(file2.getName());
		System.out.println("파일? : " + file2.isFile());
		System.out.println("디렉토리? : " + file2.isDirectory());
		System.out.println("파일의 크기 : " + file2.length());
		System.out.println();
		
		
		//디렉토리(폴더) 생성
		File file3 = new File("D:/D_Other/연습용");
		if(file3.mkdir()){
			//성공 했을 때 처리내용
			System.out.println(file3.getName() + "폴더 만들기 성공");
		}else{
			//만들기 실패했을 때 처리내용
			System.out.println(file3.getName() + "폴더 만들기 실패");
		}
		System.out.println();
		
		
		File file4 = new File("D:/D_Other/test/java/src");
		if(file4.mkdirs()){
			//성공 했을 때 처리내용
			System.out.println(file4.getName() + "만들기 성공");
		}else{
			//만들기 실패했을 때 처리내용
			System.out.println(file4.getName() + "만들기 실패");
		}
		System.out.println();
		
		File file5 = new File("D:/D_Other/연습용");		
		
		if(file5.exists()){		//해당 파일이나 디렉토리가 실제 있으면 true
			System.out.println(file5.getPath() + "은 존재합니다.");
			if(file5.isFile()){
				System.out.println("이것은 파일입니다.");
			}else if(file5.isDirectory()){
				System.out.println("이것은 폴더입니다.");
			}
		}else{
			System.out.println(file5.getAbsolutePath() + "은 없습니다.");
			if(file5.mkdir()){
				System.out.println("폴더 만들기 성공");
			}else{
				System.out.println("폴더 만들기 실패");
			}
		}
		
		
		File testFile = new File("D:/D_Other");
		displayFileList(testFile);
		//지정된 폴더의 전체내용 출력	
		
	}
	
	public static void displayFileList(File dir){
		System.out.println("[" + dir.getAbsolutePath() + "]");
		
		File[] files = dir.listFiles();
		
		ArrayList<Integer> subList = new ArrayList<Integer>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH:mm");
		
		for (int i = 0; i < files.length; i++) {
			String attr = "";
			String size = "";
			
			if(files[i].isDirectory()){
				attr = "<DIR>";
				subList.add(i);
			}else{
				size = files[i].length() + "";
				attr = files[i].canRead() ? "R" : "";
				attr += files[i].canWrite() ? "W" : "";
				attr += files[i].isHidden() ? "H" : "";
			}
			System.out.printf("%s %5s %12s %s\n", sdf.format(new Date(files[i].lastModified())), attr, size, files[i].getName());
		}
		
		int dirNum = subList.size();
		int fileNum = files.length - dirNum;
		
		System.out.println(fileNum + "개의 파일, " + dirNum + "개의 디렉토리");
		System.out.println();
		
		for (int i = 0; i < subList.size(); i++) {
			displayFileList(files[subList.get(i)]);
		}
	}
}
