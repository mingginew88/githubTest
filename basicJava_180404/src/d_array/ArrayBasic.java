package d_array;

public class ArrayBasic {
	
	public static void main(String[] args) {
		
		/*
		 1. 배열(Array)
		  - "같은" 타입의 여러 변수를 하나의 묶음으로 다루는 것
		  
		 2. 배열의 선언
		  - 원하는 타입의 변수를 선언하고 변수 또는 타입에 배열임을 의미하는 []을 붙이면 된다.
		  	
		  	int[] score; 'score라는 인트형배열' , '참조형(기본형이 아니다)'
		  	int score[];
		  	
		 3. 배열의 생성
		  - 배열을 선언한 다음에 배열을 생성해야 한다.
		  - 배열을 생성하기 위해서는 'new'와 함께 배열의 타입과 크기를 정해주어야한다.
		  - 기본값으로 초기화 된다.
		    int[] score = new int[5];
		    int[] score = new int[] {10, 20, 30, 40, 50};
		 
		 */
		int score1 = 10;
		int score2 = 20;
		int score3 = 30;
		int score4 = 40;
		int score5 = 50;
		
		int[] score = new int[5]; //{0, 0, 0, 0, 0}
		int[] score6 = new int[] {10, 20, 30, 40, 50};
		//배열의 선언 및 생성이 같이 이루어질때만 쓸수 있다.
		int[] score7 = {10, 20, 30, 40, 50};
		score[0] = 10;
		score[1] = 20;
		score[2] = 30;
		score[3] = 40;
		score[4] = 50;
		System.out.println(score.length);
		
		System.out.println(score[0]);
		System.out.println(score[1]);
		System.out.println(score[2]);
		System.out.println(score[3]);
		System.out.println(score[4]);
		
		for(int i = 0; i < score.length; i++) {
			System.out.println(score[i]);
		}
		
		
		String[] name = new String[4];
		name[0] = "김현경";
		name[1] = "조계환";
		name[2] = "임수빈";
		name[3] = "서영준";
		for(int i = 0; i < name.length; i++) {
			System.out.println(name[i]);
		}
		
		String[] name1 = {"김현경","조계환","임수빈","서영준"};
		
		//변수명 jumSu, 7과목의 점수를 저장할수 있는 변수를 선언 및 초기화 하세요.
		
		int[] jumSu = new int[7];
		
		//jumSu의 모든방에 0~100점 사이의 랜덤한 정수값을 저장해주세요.
		
//		jumSu[0] = (int)(Math.random()*101);
//		jumSu[1] = (int)(Math.random()*101);
//		jumSu[2] = (int)(Math.random()*101);
//		jumSu[3] = (int)(Math.random()*101);
//		jumSu[4] = (int)(Math.random()*101);
//		jumSu[5] = (int)(Math.random()*101);
//		jumSu[6] = (int)(Math.random()*101);
		
		//랜덤
		for(int i = 0; i < jumSu.length; i++) {
			jumSu[i] =(int)(Math.random()*101);
		}
		
		//출력
		for(int i = 0; i < jumSu.length; i++) {
			System.out.println(jumSu[i]);
		}
		
		//7과목의 합계
		int sum = 0;
		for(int i = 0; i < jumSu.length; i++) {
			sum += jumSu[i];
		}System.out.println("7과목의 합계는 " + sum);
		
		//평균은 셋째자리에서 둘째자리까지
		float ave = (int)(100f*sum/jumSu.length+0.5)/100f;
		System.out.println("7과목의 평균은 " + ave);		
		
		//최대값을 구하세요.	
		int max = jumSu[0];
		for(int i = 0; i < jumSu.length; i++){
			if(max < jumSu[i]) {
				max = jumSu[i];
			}
		}
		System.out.println(max);		

		//최소값을 구하세요.	
		int min = jumSu[0];
		for(int i = 0; i < jumSu.length; i++) {
			if(min > jumSu[i]) {
				min = jumSu[i];
			}
		}
		System.out.println(min);
		
		
		

		

	}

}
