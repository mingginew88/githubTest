package basic;

public class ThreadTest12 {
	public static void main(String[] args) {
		ThreadYield th1 = new ThreadYield("1번 쓰레드");
		ThreadYield th2 = new ThreadYield("2번 쓰레드");
		
		th1.start();
		th2.start();
		
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {}
		System.out.println("11111========================");
		
		th1.work = false;
		
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {}	
		
		

		System.out.println("11111========================");
		th1.work = true;
		
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {}	
		
		
		th1.stop = true;
		th2.stop = true;
		
	}
}


//yield()메서드 연습용 쓰레드
class ThreadYield extends Thread{
	public boolean stop = false;
	public boolean work = true;
	
	public ThreadYield(String name){
		super(name);	//쓰레드의 이름 설정
	}
	
	@Override
	public void run() {
		while(!stop){		//stop이 true면 반복문 종료
			if(work){
				//getName() ==> 쓰레드 이름 즉, name값 반환하는 메서드
				System.out.println(getName() + "작업중...");
			}else{
				System.out.println(getName() + "양보 전...");
				Thread.yield();
				System.out.println(getName() + "양보 후...");
			}
		}
		System.out.println(getName() + "종료...");
	}
	
	
	
	
}