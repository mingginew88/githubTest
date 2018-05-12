package e_oop;

public class MemberCall {

	int iv = 10;
	static int cv = 20;
	
	int iv2 = iv;
	int iv3 = cv;
	
	static int cv2 = cv;
	
//	static int cv3 = iv;  //클래스가 생성되는 시점에서 인스턴스는 아직 존재하지 않기때문에 성립되지않는다.
	
	static void staticMethod() {
		System.out.println(cv);
//		System.out.println(iv);		
	}
	
	void instanceMethod() {
		System.out.println(cv);
		System.out.println(iv);
	}
	
	
	
	

	
	
	
}
