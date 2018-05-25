package basic;

public class ThreadTest01 {
	public static void main(String[] args) {
		//½Ì±Û ¾²·¹µå
		for (int i = 0; i <= 200 ; i++) {
			System.out.print("*");
		}
		System.out.println();
		
		for (int i = 0; i <= 200; i++) {
			System.out.print("$");
		}
		System.out.println();
	}
}
