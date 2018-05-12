package e_oop;

public class OverLoadingTest {
	public static void main(String[] args) {				
		
	}

}

class PrintCall {
	
	int a = 10;
	int b = 20;
	
	static int d = 30; 
	static int e = 30;
	//add
	
	int add(){
		int result = a + b;
		return result;
	}
	 
	//	매개변수는 하나, d 와 e의 합을 반환하는 메서드를 만드세요.
	int add(int num1){
		int result = num1 + d + e;
		return result;
	}
	
	//  매개변수(long)인 하나의 매개변수와 a 와 b의 합을 반환하는 메서드를만드세요.		
	long add(long num2){		
		long result =num2 + a + b;
		return result;
	}
	
	//  매개변수가 두개, 매개변수 두개의 합을 반환하는 메서드를 만드세요.
	int add(int num3, int num4){
		int result = num3 + num4;
		return result;
	}
	
	// 매개변수가 두개, 하나는 float, 하나는 double의 매개변수의 합을 반환하는 메서드를 만드세요.
	double add(float num5, double num6) {
		double result = num5 + num6;
		return result;
	}
	//메서드명은 같지만 매개변수의 갯수와 타입이 같기때문에 오버로딩이 되지않는다.
//	float add(float num5, double num6) {
//		float result = (float)(num5 + num6);
//		return result;
//	}
	
	 
}    