package basic;

import javax.swing.JOptionPane;

public class ThreadTest06 {
	public static boolean inputCheck = false;
	public static void main(String[] args) {
		DataInput th1 = new DataInput();
		CountDown th2 = new CountDown();
		
		th1.start();
		th2.start();

	}
}


//데이터를 입력하는 쓰레드
class DataInput extends Thread{
	@Override
	public void run() {
		String str = JOptionPane.showInputDialog("아무거나 입력하세요.");
		System.out.println("입력 값 : " + str);
		ThreadTest06.inputCheck = true;
	}
}

//카운트 다운을 진행하는 쓰레드
class CountDown extends Thread{
	@Override
	public void run() {
		for (int i = 10; i >= 1; i--) {
			if(ThreadTest06.inputCheck == true){
				return;
			}
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
		//10초 동안 입력이 없으면 프로그램을 종료 시킨다.
		System.out.println("10초가 지났습니다. 프로그램을 종료합니다.");
		System.exit(0);		//프로그램 종료
	}
}
