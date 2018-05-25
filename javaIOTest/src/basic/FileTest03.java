package basic;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/*
	지정된 폴더의 전체 내용을 출력하는 예제
 */

public class FileTest03 {
	public static void main(String[] args) {
		
		File testFile = new File("D:/D_Other");
		displayFileList(testFile);
		
	}
	
	
//지정된 폴더(디렉토리)에 포함된 파일과 디렉토리 목록을 보여주는 메서드
	public static void displayFileList(File dir){
		System.out.println("[" + dir.getAbsolutePath() +"] 디렉토리 내용");
		
		File[] files = dir.listFiles();		//디렉토리 안의 모든 파일 목록 읽어오기
		
		//파일 목록중 '폴더'의 index값이 저장될 List
		ArrayList<Integer> subList = new ArrayList<Integer>();
		
		//날짜 형식 설정
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd a HH:mm");
		
		for (int i = 0; i < files.length; i++) {
			String attr = "";		//파일 속성을 저장할 변수(읽기, 쓰기, 히든, 디렉토리)
			String size = "";		//파일 크기를 문자열로 저장할 변수
			
			if(files[i].isDirectory()){
				attr = "<DIR>";
				subList.add(i);		//하위 디렉토리의 인덱스값을 list에 추가
			}else{
				size = files[i].length() + "";
				attr = files[i].canRead() ? "R" : "";
				attr += files[i].canWrite() ? "W" : "";
				attr += files[i].isHidden() ? "H" : "";
			}
			System.out.printf("%s %5s %12s %s\n", df.format(new Date(files[i].lastModified())), attr, size, files[i].getName());
		}//for
		
		int dirNum = subList.size();		//하위 디렉토리 개수 구하기
		int fileNum = files.length - dirNum;		//파일 개수만 구하기
		
		System.out.println(fileNum + "개의 파일," + dirNum + "개의 디렉토리");
		System.out.println();
		
		//재귀호출을 이용해서 하위 폴더의 정보도 읽어온다.
		for (int i = 0; i < subList.size(); i++) {
			displayFileList(files[subList.get(i)]); 		//재귀 호출
		}
	}
}


//컴퓨터 안에서 사용되는 프로그램을 기준으로 데이터가 오느냐(입력) 가느냐(출력)로 구분한다. 


