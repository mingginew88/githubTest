package test_thread;

import javax.swing.JOptionPane;

//���������� ���� �����


public class Test5 {
	public static boolean inputCheck = false;
	public static String inputValue = "";
	
	public static void main(String[] args) {
		
		Thread th1 = new Thread(new Test12());
		Test13 th2 = new Test13();
		
		int com = (int)(Math.random()*3);
		String strCom = "";
		if(com == 0){
			strCom = "����";
		}else if(com == 1){
			strCom = "����";
		}else{
			strCom = "��";
		}
				
		th2.start();
		th1.start();
		
		try {
			th1.join();
			th2.join();
		} catch (InterruptedException e) {}
		
		System.out.println("���");
		System.out.println("��ǻ�� : " + strCom);
		System.out.println("��   �� : " + Test5.inputValue);
		
		if(Test5.inputValue.equals(strCom)){
			System.out.println("�����ϴ�.");
		}else if(strCom.equals("����")&&Test5.inputValue.equals("����")||strCom.equals("����")&&Test5.inputValue.equals("��")||strCom.equals("��")&&Test5.inputValue.equals("����")){
			System.out.println("�̰���ϴ�.");
		}else{
			System.out.println("�����ϴ�.");
		}
	}
}

//ī��Ʈ�ٿ� �ϴ�Ŭ����
class Test12 implements Runnable{
	@Override
	public void run() {
		for (int i = 10; i > 0 ; i--) {
			if(Test5.inputCheck == true){
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

//�Է��ϴ� �� 
class Test13 extends Thread{
	@Override
	public void run() {
		String str = null;
		do{
			str = JOptionPane.showInputDialog("���� ���� �� �߿� �Է����ּ���.");
		}while(str==null||!(str.equals("����")||str.equals("����")||str.equals("��")));
		Test5.inputCheck = true;
		Test5.inputValue = str;		
				
	}
}


