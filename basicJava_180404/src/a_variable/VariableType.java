package a_variable;

public class VariableType {
	public static void main(String[] args) {
		/*
		 1. 변수의 타입
		   - 기본형 타입(primitive type)
		   	 : boolean, char, byte, short, int, long, float, double
		   	 : 값(리터럴)을 저장한다.
		   - 참조형 타입(reference type)
		     : 기본형 8가지를 제외한 나머지 타입
		     : 주소를 저장한다.
		     
		 2. 기본형 타입
		   - 종류
		     : 논리형 => true, false 중 하나의 값을 가지며 조건식과, 논리적 계산에 사용된다.
		     			ex) boolean
		     : 문자형 => 문자 하나를 저장하는데 사용된다. ex) char
		     : 정수형 => 정수값을 저장하는데 사용한다. ex) byte, short, int, long
		     : 실수형 =>	실수값을 저장하는데 사용한다. ex) float, double
		     
		   - 변수의 크기(1byte = 8bit)
		     : 1byte => boolean, byte 
		     : 2byte => char, short
		     : 4byte => int, float
		     : 8byte => long, double
		 
		  3. 논리형 - boolean(기본값 false)
		  	- boolean형 변수는 true, false 중 하나의 값만을 저장할 수 있다.
		 	  ex) boolean a = true;
		 	- boolean형 변수는 대답(Yes, No), 스위치(On/Off)등의 논리구현에 주로 사용된다.  
		 
		  4. 문자형 - char(기본값 ' ', '\u0000')
		  	- java는 Unicode문자 체계를 가지고 있기 때문에 2byte의 크기를 가진다.
		  	  ex) 'A' '\u0041'
		  	  	   char c = 'A';
				   char c1 = '\u0041';
		  
		  5. 정수형 = byte(0) short(0) int(0) long(0L)
		    - 기본 자료형은 int이다
		    - 변수에 저장하려는 정수값의 범위에 따라 4개의 정수형중에 하나를 선택해야 한다.
		    - byte, short의 경우 크기가 작아서 범위를 넘어선 잘못된 결과를 얻기 쉽다.
		               그래서 기본 자료형인 int형을 사용하는 것이 좋다.
		    - JVM의 피연산자를 4byte단위로 저장을 하기 때문에 4byte형보다 작은 자료형은 4byte형으로 바꾸어 계산한다.
		    
		    -오버플로우(overflow)
		 
		 */
		
		byte b = 127;
		short s = 20;
		int i2 = 30;
		long l = 8801151111111L;
		float p = 2.414F;
		double k = 2.415;
		
		/*
		  6. 실수형 - float(0.0F), double(0.0)
		    - 실수값을 저장하는데 사용한다.
		    - float : 1 + 8 + 23
		      double : 1 + 11 + 52
		    - 실수형 중 사용할 자료형을 선택할때 값의 범위 뿐만 아니라 정밀도도 중요한 요소가 된다.
		 
		 */
		
		float f = 1.234123987534f;
		double d = 1.234123987534;
		
		System.out.println(f);
		System.out.println(d);
		
		
		/*
		  7. String
		    - 문자열을 다루기 위해 사용한다.
		    - 값의 길이의 제한이 없다.
		 */
		
		String str = null;  //참조형의 기본값은 null(아직 주소가 만들어지지않았다)
		str = "하이 Hello 안녕";
		System.out.println(str);
		
		String aa = "7" + "하이";
		System.out.println(aa);
		
		String aa2 = 7 + 7 + "Hello";
		System.out.println(aa2);
		
		String aa3 = "Hello" + 7 + 7;
		System.out.println(aa3);
		
		char cc = '\u0041';
		String aa4 = "=================\t=================\n=================\t=================";
		System.out.println(aa4);
		
		System.out.println("abc" + true); // abctrue
		
		/*
		  8. 오버플로우(overflow)
		    - 변수자신이 저장할 수 있는 범위를 넘었을때 최소값부터 다시 표현하는 현상
		    - 변수에 저장되는 값의 범위를 넘는 값으로의 초기화는 허용하지 않는다.		  		  
		 */
		
		byte bb = 126;
		System.out.println(bb); //126
		bb++;
		System.out.println(bb); //127
		bb++;
		System.out.println(bb); // 자신이 표현할수 있는 수를 넘어가면 자신이 표현할수있는 가장 작은 수로 돌아간다.
		bb++;
		System.out.println(bb); // -127
		
		/*
		  9. 형변환(casting)
		    - 변수 또는 리터럴의 타입을 다른 타입으로 변환하는 것이다.
		    
		    byte -> short -> int -> long -> float -> double
		    				  ^
		    				  |
		    		char------
		    
		 */
		
		byte b8 = 10;
		short s8 = 200;
		int i8 = 50000;
		long l8 = 4000000000L;
		char c9 = 'A';  // \u0041
		
		int i9 = b8; // (타입) : 캐스트연산자
		short s9 = (short)i8; //  
		System.out.println(s9);
		int i10 = (int)c9;
		System.out.println(i10);
		
		float f8 = 3.141592F;
		int i11 = (int)f8;  //3
		System.out.println(i11);
	}

}
