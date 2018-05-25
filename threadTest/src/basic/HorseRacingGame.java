package basic;
/*
10마리의 말들이 경주를 하는 경마 프로그램 작성하기

말은 Horse라는 이름의 클래스로 구성하는데
이 클래스는 말이름(String), 등수(int), 현재위치(int)를 
멤버변수로 갖는다.
그리고 이 클래스에는 등수를 오름차순으로 처리할 수 있는 
기능이 있다.
(Comparable인터페이스 구현)

경기 구간은 1~50구간으로 되어 있다.

경기 중 일정한 시간마다 현재 말의 위치를 출력한다.
출력 예시)
	01번말 : --->-----------------------------------
	02번말 : ------>--------------------------------
	03번말 : ---->----------------------------------
	04번말 : -------->------------------------------
	...
	10번말 : ----->---------------------------------

경기가 끝나면 등수 순으로 출력한다.
*/
public class HorseRacingGame {
	public static String strRank = "";
	public static int intDistance;
	
	
	public static void main(String[] args) {
//		Horse[] player = new Horse[]{
//				new Horse("천리마"),					
//				new Horse("루돌프"),					
//				new Horse("고양이"),
//				new Horse("오바마"),
//				new Horse("흑표범"),
//				new Horse("호랑이"),
//				new Horse("피터팬"),
//				new Horse("월요일"),
//				new Horse("마이클"),
//				new Horse("거북이")				
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
//				System.out.println( i+1 + "번말 : " + strDistance + ">");
//			} catch (InterruptedException e) {
//			}
//		}	
//		System.out.println("경기결과");
//		System.out.println("      1등     2등     3등     4등     5등     6등     7등     8등     9등     10등");
//		System.out.println("순위 : " + strRank);
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
//				System.out.println(name + "의 이동거리 : " + strDistance + ">");
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




