package basic;

public class ThreadTest15 {
	public static void main(String[] args) {
		
		ShareObject sObj = new ShareObject();
		
		WorkerThread th1 = new WorkerThread("1번", sObj);
		WorkerThread th2 = new WorkerThread("2번", sObj);
		
		th1.start();
		th2.start();
		
	}
}


//ShareObject를 사용하는 쓰레드
class WorkerThread extends Thread{
	private ShareObject sObj;
	
	public WorkerThread(String name, ShareObject sObj) {
		super(name);	//Thread의 name설정
		this.sObj = sObj;
	}
	
	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			sObj.add();
		}
	}
}



//공통으로 사용하는 클래스
class ShareObject{
	private int sum = 0;
	
	//동기화 방법1 ==> 메서드에 동기화 설정하기
//	public synchronized void add(){
//		int n = sum;
//		
//		n += 10;	//10증가
//		
//		sum = n;
//		
//		System.out.println(Thread.currentThread().getName() + "합계 : " + sum);
//	}
	
	//동기화 방법2 ==> 동기화 블록 설정하기
	public void add(){
		synchronized (this) {
			int n = sum;
			
			n += 10;	//10증가
			
			sum = n;
			
			System.out.println(Thread.currentThread().getName() + "합계 : " + sum);
		}
	}
}
