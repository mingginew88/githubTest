package basic;

import java.util.Enumeration;
import java.util.ResourceBundle;

/*
 	ResourceBundle객체 ==> 확장자가 properties파일 정보를 읽어와 key값과 value값으로 분리해 정보를 갖고 있는 객체
 					  ==> 읽어올 파일은 'key값=value값' 형태로 되어 있어야 한다.
 */
// properties방법 보다는 resourceBundle을 더 많이 사용하는 추세이다.

public class ResourceBundleTest {
	
	//ResourceBundle객체를 이요하여 파일 정보 읽어와 출력하기
	public static void main(String[] args) {
		//ResourceBundle객체 생성
		// ==> 파일을 지정할 때는 '파일명'만 지정하고 확장자는 지정하지 않는다.( 이유 : 확장자는 항상 'properties'이기 때문이다.)
		ResourceBundle bundle = ResourceBundle.getBundle("db");
		
		//key값들만 읽어오기
		Enumeration<String> keys = bundle.getKeys();
		
		//key값 개수만큼 반복
		while(keys.hasMoreElements()){
			String key = keys.nextElement();
			
			//key값을 이용해서 value값을 구하는 방법
			//형식) bundle.getString("key값");
			String value = bundle.getString(key);
			
			System.out.println(key + " ==> " + value);
		}
		System.out.println("출력 끝...");
		
	}

}
