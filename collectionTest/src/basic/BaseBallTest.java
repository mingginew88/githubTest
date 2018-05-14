package basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

/*
	문제) Set을 이용하여 숫자 야구 게임 프로그램을 작성하시오.
	컴퓨터의 숫자는 난수를 이용하여 구한다.
	(난수 => 1~9사이의 서로 다른 숫자 3개)
	(스트라이크는 S, 볼은 B로 출력한다.)
 */

public class BaseBallTest {
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		HashSet<Integer> baseBall = new HashSet<Integer>();
		
		while(baseBall.size() < 3){
			int num = (int)(Math.random()*9 + 1);
			baseBall.add(num);
		}
		
		ArrayList<Integer> bbList = new ArrayList<Integer>(baseBall);
		Collections.shuffle(bbList);
		
		System.out.println("게임을 시작하지");
		int count = 0;
		
		while(true){	
			ArrayList<Integer> inputList = new ArrayList<Integer>();
			int countStrike = 0;
			int countBall = 0;
			count++;
			
			System.out.println("당신의 " + count + "번째 시도");
						
			try {				//try catch 잡아보자...
//				System.out.print("1번: ");
				inputList.add(sc.nextInt());
//				System.out.print("2번: ");
				inputList.add(sc.nextInt());
//				System.out.print("3번: ");
				inputList.add(sc.nextInt());				
			} catch (Exception e) {
				System.out.println("잘못 입력하였습니다.");
				continue;
			}
			
			for (int j = 0; j <  bbList.size(); j++) {
				if(bbList.get(j)==inputList.get(j)){
					countStrike++;
				}else{
					for (int i = 0; i < bbList.size(); i++) {
						if(bbList.get(i)==inputList.get(j)){
							countBall++;
						}
					}
				}
			}
			System.out.println(countStrike + "S" + countBall + "B입니다.");			
			if(countStrike == 3){
				break;
			}
		}
		System.out.println(count + "번만에 맞췄군요!");
	}
}



