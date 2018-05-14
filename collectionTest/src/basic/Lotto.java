package basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/*
로또판매점 프로그램

사용자로부터 금액과 게임수를입력받아서 게임 수에 맞는 로또번호를 생성하는 프로그램을 작성하시오.

(단, 1게임의 가격은 1000원이다.)

(이때 입력한 금액보다 게임수가 많으면 게임수를 다시 입력 받고, 
   입력한 금액보다 게임수가 적으면 게임 후 거스름 돈을 출력하도록 처리한다.)

(로또번호 1~45사이의 중복되지 않은 수 6가지..)
*/


public class Lotto {
	int [] lottoNum = new int [6]; 
	int user_money;
	int user_count;
	
	ArrayList<List<Integer>> lottoList = new ArrayList<List<Integer>>();
	HashSet<Integer> lotto = new HashSet<Integer>();
	ArrayList<Integer> lottoWin = new ArrayList<Integer>(lotto);
	
	public void inputMoney(){
		while(true){
			Scanner sc = new Scanner(System.in);
			System.out.println("로또집 사장님 : 돈주세요.");
			user_money = sc.nextInt();
			System.out.println("나 : " + user_money + "원 드릴게요.");
			System.out.println("로또집 사장님 : 몇장이나 드릴까요?");
			user_count = sc.nextInt();
			System.out.println("나 : " + user_count + "장 만큼 살래요.");
			int user_change = 0;
			
			if(user_money < user_count*1000){
				System.out.println("로또집 사장님 : 손님! 돈이 부족합니다.");
				System.out.println("돈을 다시 주세요.");
				continue;
			}else if(user_money == user_count*1000){
				System.out.println("로또집 사장님 : 따로 거스름돈은 없어요.");
				System.out.println("로또집 사장님 : 로또번호 입력해서 주세요.");
				inputGame();
				break;
			}else{
				user_change = user_money - user_count*1000;
				System.out.println("로또집 사장님 : 손님 거스름돈은 " + user_change + "이에요. 여기있습니다.");
				System.out.println("로또집 사장님 : 로또 자동으로 드릴게요.");
				System.out.println();
				inputGame();
				break;
			}
		}
	}
	
	public void inputGame(){
		Scanner sc = new Scanner(System.in);
		int n1, n2, n3, n4, n5, n6;
		
		for (int i = 0; i < user_count; i++) {
			do{
				n1 = (int)(Math.random()*45 + 1);
				n2 = (int)(Math.random()*45 + 1);
				n3 = (int)(Math.random()*45 + 1);
				n4 = (int)(Math.random()*45 + 1);
				n5 = (int)(Math.random()*45 + 1);
				n6 = (int)(Math.random()*45 + 1);
				
			}while(n1==n2 || n1==n3 || n1==n4 || n1==n5 || n1==n6 ||
					n2==n3 || n2==n4 || n2==n5 || n2==n6 ||
					n3==n4 || n3==n5 || n3==n6 ||
					n4==n5 || n4==n6 ||
					n5==n6);

			lottoNum = new int[]{n1, n2, n3, n4, n5, n6};		
			List<Integer> list = new ArrayList<Integer>();
			list.add(n1);
			list.add(n2);
			list.add(n3);
			list.add(n4);
			list.add(n5);
			list.add(n6);
			
			Collections.sort(list);
			lottoList.add(list);
			
		
		
			System.out.println("당신의 " + (i+1) + "번째 로또 번호 : " + list);				
			
		}	
		System.out.println();
	}
	
	
	public void checkMyFuture(){		
		System.out.println("※이번주 로또번호※");
		Collections.sort(lottoWin);
		System.out.println(lottoWin);
		System.out.println();
		
		System.out.println("나 : 두근 두근 당첨되었을까?");		
		for (int i = 0; i < user_count; i++) {
			int correctNum = 0;
			for (int j = 0; j < 6; j++) {
				for (int j2 = 0; j2 < lottoWin.size(); j2++) {
					if(lottoWin.get(j2) == lottoList.get(i).get(j)){
						correctNum++;
						break;
					}
				}
			}
			if(!(correctNum==0 || correctNum==1 || correctNum==2)){
				System.out.println( i+1 + "번째 로또는 " + correctNum +"개 맞췄습니다.");				
			}
			if(correctNum == 6){
				System.out.println("나 : 이럴시간이 없다. 어서 떠나자!");
			}else if(correctNum == 5){
				System.out.println("나 : 2등 당첨!!!");
			}
		}	
	}
	
	
	public void lottoWin(){
		while(lotto.size() < 6){
			int num = (int)(Math.random()*45 + 1);
			lotto.add(num);
		}		
		lottoWin.addAll(lotto);
	}
	
	public void lottoStart(){
		while(true){
			Scanner sc = new Scanner(System.in);
			System.out.println("로또집 사장님 : 로또사러왔어요? Y/N");
			if(sc.nextLine().equals("Y")){	
				lottoWin();
				inputMoney();				
				checkMyFuture();			
				break;
			}else{
				break;
			}			
		}
	}

	public static void main(String[] args) {
		new Lotto().lottoStart();		
	}
	

}
