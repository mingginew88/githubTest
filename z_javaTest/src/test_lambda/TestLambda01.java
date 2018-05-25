package test_lambda;

public class TestLambda01 {
	
	/*
	 람다식이란
	 익명함수를 생성하기 위한 식
	 자바에서는 매개변수를 가진 코드 블럭
	 런타임시에는 익명구현객체로 생성된다.
	 
	 기본형식> 인터페이스명 변수명 = 람다식;
	 람다형식> (자료형이름 변수명, ...) ->{실행문;}
	 
	 **람다식으로 변환할 수 있는 인터페이스(함수적 인터페이스)
	 ==> 하나의 추상메서드가 선언된 인터페이스
	 
	 **람다식 사용규칙
	 
	 1. '자료형이름'을 생략할수있다.
	 (int a) -> {System.out.println(a);}
	 (a) -> {System.out.println(a);}
	 
	 2. 매개변수가 1개이면 '(' , ')' (괄호)생략 가능
	 a -> {System.out.println(a);}
	 
	 3. 실행문이 1개이면 '{'  ,  '}' 생략가능
	 a -> System.out.println(a)
	 
	 4. 매개변수가 하나도 없으면 () 생략할수 없다.
	 () -> System.out.println("hello")
	 
	 5. 반환값이 있으면 return명령을 사용한다.
	 (a, b) -> {return a+b;}
	 (a, b) -> return a+b
	 
	 6. 실행문에 return명령 1개만 사용할 경우 {}와 return명령을 생략가능
	 (a, b) -> a+b
	
	 
	 */

}
