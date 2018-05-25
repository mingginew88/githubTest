package basic;

public class ThreadTest03 {
	
	//Thread의 수행 시간 확인해 보기
	public static void main(String[] args) {
//		MyRunner r1 = new MyRunner();
		Thread th1 = new Thread(new MyRunner());
		
		//1970년 1월 1일 0시 0분 0초 (표준시간기준)로부터 경과한 시간
		long startTime = System.currentTimeMillis();
		th1.start();
		try {
			th1.join();		//현재 실행중인 쓰레드에서 join()메서드를 호출한 쓰레드(여기서는 th1)가 종료될때까지 기다려라..
		} catch (InterruptedException e) {
		}	
		long endTime = System.currentTimeMillis();	
		System.out.println("경과시간 : " + (endTime - startTime));
	
	}
}

class Runner{
	
}

class MyRunner extends Runner implements Runnable{
	@Override
	public void run() {
		long sum = 0L;
		for (long i = 1L; i < 1_000_000_000L; i++) {
			sum += i;
		}
		System.out.println("합계 : " + sum);
	}
}

class MyRunner2 extends Thread{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
	}
}

