package test_thread;

public class Test {
	public static void main(String[] args) {
		
		Test01 t1 = new Test01();
		t1.start();
		
		Thread th2 = new Thread(new Test02());
		th2.start();
		
		Runnable r1 = new Runnable(){
			@Override
			public void run() {
				for (int i = 0; i < 20; i++) {
					System.out.print("*");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {}
				}
			}
		};
		Thread th3  = new Thread(r1);
		th3.start();
	}
}


//쓰레드 클래스 이용하는 방법
class Test01 extends Thread{
	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			System.out.print("*");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {}
		}
	}
}

class Test02 implements Runnable{
	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			System.out.print("#");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {}
		}
	}
}


