package e_oop;

import java.util.Scanner;

public class RecursiveCall {
	
	public static void main(String[] args) {
		
		System.out.print("숫자를 입력하세요 : ");
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		RecursiveCall rc = new RecursiveCall();
		long result = rc.factorial(number);
		System.out.println(result);
		
		sc.close();
	}
	
	long factorial(int num) {
		long result = 0L;
		if(num == 1) {
			result = 1;
		}else{
			result = num*factorial(num-1);
		}		
		return result;
	}	

}
