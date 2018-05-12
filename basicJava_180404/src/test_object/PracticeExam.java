package test_object;

public class PracticeExam {
	
	public static void main(String[] args) {
		
		
		 /*
	 	[2-1] 다음 표의 빈 칸에 8개의 기본형(primitive type)을 알맞은 자리에 넣으시오. 
		  	크 기    1 byte     2byte     4 byte     8 byte
		  종 류 
		  논리형  	 		  boolean
		  문자형   	char
		  정수형   	byte	   short	  int		 long
		  실수형	 		  		     float		double
		 */
		
		//boolean의 기본값은 false, char의 기본값은 ' ', '\u0041' byte short int의 기본값은 0 long은 0L float의 기본값은 0.0f double의기본값은 0.0
		
		/*
		[2-2] 주민등록번호를 숫자로 저장하고자 한다. 이 값을 저장하기 위해서는 어떤 자료형
		(data type)을 선택해야 할까? regNo라는 이름의 변수를 선언하고 자신의 주민등록번호로
		초기화 하는 한 줄의 코드를 적으시오.		
		long regNo;
		regNo = 8801151111111L;  	
		 */		
		
//		long regNo = 8801151111111L; 
//		System.out.println(regNo);
		
		/*
		[2-3] 다음의 문장에서 리터럴, 변수, 상수, 키워드를 적으시오.
		int i = 100;
		long l =100L;
		final float PI = 3.14f;
		*/
		
//		리터럴 : 100, 100L, 3.14f
//		변수 : i l PI
//		상수 : PI
//		키워드 : final, int, long, float 		
		
		/*
		[2-4] 다음 중 기본형(primitive type)이 아닌 것은? 
		a. int
		b. Byte 
		c. double
		d. boolean
		*/
		
//		Byte -> byte가 기본형이다.
		
		/*
	  	[2-5] 다음 문장들의 출력결과를 적으세요. 오류가 있는 문장의 경우, 괄호 안에 ‘오 류’라고 적으시오.
  		System.out.println(“1” + “2”) → ( ) 	//12출력
  		System.out.println(true + “”) → ( ) 	//true출력
  		System.out.println('A' + 'B') → ( ) 	//char A값 65? char B값 66 더한 131 출력  											
  		System.out.println('1' + 2) → ( )   	//char 1값 49 + 2 = 51출력
  		System.out.println('1' + '2') → ( ) 	//char 1값 49 + char2값  50  = 99출력
  		System.out.println('J' + “ava”) → ( ) 	//char형과 String형이 합쳐지면 String 형으로  Java출력
  		System.out.println(true + null) → ( ) 	//오류 예약어를 사용할 수 없다.
		*/
		
//		System.out.println("1" + "2");
//  	System.out.println(true + "");
//  	System.out.println('A' + 'B');									
//  	System.out.println('1' + 2);
//  	System.out.println('1' + '2');
//  	System.out.println('J' + "ava");
		
		
		
		/*
		[2-6] 다음 중 키워드가 아닌 것은? ()  
		a. if
		b. True   
		c. NULL   
		d. Class 
		e. System
		 */		
		
//		b true가 예약어이다. c null이 예약어이다. d class가 예약어이다. e System은 예약어가 아니다. 
		
		/*
		[2-7] 다음 중 변수의 이름으로 사용할 수 있는 것은? 
		a. $ystem		//x 특수기호는 '_'과 '$'만 사용가능하다.
		b. channel#5	//x
		c. 7eleven      //x 변수,메서드,클래스의 이름에 첫글자는 숫자가 나올수 없다.
		d. If			//O
		e. 자바          		//O 암묵적약속으로 한글은 사용하지않는다.
		f. new          //x 예약어는 사용할수 없다.
		g. $MAX_NUM		//O
		h. hello@com	//x
		*/		
		
		
		/*
		[2-8] 참조형 변수(reference type)와 같은 크기의 기본형(primitive type)은? 
		a. int
		b. long
		c. short
		d. float
		e. double	
		*/
		
//		참조형변수는 4바이트의 크기를 갖는다. 정수형 int, 실수형 float이 4바이트의 크기이다. 
		
		
		/*
		[2-9] 다음 중 형변환을 생략할 수 있는 것은? d , e
		byte b = 10;
		char ch = 'A';
		int i = 100;
		long l = 1000L;
		
		a. b = (byte)i;				//i는 인트형이고 b는 바이트이므로 형변환을 생략할수 없다.
		b. ch = (char)b;			//b는 바이트형이고 캐릭터형과 형변환을 생략할수 없다.
		c. short s = (short)ch;		//ch는 캐릭터형이고 short형으로 형변환할시 생략할 수없다.
		d. float f = (float)l;		//l은 long형이고 float으로 형변환할시 생략가능하다.
		e. i = (int)ch;				//ch는 캐릭터형이고 인트형으로는 형변환을 생략할수 있다.
		*/
		
		
		/*[2-10] char타입의 변수에 저장될 수 있는 정수 값의 범위는? (10진수로 적으시오)*/
//		(0~2^16-1)
		
		/*
		[2-11] 다음중 변수를 잘못 초기화 한 것은? 
		a. byte b = 256;		
		b. char c = '';		
		c. char answer = 'no';								
		d. float f = 3.14	
		e. double d = 1.4e3f;
		*/		
		
//		a byte는 최대 127까지 표현가능하기때문에 잘못 초기화하였다. 
//		b c는 ' ' 또는 '\u0041'로 표현해줘야한다.
//		c 캐릭터형은 한글자로 표현가능하다.
//		d float은 3.14f로 표현해야한다.

		
		/*
		[2-13] 다음 중 타입과 기본값이 잘못 연결된 것은? 
		a. boolean - false	//o
		b. char - '\u0000' 	//x '\u0041' 또는 ' '
		c. float - 0.0		//x 0.0f
		d. int - 0			//o
		e. long - 0			//x 0L
		f. String - ""      //x null
		*/
		
		
		
		/*		 
		 [3-1] 다음 연산의 결과를 적으시오.
		int x = 2;
		int y = 5;
		char c = 'A'; // 'A'의 문자코드는 65
		
		System.out.println(1 + x << 33); //1 + x는  3  3*2 = 6												
		System.out.println(y >= 5 || x < 0 && x > 2); //true													     
		System.out.println(y += 10 - x++);  //y = y + 10 - x++  y= 13 x= 3
		System.out.println(x+=2);    //x = x + 2 x= 5
		System.out.println( !('A' <= c && c <='Z') ); //false 
		System.out.println('C'-c);  //'C' - 'A'  = 2 
		System.out.println('5'-'0');	// 5
		System.out.println(c+1);  //'A' = 65 c+1 = 66
		System.out.println(++c); 	// B 
		System.out.println(c++); 	// B  이후에  c= C
		System.out.println(c);  	// C
		 */
		
//		int x = 2;
//		int y = 5;
//		char c = 'A'; // 'A'의 문자코드는 65
//		System.out.println(1 + x << 33);
//		System.out.println(y >= 5 || x < 0 && x > 2); 
//	     
//		System.out.println(y += 10 - x++);  
//		System.out.println(x+=2);    
//		System.out.println( !('A' <= c && c <='Z') ); 
//		System.out.println('C'-c);  
//		System.out.println('5'-'0');
//		System.out.println(c+1);  
//		System.out.println(++c); 
//		System.out.println(c++); 
//		System.out.println(c);  
				
		
		/*		 
		[3-2] 아래의 코드는 사과를 담는데 필요한 바구니(버켓)의 수를 구하는 코드이다.
		만일 사과의 수가 123개이고 하나의 바구니에는 10개의 사과를 담을 수 있다면, 
		13개의 바구니가 필요할 것이다. (1)에 알맞은 코드를 넣으시오.
		[연습문제]/ch3/Exercise3_2.java
		class Exercise3_2 {
			public static void main(String[] args) {
				int numOfApples = 123; // 사과의 개수
				int sizeOfBucket = 10; // 바구니의 크기(바구니에 담을 수 있는 사과의 개수)
				int numOfBucket = ( (1) ); // 모든 사과를 담는데 필요한 바구니의 수
				System.out.println("필요한 바구니의 수 :"+numOfBucket);
			}
		}		
		*/
		
//		int numOfApples = 123; // 사과의 개수
//		int sizeOfBucket = 10; // 바구니의 크기(바구니에 담을 수 있는 사과의 개수)
//		int numOfBucket = numOfApples%sizeOfBucket > 0 ? numOfApples/sizeOfBucket + 1 : numOfApples/sizeOfBucket ; // 모든 사과를 담는데 필요한 바구니의 수
//		System.out.println("필요한 바구니의 수 :"+numOfBucket);
		
//		int numOfApples = 123; // 사과의 개수
//		int sizeOfBucket = 10; // 바구니의 크기(바구니에 담을 수 있는 사과의 개수)
//		int numOfBucket = numOfApples/sizeOfBucket + (numOfApples%sizeOfBucket == 0 ? 0 : 1) ; // 모든 사과를 담는데 필요한 바구니의 수
//		System.out.println("필요한 바구니의 수 :"+numOfBucket);
		
		
		/*
		[3-3] 아래는 변수 num의 값에 따라 ‘양수’, ‘음수’, ‘0’을 출력하는 코드이다. 삼항 연산
		자를 이용해서 (1)에 알맞은 코드를 넣으시오.
		[Hint] 삼항 연산자를 두 번 사용하라.
		[연습문제]/ch3/Exercise3_3.java
		class Exercise3_3 {
			public static void main(String[] args) {
				int num = 10;
				System.out.println( (1) );
			}
		}		
		*/

//		int num = 10;
//		System.out.println( num > 0 ? "양수" : (num < 0 ? "음수" : 0) );
		
		
		/*
		 [3-4] 아래는 변수 num의 값 중에서 백의 자리 이하를 버리는 코드이다.
		 만일 변수 num의 값이 ‘456’이라면 ‘400’이 되고, ‘111’이라면 ‘100’이 된다.
		 (1)에 알맞은 코드를 넣으시오.
		 [연습문제]/ch3/Exercise3_4.java
		 class Exercise3_4 {
			public static void main(String[] args) {
				int num = 456;
				System.out.println( (1) );
			}
		 }			
		 */

//		int num = 456;
//		System.out.println(100*(num/100));
		
		/*
		[3-5] 아래는 변수 num의 값 중에서 일의 자리를 1로 바꾸는 코드이다. 
		만일 변수 num의 값이 333이라면 331이 되고, 777이라면 771이 된다.
		(1)에 알맞은 코드를 넣으시오.
		[연습문제]/ch3/Exercise3_5.java
		class Exercise3_5 {
		public static void main(String[] args) {
		int num = 333;
		System.out.println( (1) );
			}
		}	
		*/
		
//		int num = 333;
//		System.out.println( 100*(num/100) + 10*((num -(100*(num/100)))/10) + 1);

		
		/*
		[3-6] 아래는 변수 num의 값보다 크면서도 가장 가까운 10의 배수에서 변수 num의 값을
		뺀 나머지를 구하는 코드이다. 예를 들어, 24의 크면서도 가장 가까운 10의 배수는 30이
		다. 19의 경우 20이고, 81의 경우 90이 된다. 30에서 24를 뺀 나머지는 6이기 때문에 변
		수 num의 값이 24라면 6을 결과로 얻어야 한다. (1)에 알맞은 코드를 넣으시오.
		[Hint] 나머지 연산자를 사용하라.
		[연습문제]/ch3/Exercise3_6.java
		class Exercise3_6 {
			public static void main(String[] args) {
				int num = 24;
				System.out.println( (1) );
			}
		}		
		*/
		
//		int num = 24;
//		System.out.println( 10*(num/10 + 1) - num );

		
		/*
		[3-7] 아래는 화씨(Fahrenheit)를 섭씨(Celcius)로 변환하는 코드이다. 
		변환공식이 'C = 5/9 ×(F - 32)'라고 할 때, (1)에 알맞은 코드를 넣으시오.
		단, 변환 결과값은 소수점 셋째자리에서 반올림해야한다.(Math.round()를 사용하지 않고 처리할 것)
		[연습문제]/ch3/Exercise3_7.java
		class Exercise3_7 {
		public static void main(String[] args) {
		int fahrenheit = 100;
		float celcius = ( (1) );
		System.out.println("Fahrenheit:"+fahrenheit);
		System.out.println("Celcius:"+celcius);
			}
		}
		[실행결과]
		Fahrenheit:100
		Celcius:37.78		
		*/
		
//		int fahrenheit = 100;
//		float celcius = ((int)(100f*5/9f*(fahrenheit-32)+0.5)/100f );
//		System.out.println("Fahrenheit:"+fahrenheit);
//		System.out.println("Celcius:"+celcius);

		
		/*
		[3-8] 아래 코드의 문제점을 수정해서 실행결과와 같은 결과를 얻도록 하시오.
		[연습문제]/ch3/Exercise3_8.java
		class Exercise3_8 {
		public static void main(String[] args) {
		byte a = 10;
		byte b = 20;
		byte c = a + b;
		char ch = 'A';
		ch = ch + 2;
		float f = 3 / 2;
		long l = 3000 * 3000 * 3000;
		float f2 = 0.1f;
		double d = 0.1;
		boolean result = d==f2;
		System.out.println("c="+c);     
		System.out.println("ch="+ch);   
		System.out.println("f="+f);		
		System.out.println("l="+l); 	
		System.out.println("result="+result);		 										  
		}
		
		[실행결과]
		c=30
		ch=C
		f=1.5
		l=27000000000
		result=true	
		*/	
		
//		byte a = 10;
//		byte b = 20;
//		int c = a + b;
//		char ch = 'A';
//		ch =(char)(ch + 2);
//		float f = 3/2f;
//		long l = (long)3000 * 3000 * 3000;
//		float f2 = 0.1f;
//		double d = 0.1;
//		boolean result = d!=f2;
//		System.out.println("c="+c);     
//		System.out.println("ch="+ch);   
//		System.out.println("f="+f);		
//		System.out.println("l="+l); 	
//		System.out.println("result="+result);	
		
				
		/*
		[3-9] 다음은 문자형 변수 ch가 영문자(대문자 또는 소문자)이거나 숫자일 때만
		변수 b의 값이 true가 되도록 하는 코드이다. (1)에 알맞은 코드를 넣으시오.
		[연습문제]/ch3/Exercise3_9.java
		class Exercise3_9 {
		public static void main(String[] args) {
		char ch = 'z';
		boolean b = (  (1)  );
		System.out.println(b);
			}
		}		 
		*/
		
//		char ch = 'z';
//		boolean b = 0 <= ch && ch <= 9 || 'A' <= ch && ch <= 'Z' || 'a' <= ch && ch <= 'z' ? true : false ;
//		System.out.println(b);

		
		/*
		[3-10] 다음은 대문자를 소문자로 변경하는 코드인데, 문자 ch에 저장된 문자가 대문자
		인 경우에만 소문자로 변경한다. 문자코드는 소문자가 대문자보다 32만큼 더 크다. 예를
		들어 'A‘의 코드는 65이고 ’a'의 코드는 97이다. (1)~(2)에 알맞은 코드를 넣으시오.
		[연습문제]/ch3/Exercise3_10.java
		class Exercise3_10 {
			public static void main(String[] args) {
				char ch = 'A';
				char lowerCase = ( (1) ) ? ( (2) ) : ch;
				System.out.println("ch:"+ch);
				System.out.println("ch to lowerCase:"+lowerCase);
			}
		}		
		[실행결과]
		ch:A
		ch to lowerCase:a	
		*/
		
//		char ch = 'A';
//		char lowerCase = ( 'A'<= ch && ch <= 'Z' ) ? (char)(ch + 32) : ch;
//		System.out.println("ch:"+ch);
//		System.out.println("ch to lowerCase:"+lowerCase);

		
		
		/*
		[4-1] 다음의 문장들을 조건식으로 표현하라.
		1. int형 변수 x가 10보다 크고 20보다 작을 때 true인 조건식  //(10 < x1 && x1 < 20)
		2. char형 변수 ch가 공백이나 탭이 아닐 때 true인 조건식	//(!(ch1 != ' ' || ch1 !='\t'))
		3. char형 변수 ch가 ‘x' 또는 ’X'일 때 true인 조건식   //(ch1 =='x' || ch1 =='X')
		4. char형 변수 ch가 숫자(‘0’~‘9’)일 때 true인 조건식		//('0' <= ch1 && ch1 <='9')
		5. char형 변수 ch가 영문자(대문자 또는 소문자)일 때 true인 조건식	//('a' <= ch1 && ch1 <= 'z' || 'A' <= ch1 && ch1 <= 'Z')
		6. int형 변수 year가 400으로 나눠떨어지거나 또는 4로 나눠떨어지고 100으로 나눠떨어지지
		않을 때 true인 조건식		// (year%400 == 0 || year%4 == 0 && year%100 != 0)
		7. boolean형 변수 powerOn가 false일 때 true인 조건식	//(powerOn==false)
		8. 문자열 참조변수 str이 “yes”일 때 true인 조건식 	//(str == "yes")
		*/		
		

		/*
		[4-2] 1부터 20까지의 정수 중에서 2 또는 3의 배수가 아닌 수의 총합을 구하시오.
		*/
		
//		int sum = 0;
//		int i = 0;
//		while(i < 21){
//			i++;
//			if(!(i%2==0 || i%3==0)){
//				sum += i;
//			}
//		}
//		System.out.println(sum);
		
		
		/*
		[4-3] 1+(1+2)+(1+2+3)+(1+2+3+4)+...+(1+2+3+...+10)의 결과를 계산하시오.
		*/		
		//문제와같이 똑같이 출력하시오.	
//		int sum = 0;
//		for(int i = 1; i < 11; i++) {
//			sum += i;
//			System.out.println(sum);
//		}
		
		
//		System.out.print(1);
//		for(int i = 2; i < 11; i++) {
//			System.out.print("+" + "(");
//			for(int j = 1; j <= i; j++){
//				if(i == j) {
//					System.out.print(j);
//				}else{
//					System.out.print(j + "+");
//				}
//			}
//			System.out.print(")");
//		}					
	
		
		/*
		[4-4] 1+(-2)+3+(-4)+... 과 같은 식으로 계속 더해나갔을 때, 몇까지 더해야 총합이
		100이상이 되는지 구하시오.
		*/
		
//		int i = 0;
//		int sum = 0;
//		
//		while (sum < 100) {
//			i++;
//			sum += i;					
//		}
//		System.out.println(sum);
//		System.out.println(i);		

		
		/*
		[4-5] 다음의 for문을 while문으로 변경하시오.
		[연습문제]/ch4/Exercise4_5.java
		public class Exercise4_5 {
			public static void main(String[] args) {
				for(int i=0; i<=10; i++) {
					for(int j=0; j<=i; j++)
						System.out.print("*");
						System.out.println();
					}
				}
			} // end of main
		} // end of class
		*/
		
//		for(int i=0; i<=10; i++) {
//			for(int j=0; j<=i; j++)
//				System.out.print("*");
//				System.out.println();
//			}	
//		}
		
//		int i = 0;
//		while(i < 10){
//			int j = 0;
//			while(j <= i) {
//				System.out.print("*");
//				j++;
//			}
//			System.out.println();
//			i++;
//		}
		
		
		/*
		[4-6] 두 개의 주사위를 던졌을 때, 눈의 합이 6이 되는 모든 경우의 수를 출력하는 프
		로그램을 작성하시오.
		*/
//		int sum = 0;
//		for(int i = 1; i < 7; i++){
//			for(int j = 1; j < 7; j++) {
//				sum = i + j;
//				if(sum==6){
//					System.out.println(i + "과" + j);
//				}
//			}
//		}
				
		/*
		[4-7] Math.random()을 이용해서 1부터 6사이의 임의의 정수를 변수 value에 저장하는
		코드를 완성하라. (1)에 알맞은 코드를 넣으시오.
		[연습문제]/ch4/Exercise4_7.java
		class Exercise4_7 {
		public static void main(String[] args) {
			int value = ( (1) );
			System.out.println("value:"+value);
			}
		}		
		*/

//		INT VALUE = (INT)(MATH.RANDOM()*6 + 1);
//		SYSTEM.OUT.PRINTLN("VALUE:"+VALUE);
		
		/*
		[4-8] 방정식 2x+4y=10의 모든 해를 구하시오. 단, x와 y는 정수이고 각각의 범위는
			0<=x<=10, 0<=y<=10 이다.				
				
		[실행결과]
		x=1, y=2
		x=3, y=1
		x=5, y=0		
		*/
				
//		for(int x = 0; x <= 10; x++){			
//			for(int y = 0; y <= 10; y++){
//				if(2*x+4*y == 10){
//					System.out.println("x : " + x + " y : " + y);
//				}
//			}
//		}

		
		/*		
		[4-9] 숫자로 이루어진 문자열 str이 있을 때, 각 자리의 합을 더한 결과를 출력하는 코
		드를 완성하라. 만일 문자열이 "12345"라면, ‘1+2+3+4+5’의 결과인 15를 출력이 출력되
		어야 한다. (1)에 알맞은 코드를 넣으시오.
		[Hint] String클래스의 charAt(int i)을 사용
		[연습문제]/ch4/Exercise4_9.java
		class Exercise4_9 {
			public static void main(String[] args) {
				String str = "12345";
				int sum = 0;
				for(int i=0; i < str.length(); i++) {
					(1) 알맞은 코드를 넣어 완성하시오.
				}
					System.out.println("sum="+sum);
			}
		}		
		[실행결과]
		15
		*/
		
//		String str = "12345";
//		int sum = 0;
//		for(int i=0; i < str.length(); i++) {
//			sum += str.charAt(i) - '0';
//		}
//			System.out.println("sum="+sum);
		
		
		/*
		[4-10] int타입의 변수 num 이 있을 때, 각 자리의 합을 더한 결과를 출력하는 코드를 완성하라.
		 만일 변수 num의 값이 12345라면, ‘1+2+3+4+5’의 결과인 15를 출력하라. (1)에 알맞은 코드를 넣으시오.
		[주의] 문자열로 변환하지 말고 숫자로만 처리해야 한다.
		[연습문제]/ch4/Exercise4_10.java
		class Exercise4_10 {
			public static void main(String[] args) {
				int num = 12345;
				int sum = 0;

				(1) 알맞은 코드를 넣어 완성하시오.

				System.out.println("sum="+sum);
			}
		}		
		[실행결과]
		15
		 */		
//		int num = 12345;
//		int sum = 0;
//		
//		while(num > 0){
//			sum += num%10;
//			num = num/10;
//		}
//		System.out.println("sum="+sum);
		
		
		/*
	[4-11] 피보나치(Fibonnaci) 수열(數列)은 앞을 두 수를 더해서 다음 수를 만들어 나가는 수열이다.
	 예를 들어 앞의 두 수가 1과 1이라면 그 다음 수는 2가 되고 그 다음 수는 1과 2를 더해서 3이 되어서
	 1,1,2,3,5,8,13,21,... 과 같은 식으로 진행된다. 1과 1부터 시작하는 피보나치수열의 10번째 수는
	 무엇인지 계산하는 프로그램을 완성하시오.
	[연습문제]/ch4/Exercise4_11.java
	public class Exercise4_11 {
		public static void main(String[] args) {
	// Fibonnaci 수열의 시작의 첫 두 숫자를 1, 1로 한다.
			int num1 = 1;
			int num2 = 1;
			int num3 = 0; // 세번째 값
			System.out.print(num1+","+num2);
				for (int i = 0 ; i < 8 ; i++ ) {

				(1) 알맞은 코드를 넣어 완성하시오.

				}
			} // end of main
	} // end of class

		[실행결과]
		1,1,2,3,5,8,13,21,34,55
		*/
		
//		int num1 = 1;
//		int num2 = 1;
//		int num3 = 0; // 세번째 값
//		System.out.print(num1+","+num2);		
//		for (int i = 0 ; i < 8 ; i++ ) {
//			num3 = num1 + num2;
//			num1 = num2;
//			num2 = num3;
//			System.out.print("," + num3);
//		}

		
		/*
		 [4-12] 구구단의 일부분을 다음과 같이 출력하시오.		  
		 [실행결과]
		2*1=2  3*1=3  4*1=4
		2*2=4  3*2=6  4*2=8
		2*3=6  3*3=9  4*3=12
		
		5*1=5  6*1=6  7*1=7
		5*2=10 6*2=12 7*2=14
		5*3=15 6*3=18 7*3=21
		
		8*1=8  9*1=9
		8*2=16 9*2=18
		8*3=24 9*3=27
		 */
		
//		for(int i = 1; i < 10; i++){
//			for(int j = 2; j < 10; j++){
//				System.out.print(j + "*" + i + "=" + i*j +"\t");
//			}
//			System.out.println();
//		}
		
		/*
		 [4-13] 다음은 주어진 문자열(value)이 숫자인지를 판별하는 프로그램이다.
		 (1)에 알맞은 코드를 넣어서 프로그램을 완성하시오.
		 [연습문제]/ch4/Exercise4_13.java
		class Exercise4_13 {
			public static void main(String[] args) {
				String value = "12o34";
				char ch = ' ';
				boolean isNumber = true;
				// 반복문과 charAt(int i)를 이용해서 문자열의 문자를
				// 하나씩 읽어서 검사한다.
				for(int i=0; i < value.length() ;i++) {

				(1) 알맞은 코드를 넣어 완성하시오.

				}
				if (isNumber) {
					System.out.println(value+"는 숫자입니다.");
					} else {
					System.out.println(value+"는 숫자가 아닙니다.");
					}
			} // end of main
		} // end of class
		 
		 [실행결과]
		12o34는 숫자가 아닙니다.
		 */
		
//		String value = "12o34";
//		char ch = ' ';
//		boolean isNumber = true;
//		// 반복문과 charAt(int i)를 이용해서 문자열의 문자를
//		// 하나씩 읽어서 검사한다.
//		for(int i=0; i < value.length() ;i++) {
//			ch = value.charAt(i);
//			if(!('0'<= ch && ch <= '9')){
//				isNumber = false;
//			}			
//		}
//		if (isNumber) {
//			System.out.println(value+"는 숫자입니다.");
//		} else {
//			System.out.println(value+"는 숫자가 아닙니다.");
//		}
		
	
		 /*
		 [4-14] 다음은 숫자맞추기 게임을 작성한 것이다. 1과 100사이의 값을 반복적으로 입력해서
		  컴퓨터가 생각한 값을 맞추면 게임이 끝난다. 사용자가 값을 입력하면, 컴퓨터는 자신이 생각한 값과
		  비교해서 결과를 알려준다. 사용자가 컴퓨터가 생각한 숫자를 맞추면 게임이 끝나고 몇 번 만에 
		  숫자를 맞췄는지 알려준다. (1)~(2)에 알맞은 코드를 넣어 프로그램을 완성하시오.
		[연습문제]/ch4/Exercise4_14.java
		class Exercise4_14 {
			public static void main(String[] args) {
			// 1~100사이의 임의의 값을 얻어서 answer에 저장한다.
				int answer =  (1) ;
				int input = 0; // 사용자입력을 저장할 공간
				int count = 0; // 시도횟수를 세기위한 변수
			// 화면으로 부터 사용자입력을 받기 위해서 Scanner클래스 사용
		java.util.Scanner s = new java.util.Scanner(System.in);
			do {
				count++;
				System.out.print("1과 100사이의 값을 입력하세요 :");
				input = s.nextInt(); // 입력받은 값을 변수 input에 저장한다.

				(2) 알맞은 코드를 넣어 완성하시오.

				} while(true); // 무한반복문
			} // end of main
		} // end of class HighLow	
		
		[실행결과]
		1과 100사이의 값을 입력하세요 :50
		더 큰 수를 입력하세요.
		1과 100사이의 값을 입력하세요 :75
		더 큰 수를 입력하세요.
		1과 100사이의 값을 입력하세요 :87
		더 작은 수를 입력하세요.
		1과 100사이의 값을 입력하세요 :80
		더 작은 수를 입력하세요.
		1과 100사이의 값을 입력하세요 :77
		더 작은 수를 입력하세요.
		1과 100사이의 값을 입력하세요 :76
		맞췄습니다.
		시도횟수는 6번입니다.
		*/ 
			
		
		/*
		 [4-15] 다음은 회문수를 구하는 프로그램이다. 회문수(palindrome)란, 숫자를 거꾸로 읽어도
		 앞으로 읽는 것과 같은 수를 말한다. 예를 들면 ‘12321’이나 ‘13531’같은 수를 말한다.
		 (1)에 알맞은 코드를 넣어서 프로그램을 완성하시오.
		[Hint] 나머지 연산자를 이용하시오.
		[연습문제]/ch4/Exercise4_15.java
		class Exercise4_15 {
			public static void main(String[] args) {
				int number = 12321;
				int tmp = number;
				int result =0; // 변수 number를 거꾸로 변환해서 담을 변수
				while(tmp !=0) {

				(1) 알맞은 코드를 넣어 완성하시오.

				}
				if(number == result)
					System.out.println( number + "는 회문수 입니다.");
				else
					System.out.println( number + "는 회문수가 아닙니다.");
			} // main
		}
		[실행결과]
		12321는 회문수 입니다.
		 */	

//		int number = 12321;
//		int tmp = number;
//		int result =0; // 변수 number를 거꾸로 변환해서 담을 변수
//		while(tmp !=0) {		
//			result = result*10 + tmp%10;  	
//			tmp = tmp/10;
//		}
//		if(number == result)
//			System.out.println( number + "는 회문수 입니다.");
//		else
//			System.out.println( number + "는 회문수가 아닙니다.");
		
		
		
		/*
		[5-1] 다음은 배열을 선언하거나 초기화한 것이다. 잘못된 것을 고르고 그 이유를 설명하시오.
		a. int[] arr[];    //가능
		b. int[] arr = {1,2,3,};  // 가능 ,뒤에는 없는걸로 인식됨
		c. int[] arr = new int[5];	// 가능 1차배열
		d. int[] arr = new int[5]{1,2,3,4,5};	//x 안에 방갯수를 쓰지말아야한다.
		e. int arr[5];	//가능 선언만 해두고 초기화하면 가능
		f. int[] arr[] = new int[3][]; //가능 
		*/		
		
		
		
		
		/*
		 [5-2] 다음과 같은 배열이 있을 때, arr[3].length의 값은 얼마인가?
			int[][] arr = {{ 5, 5, 5, 5, 5},{ 10, 10, 10},{ 20, 20, 20, 20},{ 30, 30}};			
			arr[3].length = 2;
		 */
	
//		int[][] arr = {{ 5, 5, 5, 5, 5},{ 10, 10, 10},{ 20, 20, 20, 20},{ 30, 30}};
//		System.out.println(arr[3].length);
		
		
		/*
		[5-3] 배열 arr에 담긴 모든 값을 더하는 프로그램을 완성하시오.
		[연습문제]/ch5/Exercise5_3.java
		class Exercise5_3
		{
			public static void main(String[] args)
			{
				int[] arr = {10, 20, 30, 40, 50};
				int sum = 0;
		
				(1) 알맞은 코드를 넣어 완성하시오.
		
				System.out.println("sum="+sum);
			}
		}
		[실행결과]
		sum=150
		*/
		
//		int[] arr = {10, 20, 30, 40, 50};
//		int sum = 0;
//
//		for(int i = 0; i < arr.length; i++) {
//			sum += arr[i];
//		}		
//		System.out.println("sum="+sum);
		

		
		/*
		 [5-4] 2차원 배열 arr에 담긴 모든 값의 총합과 평균을 구하는 프로그램을 완성하시오.
		[연습문제]/ch5/Exercise5_4.java
		class Exercise5_4 {
			public static void main(String[] args){
			int[][] arr = {	{ 5, 5, 5, 5, 5}, {10,10,10,10,10},	{20,20,20,20,20}, {30,30,30,30,30}};
			int total = 0;
			float average = 0;
			
			(1) 알맞은 코드를 넣어 완성하시오.
			
			System.out.println("total="+total);
			System.out.println("average="+average);
			} // end of main
		} // end of class
		[실행결과]
		total=325
		average=16.25
		 */
		
//		int[][] arr = {	{ 5, 5, 5, 5, 5}, {10,10,10,10,10},	{20,20,20,20,20}, {30,30,30,30,30}};
//		int total = 0;
//		float average = 0;
//		
//		for(int i = 0; i < arr.length; i++) {
//			for(int j = 0 ; j < arr[i].length; j++){
//				total += arr[i][j];
//			}
//		}		
//		average = (int)(100f*total/(arr.length*arr[0].length))/100f;
//		
//		System.out.println("total="+total);
//		System.out.println("average="+average);
		
		
		/*
		 [5-5] 다음은 1과 9사이의 중복되지 않은 숫자로 이루어진 3자리 숫자를 만들어내는 프
		로그램이다. (1)~(2)에 알맞은 코드를 넣어서 프로그램을 완성하시오.
		[참고] Math.random()을 사용했기 때문에 실행결과와 다를 수 있다.
		[연습문제]/ch5/Exercise5_5.java
		class Exercise5_5 {
			public static void main(String[] args) {
				int[] ballArr = {1,2,3,4,5,6,7,8,9};
				int[] ball3 = new int[3];
				// 배열 ballArr의 임의의 요소를 골라서 위치를 바꾼다.
				for(int i=0; i< ballArr.length;i++) {
				int j = (int)(Math.random() * ballArr.length);
				int tmp = 0;
		
				(1) 알맞은 코드를 넣어 완성하시오.
		 		}
				// 배열 ballArr의 앞에서 3개의 수를 배열 ball3로 복사한다.
		 		(2) 
		 		
				for(int i=0;i<ball3.length;i++) {
					System.out.print(ball3[i]);
				}
			} // end of main
		} // end of class
		[실행결과]
		486		 
		 */
		
//		int[] ballArr = {1,2,3,4,5,6,7,8,9};
//		int[] ball3 = new int[3];
//		// 배열 ballArr의 임의의 요소를 골라서 위치를 바꾼다.
//		for(int i=0; i< ballArr.length;i++) {
//			int j = (int)(Math.random() * ballArr.length);
//			int tmp = 0;
//			
//			tmp = ballArr[i];
//			ballArr[i] = ballArr[j];
//			ballArr[j] = ballArr[i];		
// 		}
//		// 배열 ballArr의 앞에서 3개의 수를 배열 ball3로 복사한다.
//		for(int i = 0; i < ball3.length; i++){
//			ball3[i] = ballArr[i];
//		}
//		for(int i=0;i<ball3.length;i++) {
//			System.out.print(ball3[i]);
//		}	
	
		
		/*
		 [5-6] 다음은 거스름돈을 몇 개의 동전으로 지불할 수 있는지를 계산하는 문제이다. 변
		수 money의 금액을 동전으로 바꾸었을 때 각각 몇 개의 동전이 필요한지 계산해서 출력하
		라. 단, 가능한 한 적은 수의 동전으로 거슬러 주어야한다. (1)에 알맞은 코드를 넣어서
		프로그램을 완성하시오.
		[Hint] 나눗셈 연산자와 나머지 연산자를 사용해야 한다.
		[연습문제]/ch5/Exercise5_6.java
		class Exercise5_6 {
			public static void main(String args[]) {
				// 큰 금액의 동전을 우선적으로 거슬러 줘야한다.
				int[] coinUnit = {500, 100, 50, 10};
				int money = 2680;
				System.out.println("money="+money);
				for(int i=0;i<coinUnit.length;i++) {
		
				(1) 알맞은 코드를 넣어 완성하시오.
		 		}
			} // main
		}
		[실행결과]
		money=2680
		500원: 5
		100원: 1
		50원: 1
		10원: 3
		 */	
		
//		int[] coinUnit = {500, 100, 50, 10};
//		int money = 2680;
//		System.out.println("money="+money);
//		for(int i=0;i<coinUnit.length;i++) {
//			
//			System.out.println(coinUnit[i] + "원: " + money/coinUnit[i]);
//			money = money - coinUnit[i]*(money/coinUnit[i]);		
// 		}		
		
		
		/*
		 [5-7] 문제 5-6에 동전의 개수를 추가한 프로그램이다. 커맨드라인으로부터 거슬러 줄
		금액을 입력받아 계산한다. 보유한 동전의 개수로 거스름돈을 지불할 수 없으면, ‘거스름
		돈이 부족합니다.’라고 출력하고 종료한다. 지불할 돈이 충분히 있으면, 거스름돈을 지불
		한 만큼 가진 돈에서 빼고 남은 동전의 개수를 화면에 출력한다. (1)에 알맞은 코드를 넣
		어서 프로그램을 완성하시오.
		[연습문제]/ch5/Exercise5_7.java
		class Exercise5_7{
			public static void main(String args[]){
				if(args.length!=1) {
					System.out.println("USAGE: java Exercise5_7 3120");
					System.exit(0);
					}
				// 문자열을 숫자로 변환한다. 입력한 값이 숫자가 아닐 경우 예외가 발생한다.
				int money = Integer.parseInt(args[0]);
				System.out.println("money="+money);
				int[] coinUnit = {500, 100, 50, 10 }; // 동전의 단위
				int[] coin = {5, 5, 5, 5}; // 단위별 동전의 개수
				for(int i=0;i<coinUnit.length;i++) {
					int coinNum = 0;
			 		(1) 아래의 로직에 맞게 코드를 작성하시오.
					1. 금액(money)을 동전단위로 나눠서 필요한 동전의 개수(coinNum)를 구한다.
					2. 배열 coin에서 coinNum만큼의 동전을 뺀다.
					(만일 충분한 동전이 없다면 배열 coin에 있는 만큼만 뺀다.)
					3. 금액에서 동전의 개수(coinNum)와 동전단위를 곱한 값을 뺀다.
			
					System.out.println(coinUnit[i]+"원: "+coinNum);
				}
				if(money > 0) {
					System.out.println("거스름돈이 부족합니다.");
					System.exit(0); // 프로그램을 종료한다.
				}
				System.out.println("=남은 동전의 개수 =");
				for(int i=0;i<coinUnit.length;i++) {
					System.out.println(coinUnit[i]+"원:"+coin[i]);
				}
			} // main
		}
		[실행결과]
		C:\jdk1.8\work\ch5>java Exercise5_7
		USAGE: java Exercise5_7 3120
		C:\jdk1.8\work\ch5>java Exercise5_7 3170
		money=3170
		500원: 5
		100원: 5
		50원: 3
		10원: 2
		=남은 동전의 개수 =
		500원:0
		100원:0
		50원:2
		10원:3
		C:\jdk1.8\work\ch5>java Exercise5_7 3510
		money=3510
		500원: 5
		100원: 5
		50원: 5
		10원: 5
		거스름돈이 부족합니다.		 
		 */
		
//		if(args.length!=1) {
//			System.out.println("USAGE: java Exercise5_7 3120");
//			System.exit(0);
//			}
//		// 문자열을 숫자로 변환한다. 입력한 값이 숫자가 아닐 경우 예외가 발생한다.
//		int money = Integer.parseInt(args[0]);
//		System.out.println("money="+money);
//		int[] coinUnit = {500, 100, 50, 10 }; // 동전의 단위
//		int[] coin = {5, 5, 5, 5}; // 단위별 동전의 개수
//		for(int i=0;i<coinUnit.length;i++) {
//			int coinNum = 0;
//			coinNum = money/coinUnit[i];
//			if(coin[i] < coinNum){
//				coinNum = coin[i] ;				
//			}
//			coin[i] = coin[i] - coinNum;
//			money = money - coinNum*coinUnit[i];	
//			System.out.println(coinUnit[i]+"원: "+coinNum);
//		}
//		if(money > 0) {
//			System.out.println("거스름돈이 부족합니다.");
//			System.exit(0); // 프로그램을 종료한다.
//		}
//		System.out.println("=남은 동전의 개수 =");
//		for(int i=0;i<coinUnit.length;i++) {
//			System.out.println(coinUnit[i]+"원:"+coin[i]);
//		}		
		
		
		/*
		 [5-8] 다음은 배열 answer에 담긴 데이터를 읽고 각 숫자의 개수를 세어서 개수만큼 ‘*’
		을 찍어서 그래프를 그리는 프로그램이다. (1)~(2)에 알맞은 코드를 넣어서 완성하시오.
		[연습문제]/ch5/Exercise5_8.java
		class Exercise5_8 {
			public static void main(String[] args) {
				int[] answer = { 1,4,4,3,1,4,4,2,1,3,2 };
				int[] counter = new int[4];
				for(int i=0; i < answer.length;i++) {
		 		(1) 알맞은 코드를 넣어 완성하시오.  }
				for(int i=0; i < counter.length;i++) {
		
				(2) 알맞은 코드를 넣어 완성하시오.
		
				System.out.println();
				}
			} // end of main
		} // end of class	
		[실행결과]
		3***
		2**
		2**
		4****		 
		 */
		
	
		
			
		/*
		 [5-9] 주어진 배열을 시계방향으로 90도 회전시켜서 출력하는 프로그램을 완성하시오.
		[연습문제]/ch5/Exercise5_9.java
		class Exercise5_9 {
			public static void main(String[] args) {
				char[][] star = {
				{'*','*',' ',' ',' '},
				{'*','*',' ',' ',' '},
				{'*','*','*','*','*'},
				{'*','*','*','*','*'}
				};
				char[][] result = new char[star[0].length][star.length];
				for(int i=0; i < star.length;i++) {
				for(int j=0; j < star[i].length;j++) {
					System.out.print(star[i][j]);
				}
				System.out.println();
				}
				System.out.println();
				for(int i=0; i < star.length;i++) {
				for(int j=0; j < star[i].length;j++) {
				
				(1) 알맞은 코드를 넣어 완성하시오.
				}
				}
				for(int i=0; i < result.length;i++) {
				for(int j=0; j < result[i].length;j++) {
					System.out.print(result[i][j]);
				}
				System.out.println();
				}
			} // end of main
		} // end of class
		[실행결과]
		**
		**
		*****
		*****
		****
		****
		**
		**
		**
			
		 */		
	
		
		/*
		[5-10] 다음은 알파벳과 숫자를 아래에 주어진 암호표로 암호화하는 프로그램이다.
		(1)에 알맞은 코드를 넣어서 완성하시오.
		
		a b c d e f g h i j k l m n o p q r s t
		` ~ ! @ # $ % ^ & * ( ) - _ + = | [ ] {
			
		 u v w x y z
		} ; : , . /
		
		0 1 2 3 4 5 6 7 8 9
		q w e r t y u i o p
		 
		[연습문제]/ch5/Exercise5_10.java
		class Exercise5_10 {
		public static void main(String[] args) {
		char[] abcCode =
		{ '`','~','!','@','#','$','%','^','&','*',
		'(',')','-','_','+','=','|','[',']','{',
		'}',';',':',',','.','/'};
							// 0 1 2 3 4 5 6 7 8 9
		char[] numCode = {'q','w','e','r','t','y','u','i','o','p'};
		String src = "abc123";
		String result = "";
		// 문자열 src의 문자를 charAt()으로 하나씩 읽어서 변환 후 result에 저장
		for(int i=0; i < src.length();i++) {
		char ch = src.charAt(i);
		
		(1) 알맞은 코드를 넣어 완성하시오.
		 }
		System.out.println("src:"+src);
		System.out.println("result:"+result);
		} // end of main
		} // end of class 
		
		
		[실행결과]
		src:abc123
		result:`~!wer
		*/
	
		
		/*
		[5-11] 주어진 2차원 배열의 데이터보다 가로와 세로로 1이 더 큰 배열을 생성해서 배열
		의 행과 열의 마지막 요소에 각 열과 행의 총합을 저장하고 출력하는 프로그램이다. (1)
		에 알맞은 코드를 넣어서 완성하시오.
		[연습문제]/ch5/Exercise5_11.java
		class Exercise5_11{
			public static void main(String[] args){
		int[][] score = {
		{100, 100, 100}
		, {20, 20, 20}
		, {30, 30, 30}
		, {40, 40, 40}
		, {50, 50, 50}
		};
		int[][] result = new int[score.length+1][score[0].length+1];
		for(int i=0; i < score.length;i++) {
		for(int j=0; j < score[i].length;j++) {
		
		(1) 알맞은 코드를 넣어 완성하시오.
		 }
		}
		for(int i=0; i < result.length;i++) {
		for(int j=0; j < result[i].length;j++) {
		System.out.printf("%4d",result[i][j]);
		}S
		ystem.out.println();
		}
		} // main
		}
		[실행결과]
		100 100 100 300
		20 20 20 60
		30 30 30 90
		40 40 40 120
		50 50 50 150
		240 240 240 720
		*/


		
	}

}
