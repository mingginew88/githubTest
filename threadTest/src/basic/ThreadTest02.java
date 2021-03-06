package basic;

//멀티 쓰레드 프로그램 예제			-- 모든 쓰레드가 종료되어야 메인메서드가 끝난다
public class ThreadTest02 {
	public static void main(String[] args) {
		//멀티 Thread를 사용하는 방법
		
		//방법 1.
		//Thread클래스를 상속한 class의 인스턴스를 생성한 후 이 인스턴스의 start()메서드를 호출한다.
		MyThread1 th1 = new MyThread1();
		th1.start();
		
		
		//방법 2.
		//Runnable인터페이스를 구현한 class의 인스턴스를 생성한 후
		//이 인스턴스를 Thread객체의 인스턴스를 생성할 때 생성자의 매개값으로 넘겨준다.
		//이 때 생성된 Thread인스턴스의 start()메서드를 호출한다.
		MyThread2 r2 = new MyThread2();
		Thread th2 = new Thread(r2);
		th2.start();
		
		
		//방법 3. ==> 익명구현체를 이용한 방법
		//Runnable인터페이스를 구현한 익명 구현체의 인스턴스를 Thread인스턴스를 생성할 때 매개값으로 념겨준다.
		Runnable r3 = new Runnable(){
			@Override
			public void run() {
				for (int i = 0; i <= 100; i++) {
					System.out.print("@");
					try {
						//Thread.sleep(시간); ==> 주어진 시간동안 작업을 잠시 멈춘다.
						//시간은 밀리세컨드 단위를 사용한다.
						//즉, 1000은 1초를 의미한다.
						Thread.sleep(100);
					} catch (InterruptedException e) {
						
					}
				}	
			}			
		};
		Thread th3 = new Thread(r3);
		th3.start();
		
		
		System.out.println("메인()메서드 끝....");
	}//End main()
}//End ThreadTest02


//Thread클래스를 상속한 클래스 작성하기
class MyThread1 extends Thread{
	@Override
	public void run() {
		//쓰레드로 처리할 내용은 run()메서드에 작성해 놓는다.
		for (int i = 0; i <= 100 ; i++) {
			System.out.print("*");
			try {
				//Thread.sleep(시간); ==> 주어진 시간동안 작업을 잠시 멈춘다.
				//시간은 밀리세컨드 단위를 사용한다.
				//즉, 1000은 1초를 의미한다.
				Thread.sleep(100);
			} catch (InterruptedException e) {}
		}
	}	
}

//Runnable인터페이스를 구현한 클래스 작성하기
class MyThread2 implements Runnable{
	@Override
	public void run() {
		//쓰레드로 처리할 내용은 run()메서드에 작성해 놓는다.
		for (int i = 0; i <= 100; i++) {			
			System.out.print("$");
			try {
				//Thread.sleep(시간); ==> 주어진 시간동안 작업을 잠시 멈춘다.
				//시간은 밀리세컨드 단위를 사용한다.
				//즉, 1000은 1초를 의미한다.
				Thread.sleep(100);
			} catch (InterruptedException e) {
				
			}
		}		
	}	
}





