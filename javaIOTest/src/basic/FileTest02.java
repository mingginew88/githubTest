package basic;

import java.io.File;

public class FileTest02 {
	public static void main(String[] args) {
		//디렉토리(폴더) 만들기 예제
		/*
		 1. mkdir() ==> File객체의 경로 중 마지막 위치의 디렉토리를 만들어 준다.
		 				중간의 경로가 모두 미리 만들어져 있어야 마지막 위치의 디렉토리를 만들 수 있다.
		 				(반환값 : 만들기 성공(true), 실패(false))
		 
		 2. mkdirs() ==> File객체의 경로 중 마지막 위치의 디렉토리를 만들어 준다.
		 				중간의 경로가 없으면 중간의 경로도 모두 만들어 준 후에 마지막 위치의 디렉토리를 만들어준다.
		 */
		
//		File file1 = new File("D:/D_Other/연습용");
//		if(file1.mkdir()){
//			//성공 했을 때 처리내용
//			System.out.println(file1.getName() + "폴더 만들기 성공");
//		}else{
//			//만들기 실패했을 때 처리내용
//			System.out.println(file1.getName() + "폴더 만들기 실패");
//		}
//		System.out.println();
//		
//		
//		File file2 = new File("D:/D_Other/test/java/src");
//		if(file2.mkdirs()){
//			//성공 했을 때 처리내용
//			System.out.println(file2.getName() + "만들기 성공");
//		}else{
//			//만들기 실패했을 때 처리내용
//			System.out.println(file2.getName() + "만들기 실패");
//		}
//		System.out.println();
		
		
		//==================================================================
		
		File file3 = new File("D:/D_Other/연습용");
		File file4 = new File("D:/D_Other/test.txt");
		
		if(file3.exists()){		//해당 파일이나 디렉토리가 실제 있으면 true
			System.out.println(file3.getPath() + "은 존재합니다.");
			if(file3.isFile()){
				System.out.println("이것은 파일입니다.");
			}else if(file3.isDirectory()){
				System.out.println("이것은 폴더입니다.");
			}
		}else{
			System.out.println(file3.getAbsolutePath() + "은 없습니다.");
			if(file3.mkdir()){
				System.out.println("폴더 만들기 성공");
			}else{
				System.out.println("폴더 만들기 실패");
			}
		}
		
		
		
		
		
		
		
	}

}
