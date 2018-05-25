package basic;

//쓰레드의 상태를 출력하는 예제
public class ThreadTest10 {
	public static void main(String[] args) {
		TargetThread targetThread = new TargetThread();
		StatePrintThread spt = new StatePrintThread(targetThread);
		
		spt.start();
	}
}

//targetThread의 상태를 출력하는 쓰레드
class StatePrintThread extends Thread{
	private Thread targetThread;
	
	//생성자
	public StatePrintThread(Thread targetThread){
		this.targetThread = targetThread;
	}
	
	@Override
	public void run() {
		while(true){
			//현재의 쓰레드 상태값 구하기
			Thread.State state = targetThread.getState();
			System.out.println("타겟 쓰레드의 상태값 : " + state);
			
			//New상태인지 검사
			if(state == Thread.State.NEW){
				targetThread.start(); //쓰레드 작업 시작
			}
			
			//타겟쓰레드가 종료상태인지 검사
			if(state == Thread.State.TERMINATED){
				break;
			}
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
		}
	}//END run()
}//END StatePrintThread


//target용 쓰레드 (작업용 쓰레드)
class TargetThread extends Thread{
	@Override
	public void run() {
		for (long i = 1L; i <= 2000000000L ; i++) {} //시간 지연용
			
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
		}
		
		for (long i = 1L; i <= 2000000000L ; i++) {} //시간 지연용

	}
}





