package singleton;

public class SingletonTest {
	public static void main(String[] args) {
		// 오류(생성자가 private이라 외부에서 new명령을 사용하지 못한다.
//		MySingleton sss1 = new MySingleton();
		
		MySingleton sss2 = MySingleton.getInstance();
		MySingleton sss3 = MySingleton.getInstance();
		MySingleton sss4 = MySingleton.getInstance();
		
		
		//참조값이 동일하다. 하나의 인스턴스를 가리킨다.
		System.out.println("sss2 =" + sss2);
		System.out.println("sss3 =" + sss3);
		System.out.println("sss4 =" + sss4);
		
		sss2.printScreen();
		
	}

}
