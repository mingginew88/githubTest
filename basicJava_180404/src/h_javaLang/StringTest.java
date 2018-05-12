package h_javaLang;

public class StringTest {
	public static void main(String[] args) {
		String str = "abc";
		String str2 = "abc";		//리터럴
		
		System.out.println(str == str2);
		System.out.println(str.equals(str2));
		
		String str3 = new String("abc");
		String str4 = new String("abc");	//주소
		
		System.out.println(str3 == str4);
		System.out.println(str3.equals(str4));		//오버라이드해서 값을 비교하게끔 
		
	}

}
