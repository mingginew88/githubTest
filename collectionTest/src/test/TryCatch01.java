package test;

import java.util.Scanner;

public class TryCatch01 {
	public static void main(String[] args) {
		System.out.println("try-catch �ǽ��ð�");
		Scanner sc = new Scanner(System.in);
		try {
			int a = 10;
			int b = 0;
			int c = a/b;
			System.out.println(c);
		} catch (ArithmeticException e) {
			System.out.println("���ܴ�� ȣ�⽺�ÿ� �ִ� �޼����� ������ ���ܸ޽��� ���");
			e.printStackTrace();
			System.out.println("�߻��� ����Ŭ������ �ν��Ͻ��� ����� �޽����� ���� �� �ִ�.");			
			System.out.println("���ܸ޽��� : " + e.getMessage());
		} finally {
			System.out.println("�ǽ��� ��ӵȴ�.");
		}
		
		int d = sc.nextInt();
		System.out.println(d);
	}
	

}
