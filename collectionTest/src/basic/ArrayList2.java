package basic;

import java.util.ArrayList;
import java.util.Scanner;

/*
 	문제) 5명의 사람 이름을 입력하여 ArrayList에 저장한 후 이 이름들 중에 '김'씨 성의 이름을 모두 출력하시오.
 	(단, 입력은 Scanner을 이용하여 입력한다.)
 */

public class ArrayList2 {
	public static void main(String[] args) {
		
		ArrayList<String> name = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("5명의 사람의 이름을 입력해주세요.");
		for (int i = 0; i < 5; i++) {
			System.out.println(i+1 +"번째 사람 : ");
			name.add(sc.nextLine());
		}		
		System.out.println();
		
		System.out.println("김씨성을 가진 사람들을 출력하세요.");
		
		for (int i = 0; i < name.size(); i++) {
			String s = name.get(i).substring(0,1);
			if(s.equals("김")){
				System.out.println(i+1 + "번째 사람인 " + name.get(i));
			}
		}
		
		for (int i = 0; i < name.size(); i++) {
			if(name.get(i).startsWith("김")){
				System.out.println(name.get(i));
			}
		}
		
		for (int i = 0; i < name.size(); i++) {
			if(name.get(i).indexOf("김")==0){
				System.out.println(name.get(i));
			}
		}
		
		for (int i = 0; i < name.size(); i++) {
			if(name.get(i).charAt(i)=='김'){
				System.out.println(name.get(i));
			}
		}	
		
		sc.close();
		
	}
}
