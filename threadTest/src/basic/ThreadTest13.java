package basic;

/*
	Thread의 stop()메서드는 호출하면 쓰레드가 바로 멈춘다.
	이 때 사용하던 자원을 정리하지 못하고 프로그램이 종료되어서 나중에 실행되는 프로그램에 영향을 줄 수 있다.
	그래서 stop()메서드는 비추천한다.

 */

public class ThreadTest13 {
	public static void main(String[] args) {
		/*
		ThreadStopEx01 th = new ThreadStopEx01();
		th.start();
		
		try {
			Thread.sleep(500);
		} catch (Exception e) {}
		
//		th.stop(); 	//쓰레드 종료... 비추천
		
		th.setStop(true);
		*/
		
		//interrupt()메서드를 이용한 쓰레드 멈추기
		ThreadStopEx02 th2 = new ThreadStopEx02();
		th2.start();
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {}
		
		th2.interrupt();
	}
}


class ThreadStopEx01 extends Thread{
	private boolean stop;
	
	public void setStop(boolean stop){
		this.stop = stop;
	}
	
	@Override
	public void run() {
		while(!stop){
			System.out.println("쓰레드 실행 중....");
		}
		
		System.out.println("자원 정리....");
		System.out.println("실행 종료....");
	}
}


//interrupt()메서드를 이용하여 쓰레드를 멈추게 하는 방법
class ThreadStopEx02 extends Thread{
	@Override
	public void run() {
		/*
		//방법1 -->sleep()메서드와 interruptedException을 이용한 방법
		//		-->sleep()메서드는 interrupt()메서드 명령을 만나면 InterruptedException이 발생한다.
		try {
			while(true){
				System.out.println("실행 중...");
				Thread.sleep(1);	//
			}
		} catch (InterruptedException e) {}
		 */
		
		//방법2 -->interrupt가 발생했는지 여부를 알수 있는 메서드 이용하기
		while(true){
			System.out.println("실행중...");
			// (검사방법)1
			// isInterrupted() => 인스턴스 메서드, interrupt()메서드가 호출되었는지 여부를 감사한다.
			if(this.isInterrupted()){
				break;
			}
		}
		
		System.out.println("자원 정리....");
		System.out.println("실행 종료....");
	
		
	}
}









