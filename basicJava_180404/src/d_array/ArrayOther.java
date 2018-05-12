package d_array;

public class ArrayOther {
	
	public static void main(String[] args) {
		
		/*
		 1. 다차원 배열
		   - 자바에서는 1차원 배열 뿐만 아니라 2차원 이상의 다차원 배열도 허용한다.
		   - 선언방법
		     
		     선언방법				선언예
		     int[][] 변수명		int[][] score;
		     int 변수명[][];		int score[][];
		 	 int[] 변수명[];		int[] score[];		 
		 
		 */
		
		int[][] score = new int[3][];  //앞에 배열초기화가 중요.  , 뒤에 배열에는 주소가없다(null)
		// 0번방은 5개
		score[0] = new int[5];  //앞 0번방에 뒤 5개짜리 방을 만들겠다.
		// 1번방은 7개
		score[1] = new int[7];
		// 2번방은 9개
		score[2] = new int[9];
		
		//score.length = 3 , score에 큰번방에 몇개의 작은 방이있는건가
		//score[1].length = 7 , score 1번방에 길이는 7이다.
		
		int[][] score2 = new int[2][2];
		
		System.out.println(score2[0][0]);
		System.out.println(score2[0][1]);
		System.out.println(score2[1][0]);
		System.out.println(score2[1][1]);
		
		
		for(int i = 0; i < score2[0].length; i++) {
			System.out.println(score2[0][i]);
		}
		for(int i = 0; i < score2[1].length; i++) {
			System.out.println(score2[1][i]);
		}
		
		System.out.println("====================");
		for(int i = 0; i < score2.length; i++) {
			for(int j =0; j <score2[i].length; j++) {
				System.out.println(score2[i][j]);
			}
		}		
		
		System.out.println(score2[0]);
		System.out.println(score2[1]);
		
		
		
	}

}
