package basic;

/*
	3개의 쓰레드가 각각 알파벳을 A~Z까지 출력하는데
	출력을 끝낸 순서대로 결과를 나타내는 프로그램 작성하기

 */

public class ThreadTest11 {
	public static String strRank ="";
	public static void main(String[] args) {
		DisplayCharacter[] player = new DisplayCharacter[]{
				new DisplayCharacter("홍길동"),
				new DisplayCharacter("이순신"),
				new DisplayCharacter("변학도")
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
		System.out.println("경기결과");
		System.out.println("순위 : " + strRank);
	}//End main()
}//End ThreadTest11

//인스턴스를 여러개 만들면된다
class DisplayCharacter extends Thread{
	private String name;
	
	public DisplayCharacter(String name){
		this.name = name;
	}
	
	@Override
	public void run() {
		for (char ch = 'A'; ch <= 'Z'; ch++) {
			System.out.println(name + "의 출력문자" + ch);
			try {
				//sleep()메서드의 값을 100~500사이의 난수로 한다.				
				Thread.sleep((int)(Math.random()*401 + 100));
			} catch (InterruptedException e) {
			}
		}
		//
		System.out.println(name + "출력 끝...");
		ThreadTest11.strRank += name + " ";
	}	
}

