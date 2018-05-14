package basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 	ȸ����ȣ, ȸ���̸�, ��ȭ��ȣ�� ��������� ����
 	ȸ���̸��� �������� �������� ������ �Ǵ� MemberŬ������ �ۼ��� ����.
 */

public class ListSortTest2 {
	public static void main(String[] args) {
		
		ArrayList<Member> memList = new ArrayList<Member>();
		
		memList.add(new Member(1, "ȫ�浿", "010-1111-1111"));
		memList.add(new Member(5, "���е�", "010-2222-2222"));
		memList.add(new Member(9, "������", "010-3333-3333"));
		memList.add(new Member(3, "�̼���", "010-4444-4444"));
		memList.add(new Member(6, "������", "010-5555-5555"));
		memList.add(new Member(2, "������", "010-6666-6666"));
		
		System.out.println("������");
		for (Member mem : memList) {
			System.out.println(mem);
		}
		System.out.println("----------------------------------------------");
		
		System.out.println("�̸��� �������� ������");
		Collections.sort(memList);
		for (Member mem : memList) {
			System.out.println(mem);
		}
		
		//ȸ����ȣ�� ������������ ���ĵǴ� �ܺ����� ������ �����Ͽ� ������ �� ����� ����Ͻÿ�.
		System.out.println("ȸ����ȣ �������� ���� ��");
		Collections.sort(memList, new MemberDesc());
		for (Member mem : memList) {
			System.out.println(mem);
		}
		

	}
}

/*
	���İ� ���õ� interface�� Comparator�� Comparable �̷��� �ΰ����� �ִ�.
	
	���� ��ü ��ü�� ���ı���� �ֱ� ���ؼ��� Comparable�� �����ϰ� 
	���ı����� ������ �����ϰ� ���� ���� Comparator�� �����Ͽ� ����ϸ� �ȴ�.
	
	Comparable������ compareTo()�޼��带 �����ؾ� �ϰ�,
	Comparator������ compare()�޼��带 �����ؾ� �Ѵ�.
 */

//ȸ�� �̸��� �������� �������� ������ �� �� �ִ� Ŭ���� �����
//MemberŬ���� ��ü�� ���� ������ �ִ´�.
class Member implements Comparable<Member>{			//���ʿ� Ŭ�������� ���ı��� �־��ִ� ����� �ְ�, �ܺ������� ���� ���ִ¹�ĵ� �ִ�.
	private int num;
	private String name;
	private String te;
	
	public Member(int num, String name, String te) {
		super();
		this.num = num;
		this.name = name;
		this.te = te;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTe() {
		return te;
	}

	public void setTe(String te) {
		this.te = te;
	}
	
	
	@Override
	public String toString() {
		return "Member [num=" + num + ", name=" + name + ", te=" + te + "]";
	}
	
	//�̸��� �������� �������� ������ �ǵ��� �����Ѵ�.
	@Override
	public int compareTo(Member mem) {
		return name.compareTo(mem.getName());
	}
}

//ȸ����ȣ�� ���������� ������ �� �ִ� �ܺ� ���� ����
class MemberDesc implements Comparator<Member>{
	
	@Override
	public int compare(Member mem1, Member mem2) {
		
		/*
		// �� �޼��尡 ����� ��ȯ�ϸ� �� ���� ������ �ٲ��.		
		if(mem1.getNum() > mem2.getNum()){
			return -1;
		}else if(mem1.getNum() < mem2.getNum()){
			return 1;
		}else{
			return 0;
		}
		*/
		
		//wrapperŬ������ �̿��ϴ� ���1
//		return Integer.compare(mem1.getNum(), mem2.getNum()) * -1;
		
		//wrapperŬ������ �̿��ϴ� ���2
		return new Integer(mem1.getNum()).compareTo(mem2.getNum()) * -1;
		
	}
}


