package basic;

import java.util.ArrayList;
import java.util.Scanner;

/*
 	����1) 5���� ������ �Է��Ͽ� ArrayList�� �����ϰ� ������ ���̰� ���� �� ������ ����Ͻÿ�.
 	(��, �������� ���̴� ��� �ٸ��� �Է��Ѵ�.)
 	
 	����2) ����1���� ������ ���̰� ���� ������ ������ �Է����� �� �� ��츦 ó���Ͻÿ�.
 	
 */

public class Homework {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ArrayList<String> alias = new ArrayList<String>();
		
		System.out.println("5���� ������ �Է��ϼ���.");
		for (int i = 0; i < 5; i++) {
			System.out.println(i+1 + "��° ����� ���� : ");
			alias.add(sc.nextLine());
		}
		
//		int aliasLength = alias.get(0).toString().length(); 
//		String s = "";
//		System.out.println("������ ���� �� ����� ������ ����ϼ���.");		
//		for (int i = 0; i < alias.size(); i++) {
//			if(aliasLength < alias.get(i).toString().length()){
//				s = alias.get(i).toString();				
//			}			
//		}
//		System.out.println(s);
		
		int maxIndex = 0; //���� �� ������ ����ִ� index�� ������ ����
		for (int i = 1; i < alias.size(); i++) {
			if(alias.get(i).length() > alias.get(maxIndex).length()) {
				maxIndex = i;				
			}
		}
		
		System.out.println("���� �� ���� : " + alias.get(maxIndex));
		System.out.println("-------------------------------------");
		
		ArrayList<String> alias2 = new ArrayList<String>();
		System.out.println("5���� ������ �Է��ϼ���.");
		for (int i = 0; i < 5; i++) {
			System.out.println(i+1 + "��° ����� ���� : ");
			alias2.add(sc.nextLine());
		}
		
		//maxLeng������ ���� �� ������ ���̰� ����� �����̴�.
		int maxLength = alias2.get(0).length();
		for (int i = 1; i < alias2.size(); i++) {
			if(maxLength < alias2.get(i).length()) {
				maxLength = alias2.get(i).length();				
			}
		}
		
		System.out.println("���� �� �����...");
		for (int i = 0; i < alias2.size(); i++) {
			if(maxLength == alias2.get(i).length()){
				System.out.println(alias2.get(i));
			}
		}
	
		
		
	}
}












