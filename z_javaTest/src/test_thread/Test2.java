package test_thread;

public class Test2 {
	public static void main(String[] args) {
		
		Thread th1 = new Thread(new Test04());
		
		Test05 th2 = new Test05();
//		th2.start();
		
		long startTime = System.currentTimeMillis();
		th1.start();
		try {
			th1.join();
			Thread.sleep(100);
		} catch (InterruptedException e) {
		}
		long endTime = System.currentTimeMillis();
		System.out.println("경과시간 : "+ (endTime - startTime));
	}
}


class Test03{
	
}

class Test04 extends Test03 implements Runnable{
	@Override
	public void run() {
		long sum = 0L;
		for (int i = 0; i < 10000000; i++) {
			sum += i;
		}
		System.out.println("합계는 : " + sum);
	}
}

class Test05 extends Thread{
	@Override
	public void run() {
		super.run();
	}
}


