package basic;

/*
	3���� �����尡 ���� ���ĺ��� A~Z���� ����ϴµ�
	����� ���� ������� ����� ��Ÿ���� ���α׷� �ۼ��ϱ�

 */

public class ThreadTest11 {
	public static String strRank ="";
	public static void main(String[] args) {
		DisplayCharacter[] player = new DisplayCharacter[]{
				new DisplayCharacter("ȫ�浿"),
				new DisplayCharacter("�̼���"),
				new DisplayCharacter("���е�")
		};
		
		for (int i = 0; i < player.length; i++) {
			player[i].start();
		}
		
		for (int i = 0; i < player.length; i++) {
			try {
				player[i].join();
			} catch (InterruptedException e) {
			}
		}
		
		System.out.println();
		System.out.println("�����");
		System.out.println("���� : " + strRank);
	}//End main()
}//End ThreadTest11

//�ν��Ͻ��� ������ �����ȴ�
class DisplayCharacter extends Thread{
	private String name;
	
	public DisplayCharacter(String name){
		this.name = name;
	}
	
	@Override
	public void run() {
		for (char ch = 'A'; ch <= 'Z'; ch++) {
			System.out.println(name + "�� ��¹���" + ch);
			try {
				//sleep()�޼����� ���� 100~500������ ������ �Ѵ�.				
				Thread.sleep((int)(Math.random()*401 + 100));
			} catch (InterruptedException e) {
			}
		}
		//
		System.out.println(name + "��� ��...");
		ThreadTest11.strRank += name + " ";
	}	
}

