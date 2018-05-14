package basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

/*
	����) Set�� �̿��Ͽ� ���� �߱� ���� ���α׷��� �ۼ��Ͻÿ�.
	��ǻ���� ���ڴ� ������ �̿��Ͽ� ���Ѵ�.
	(���� => 1~9������ ���� �ٸ� ���� 3��)
	(��Ʈ����ũ�� S, ���� B�� ����Ѵ�.)
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
		
		System.out.println("������ ��������");
		int count = 0;
		
		while(true){	
			ArrayList<Integer> inputList = new ArrayList<Integer>();
			int countStrike = 0;
			int countBall = 0;
			count++;
			
			System.out.println("����� " + count + "��° �õ�");
						
			try {				//try catch ��ƺ���...
//				System.out.print("1��: ");
				inputList.add(sc.nextInt());
//				System.out.print("2��: ");
				inputList.add(sc.nextInt());
//				System.out.print("3��: ");
				inputList.add(sc.nextInt());				
			} catch (Exception e) {
				System.out.println("�߸� �Է��Ͽ����ϴ�.");
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
			System.out.println(countStrike + "S" + countBall + "B�Դϴ�.");			
			if(countStrike == 3){
				break;
			}
		}
		System.out.println(count + "������ ���豺��!");
	}
}



