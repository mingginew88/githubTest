package basic;

import java.util.InputMismatchException;

import javax.swing.JOptionPane;

public class ThreadTest07 {
/*
	��ǻ�Ϳ� ���� ���� ���� �����ϴ� ���α׷��� �ۼ��Ͻÿ�.
	��ǻ���� ���� ���� ���� ������ �̿��Ͽ� ���ϰ�, 
	������� �Է��� showInputDialog()�� �̿��Ͽ� �Է¹޴´�.
	�Է½ð��� 5�ʷ� �����ϰ� ī��Ʈ�ٿ��� ¡���Ѵ�.
	5�ʵ��� �Է��� ������ ������ �������� ó���Ѵ�.
	
	5�ʾȿ� �Է��� �Ϸ�ȸ� ���и� ����Ѵ�.
	
	��� ����>
	---- ��� ----
	��ǻ�� : ����
	��  �� : ����
	��  �� : ����� �̰���ϴ�.	
 */
	public static boolean inputCheck = false;
	
	public static void main(String[] args) {
		DataInput2 th11 =new DataInput2();
		CountDown2 th22 = new CountDown2();
		
		th11.start();
		th22.start();
		
	}
}



class DataInput2 extends Thread{
	@Override
	public void run() {		
		while(true){
			String str = JOptionPane.showInputDialog("���� ���� �� �� �Է��ϼ���.");
			
			System.out.println("�� : " + str);
			if(!(str.equals("����")||str.equals("����")||str.equals("��"))){
				System.out.println("�߸��Է��Ͽ����ϴ�.");
				continue;
			}	
			
			ThreadTest07.inputCheck = true;
			int computer = (int)(Math.random()*3);
			if(computer == 0){
				System.out.println("��ǻ�� : ����");
			}else if(computer == 1){
				System.out.println("��ǻ�� : ����");
			}else if(computer ==2){
				System.out.println("��ǻ�� : ��");
			}
			if(str.equals("����")){
				if(computer == 0){
					System.out.println("�����ϴ�.");
				}else if(computer == 1){
					System.out.println("�����ϴ�.");
				}else if(computer ==2){
					System.out.println("�̰���ϴ�.");
				}
			}else if(str.equals("����")){
				if(computer == 0){
					System.out.println("�̰���ϴ�.");
				}else if(computer == 1){
					System.out.println("�����ϴ�.");
				}else if(computer ==2){
					System.out.println("�����ϴ�.");
				}
			}else if(str.equals("��")){
				if(computer == 0){
					System.out.println("�����ϴ�.");
				}else if(computer == 1){
					System.out.println("�̰���ϴ�.");
				}else if(computer ==2){
					System.out.println("�����ϴ�.");
				}			
			}
			
			break;			
		}		
	}
}


class CountDown2 extends Thread{
	@Override
	public void run() {
		for (int i = 5; i >= 1; i--) {
			if(ThreadTest07.inputCheck==true){
				return;
			}
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}	
		System.out.println("�����ϴ�.");
		System.exit(0);
		//5�ʵ��� �Է� ���ٸ�.. �й�		
	}
	
}





