package e_oop;

public class InitTest {
	
	public static void main(String[] args) {
		
		System.out.println(Init.action);
		//클래스 초기화 한다음에 클래스초기화블럭
		Init it = new Init();
		System.out.println(it.action2);
		//인스턴스의 경우에는 초기화를 하고 초기화블럭을 만나고 생성자를 통해 초기화를 한다.
	}
}

class Init{
	
	static int action;
	int action2 = 10;	//명시적 초기화
	
	Init(){		//생성자를 이용한 초기화
		action2 = 4;
	}
	
	static {		//클래스 초기화 블럭
		action = 30;
	}
	
	{		//인스턴스 초기화블럭
		action2 = 17;
	}
	
	
}