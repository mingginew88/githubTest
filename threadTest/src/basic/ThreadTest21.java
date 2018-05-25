package basic;

import java.util.Arrays;

/*
10마리의 말들이 경주를 하는 경마 프로그램 작성하기

말은 Horse라는 이름의 클래스로 구성하는데 이 클래스는 말이름(String), 등수(int), 현재위치(int)를 멤버변수로 갖는다.
그리고 이 클래스에는 등수를 오름차순으로 처리할 수 있는 기능이 있다. (Comparable인터페이스 구현)
경기 구간은 1~50구간으로 되어 있다.
경기 중 일정한 시간마다(100/1000초) 현재 말의 위치를 출력한다.
출력 예시)
	01번말 : --->-----------------------------------
	02번말 : ------>--------------------------------
	03번말 : ---->----------------------------------	
	...
	10번말 : ----->---------------------------------
경기가 끝나면 등수 순으로 출력한다.
*/
public class ThreadTest21 {
	public volatile static int currentRank = 0;
	
	public static void main(String[] args) {
		Horse[] horses = new Horse[]{
				new Horse("1번말"),
				new Horse("2번말"),
				new Horse("3번말"),
				new Horse("4번말"),
				new Horse("5번말"),
				new Horse("6번말"),
				new Horse("7번말"),
				new Horse("8번말"),
				new Horse("9번말"),
				new Horse("10번말")
		};
		PlayState playState = new PlayState(horses);
		
		//경주 시작...
		for (Horse ho : horses) {
			ho.start();
		}
		
		playState.start();
		
		
		//경주 끝날때까지 기다리기
		for (Horse ho : horses) {
			try {
				ho.join();
			} catch (InterruptedException e) {}			
		}
		
		try {
			playState.join();
		} catch (InterruptedException e) {}
		
		
		System.out.println();
		System.out.println("경기 끝~~~");
		
		//등수 순으로 정렬하기
		Arrays.sort(horses);	//배열정렬
		
		System.out.println("경기 결과");
		for (Horse ho : horses) {
			System.out.println(ho);
		}
	}
}


//경주 마 클래스 만들기
class Horse extends Thread implements Comparable<Horse>{

	private String horseName;		//말이름
	private int rank;				//등수
	private int location;			//현재 위치
	
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

	//등수의 오름차순으로 정렬되는 기준 만들기
	@Override
	public int compareTo(Horse ho) {
		return Integer.compare(rank, ho.getRank());
	}
	
	//경주를 진행하는 쓰레드부분 구현
	@Override
	public void run() {
		for (int i = 1; i <= 50; i++) {
			location = i;
			try {
				Thread.sleep((int)(Math.random()*401+1));
			} catch (InterruptedException e) {}
		}
		ThreadTest21.currentRank++;	//등수증가
		rank = ThreadTest21.currentRank;
	}

	@Override
	public String toString() {
		return "경주마 " + horseName +"는" + rank + "등 입니다.";
	}
}


//경기가 진행 중에 현재 위치
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
				System.out.println();//줄바꿈
			}//end for -i
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {}
		}//end while()
	}//end run()
}//end PlayState






