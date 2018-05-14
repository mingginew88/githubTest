package basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/*
�ζ��Ǹ��� ���α׷�

����ڷκ��� �ݾװ� ���Ӽ����Է¹޾Ƽ� ���� ���� �´� �ζǹ�ȣ�� �����ϴ� ���α׷��� �ۼ��Ͻÿ�.

(��, 1������ ������ 1000���̴�.)

(�̶� �Է��� �ݾ׺��� ���Ӽ��� ������ ���Ӽ��� �ٽ� �Է� �ް�, 
   �Է��� �ݾ׺��� ���Ӽ��� ������ ���� �� �Ž��� ���� ����ϵ��� ó���Ѵ�.)

(�ζǹ�ȣ 1~45������ �ߺ����� ���� �� 6����..)
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
			System.out.println("�ζ��� ����� : ���ּ���.");
			user_money = sc.nextInt();
			System.out.println("�� : " + user_money + "�� �帱�Կ�.");
			System.out.println("�ζ��� ����� : �����̳� �帱���?");
			user_count = sc.nextInt();
			System.out.println("�� : " + user_count + "�� ��ŭ �췡��.");
			int user_change = 0;
			
			if(user_money < user_count*1000){
				System.out.println("�ζ��� ����� : �մ�! ���� �����մϴ�.");
				System.out.println("���� �ٽ� �ּ���.");
				continue;
			}else if(user_money == user_count*1000){
				System.out.println("�ζ��� ����� : ���� �Ž������� �����.");
				System.out.println("�ζ��� ����� : �ζǹ�ȣ �Է��ؼ� �ּ���.");
				inputGame();
				break;
			}else{
				user_change = user_money - user_count*1000;
				System.out.println("�ζ��� ����� : �մ� �Ž������� " + user_change + "�̿���. �����ֽ��ϴ�.");
				System.out.println("�ζ��� ����� : �ζ� �ڵ����� �帱�Կ�.");
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
			
		
		
			System.out.println("����� " + (i+1) + "��° �ζ� ��ȣ : " + list);				
			
		}	
		System.out.println();
	}
	
	
	public void checkMyFuture(){		
		System.out.println("���̹��� �ζǹ�ȣ��");
		Collections.sort(lottoWin);
		System.out.println(lottoWin);
		System.out.println();
		
		System.out.println("�� : �α� �α� ��÷�Ǿ�����?");		
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
				System.out.println( i+1 + "��° �ζǴ� " + correctNum +"�� ������ϴ�.");				
			}
			if(correctNum == 6){
				System.out.println("�� : �̷��ð��� ����. � ������!");
			}else if(correctNum == 5){
				System.out.println("�� : 2�� ��÷!!!");
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
			System.out.println("�ζ��� ����� : �ζǻ緯�Ծ��? Y/N");
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
