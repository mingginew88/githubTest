package basic;

public class ThreadTest08 {
	public static void main(String[] args) {
		Thread th1 = new ShowUpperChar();
		Thread th2 = new ShowLowerChar();
		
		th1.setPriority(7);
		th2.setPriority(3);
		
		System.out.println("th1의 우선 순위 : " + th1.getPriority());
		System.out.println("th2의 우선 순위 : " + th2.getPriority());
		th1.start();
		th2.start();
	}
}


//대문자를 출력하는 쓰레드
class ShowUpperChar extends Thread{
	@Override
	public void run() {
		for (char ch = 'A'; ch <= 'Z' ; ch++) {
			System.out.print(ch);
			//아무것도 안하는 반복문 (시간때우기 용)
			for (long i = 1; i <= 1000000000L ; i++) {
				
			}
		}
	}
}

//소문자를 출력하는 쓰레드
class ShowLowerChar extends Thread{
	@Override
	public void run() {
		for (char ch = 'a'; ch <= 'z' ; ch++) {
			System.out.print(ch);
			//아무것도 안하는 반복문 (시간때우기 용)
			for (long i = 1; i <= 1000000000L ; i++) {
				
			}
		}
	}
}