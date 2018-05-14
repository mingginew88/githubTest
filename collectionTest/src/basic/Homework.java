package basic;

import java.util.ArrayList;
import java.util.Scanner;

/*
 	문제1) 5명의 별명을 입력하여 ArrayList에 저장하고 별명의 길이가 제일 긴 별명을 출력하시오.
 	(단, 각별명의 길이는 모두 다르게 입력한다.)
 	
 	문제2) 문제1에서 별명의 길이가 같은 별명을 여러개 입력했을 때 의 경우를 처리하시오.
 	
 */

public class Homework {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ArrayList<String> alias = new ArrayList<String>();
		
		System.out.println("5명의 별명을 입력하세요.");
		for (int i = 0; i < 5; i++) {
			System.out.println(i+1 + "번째 사람의 별명 : ");
			alias.add(sc.nextLine());
		}
		
//		int aliasLength = alias.get(0).toString().length(); 
//		String s = "";
//		System.out.println("별명이 가장 긴 사람의 별명을 출력하세요.");		
//		for (int i = 0; i < alias.size(); i++) {
//			if(aliasLength < alias.get(i).toString().length()){
//				s = alias.get(i).toString();				
//			}			
//		}
//		System.out.println(s);
		
		int maxIndex = 0; //제일 긴 별명이 들어있는 index값 저장할 변수
		for (int i = 1; i < alias.size(); i++) {
			if(alias.get(i).length() > alias.get(maxIndex).length()) {
				maxIndex = i;				
			}
		}
		
		System.out.println("제일 긴 별명 : " + alias.get(maxIndex));
		System.out.println("-------------------------------------");
		
		ArrayList<String> alias2 = new ArrayList<String>();
		System.out.println("5명의 별명을 입력하세요.");
		for (int i = 0; i < 5; i++) {
			System.out.println(i+1 + "번째 사람의 별명 : ");
			alias2.add(sc.nextLine());
		}
		
		//maxLeng변수는 제일 긴 글자의 길이가 저장될 변수이다.
		int maxLength = alias2.get(0).length();
		for (int i = 1; i < alias2.size(); i++) {
			if(maxLength < alias2.get(i).length()) {
				maxLength = alias2.get(i).length();				
			}
		}
		
		System.out.println("제일 긴 별명들...");
		for (int i = 0; i < alias2.size(); i++) {
			if(maxLength == alias2.get(i).length()){
				System.out.println(alias2.get(i));
			}
		}
	
		
		
	}
}












