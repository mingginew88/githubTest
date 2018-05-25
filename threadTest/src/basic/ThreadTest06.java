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


//�����͸� �Է��ϴ� ������
class DataInput extends Thread{
	@Override
	public void run() {
		String str = JOptionPane.showInputDialog("�ƹ��ų� �Է��ϼ���.");
		System.out.println("�Է� �� : " + str);
		ThreadTest06.inputCheck = true;
	}
}

//ī��Ʈ �ٿ��� �����ϴ� ������
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
		//10�� ���� �Է��� ������ ���α׷��� ���� ��Ų��.
		System.out.println("10�ʰ� �������ϴ�. ���α׷��� �����մϴ�.");
		System.exit(0);		//���α׷� ����
	}
}
