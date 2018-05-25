package basic;

import java.util.Arrays;

/*
10������ ������ ���ָ� �ϴ� �渶 ���α׷� �ۼ��ϱ�

���� Horse��� �̸��� Ŭ������ �����ϴµ� �� Ŭ������ ���̸�(String), ���(int), ������ġ(int)�� ��������� ���´�.
�׸��� �� Ŭ�������� ����� ������������ ó���� �� �ִ� ����� �ִ�. (Comparable�������̽� ����)
��� ������ 1~50�������� �Ǿ� �ִ�.
��� �� ������ �ð�����(100/1000��) ���� ���� ��ġ�� ����Ѵ�.
��� ����)
	01���� : --->-----------------------------------
	02���� : ------>--------------------------------
	03���� : ---->----------------------------------	
	...
	10���� : ----->---------------------------------
��Ⱑ ������ ��� ������ ����Ѵ�.
*/
public class ThreadTest21 {
	public volatile static int currentRank = 0;
	
	public static void main(String[] args) {
		Horse[] horses = new Horse[]{
				new Horse("1����"),
				new Horse("2����"),
				new Horse("3����"),
				new Horse("4����"),
				new Horse("5����"),
				new Horse("6����"),
				new Horse("7����"),
				new Horse("8����"),
				new Horse("9����"),
				new Horse("10����")
		};
		PlayState playState = new PlayState(horses);
		
		//���� ����...
		for (Horse ho : horses) {
			ho.start();
		}
		
		playState.start();
		
		
		//���� ���������� ��ٸ���
		for (Horse ho : horses) {
			try {
				ho.join();
			} catch (InterruptedException e) {}			
		}
		
		try {
			playState.join();
		} catch (InterruptedException e) {}
		
		
		System.out.println();
		System.out.println("��� ��~~~");
		
		//��� ������ �����ϱ�
		Arrays.sort(horses);	//�迭����
		
		System.out.println("��� ���");
		for (Horse ho : horses) {
			System.out.println(ho);
		}
	}
}


//���� �� Ŭ���� �����
class Horse extends Thread implements Comparable<Horse>{

	private String horseName;		//���̸�
	private int rank;				//���
	private int location;			//���� ��ġ
	
	public Horse(String horseName) {		
		this.horseName = horseName;
	}
	

	public String getHorseName() {
		return horseName;
	}

	public int getRank() {
		return rank;
	}

	public int getLocation() {
		return location;
	}

	//����� ������������ ���ĵǴ� ���� �����
	@Override
	public int compareTo(Horse ho) {
		return Integer.compare(rank, ho.getRank());
	}
	
	//���ָ� �����ϴ� ������κ� ����
	@Override
	public void run() {
		for (int i = 1; i <= 50; i++) {
			location = i;
			try {
				Thread.sleep((int)(Math.random()*401+1));
			} catch (InterruptedException e) {}
		}
		ThreadTest21.currentRank++;	//�������
		rank = ThreadTest21.currentRank;
	}

	@Override
	public String toString() {
		return "���ָ� " + horseName +"��" + rank + "�� �Դϴ�.";
	}
}


//��Ⱑ ���� �߿� ���� ��ġ
class PlayState extends Thread{
	private Horse[] horses;
	
	public PlayState(Horse[] horses){
		this.horses = horses;
	}
	
	@Override
	public void run() {
		
		while(true){
			if(ThreadTest21.currentRank==horses.length){
				break;
			}
			for (int i = 1; i <= 30; i++) {
				System.out.println();
			}
			for (int i = 0; i < horses.length; i++) {
				System.out.print(horses[i].getHorseName() + " : ");
				for (int j = 1; j <= 50; j++) {
					if(j == horses[i].getLocation()){
						System.out.print(">");
					}
					System.out.print("-");
				}//end for -j
				System.out.println();//�ٹٲ�
			}//end for -i
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {}
		}//end while()
	}//end run()
}//end PlayState






