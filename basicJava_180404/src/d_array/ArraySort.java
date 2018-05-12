package d_array;

import java.util.Arrays;

public class ArraySort {
	
	public static void main(String[] args) {
		
		/*
		 1. 정렬
		   - 어떤 데이터를 빠르고 쉽게 찾기 위해서 일정한 순서대로 데이터를 가지런히 나열하는 작업이다.
		   - 버블정렬(bubble sort), 선택정렬(select sort), 삽입정렬(insert sort)
		   
		 2. 버블정렬(bubble sort)
		   - 인접한 데이터 간에 교환이 계속해서 일어나면서 정렬이 이루어진다.
		   - 가장 큰값이 뒤로 보내진다.	
		   
		 3. 선택정렬(select sort)
		   1) 기준방 이상에서 최소값을 찾는다.
		   2) 최소값이 있는 방번호를 찾는다.
		   3) 기준방 <-> 최소값방
		   
		 4. 삽입정렬(insert sort)
		 
		 */
		
		//버블정렬 과정
		int[] arr = new int[] {5, 2, 3, 1, 4};
		
		for(int k = 0;  k < arr.length - 1; k++) {
			System.out.println(k+1+"회전");
			for(int i = 0; i < arr.length - 1 - k ; i++) {  //i = 기준방   
				//확정(마지막을)시킨건 제외시키려면 (arr.length-1 대신 arr.length-1-k 하면 가능) 
				if(arr[i] > arr[i+1]) { // i+1 기준방과 버블이 되는방
					int tmp = arr[i]; 	// i 값을 임의의 방에 집어넣어둔다.
					arr[i] = arr[i+1];	// i+1 값을 i에 옮겨주고,
					arr[i+1] = tmp;		// 임시에있던(i값이었던) 것을 i+1로 옮겨준다. 
				}
//				for(int j = 0; j <arr.length; j++){  // 길이만큰 다 출력하기위해서 arr.length 만큼 반복
//					System.out.print(arr[j] + " ");
					
					System.out.println(Arrays.toString(arr) + " ");
//				}
				System.out.println();
			}
		}
		
		
		/*
		 선택정렬 과정
		 1) 기준방 이상에서 최소값을 찾는다.
		 2) 최소값이 있는 방번호를 찾는다.
		 3) 기준방 <-> 최소값방
		 */
		
		int[] arr3 = {5, 2, 3, 1, 4};
		for(int j = 0; j < arr3.length - 1; j++){
			System.out.println(j + 1 + "회전");
			int bang = j;
			int min = arr3[j];
			for(int i = j +1 ; i < arr3.length; i++){
				if(min > arr3[i]){
					min = arr3[i];
					bang = i;
				}
			}
			int temp = arr3[j];
			arr3[j] = arr3[bang];
			arr3[bang] =temp;
			
			System.out.println(Arrays.toString(arr3));
		}
		
		//1. 정수값을 13개 저장할수 있는 변수를 선언 및 생성하세요.
		int[] score = new int[13];
		
		//2. score변수에 각방을 0~100점 사이의 값으로 저장해주세요.
		
//		score[0] = (int)(Math.random()*101);
//		score[1] = (int)(Math.random()*101);
//		score[2] = (int)(Math.random()*101);
//		score[3] = (int)(Math.random()*101);
//		score[4] = (int)(Math.random()*101);
//		score[5] = (int)(Math.random()*101);
//		score[6] = (int)(Math.random()*101);
//		score[7] = (int)(Math.random()*101);
//		score[8] = (int)(Math.random()*101);
//		score[9] = (int)(Math.random()*101);
//		score[10] = (int)(Math.random()*101);
//		score[11] = (int)(Math.random()*101);
//		score[12] = (int)(Math.random()*101);		
		for(int i = 0; i < score.length; i++) {
			score[i] = (int)(Math.random()*101);
		}
		for(int i = 0; i < score.length; i++) {
			System.out.print(score[i] + " ");
		}
		System.out.println();
		
		//3. score배열의 각방의 합계를 구하세요.
		int sum = 0;
		for(int i = 0; i < score.length; i++) {
			sum += score[i];
		}
		System.out.println(sum);
		
		//4. score배열의 각방의 평균을 구하세요. (소숫점 두째자리에서 반올림하여 첫째자리까지 표현하세요.)
		float avg = (int)((float)sum/score.length*10 + 0.5)/10f;		
		System.out.println(avg);
		
		//5. score배열을 내림차순으로 정렬하세요.
		//선택정렬
		System.out.println("선택정렬을 이용한 내림차순");
		for(int j = 0; j < score.length - 1; j++){
			int max = score[j];
			int bang = j;
			for(int i = j + 1; i < score.length; i++) {
				if(score[i] > max) {
					max = score[i];
					bang = i;
				}
			}
			int tmp = score[j];
			score[j] = score[bang];
			score[bang] = tmp;
		}
		System.out.println(Arrays.toString(score));
		
		
	
//		for(int j = 0; j < score.length - 1; j++){
//			int max = score[j];	
//			int bang = j;
//			for(int i = 1; i < score.length; i++){
//				if(score[i] > max) {
//					max = score[i];
//					bang = i;
//				}
//			}
//			int tmp = score[j];
//			score[j] = score[bang];
//			score[bang] = tmp;//			
//		}
		
		//버블정렬
		for(int k = 0;  k < arr.length - 1; k++) {			
			for(int i = 0; i < score.length - 1 - k; i++) {
				if(score[i] < score[i+1]) {
					int tmp = score[i+1];
					score[i+1] =score[i];
					score[i] = tmp;
				}
			}		
		}
		System.out.println(Arrays.toString(score));
		
		
		
		
	}

}
