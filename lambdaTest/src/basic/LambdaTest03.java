package basic;

public class LambdaTest03 {
	
	//메서드의 매개변수도 그 메서드의 지역변수이다.
	public void testMethod(final int temp) {
		final int localVar = 40;		//final을 붙여주지않아도 컴파일과정에서 해주지만 final을 붙여주는것이 좋다.
		int kor = 100;
		
		kor = 200;
		//localVar = 30;
		//temp = 80;
		//람다식 내부에서 사용되는 지역변수는 final이어어야 한다.
		//보통 final을 붙이지 않으면 컴파일러가 final을 붙여준다.
		//그렇지만 final을 붙이지 않은 변수값을 변경하면 final을 자동으로 붙여주지 않는다.
		
		
		//람다식
		LambdaTestInterface lt = ()->{
			//람다식 내부에서 지역변수 사용하기
			System.out.println("temp = " + temp);
			System.out.println("localVar = " + localVar);			
		};
		lt.test();
	}
	
	
	
	
	
	public static void main(String[] args) {
		new LambdaTest03().testMethod(50);
	}

}
