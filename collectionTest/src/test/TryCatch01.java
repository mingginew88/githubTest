package test;

import java.util.Scanner;

public class TryCatch01 {
	public static void main(String[] args) {
		System.out.println("try-catch 실습시간");
		Scanner sc = new Scanner(System.in);
		try {
			int a = 10;
			int b = 0;
			int c = a/b;
			System.out.println(c);
		} catch (ArithmeticException e) {
			System.out.println("예외당시 호출스택에 있던 메서드의 정보와 예외메시지 출력");
			e.printStackTrace();
			System.out.println("발생한 예외클래스의 인스턴스에 저장된 메시지를 얻을 수 있다.");			
			System.out.println("예외메시지 : " + e.getMessage());
		} finally {
			System.out.println("실습은 계속된다.");
		}
		
		int d = sc.nextInt();
		System.out.println(d);
	}
	

}
