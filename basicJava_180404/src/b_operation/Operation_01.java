package b_operation;

public class Operation_01 {
	
	public static void main(String[] args) {
		
		/*
		 1. 증감연산자 (++, --) : 자신의 타입을 유지한다.
		   - 증가 연산자 (++) : 피연산자의 값을 1 증가시킨다.
		   - 감소 연산자 (--) : 피연산자의 값을 1 감소시킨다.
		 */
		int i = 3;
		i++;  // i = 4
		++i;  // i = 5
		
		int i2 = 5;
		int i3 = 0;
		
		i3 = 5 + i2++;  // i3 = 10, i2 = 6
		System.out.println(i3 + " , " + i2);
		
		int i4 = 5;
		int i5 = 0;
		i5 = 5 + ++i4; // i4 = 6, i5 = 11
		System.out.println(i5 + " , " + i4);
		
		int i6 = 10;
		int i7 = 11;
		int i8 = i6++ + ++i7 + ++i6;  // i6 = 11  i7 = 12 i6 = 12
									  // i8 = 35  result : i6 = 12 i7 = 12 i8 = 35 (incorrect)
		System.out.println("i6 = " + i6 + " " + "i7 = " +i7 + " " + "i8 = " + i8);
		
				
		/*
		 2. 부호연산자 (+, -)
		   - 부호 연산자는 피연산자의 부호를 변경하는데 사용된다.
		   - boolean, char를 제외한 나머지 기본형에 사용가능하다.		 
		 */
		
		int i9 = -(10);
		
		/*
		 3. 비트전환연산자(~)
		   - char형과 정수형에만 사용할 수 있다.		   		   
		 */
		
		byte b1 = 10;
		System.out.println(~b1); // -10-1 = -11
		byte b2 =-17;
		System.out.println(~b2); // 17-1 = 16
		
		/*
		 4. 논리부정연산자(!)
		   - boolean형에만 사용 가능하다.
		   - true -> false, false -> true
		 */
		boolean power = false;
		power = !power;
		System.out.println(power);
		power = !power;
		System.out.println(power);
		
		/*
		 5. 산술연산자
		   - 사칙연산자(+,-,*,/)
		   - 나머지 연산자(%)
		   - 쉬프트연산자(<<,>>,>>>)
		 */
		
		/*
		 6. 사칙연산자
		   - int형(4byte)보다 크기가 작은 자료형간의 연산은 int형으로 변환 후 연산한다.
		   byte + byte => int + int
		   short + char => int + int
		   - 두개의 피연산자중 자료형의 표현범위가 큰쪽에 맞춰서 형변환후에 연산한다.
		   long + byte => long + long
		   - 정수형간의 나눗셈은 0으로 나누는것은 금지되어 있다.
		 */
		byte bb1 = 1;
		byte bb2 = 10;
		int result = bb1 + bb2;
//		System.out.println(bb2/0);
		
		/*
		 7. 나머지 연산자(%)
		   - 왼쪽의 피연산자를 오른쪽의 피연산자로 나누고 난 나머지 값을 돌려준다.
		   - boolean형을 제외하고 모든 기본형 변수에 사용가능하다.
		 */
		int a = 10;
		int b = 3;
		int share = a/b;  // share(몫),  3
		int remain =a%b;  // 1
		
//		10을 3으로 나눈 몫은 3이고 나머지는 1이다.
		System.out.println(a + "을 " + b + "으로 나눈 몫은 " + share + "이고 나머지는 " + remain + "이다.");
		
		/*
		 8. 쉬프트 연산자(<<,>>,>>>)
		   - 정수형 변수에만 사용가능하다.
		   - 피연산자의 각자리(2진수)를 오른쪽 또는 왼쪽으로 이동한다.
		   - 곱셈과 나눗셈을 할때 연산속도가 빠르기 때문에 사용한다.
		   - << : x<<n = x*2^n
		   - >> : x>>n = x/2^n
		    
		  10<<2  :  10*2에 2제곱 = 40
		  15<<3  :  15*2에 3제곱 = 120
		  10>>2  :  10/2에 2제곱 = 2
		 */
		System.out.println(10<<2); // 10 * 2^2 = 40
		System.out.println(10>>2); // 10 / 2^2 = 2
		
		/*
		 9. 비교 연산자
		   - 두 개의 변수 또는 리터럴을 비교하는데 사용한다.
		   - 주로 조건문과 반복문의 조건식에 사용되며 연산결과는 true 또는 false이다.
		   
		 10. 대소비교연산자( < , > , <= , >= )
		   - 기본형 변수 중 boolean은 사용할 수 없다. (참조형은 비교할수없기때문에 제외시킨다)
		 
		 11. 등가비교연산자(== , !=)
		   - 모든 자료형에 사용가능하다.
		   - 기본형은 저장된 값을 비교하고, 참조형에는 주소를 비교한다. 
		   
		      수식          연산결과
		     x>y    |  x가 y보다 클때 true, 그외에는 false
		     x<y    |  x가 y보다 작을때 true, 그외에는 false
		     x>=y   |  x가 y보다 클거나 같을때 true, 그외에는 false
		     x<=y   |  x가 y보다 작거나 같을떄 true, 그외에는 false
		     x==y   |  x가 y가 같을 때 true, 그외에는 false
		     x!=y   |  x가 y가 다를 때 true, 그외에는 false
		 
		  */
		
		System.out.println(5 < 10);  // true
		System.out.println(5 > 10);  // false
		System.out.println(!(5 == 10)); // true
		
		float f1 = 0.1f;
		double d1 = 0.1;  //0.1에 근사치  1 / 2^n으로 표현하는게 double
		System.out.println(f1 == d1);
		float f2 = 0.25f;
		double d2 = 0.25;
		System.out.println(f2 == d2);
		
		/*
		 12. 비트연산자( &, |, ^(xor))
		   - 이진비트를 수행한다.
		   - 실수형에는 사용할 수 없다.
		   
		   | (or연산) - 피연산자중 한쪽의 값이 1이면 1의 결과를 얻는다.
		   & (and연산) - 피연산자 양쪽 값이 1이면 1이다.
		   ^ (xor연산) - 피연산자의 값이 서로 다를때만 1이다.
		   
		   3 -> 00000011
		   5 -> 00000101
		   3|5 -> 00000111 -> 7
		   3&5 -> 00000001 -> 1
		   3^5 -> 00000110 -> 6		   
		 */
		System.out.println(3^5);
		
		/*
		 13. 논리연산자(||, &&)
		  - 피연산자로 boolean형 또는 boolean형 값을 결과로 하는 조건식을 허용한다.
		  - 조건문의 결합에 사용한다.
		  
		    || (or결합)  : 피연산자 중 어느 한쪽만 true이면 true의 결과를 얻는다.
		    && (and결합) : 피연산자 모두 true 이면 true의 결과를 얻는다.
		    연산우선순위가 &&(논리곱) > ||(논리합) 이다.
		*/
		System.out.println(0 < 7 && 7 < 10);
//		'A'~'Z'
		char c ='F';
//		'A' <= c <= 'Z'
		System.out.println('A' <= c && c <= 'Z');
		System.out.println('a' <= c && c <= 'z');
		System.out.println(('A' <= c && c <= 'Z') || ('a' <= c && c <= 'z'));
		System.out.println('0' <= c && c <= '9');
		
		/*
		 14. 삼항연산자
		 	- 세 개의 피연산자를 필요로 하기 때문에 삼항연산자로 이름지어졌다.
		 	- 삼항연산자의 조건식에는 연산결과가 true와 false인 식이 사용되어야한다.
		 	- 기본구조
		 	  (조건식) ? 트루일때 실행 : false일때 실행		 
		 */
		int x = -10;
		int absx = x > 0 ? x : -x;
		System.out.println(absx);
		
		
		/*
		 15. 대입연산자 ( =, op= )
		   - 변수에 값 또는 수식의 연산결과를 저장하는데 사용한다.
		   - 연산자중 가장 낮은 연산 우선순위를 가진다.		   
		 */
		int i10 = 0;
		i10 = 3;
		
//		i10 = i10 +10;// i10 = 13
		i10 += 10; // i10 = 13
		i10 *= 3;  // 39
		i10 >>= 2; // 39 / 2^2 = 9
		System.out.println(i10);
		
		
		/*
		 random
		 0 <= Math.random() < 1		
		 */
		
		//주사위 숫자 랜덤뽑기
		int dice = (int)(Math.random()*6 + 1);
		System.out.println(dice);
		
		//1. 0(포함) ~ 100(포함) 사이의 정수값을 하나 뽑으세요.
		//2. 1에서 뽑힌 정수의 값을 변수 score에 저장해주세요.
		
		int score = (int)(Math.random()*101);
		System.out.println(score);
		
		// 1~45 랜덤하게 하나 뽑으세요.
		int lotto = (int)(Math.random()*45 + 1);
		System.out.println(lotto);
		
		
		// 36(미포함)~167(포함) 범위의 랜덤한 정수값을 뽑으세요.
		// -> 37(포함) ~ 168(미포함)
		System.out.println((int)(Math.random()*131 + 37));
		
		float f10 = 3.141592f;
		System.out.println((int)(f10*1000 + 0.5)/1000f);
		// f10 * 1000 = 3141.592
		// f10 + 0.5 = 3142.092
		// (int)f10 = 3142
		// f10/1000f = 3.142
//		f10 *= 1000;
//		f10 += 0.5;
//		f10 = (int)f10;
//		f10 = 1000f;
//		System.out.println(f10);
		
		
//		549.5683
		//f11 =  549.5683f
		//f11 * 10 = 5495.683
		//f11 + 0.5 = 5496.183
		//f11 = (int)f11
		//f11 = f11/10f
		float f11 = 549.5683f;
		System.out.println((int)(f11*10+0.5)/10f);
		
		float f12 = 56.8803f;
		//소숫점 셋째자리에서 올림하여 소숫점 두째자리까지 표현해주세요.
		System.out.println((int)(f12*100+0.9)/100f);		
		
	}

}
