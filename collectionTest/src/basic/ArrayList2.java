package basic;

import java.util.ArrayList;
import java.util.Scanner;

/*
 	����) 5���� ��� �̸��� �Է��Ͽ� ArrayList�� ������ �� �� �̸��� �߿� '��'�� ���� �̸��� ��� ����Ͻÿ�.
 	(��, �Է��� Scanner�� �̿��Ͽ� �Է��Ѵ�.)
 */

public class ArrayList2 {
	public static void main(String[] args) {
		
		ArrayList<String> name = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("5���� ����� �̸��� �Է����ּ���.");
		for (int i = 0; i < 5; i++) {
			System.out.println(i+1 +"��° ��� : ");
			name.add(sc.nextLine());
		}		
		System.out.println();
		
		System.out.println("�达���� ���� ������� ����ϼ���.");
		
		for (int i = 0; i < name.size(); i++) {
			String s = name.get(i).substring(0,1);
			if(s.equals("��")){
				System.out.println(i+1 + "��° ����� " + name.get(i));
			}
		}
		
		for (int i = 0; i < name.size(); i++) {
			if(name.get(i).startsWith("��")){
				System.out.println(name.get(i));
			}
		}
		
		for (int i = 0; i < name.size(); i++) {
			if(name.get(i).indexOf("��")==0){
				System.out.println(name.get(i));
			}
		}
		
		for (int i = 0; i < name.size(); i++) {
			if(name.get(i).charAt(i)=='��'){
				System.out.println(name.get(i));
			}
		}	
		
		sc.close();
		
	}
}
