package h_javaLang;

public class WrapperTest {
	public static void main(String[] args) {
		
		Integer i1 = new Integer(100);
		Integer i2 = new Integer(100);
		
		System.out.println(i1 == i2);	//false
		System.out.println(i1.equals(i2));	//true  equals메서드가 오버라이드 되서 값을 비교함
		
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE);
		
		System.out.println(Integer.SIZE); // 비트수
		System.out.println(Byte.SIZE);
		//BYTES => byte수
		
		
	
		
	}

}

