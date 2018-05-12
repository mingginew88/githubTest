package d_array;

public class ArrayTest {
	
	public static void main(String[] args) {		
		
		// 사람이름 6개 배열
		String[] name2 = new String[] {"임수빈", "조계환", "김현경","노미소","공은별","김민겸"};		
		//과목명 입력하기
		String[] subject = new String[] {"국어", "영어", "수학", "사회", "과학", "HTML", "JAVA"};
		
		

		//1. 6명의 7과목을 관리할 수  있는 이차원 배열을 선언 및 생성하시오.
		int[][] score = new int[name2.length][subject.length];
		
		//2. 6명의 7과목의 점수를 0~100점 사이의 랜덤한 정수값을 입력해주세요.		
		for(int i = 0; i < score.length; i++) {
			for(int j =0; j < score[i].length; j++) {
				score[i][j] = (int)(Math.random()*101);
			}
		}
		
		
		//합계형 배열 생성
		int[] sum = new int[name2.length];		
		for(int i = 0; i < name2.length; i++) {			
			for(int j = 0; j < subject.length; j++) {
				sum[i] += score[i][j];
			}
		}
		
		//평균 배열 생성
		float [] avg = new float[name2.length];
		for(int i = 0; i < name2.length; i++) {
			avg[i] = ((int)(100f*sum[i]/score[i].length + 0.5))/100f;			
		}
		
		//과목합계
		int[] subjectSum = new int[subject.length];
		for(int i = 0; i < subject.length; i++) {
			for(int j = 0; j < name2.length; j++) {
				subjectSum[i] += score[j][i];
			}
		}
		
		//과목평균
		float[] subjectAvg = new float[subject.length];
		for(int i = 0; i < subject.length ; i++) {
			subjectAvg[i] = ((int)(100f*subjectSum[i]/name2.length +0.5))/100f;
		}
		
		//석차
		int[] seokcha = new int[name2.length];
		for(int i = 0; i < sum.length; i++) {
			seokcha[i] = 1;
			for(int j = 0; j < sum.length; j++) {
				if(sum[i] < sum[j]) {
					seokcha[i] += 1;
				}
			}
		}
				
		//3. 입력된 점수를 아래처럼 출력해주세요.
		System.out.print('\t');		
		for(int i = 0; i < subject.length; i++) {
			System.out.print(subject[i] + '\t');
		}
		System.out.print("합계" + '\t');		
		System.out.print("평균" + '\t');		
		System.out.print("석차" + '\t');		
		System.out.println();
		
		
		for(int i = 0; i < score.length; i++) {
			System.out.print(name2[i] + " " + '\t');
			for(int j =0; j < score[i].length; j++) {				
				System.out.print(score[i][j] + " " + '\t');	
				
			}			
			System.out.print(sum[i]);
			System.out.print('\t');
			System.out.print(avg[i]);
			System.out.print('\t');
			System.out.print(seokcha[i]);
			System.out.print('\t');
			System.out.println();			
		}
		
		System.out.print("과목합계" + '\t');
		for(int i = 0; i < subject.length; i++) {
			System.out.print(subjectSum[i] + " " + '\t');	
		}
		System.out.println();
		
		System.out.print("과목평균" + '\t');
		for(int i = 0; i <subject.length; i++) {
			System.out.print(subjectAvg[i] + " " + '\t');
		}
		System.out.println();
		
		
		
		
	
		
		for(int i = 0; i < sum.length - 1; i++) {			
			for(int j = 0; j < sum.length- 1 - i; j++){				
				if(sum[j] < sum[j+1]) {
					int tmp = sum[j];
					sum[j] = sum[j+1];
					sum[j+1] = tmp;
				}
				if(seokcha[j] > seokcha[j+1]) {
					int tmp = seokcha[j];
					seokcha[j] = seokcha[j+1];
					seokcha[j+1] = tmp;
				}
				if(avg[j] < avg[j+1]) {
					float tmp = avg[j];
					avg[j] = avg[j+1];
					avg[j+1] = tmp;
				}
				//일단 문제점.
				//한바퀴를 돌면서 sum값의 순서가 바뀜으로 이 아래 문장이 수행되지 않는다.
				int[][] temp = new int[name2.length][subject.length];
				if(sum[i] < sum[i+1]) {
					temp[i][j] = score[i][j];
					score[i][j] = score[i+1][j];
					score[i+1][j] = temp[i][j];
				}
			}
		}

		
		

		System.out.println("==================================after sort=====================================");
		
		
		for(int i = 0; i < score.length; i++) {
			System.out.print(name2[i] + " " + '\t');
			for(int j =0; j < score[i].length; j++) {				
				System.out.print(score[i][j] + " " + '\t');
				
			}			
			System.out.print(sum[i]);
			System.out.print('\t');
			System.out.print(avg[i]);
			System.out.print('\t');
			System.out.print(seokcha[i]);
			System.out.print('\t');
			System.out.println();			
		}
		
		System.out.print("과목합계" + '\t');
		for(int i = 0; i < subject.length; i++) {
			System.out.print(subjectSum[i] + " " + '\t');	
		}
		System.out.println();
		
		System.out.print("과목평균" + '\t');
		for(int i = 0; i <subject.length; i++) {
			System.out.print(subjectAvg[i] + " " + '\t');
		}
		System.out.println();
	
	}

}
