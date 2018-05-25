package basic;
/*
	1~20������� �հ踦 ���ϴµ� �ɸ��� �ð��� üũ�ϱ�
	
	��ü �հ踦 ���ϴ� �۾��� �ܵ����� �������� ����������� �����ؼ� �۾��� ���� �ð��� Ȯ���غ���.
 */

public class ThreadTest04 {
	public static void main(String[] args) {
		//�ܵ����� ó���ϴ� ��ü ����
		SumThread sm = new SumThread(1L, 2_000_000_000L);
		
		//�����ؼ� ó���� ��ü���� �����ؼ� �迭�� ����
		SumThread[] sums = new SumThread[]{
				new SumThread(1L, 500_000_000),
				new SumThread(500_000_001L, 1000_000_000),
				new SumThread(1000_000_001L, 1500_000_000),
				new SumThread(1500_000_001L, 2000_000_000),
		};
		
		//�ܵ����� ó���� �ð� ���ϱ�
		long startTime = System.currentTimeMillis();
		sm.start();
		try {
			sm.join();
		} catch (InterruptedException e) {
		}
		long endTime = System.currentTimeMillis();
		System.out.println("�ܵ� ó�� �ð� : " + (endTime - startTime));
		System.out.println("==========================");
		
		// ���� �����尡 �����ؼ� ó������ ���
		startTime = System.currentTimeMillis();
		for (int i = 0; i < sums.length; i++) {
			sums[i].start();
		}
		
		for (int i = 0; i < sums.length; i++) {
			try {
				sums[i].join();
			} catch (InterruptedException e) {
			}
		}
		endTime = System.currentTimeMillis();
		System.out.println("���� ó�� �ð� : " + (endTime - startTime));
		System.out.println("==========================");
		
	}
}


//�հ踦 ����ϴ� ������
class SumThread extends Thread{
	private long min, max;
	
	public SumThread(long min, long max){
		this.min = min;
		this.max = max;
	}
	
	@Override
	public void run() {
		long sum = 0L;
		for (long i = min; i <= max ; i++) {
			sum += i;
		}
		System.out.println("�հ� : " + sum);
	}
	
	
	
	
}
