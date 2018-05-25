package test_thread;

//1~20�� ���� ������ �ɸ��� �ð�
//���� ������ �̿� �ɸ��� �ð�



//�ǹ���. runnable �������̽��� �̿��� ������� �迭�� �Ѳ����� �������� ����??
//�ǹ���. �ϳ��� Ŭ�������� ó���ϴ� �ð��� ���� Ŭ�������� ������ ó���ϴ� �ð��� ���̰� ���� ������ �����ΰ�?

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
		System.out.println("�ɸ� �ð� : " + (endTime - startTime));
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
		
		System.out.println("�ɸ� �ð� : " + (endTime - startTime));
		
	}
}


class Test06 extends Thread{
	@Override
	public void run() {
		long sum =0L;
		for (int i = 1; i <= 2_000_000_000; i++) {
			sum += i;
		}
		System.out.println("������ : " + sum);
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
		System.out.println("������ : " + sum);		
	}
}

class Test07 implements Runnable{
	@Override
	public void run() {
		long sum =0L;
		for (int i = 1; i <= 500_000_000; i++) {
			sum += i;
		}
		System.out.println("������ : " + sum);		
	}
}

class Test08 implements Runnable{
	@Override
	public void run() {
		long sum =0L;
		for (int i = 500_000_001; i <= 1_000_000_000; i++) {
			sum += i;
		}
		System.out.println("������ : " + sum);
	}
}

class Test09 implements Runnable{
	@Override
	public void run() {
		long sum =0L;
		for (int i = 1_000_000_001; i <= 1_500_000_000; i++) {
			sum += i;
		}
		System.out.println("������ : " + sum);
	}
}

class Test10 implements Runnable{
	@Override
	public void run() {
		long sum =0L;
		for (int i = 1_500_000_001; i <= 2_000_000_000; i++) {
			sum += i;
		}
		System.out.println("������ : " + sum);
		
	}
}


