package basic;

public class ThreadTest08 {
	public static void main(String[] args) {
		Thread th1 = new ShowUpperChar();
		Thread th2 = new ShowLowerChar();
		
		th1.setPriority(7);
		th2.setPriority(3);
		
		System.out.println("th1�� �켱 ���� : " + th1.getPriority());
		System.out.println("th2�� �켱 ���� : " + th2.getPriority());
		th1.start();
		th2.start();
	}
}


//�빮�ڸ� ����ϴ� ������
class ShowUpperChar extends Thread{
	@Override
	public void run() {
		for (char ch = 'A'; ch <= 'Z' ; ch++) {
			System.out.print(ch);
			//�ƹ��͵� ���ϴ� �ݺ��� (�ð������ ��)
			for (long i = 1; i <= 1000000000L ; i++) {
				
			}
		}
	}
}

//�ҹ��ڸ� ����ϴ� ������
class ShowLowerChar extends Thread{
	@Override
	public void run() {
		for (char ch = 'a'; ch <= 'z' ; ch++) {
			System.out.print(ch);
			//�ƹ��͵� ���ϴ� �ݺ��� (�ð������ ��)
			for (long i = 1; i <= 1000000000L ; i++) {
				
			}
		}
	}
}