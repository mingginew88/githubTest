package test_thread;

import javax.swing.JOptionPane;

//�Է��ϴ� ���� ī��Ʈ�ٿ� �����۾�

public class Test4 {
	public static boolean inputCheck = false;	
	public static void main(String[] args) {
		
		Thread th1 = new Thread(new Test11());
		th1.start();
		
		String str = JOptionPane.showInputDialog("�Է����ּ���>");
		System.out.println("�Է°��� : " + str);
		Test4.inputCheck = true;
	}
}


//ī��Ʈ�ٿ�
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



