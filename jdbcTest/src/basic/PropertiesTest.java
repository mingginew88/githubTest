package basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class PropertiesTest {
	
	//외부 properties파일을 읽어와 Properties객체로 처리하기
	public static void main(String[] args) {
		//읽어온 정보를 저장할 Properties객체 생성
		Properties prop = new Properties();
		
		//읽어올 파일 정보를 갖는 File객체 생성
		File file = new File("res/db.properties");
		
		try {
			//파일 읽기를 수행하기 위한 FileInputSream객체 생성
			FileInputStream fin = new FileInputStream(file);
			
			//Properties객체를 이용하여 파일 정보 읽어오기
			prop.load(fin); 	//파일 내용을 읽어와 key와 value로 분류한 후 Properties객체에 담아준다.
			
			//읽어온 정보 출력해 보기
			
			//key값만 읽어와 enumeration객체로 변환하기
			Enumeration<String> names = (Enumeration<String>) prop.propertyNames();
			
			//key값 개수만큼 반복
			while(names.hasMoreElements()){
				String key = names.nextElement();
				String value = prop.getProperty(key);
				
				System.out.println(key + " ==> " + value);
			}
			
			System.out.println("출력 끝...");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}

}
