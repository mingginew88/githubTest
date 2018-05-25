package basic;
/*
	1~20억까지의 합계를 구하는데 걸리는 시간을 체크하기
	
	전체 합계를 구하는 작업을 단독으로 했을때와 여러쓰레드로 분할해서 작업할 때의 시간을 확인해보자.
 */

public class ThreadTest04 {
	public static void main(String[] args) {
		//단독으로 처리하는 객체 생성
		SumThread sm = new SumThread(1L, 2_000_000_000L);
		
		//분할해서 처리할 객체들을 생성해서 배열에 저장
		SumThread[] sums = new SumThread[]{
				new SumThread(1L, 500_000_000),
				new SumThread(500_000_001L, 1000_000_000),
				new SumThread(1000_000_001L, 1500_000_000),
				new SumThread(1500_000_001L, 2000_000_000),
		};
		
		//단독으로 처리한 시간 구하기
		long startTime = System.currentTimeMillis();
		sm.start();
		try {
			sm.join();
		} catch (InterruptedException e) {
		}
		long endTime = System.currentTimeMillis();
		System.out.println("단독 처리 시간 : " + (endTime - startTime));
		System.out.println("==========================");
		
		// 여러 쓰레드가 협력해서 처리했을 경우
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
		System.out.println("협력 처리 시간 : " + (endTime - startTime));
		System.out.println("==========================");
		
	}
}


//합계를 계산하는 쓰레드
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
		System.out.println("합계 : " + sum);
	}
	
	
	
	
}
