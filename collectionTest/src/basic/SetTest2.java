package basic;

import java.util.HashSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class SetTest2 {
	public static void main(String[] args) {
		//HashSet�� �������� ������ ������
		//TreeSet�� �����͸� �ڵ����� ����
		
//		HashSet<String> ts = new HashSet<String>();
		TreeSet<String> ts = new TreeSet<String>();		
		for (char ch = 'Z';  ch >= 'A'; ch--) {
//			String temp = String.valueOf(ch);
			String temp = ch + "";
			ts.add(temp);
		}
		System.out.println("TreeSet ������ : " + ts);
		System.out.println();
		
		// TreeSet�� ����� �ڷ��� Ư���� �ڷẸ�� ���� �ڷḦ ã�Ƽ� SortedSet���� ��ȯ�ϴ� �޼��尡 �ִ�.
		// ==> headSet(���ذ�) �޼���
		// ==> �� �޼���� �⺻������ '���ذ�'�� ���Ե��� �ʴ´�.
		
		// '���ذ�'�� ���� ���δ� �޼��带 ȣ���� �� ���ذ� ������ true(����), false(������)�� �����Ͽ� ������ �� �ִ�.
		SortedSet<String> ss1 = ts.headSet("K");		//K���� ���� �����͸� ��������� ����.
		System.out.println("K���� �ڷ� : " + ss1);
		System.out.println("K���� �ڷ� : " + ts.headSet("K", true));
		System.out.println();
		
		// tailSet(���ذ�) ==> '���ذ�'���� ū �ڷḦ ã�� SortedSet���� ��ȯ�ϴ� �޼��� �⺻������ '���ذ�'�� ���Եȴ�.
		SortedSet<String> ss2 = ts.tailSet("K");
		System.out.println("K���� �ڷ� : " + ss2);
		System.out.println("K���� �ڷ� : " + ts.tailSet("K", false));
		System.out.println();
		
		//subSet(���ذ�1, ���ذ�2) ==> ~���� ~������ ���� �����´�.
		System.out.println(ts.subSet("K", "N"));
		
		//subSet�� ���ذ� �ڿ� boolean���� �ٿ��� ���� ���θ� ���� �� �ִ�.
		System.out.println(ts.subSet("K", true, "N", true));
		System.out.println(ts.subSet("K", false, "N", false));
		System.out.println(ts.subSet("K", false, "N", true));
		
		
		
		
		
		
	}

}
