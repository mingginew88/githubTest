package basic;

public class ThreadTest01 {
	public static void main(String[] args) {
		//�̱� ������
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
