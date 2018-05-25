package test_thread;

//1~20억 단일 쓰레드 걸리는 시간
//여러 쓰레드 이용 걸리는 시간



//의문점. runnable 인터페이스를 이용한 방법으로 배열로 한꺼번에 묶을수는 없나??
//의문점. 하나의 클래스에서 처리하는 시간과 여러 클래스에서 나눠서 처리하는 시간이 차이가 나는 이유는 무엇인가?

public class Test3 {
	public static void main(String[] args) {
		Test06 t06 = new Test06();
		
		long startTime;
		long endTime;
		startTime = System.currentTimeMillis();
		t06.start();
		try {
			t06.join();
		} catch (InterruptedException e) {
		}
		endTime = System.currentTimeMillis();
		System.out.println("걸린 시간 : " + (endTime - startTime));
		System.out.println("===========================");
		
		
//		Thread th1 = new Thread(new Test07());
//		Thread th2 = new Thread(new Test08());
//		Thread th3 = new Thread(new Test09());
//		Thread th4 = new Thread(new Test10());	
		
		Thread th1 = new Thread(new Test007(1,500000000));
		Thread th2 = new Thread(new Test007(500000001,1000000000));
		Thread th3 = new Thread(new Test007(1000000001,1500000000));
		Thread th4 = new Thread(new Test007(1500000001,2000000000));
		
		
		
		startTime = System.currentTimeMillis();
		th1.start();
		th2.start();
		th3.start();
		th4.start();
		try {
			th1.join();
			th2.join();
			th3.join();
			th4.join();			
		} catch (InterruptedException e) {}
		endTime = System.currentTimeMillis();
		
		System.out.println("걸린 시간 : " + (endTime - startTime));
		
	}
}


class Test06 extends Thread{
	@Override
	public void run() {
		long sum =0L;
		for (int i = 1; i <= 2_000_000_000; i++) {
			sum += i;
		}
		System.out.println("총합은 : " + sum);
	}
}


class Test007 implements Runnable{
	private long min;
	private long max;
	
	public Test007(long min, long max) {
		this.min = min;
		this.max = max;
	}
	
	@Override
	public void run() {
		long sum =0L;
		for (long i = min; i <= max; i++) {
			sum += i;
		}
		System.out.println("총합은 : " + sum);		
	}
}

class Test07 implements Runnable{
	@Override
	public void run() {
		long sum =0L;
		for (int i = 1; i <= 500_000_000; i++) {
			sum += i;
		}
		System.out.println("총합은 : " + sum);		
	}
}

class Test08 implements Runnable{
	@Override
	public void run() {
		long sum =0L;
		for (int i = 500_000_001; i <= 1_000_000_000; i++) {
			sum += i;
		}
		System.out.println("총합은 : " + sum);
	}
}

class Test09 implements Runnable{
	@Override
	public void run() {
		long sum =0L;
		for (int i = 1_000_000_001; i <= 1_500_000_000; i++) {
			sum += i;
		}
		System.out.println("총합은 : " + sum);
	}
}

class Test10 implements Runnable{
	@Override
	public void run() {
		long sum =0L;
		for (int i = 1_500_000_001; i <= 2_000_000_000; i++) {
			sum += i;
		}
		System.out.println("총합은 : " + sum);
		
	}
}


