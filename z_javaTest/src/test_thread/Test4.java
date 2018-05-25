package test_thread;

import javax.swing.JOptionPane;

//입력하는 값과 카운트다운 동시작업

public class Test4 {
	public static boolean inputCheck = false;	
	public static void main(String[] args) {
		
		Thread th1 = new Thread(new Test11());
		th1.start();
		
		String str = JOptionPane.showInputDialog("입력해주세요>");
		System.out.println("입력값은 : " + str);
		Test4.inputCheck = true;
	}
}


//카운트다운
class Test11 implements Runnable{
	@Override
	public void run() {
		for (int i = 10; i > 0; i--) {
			if(Test4.inputCheck==true){
				return;
			}
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
		}
		System.exit(0);
	}
}



