package z_exam;

public class Exam_02 {
	public static void main(String[] args) {
		// 12번제외

		/*
		  [2-1] 다음 표의 빈 칸에 8개의 기본형(primitive type)을 알맞은 자리에 넣으시오. 
		  	크 기    1 byte     2byte     4 byte     8 byte
		  종 류 
		  논리형  	 		  boolean
		  문자형   	char
		  정수형   	byte	   short	  int		 long
		  실수형	 					     float		double
		
		// boolean의 기본값은 false
		// char의 기본값은 ' ' 또는 '\u0041'
		// byte, short, int의 기본값은 0, long의 기본값은 0L
		// float의 기본값은 0.0f, double의 기본값은 0.0
		
	
		  [2-2] 주민등록번호를 숫자로 저장하고자 한다. 이 값을 저장하기 위해서는 어떤 자료형
			(data type)을 선택해야 할까? regNo라는 이름의 변수를 선언하고 자신의 주민등록번호로
			초기화 하는 한 줄의 코드를 적으시오.
			
			long regNo; // regNo라는 변수 선언
			regNo = 8801151111111L;  // 변수의 초기화
			// long(정수를 표현하는 8바이트=64비트)타입은 (-2에 63제곱 ~ 2에 63제곱 -1)의 범위만큼 표현가능

		*/
	
//		long regNo; // regNo라는 변수 선언
//		regNo = 8801151111111L;  // 변수의 초기화
//		System.out.println(regNo);
		
		/* 		  
	  [2-3] 다음의 문장에서 리터럴, 변수, 상수, 키워드를 적으시오.
			int i = 100;
			long l =100L;
			final float PI = 3.14f;
			
			- 리터럴 : 100, 100L, 3.14f
			- 변수 : i, l
			- 키워드 : int, long, final, float
			- 상수 : PI
				
							
	  [2-4] 다음 중 기본형(primitive type)이 아닌 것은? b
			a. int
			b. Byte   //byte로 쓴다. 기본형 8가지는 소문자 
			c. double
			d. boolean
		  
		  
	  [2-5] 다음 문장들의 출력결과를 적으세요. 오류가 있는 문장의 경우, 괄호 안에 ‘오 류’라고 적으시오.
	  		System.out.println(“1” + “2”) → ( ) // 12
	  		System.out.println(true + “”) → ( ) // true는 예약어이지만 뒤에 ""로 인해 String(문자열)로 인식된다.
	  		System.out.println('A' + 'B') → ( ) // 65+66=131 'A'는 65, 'B'는 66 
	  											// 아스키코드
	  		System.out.println('1' + 2) → ( )   // 49+2=51  '1'은 49 
	  		System.out.println('1' + '2') → ( ) // 49+50=99 '1'은 49, '2'는 50 
	  		System.out.println('J' + “ava”) → ( ) // JAVA 문자와 문자열을 더하면 문자열로 인식된다. 
	  		System.out.println(true + null) → ( ) // true는 예약어이기에 사용할수 없다. 
		*/ 
		
// 		System.out.println("1" + "2");
// 		System.out.println(true + "");
// 		System.out.println('A' + 'B');
// 		System.out.println('1' + 2);
// 		System.out.println('1' + '2');
// 		System.out.println('J' + "ava");
 		//System.out.println(true + null);
		  		
		 /* 		
		  [2-6] 다음 중 키워드가 아닌 것은? (b, c, d, e)  
			a. if
			b. True   // true가 키워드
			c. NULL   // null이 키워드
			d. Class  // class가 키워드
			e. System		
		       
		  		
		  [2-7] 다음 중 변수의 이름으로 사용할 수 있는 것은? (a, d, e, g)
			a. $ystem
			b. channel#5	// 특수문자는 '_'와 '$'만 사용가능하다 (규칙)
			c. 7eleven      // 숫자를 첫글자로 사용할수없다. (규칙)
			d. If
			e. 자바           // 한글은 사용하지않는다. (약속)
			f. new          // 예약어는 사용할 수없다. (규칙)
			g. $MAX_NUM		
			h. hello@com	// 특수문자는 '_'와 '$'만 사용가능하다 (규칙)	
		  		
		  		
		  [2-8] 참조형 변수(reference type)와 같은 크기의 기본형(primitive type)은? (a, d)
			a. int
			b. long
			c. short
			d. float
			e. double	
	  		// 참조형변수의 기본형은 4바이트(주소저장)	
		  		
		  [2-9] 다음 중 형변환을 생략할 수 있는 것은? (d, e)
			byte b = 10;
			char ch = 'A';
			int i = 100;
			long l = 1000L;
			
			a. b = (byte)i;           // 변수 i는 int타입을 사용하고 있어서 byte로 형변환시에 생략 불가능
			b. ch = (char)b;		  // 변수 b는 byte타입을 사용하고 있어서 char로 형변환시에 생략 불가능 
			c. short s = (short)ch;   // 변수 ch는 char타입을 사용하고 있어서 short으로 형변환시에 생략 불가능
			d. float f = (float)l;    // 변수 l은 long타입을 사용하고 있어서 float으로 형변환시에 생략 가능
			e. i = (int)ch;			  // 변수 ch는 char타입을 사용하고 있어서 int로 형변환시에 생략 가능
	  		
	  		byte -> short -> int -> long -> float -> double 순으로 변형할 때 형변환을 생략할수 있다
	  						 ^
	  		char ------------|
		  
		  		
		  [2-10] char타입의 변수에 저장될 수 있는 정수 값의 범위는? (10진수로 적으시오)
		  
			//char타입은 2바이트(16비트)를 쓸 수 있는 문자형이다.
			//문자형이기 때문에 맨앞에 부호를 쓸 필요가 없어서 (0 ~ 2에 16제곱 -1만큼)이 char타입의 변수에 저장 가능한 정수 범위다.
		  		
		  	
		  [2-11] 다음중 변수를 잘못 초기화 한 것은? (a, b, c, d)
			a. byte b = 256;		// byte의 범위를 넘어서서 오버플로우 되는경우
			b. char c = '';			// char타입의 기본형은 ' ' 이거나 '\u0000' 이다.
			c. char answer = 'no';  // char타입은 한글자를 쓸수있어서 String answer = "no";
									// 또는 boolean answer = no; 로 사용가능하다.
			d. float f = 3.14		// float타입은 실수형의 기본형이 아니기 떄문에 3.14f;로 사용한다.
			e. double d = 1.4e3f;	// double타입은 실수형의 기본형이기때문에  1.4e에 3제곱으로 쓴다.	
	  		
		  
		  [2-13] 다음 중 타입과 기본값이 잘못 연결된 것은? (c, e)
			a. boolean - false
			b. char - '\u0000'   // 또는 ' ' 가능
			c. float - 0.0		 // 0.0f로 표현한다.
			d. int - 0			 // byte, short, int는 0이 기본값
			e. long - 0			 // 0L로 표현한다.
			f. String - ""       // null (주소가존재하지않는다)
		 */			
		 		
	}

}
