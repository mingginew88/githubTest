package basic;

import javax.swing.JOptionPane;

public class ThreadTest07_1 {
	//�Է¿��θ� ��Ÿ���� ����
	public static boolean inputCheck = false;
	
	
	public static void main(String[] args) {
		GameTimer gt = new GameTimer();
		
		//������ �̿��Ͽ� ��ǻ���� ����, ����, �� ���ϱ�
		String[] data = {"����", "����", "��"};
		int index = (int)(Math.random()*3); //0~2������ ���� �����
		String com = data[index];
		
		//����ڷκ��� ���� ���� �� �Է� �ޱ�
		String man = null;
		gt.start();
		
		do{
			man = JOptionPane.showInputDialog("���� ���� ���� �Է��ϼ���.");
		}while(man == null || (!man.equals("����") && !man.equals("����") && !man.equals("��")));
		
		inputCheck = true;
		
		//��������ϱ�
		String result = "";
		if(com.equals(man)){
			result = "�����ϴ�.";
		}else if(man.equals("����") && com.equals("��") || man.equals("����") && com.equals("����") || man.equals("��") && com.equals("����")){
			result = "����� �̰���ϴ�.";
		}else{
			result = "����� �����ϴ�.";
		}
		
		//��� ���
		System.out.println("--- ��  �� ---");
		System.out.println("��ǻ�� : " + com);
		System.out.println("����� : " + man);
		System.out.println("��  �� : " + result);		
	}

}

//ī��Ʈ�ٿ�
class GameTimer extends Thread{	
	@Override
	public void run() {
		for (int i = 5; i >= 1; i--) {			
			System.out.println(i);
			if(ThreadTest07_1.inputCheck==true){
				return;
			}
			try {
				Thread.sleep(1000);
			} catch (Exception e) {				
			}
		}
		System.out.println("�ð��� �ʰ��Ǿ� ��;���� �����ϴ�.");
		System.exit(0);
	}//End run()
}
