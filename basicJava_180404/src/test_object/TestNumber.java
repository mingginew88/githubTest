package test_object;

public class TestNumber {
	
	public static void main(String[] args) {
		
		// 사람이름 6개 배열
		String[] name = new String[] {"A", "B", "C", "D", "E"};		
		
		//과목명 입력하기
		String[] subject = new String[] {"국어", "영어", "수학", "사회", "과학", "실습"};
		
		//1. 5명의 6과목을 관리할 수  있는 이차원 배열을 선언 및 생성하시오.
		int[][] score = new int[name.length][subject.length];
		
		//2. 5명의 6과목의 점수를 0~100점 사이의 랜덤한 정수값을 입력해주세요.
		for(int names = 0; names < name.length; names++){
			for(int subjects = 0; subjects < subject.length; subjects++) {
				score[names][subjects] =(int)(Math.random()*101);
			}
		}		
		
		//합계형 배열 생성
		int[] sum = new int[name.length];
		for(int names = 0; names < name.length; names++) {
			for(int subjects = 0; subjects < subject.length; subjects++){
				sum[names] += score[names][subjects];
			}
		}
		
		//평균 배열 생성
		float[] avg = new float[name.length];
		for(int names = 0; names < name.length; names++){
			avg[names] = (int)(100f*sum[names]/score[names].length+0.05)/100f;
		}
				
		//과목합계
		int[] subjectSum = new int[subject.length];
		for(int subjects = 0; subjects < subject.length; subjects++) {
			for(int names = 0; names < name.length; names++){
				subjectSum[subjects] += score[names][subjects];
			}
		}
		
		//과목평균
		float[] subjectAvg = new float[subject.length]; 
		for(int subjects =0; subjects < subject.length; subjects++) {
			subjectAvg[subjects] = (int)(100f*subjectSum[subjects]/name.length+0.5)/100f;
		}	
		
		//석차
		int[] count = new int[name.length];
		for(int names = 0; names < name.length; names++) {
			count[names] = 1;
			for(int i = 1; i < name.length; i++) {
				if(sum[names] < sum[i]) {
					count[names] ++;
				}
			}
		}		
		
		//3. 출력하시오
		System.out.print("\t");		//과목과 사람 사이의 공백
		for(int subjects = 0; subjects < subject.length; subjects++) {  
			System.out.print(subject[subjects] + "\t");		//첫줄 과목 순 출력
		}
		System.out.print("합계" + "\t");  //줄바꿈이전 합계 입력
		System.out.print("평균" + "\t");	//줄바꿈이전 평균 입력
		System.out.print("석차" + "\t");  //줄바꿈이전 석차 입력
		System.out.println();  //첫줄 과목 끝나고 줄바꿈
		for(int names = 0; names < name.length; names++) {
			System.out.print(name[names] +"\t");
			for(int subjects = 0; subjects < subject.length; subjects++) {
				System.out.print(score[names][subjects] + "\t");	//과목을 반복적으로 출력하고 사람수만큼 다시 반복하여 출력			
			}
			System.out.print(sum[names] + "\t");		 //이름만큼의 sum을 반복출력하기위해서
			System.out.print(avg[names] + "\t");		//이름만큼 avg를 반복출력하기위해서
			System.out.println(count[names] + "\t");
		}
		System.out.print("과목합계" + "\t");
		for(int subjects =0; subjects < subject.length; subjects++) {
			System.out.print(subjectSum[subjects] +"\t");
		}
		System.out.println();
		System.out.print("과목평균" +"\t");
		for(int subjects = 0; subjects <subject.length; subjects++) {
			System.out.print(subjectAvg[subjects] +  "\t");
		}
		System.out.println();		
	}
}












