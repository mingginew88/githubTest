package singleton;

/*
	singleton 패턴 클래스
		- 외부에서 new를 사용하지 않고 동일한 객체를 반환시키기 위한 클래스
		(즉, 인스턴스가 하나만 만들어지는 클래스)
		
	singleton 클래스를 구성하는 방법
	    - 외부에서 new명령을 사용하지 못한다.
	    (방법 : 생성자 함수에 접근하지 못하도록 한다.)
	    1. 자기자신의 참조값을 저장하는 멤버변수를 만든다.
	      (private static으로 지정한다.)
	    
	    2. 생성자의 접근제한자를 private으로 한다.
	      
	    3. 외부에서 참조값을 얻을 수 있는 메서드를 작성한다.
	      (보통 메서드명은 getInstance()로 하고 이 메서드는 public static으로 지정한다.)	 
 */


//주석처리해둔 3가지는 필수요소이다. 
public class MySingleton {
	//1) 자기 자신의 참조값을 저장할 수 있는 변수 선언
	private static MySingleton single = new MySingleton();
	
	//2) private생성자 작성
	private MySingleton(){
		System.out.println("싱글톤 객체 생성자입니다.");
	}
	
	//3) 외부에서 참조값을 얻어갈 수 있는 메서드작성
	//(이 메서드의 반환값이 현재 클래스의 참조값이어야 된다.)
	public static MySingleton getInstance(){
		if(single == null){
			single = new MySingleton();
		}
		return single;
	}	
	
	
	//기타 사용할 메서드나 멤버변수들을 지정하여 사용한다.
	public void printScreen(){
		System.out.println("싱글톤의 인스턴스 메서드입니다.");
	}
	
	
}











