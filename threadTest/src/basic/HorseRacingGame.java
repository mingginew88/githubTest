package basic;
/*
10������ ������ ���ָ� �ϴ� �渶 ���α׷� �ۼ��ϱ�

���� Horse��� �̸��� Ŭ������ �����ϴµ�
�� Ŭ������ ���̸�(String), ���(int), ������ġ(int)�� 
��������� ���´�.
�׸��� �� Ŭ�������� ����� ������������ ó���� �� �ִ� 
����� �ִ�.
(Comparable�������̽� ����)

��� ������ 1~50�������� �Ǿ� �ִ�.

��� �� ������ �ð����� ���� ���� ��ġ�� ����Ѵ�.
��� ����)
	01���� : --->-----------------------------------
	02���� : ------>--------------------------------
	03���� : ---->----------------------------------
	04���� : -------->------------------------------
	...
	10���� : ----->---------------------------------

��Ⱑ ������ ��� ������ ����Ѵ�.
*/
public class HorseRacingGame {
	public static String strRank = "";
	public static int intDistance;
	
	
	public static void main(String[] args) {
//		Horse[] player = new Horse[]{
//				new Horse("õ����"),					
//				new Horse("�絹��"),					
//				new Horse("�����"),
//				new Horse("���ٸ�"),
//				new Horse("��ǥ��"),
//				new Horse("ȣ����"),
//				new Horse("������"),
//				new Horse("������"),
//				new Horse("����Ŭ"),
//				new Horse("�ź���")				
//		};
//		
//		for (int i = 0; i < player.length; i++) {
//			player[i].start();
//		}
//		
//		for (int i = 0; i < player.length; i++) {
//			try {
//				player[i].join();
//				String strDistance = "";
//				for (int j = 1; j <= intDistance; j++) {
//					strDistance += "-";
//				}
//				System.out.println( i+1 + "���� : " + strDistance + ">");
//			} catch (InterruptedException e) {
//			}
//		}	
//		System.out.println("�����");
//		System.out.println("      1��     2��     3��     4��     5��     6��     7��     8��     9��     10��");
//		System.out.println("���� : " + strRank);
//	}
}


//class Horse extends Thread{
//	private String name;
//	private int rank;
//	private int distance;
//	public Horse(String name){
//		this.name = name;
//	}
//	
//	@Override
//	public void run() {
//		
//		for (int i = 1; i <= 50; i++) {
//			System.out.println();
//			distance = i;
//			HorseRacingGame.intDistance = distance;
//			String strDistance = "";
//			for (int j = 1; j <= distance; j++) {
//				strDistance += "-";
//			}
//			try {
//				Thread.sleep(500);
//				System.out.println(name + "�� �̵��Ÿ� : " + strDistance + ">");
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//			}
//		}		
//		System.out.println();
//		HorseRacingGame.strRank += name + " ";
//	}
//	
//	
//
//	public int getRank() {
//		return rank;
//	}
//
//	public void setRank(int rank) {
//		this.rank = rank;
//	}
//
//	@Override
//	public int compareTo(Horse o) {
//		return rank.compareTo(o.getRank());
//	}
}




