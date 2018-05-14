package basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListSortTest {
	public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("������");
		list.add("ȫ�浿");
		list.add("������");
		list.add("���е�");
		list.add("�̼���");
		System.out.println("���� �� : " + list);
		//������ Collections.sort()�޼��带 �̿��Ͽ� �����Ѵ�.
		//������ �⺻������ �������� ������ �����Ѵ�.
		
		Collections.sort(list);
		System.out.println("���� �� : " + list);
		
		Collections.shuffle(list);		//�ڷἯ��
		System.out.println("�ڷἯ�� �� : " + list);
		
		//����
		Collections.reverse(list);
		System.out.println("���� : " + list);
		
		//Comparator �� Comparable
		//Comparable - �⺻ ���ı����� �����ϴµ� ���.
		//Comparator - �⺻ ���ı��� �ܿ� �ٸ� �������� �����ϰ��� �� �� ���
		
		//��������
		Collections.sort(list, new Desc());
		System.out.println("�������� : " + list);
		
	}

}


//�ܺ� ���� ������ ������ class�����ϱ�(Comparator�� �����Ѵ�.)
class Desc implements Comparator<String>{

	/*
	 	�������� ==> ���� ���� ũ�� ���, ������ 0, ���� ���� ������ ������ ��ȯ�ϵ��� �Ѵ�.
	 			(����� ��ȯ�ϸ� �������� ������ �ٲ��.)
	 			
	 	String��ü���� ������ ���ؼ� compareTo()�޼��尡 �����Ǿ� �ִµ� �� �޼����� ��ȯ���� ���������� �°� ��ȯ�ǵ��� �����Ǿ� �ִ�.
	 	(wrapperŬ������ Date, FileŬ�������� �����Ǿ� �ִ�.)		
	 */
	
	
	@Override
	public int compare(String s1, String s2) {
		
		if(s1.compareTo(s2) > 0) {
			return -1;  //������ �ȹٲٷ��� ������ �ָ�ȴ�. �Ϲ������� -1�� ����Ѵ�.
		}else if ( s1.compareTo(s2) < 0) {
			return 1;	//������ �ٲٷ��� ����� �ָ�ȴ�. �Ϲ������� 1�� ����Ѵ�.
		}else {
			return 0;
		}
		
//		return s1.compareTo(s2) * -1;	//�̰͸� �ᵵ �������� ��ȯ���ش�.
		
	}
}















