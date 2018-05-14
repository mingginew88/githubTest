package basic;

import java.util.ArrayList;

public class ArrayListTest {
	public static void main(String[] args) {
		//ArrayList�� ������ Vector�� ���� ����.
		
		ArrayList list1 = new ArrayList();
		
		//add�� �̿��Ͽ� �߰��Ѵ�.
		list1.add("aaa");
		list1.add("bbb");
		list1.add(111);		//������
		list1.add('k');		//������
		list1.add(true);	//����
		list1.add(3.14);	//�Ǽ���
		
		System.out.println("size => " + list1.size());
		System.out.println("list1 => " + list1);
		System.out.println();
		
		// get���� �����͸� �����´�.
		System.out.println("1��° �ڷ� : " + list1.get(1));
		System.out.println();
		
		// ������ ���� �ֱ⵵ ����.
		list1.add(2, "zzz");
		System.out.println("list1 => " + list1);
		System.out.println();
		
		// ������ �����ϱ�
		String temp = (String)list1.set(0, "yyy");
		System.out.println("temp : " + temp);
		System.out.println("list1 : " + list1);
		System.out.println();
		
		//������ ����
		list1.remove(2);
		System.out.println("list1 : " + list1);
		System.out.println();
		
		list1.remove("yyy");
		System.out.println("list1 : " + list1);
		System.out.println();
		
		// ���׸��� �����Ͽ� ���� �� �� �ִ�.
		ArrayList<String> list2 = new ArrayList<String>();
		
		list2.add("AAA");
		list2.add("BBB");
		list2.add("CCC");
		list2.add("DDD");
		list2.add("EEE");
		
		for (int i = 0; i < list2.size(); i++) {
			System.out.println(i + "��° : " + list2.get(i));
		}
		
		System.out.println("---------------------------------------");		
		// ���� for��
		for(String s : list2){
			System.out.println(s);
		}
		System.out.println("---------------------------------------");		
		
		// contains(�񱳰�ü);  ==>  ����Ʈ�� '�񱳰�ü'�� ������ true   ==> ������ false
		System.out.println("DDD�� ���� ���� : " + list2.contains("DDD"));
		System.out.println("ZZZ�� ���� ���� : " + list2.contains("ZZZ"));
		System.out.println();
		
		// indexOf(�񱳰�ü);  ==> ����Ʈ�� '�񱳰�ü'�� ������ '�񱳰�ü'�� �ִ� index���� ��ȯ�Ѵ�.
						//	 ==> ����Ʈ�� '�񱳰�ü'�� ������ -1�� ��ȯ�Ѵ�.
		System.out.println("DDD�� index�� : " + list2.indexOf("DDD"));
		System.out.println("ZZZ�� index�� : " + list2.indexOf("ZZZ"));
		System.out.println("---------------------------------------");		
		
		//toArray(); ==> ����Ʈ���� �����͵��� �迭�� ��ȯ�Ͽ� ��ȯ�Ѵ�.
				//	 ==> �⺻������ Object������ ��ȯ�ȴ�. 
		
		// toArray(new ���׸�Ÿ��[0]); ==> ���׸�Ÿ���� �迭�� ��ȯ�Ѵ�.
		Object[] strArr = list2.toArray();
		System.out.println("�迭 ���� : "  + strArr.length);
		for (int i = 0; i < strArr.length; i++) {
			System.out.println(i + "��° : " +strArr[i]);
		}
		System.out.println("---------------------------------------");		
		
//		String[] strArr3 = (String[])list2.toArray();	//����ȯ �ȵȴ�.
		String[] strArr2 = list2.toArray(new String[0]);	// toArray(new ���׸�Ÿ��[0]); ==> ���׸�Ÿ���� �迭�� ��ȯ�Ѵ�.	
		for (int i = 0; i < strArr2.length; i++) {
			System.out.println(i + "��° : " +strArr2[i]);
		}
		System.out.println("---------------------------------------");		
		
		for(String str : strArr2){
			System.out.println(str);
		}
		System.out.println("---------------------------------------");		
		
		
	}

}
