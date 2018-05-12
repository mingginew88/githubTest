package e_oop;

public class MyMathTest {
	
	public static void main(String[] args) {
		
		MyMath.add();
		MyMath.add2(1);
		MyMath.add3(2,3L);
		
		//인스턴스 
		MyMath  mm = new MyMath();
		int result = mm.add4(5, 6);
		System.out.println(result);
		
		//mm으로 불러와서 출력도 가능
		MyMath mm2 = new MyMath();
		int result2 = mm2.minus(3, 2);
		System.out.println(result2);
				
		long result3 = mm.multiply(3000, 3000, 3000);
		System.out.println(result3);
		
		float result4 =mm.divide(112, 5L);
		System.out.println(result4);		
		
	}
}


class MyMath {
	
	static int number = 50;  //클래스 변수
	
	//클래스 메서드
	static void add() {
		System.out.println(number);
		if(number>30) {
			return;
		}
		System.out.println("1");
	}
	
	static void add2(int num1) {
		System.out.println(num1);		
	}
	
	static void add3(int num2, long num3) {
		System.out.println(num2/num3);
	}
	
	int add4(int num4, int num5) {
		int result = num4 + num5;
		return result;
	}
	
	int minus(int num6, int num7) {
		int result = num6 -num7;
		return result;
	}
	
	long multiply(int num1, int num2, int num3) {
		long result = (long)num1* num2 * num3;
		return result;
	}
	
	float divide(int num1, long num2) {
		float result = (int)(100f*num1/num2+0.5)/100f;
		return result;
	}
	
}