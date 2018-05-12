package homework;

import java.util.Scanner;

public class Calculator {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);		
		System.out.print("수를 입력하세요 : ");
		int x = sc.nextInt();
		System.out.print("연산할 기호를 입력하세요 : ");
		String z = sc.next();
		System.out.print("수를 입력하세요 : ");
		int y = sc.nextInt();
		
		Operation op = new Operation();
		
		switch(z) {
		case "+" :
			int result1 = op.add(x, y);
			System.out.println(result1);
			break;
		case "-" :
			int result2 = op.subtract(x, y);
			System.out.println(result2);
			break;
		case "*" :
			long result3 = op.multiply(x, y);
			System.out.println(result3);
			break;
		case "/" :
			float result4 = op.divide(x, y);
			System.out.println(result4);
			break;
		case "%" :
			int result5 = op.remainder(x, y);
			System.out.println(result5);
			break;		
		default :
			System.out.println("잘못된 연산입니다.");
			break;		
		}		
		
		sc.close();		
	}
}

















