package c_sentence;

import java.util.Scanner;

public class ConditionalSentence02 {
	
	public static void main(String[] args) {
		
		/*
		 1. 반복문 (for, while, do- while)
		  - 어떤작업을 반복적으로 수행되도록 할때 사용한다.
		  - 반복문은 주어진 조건을 만족할 동안 반복적으로 수행해야 하기 때문에 조건식을 포함하고 있다.
		  - for문은 반복횟수를 알고 있을때 사용
		    while문은 반복횟수를 모를때 사용
		 
		 2. for문
		   - 기본구조
		     for(초기화; 조건식; 증감식) {
		     	수행될 문장.
		     }
		 	
		 	 초기화 -> 조건식 -> 수행될 문장 -> 증감식 
		     		  -> 조건식 -> 수행될 문장 -> 증감식 
		 	 
		 */
		
//		System.out.println(0);
//		System.out.println(1);
//		System.out.println(2);
//		System.out.println(3);
//		System.out.println(4);
//		System.out.println(5);
//		System.out.println(6);
//		System.out.println(7);
//		System.out.println(8);
//		System.out.println(9);
//		System.out.println(10);
		
//		for(int i = 0; i < 11; i++) {
//			System.out.println(i);
//		}
//		
//		for(int i = 0; i < 16; i++) {
//			System.out.println(i + 5);
//		}
//		
//		for(int i = 5; i < 21; i++) {
//			System.out.println(i);
//		}
//		System.out.println("홀수만 출력하시오.");
//		for(int i = 1; i < 21; i++) {
//			if(i%2 == 1) {
//				System.out.print(i + " ");
//			}
//		}
//		
//		System.out.println("");
//		System.out.println("3의배수를 출력하시오");
//		for(int i = 1; i < 21; i++) {
//			if(i%3 == 0) {
//				System.out.print(i + " ");
//			}
//		}
		
		
		//10~100 사이의 정수중 홀수의 합계를 구하시오.
		int sum1 = 0;
		System.out.println("문제1. 10에서 100사이의 홀수의 합을 구하시오.");
		for(int i = 10; i < 101; i++) {
			
			if(i%2==1) {
				sum1 += i;
				
			}
		}
		System.out.println(sum1);
		
		
		/*
		  3. while문
		    - 반복횟수를 모를떄 많이 사용한다.
		    - 기본구조
		      
		      while(조건식) {
		      		수행될문장
		      }
		 
		 */
		System.out.println("문제2. 1에서 10까지 출력하세요.");
		int count = 1;
		while(count<11) {
		
			System.out.print(count + " ");
			count++;
		}
		System.out.println();
		
		// 20에서 10까지 출력하세요.
		System.out.println("문제3. 20에서 10까지 출력하세요.");
		int number3 = 20;
		while(number3>9) {
			System.out.print(number3 + " ");
			number3--;
		}
		System.out.println();
		
		
		//0~10사이의랜덤값
		System.out.println("문제4. 0~10사이의 랜덤값이 0이 아닐때까지 출력하세요.");
		int random = 11;
		int num4 = 0;
		while(random  != 0) {
			System.out.print(num4++ + ". ");
			System.out.println(random);			
			random = (int)(Math.random()*11);
					
		}
		
		//1~? 합을 계산하였을 때 100이상이 되는지 구하세요.
		System.out.println("문제5.  1에서 N까지의 합이 100 이상이 될경우 N의 값을 구하시오.");
		int num5 = 1;  //1부터 시작
		int sum5 = 0;  
		while(sum5 < 100) {
					
			sum5 += num5;
			num5++;
						
		}
		System.out.println("N = " + (num5 - 1));  //num5가 한번더 증감한 후 출력되기때문에 -1 해줌
		System.out.println(sum5);
		
		int num6 = 1;
		int sum6 = 0;
		while(true) {
			sum6 += num6;
			
			if(sum6 >= 100) {
				break;
			}
			num6++;			
		}
		System.out.println(num6);
		System.out.println(sum6);
		
		//구구단
		System.out.println("문제6-1. 구구단 2단을 만들어보자");
		
		int dan = 2;
		System.out.println(dan + "*" + 1 + " = " + dan*1);
		System.out.println(dan + "*" + 2 + " = " + dan*2);
		System.out.println(dan + "*" + 3 + " = " + dan*3);
		System.out.println(dan + "*" + 4 + " = " + dan*4);
		System.out.println(dan + "*" + 5 + " = " + dan*5);
		System.out.println(dan + "*" + 6 + " = " + dan*6);
		System.out.println(dan + "*" + 7 + " = " + dan*7);
		System.out.println(dan + "*" + 8 + " = " + dan*8);
		System.out.println(dan + "*" + 9 + " = " + dan*9);
		
		System.out.println("문제6-2. 구구단 2단을 for문을 이용해 만들어보자");
		for(int i = 1; i < 10; i++) {
			
			System.out.println(dan + "*" + i + " = " + dan*i);
		}
		
		System.out.println("문제6-3. 구구단을 완성하시오");
		for(int j = 2; j < 10; j+=2) {
									
			for(int i =1; i < 10; i+=2) {
				
				System.out.println(j + "*" + i + " = " +j*i);

			}
		}
		
				
		for(int j = 2; j < 10; j++) {
			
			for(int i =1; i < 10; i++) {
				
				if(j%2 == 0 && i%2 == 1) {
					
					System.out.println(j + "*" + i + " = " +j*i);

				}						
			}
		}
		
		
		System.out.println("6-5문제. while문을 이용하여 구구단을 완성하시오");
		int dan2 = 2;
		
		while(dan2 < 10) {
			
			int gob2 = 1;
			
			while(gob2 < 10) {
				
				System.out.println(dan2 + "*" + gob2 + "=" +dan2*gob2);
				gob2++;
			}
			
			dan2++;						
		}	
				
		/*
		int random = 11;
		int num4 = 0;
		while(random  != 0) {
			System.out.print(num4++ + ". ");
			System.out.println(random);			
			random = (int)(Math.random()*11);		 
		 */
		for(int random2 = 11; random2 !=0; ) {
			
			System.out.println(random2);
			random2 = (int)(Math.random()*11);
		}
		
		
		/*
		 4. do-while
		   - while문의 변형으로 기본구조는 while문과 같으나 최소 1회는 블럭{}을 수행한다.
		   - 기본구조
		     do{
		     	수행될문장
		     }while(조건식);		 
		 */
				
		/*
		int random = 11;
		int num4 = 0;
		while(random  != 0) {
			System.out.print(num4++ + ". ");
			System.out.println(random);			
			random = (int)(Math.random()*11);		 
		 */
		System.out.println("====================");

		int random3 = 0;
		do{
			random3 = (int)(Math.random()*11);
			System.out.println(random3);
		}while(random3 != 0);
		
		
		/*
		 5. continue
		   - 반복문 내에서만 사용가능하다.
		   - 반복문의 끝으로 이동하여 다음 반복문으로 이동한다.
		   - for문은 증감식으로 이동한다.
		   	 while문은 조건식으로 이동한다.		 
		 */
		System.out.println("====================");
		for(int j = 0; j < 11; j++) {
			if(j%2 == 0) {
				
			}
			System.out.println(j);
		}
		
		for(int j = 0; j < 11; j++) {
			if(j%2 == 1) {
				continue;
			}
			System.out.println(j);
		}
		
		
		//입력값 받는 방법
		Scanner sc = new Scanner(System.in); // 콘솔창으로부터 받을 준비
		System.out.println("문자를 입력해주세요.");
		String result = sc.next(); // 문자열을 저장해주는 메서드?
		System.out.println(result + result);
	
		
		System.out.println("숫자를 입력해주세요.");
		int result2 =sc.nextInt();
		System.out.println(result2);
				
		sc.close();
	
		
	}

}
