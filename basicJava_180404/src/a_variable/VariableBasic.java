package a_variable;
/**
 * doc 주석
 * @author PC17
 *
 */
public class VariableBasic {    //클래스명  VariableBasic
	public static void main(String[] args){    //메서드명 main
		//한줄주석
		/*
		 * 여러줄 주석
		 */
		
		
		/*
		 1. 변수란?
		   - 단 하나의 값을 저장할 수 있는 공간이다.
		 */
		
		int a;  //변수의 선언
		a = 10; //변수의 초기화
		
		int b = 20; //변수의 선언 및 초기화
		
		a = 40;
		
		/*
		 명명규칙
		 변수의 이름, 메서드의 이름, 클래스의 이름 등 모든 이름을
		 짓는 대는 반드시 지켜야할 공통적인 규칙이 있다.
		 */
		
//		1. 대소문자가 구분되며 길이의 제한이 없다.
		int abc;
		int aBc;
		int dkddksixpvxcovianpdfasdfasdfsdafasdfasfzcviwrqr;
		
//		2. 예약어(keyword, reserved word)는 사용 할수 없다.
//		자주색으로 뜨는것은 예약어
		int trUe;
		
//		3. 숫자로 시작하면 안된다.
//		int 4af;
		
//		4. 특수문자는  '_', '$'만 사용 가능하다.
		int $ha_rp;
		
		
//		필수는 아니지만 자바프로그래머들의 암묵적인 약속(가독성)
//		1. 클래스의 명은 첫글자는 대문자로 써야한다.
//		2. 여러단어로 이루어진 경우에는 두번째 이후 단어의 첫글자는 대문자로 해야 한다.
//		   - lastIndexOf
//		3. 상수의 이름은 모두 대문자로 써야한다.
//		   - final int MAX_VALUE;
//		4. 한글은 사용하지 않는다.
//		   - int 요섭;

	}

}
