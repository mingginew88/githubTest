package basic;

public class ThreadTest09 {
	//데몬 쓰레드 예제
	public static void main(String[] args) {
		AutoSaveThread autoSave = new AutoSaveThread();
		
		//데몬 쓰레드로 설정
		autoSave.setDaemon(true);
		autoSave.start();
		
		try {
			for (int i = 1; i <= 20; i++) {
				System.out.println(i);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
		}
		System.out.println("메인쓰레드 종료...");
	}
}

//데몬 쓰레드로 사용할 쓰레드 만들기
//3초에 한번씩 저장하는 쓰레드
class AutoSaveThread extends Thread{
	public void save(){
		System.out.println("작업 내용을 저장합니다.");
	}
	
	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
			}
			save();
		}
	}
}

//suspend() 일시정지 ---- resume() 깨우는메서드
//sleep()과 join()은 안에 수를 넣어줌
//yield() 양보하는 메서드
//suspend() resume() stop() 교착상태에 빠지게 만들기때문에 더이상 사용하지 않고 앞으로 사라질 메서드들..



