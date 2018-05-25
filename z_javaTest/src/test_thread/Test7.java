package test_thread;

/*
상태출력하는 예제
 */

public class Test7 {
	public static void main(String[] args) {
		TargetOfThread tot = new TargetOfThread();
		StateOfThread sot = new StateOfThread(tot);
		
		sot.start();
	}
}


class StateOfThread extends Thread{
	private Thread targetThread;
	
	public StateOfThread(Thread targetThread) {
		super();
		this.targetThread = targetThread;
	}

	@Override
	public void run() {
		while(true){
			Thread.State state = targetThread.getState();
			System.out.println(state);
			
			if(state == Thread.State.NEW){
				targetThread.start();
			}
			
			if(state == Thread.State.TERMINATED){
				break;
			}
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {}
		}
	}
}

class TargetOfThread extends Thread{
	@Override
	public void run() {
		for (long i = 1L; i <= 2000000000L; i++) {}
		
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {}
		
		for (long i = 1L; i <= 2000000000L; i++) {}
	}
}

