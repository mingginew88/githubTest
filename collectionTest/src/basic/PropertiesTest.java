package basic;

import java.util.Properties;

public class PropertiesTest {
	/*
	 	Properties는 Map보다 축소된 기능의 객체라고 할 수 있다.
	 	
	 	Map은 모든 형태의 데이터를 key와 value값으로 넣을 수 있지만
	 	Properties는 key와 value값으로 String만 사용할 수 있다.
	 	
	 	Map은 put, get 메서드를 이용하여 데이터를 입출력하지만
	 	Properties는 setProperty, getProperty 메서드를 이용한다.
	 */
	public static void main(String[] args) {
		Properties prop = new Properties();
		
		prop.setProperty("name", "일지매");
		prop.setProperty("tel", "010-2222-2222");
		prop.setProperty("address", "원주");
		
		String name = prop.getProperty("name");
		String tel = prop.getProperty("tel");
		String address = prop.getProperty("address");
		
		System.out.println("name : " + name);
		System.out.println("tel : " + tel);
		System.out.println("address : " + address);
		
		
	}
}
