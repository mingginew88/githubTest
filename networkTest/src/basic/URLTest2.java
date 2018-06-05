package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class URLTest2 {
	
	//URLConnection클래스 ==> 어플리케이션과 URL간의 통신 연결을 위한 추상클래스
	
	//특정 서버의 정보와 파일 내용 출력하기
	public static void main(String[] args) throws IOException {
		URL url = new URL("https://www.naver.com/index.html");
		
		//URLConnection객체 구하기
		URLConnection urlCon = url.openConnection();
		
		System.out.println("Header 정보 출력");
		System.out.println("--------------");
		System.out.println();
		//Header정보 구하기
		Map<String, List<String>> headerMap = urlCon.getHeaderFields();
		
		//Header의 키값 구하기
		Iterator<String> it = headerMap.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next(); // 키값 얻기
			
			// 키값과 키값에 설정된 값 출력
			System.out.println(key + " ==> " + headerMap.get(key));
		}
		
		System.out.println("===================================================");
		
		//해당 호스트의 문서 내용 가져오기(index.html문서)
		/*
		//방법1 ==> URLConnection객체의 getInputStream() 이용하기
		
		//파일을 읽어오기 위한 스트림 생성
		InputStream is = urlCon.getInputStream();
		InputStreamReader isr = new InputStreamReader(is, "utf-8");
		BufferedReader br = new BufferedReader(isr);
		
		//내용출력
		while(true) {
			String str = br.readLine();
			if(str==null) { //끝까지 읽었는지 확인
				break;
			}
			
			System.out.println(str);
		}
		
		//스트림 닫기
		br.close();
		*/
		
		//---------------------------------------------
		//방법2 ==> URL객체의 openStream() 이용하기
		InputStream is = url.openStream();
		InputStreamReader isr = new InputStreamReader(is, "utf-8");
		BufferedReader br = new BufferedReader(isr);
		
		//내용출력
		while(true) {
			String str = br.readLine();
			if(str==null) { //끝까지 읽었는지 확인
				break;
			}
			
			System.out.println(str);
		}
		
		//스트림 닫기
		br.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
