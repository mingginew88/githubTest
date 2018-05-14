package basic;

import java.util.Vector;

public class VectorTest {
	public static void main(String[] args) {
		//Vector
		
		Vector v1 = new Vector();
		System.out.println("ó�� ũ�� : " + v1.size());
		
		//Vector�� add����� �̿��Ͽ� �����͸� �߰��Ѵ�.
		v1.add("aaa");
		v1.add(new Integer(111));		//wrapperŬ����(�⺻�����͸� ��üȭ�����ִ� Ŭ����)
		v1.add(123);	//����ڽ�(�ڵ����� ��ü�� �������)
		v1.add('a');
		v1.add(true);
		v1.add(3.14);
		
		System.out.println("ũ�� : " + v1.size());
		
		//�����͸� �߰��ϴ� ������� addElement�� �ִµ�
		//�� �޼���� ���� ������ ȣȯ���� ���ؼ� �����Ѵ�.		
		v1.addElement("CCC");
		
		System.out.println("v1 => " + v1);
		
		//������ �߰��� ���ο� ������ �����ֱ�	
		// ==> add(index, ������); ==> ������ index��°�� '������'�� �����ִ´�.
		v1.add(1, "kkk");
		System.out.println("v1 =>" + v1);
		System.out.println();
		
		//������ �����ϱ�
		// ==> set(index, ���ο����);
		// ==> index��°�� �����͸� '���ο����'�� �����Ѵ�.
		// ==> ��ȯ�� : ������ �����͸� ��ȯ�Ѵ�.
		String temp = (String) v1.set(0, "zzz");		//set���� �����ϱ����� ���� temp�� �����Ѵ�.
		System.out.println("���� ������ : " + temp);
		System.out.println("v1 =>" + v1);
		System.out.println();
		
		//������ �����ϱ�
		// ==> remove(index) ==> index��°�� �ڷḦ �����Ѵ�.
		// ==> ��ȯ�� : ������ ������
		// ==> �ڷᰡ �����Ǹ� index��° ������ �����͵��� ���ʷ� ������ �ڵ����� ������� ä������.		
//		String temp2 = (String)v1.remove(1);
//		System.out.println("���������� : " + temp2);		//remove�� �����ϱ����� temp2�� �����Ѵ�.
//		System.out.println("v1 =>" + v1);
		
		// ==> remove(�����ҵ�����) ==> ������ �����͸� ã�Ƽ� �����Ѵ�.		//List�� Vector�� ��쿡 �ߺ��Ǵ� �����Ͱ� �����Ҽ��־ ���� �տ������� �ϳ��� ��������.
		// ==> ������ �����Ͱ� �������̸� �տ������� �����ȴ�.
		// ==> ������ �����Ͱ� '������' �� 'char��' �� ��쿡�� ��ü������ ��ȯ�ؼ� ����ؾ� �Ѵ�.
		v1.remove(0);
		System.out.println("���� �� v1 => " + v1);
		System.out.println();
		
		temp = (String)v1.remove(0);
		System.out.println("������ ������ : " +  temp);
		System.out.println("���� �� v1 : " +  v1);
		System.out.println();
		
		v1.add(123);
		System.out.println("v1 => : " + v1);
		
		v1.remove(true);
		System.out.println("true ���� �� v1 : " + v1);
		System.out.println();
		
		v1.remove(new Integer(111));
		System.out.println("111 ���� �� v1 : " + v1);
		System.out.println();
		
		v1.remove(new Character('a'));
		System.out.println("a�� ���� �� v1 : " + v1);
		System.out.println();
		
		v1.remove(3.14);
		System.out.println("3.14�� ������ v1 : " + v1);
		System.out.println();
		
		v1.remove(new Integer(123));					//�ߺ��� ���� �����Ͱ� �������϶� �տ������� �ϳ��� �����.
		System.out.println("123�� ������ v1 : " + v1);
		System.out.println();
		
		
		//������ ��������
		// ==> get(index) : ==> index��°�� �����͸� �����´�.
		String data = (String) v1.get(0);
		System.out.println("������ ������ : " + data);
		System.out.println("---------------------------------------");
		
		/*
		 	���׸� Ÿ��(Generic Type)
		 	==> ��ü�� ������ ��  < > �ȿ� �� collection�� ����� ������ Ÿ���� �����ִ� ���� ���Ѵ�.
		 	 �̷������� �����ϰ� �Ǹ� ������ ������ Ÿ�� �̿��� �ٸ� �����͸� ���� �� �� ���� �ȴ�.
		 	 ��, ���׸����� ����� �� �ִ� ������ Ÿ���� Ŭ���� ���̾�� �Ѵ�.
		 	 �׷��� int�� Integer, boolean�� Boolean, char�� Character������ ��ü�Ͽ� ����ؾ� �Ѵ�.
		 	 
		 	 ���׸� Ÿ������ �����ϰ� �Ǹ� �����͸� ������ �� ������ ����ȯ�� �� �ʿ䰡 ��������.		 
		 */
		System.out.println("-----------Generic ���-----------------");
		Vector<String> v2 = new Vector<String>();	//String�� �����Ҽ� �ִ� Vector
		Vector<Integer> v3 = new Vector<Integer>(); //�������� �����Ҽ� �ִ� Vector
		
		v2.add("�ȳ��ϼ���");
//		v2.add(123);	//���� : �ٸ� ������ �����͸� �߰��� �� ����.
		
		String test = v2.get(0);
		System.out.println("test : " + test);
		System.out.println();
		
		Vector<Vector> vv = new Vector<Vector>();
		Vector<Vector<Vector>> vvv = new Vector<Vector<Vector>>();
		
		v2.clear();
		System.out.println("v2�� size : " + v2.size());
		
		v2.add("AAA");
		v2.add("BBB");
		v2.add("CCC");
		v2.add("DDD");
		v2.add("EEE");
		
		Vector<String> v4 = new Vector<String>();
		v4.add("BBB");
		v4.add("EEE");
		
		System.out.println("v2 : " + v2);
		System.out.println("v4 : " + v4);
		System.out.println();
		
		//removeAll(Collection��ü) ==> 'Collection��ü'�� ������ �ִ� �����͸� ��� �����Ѵ�.
		
		v2.removeAll(v4);
		System.out.println("���� �� v2 : " + v2);
		System.out.println();
		
		System.out.println("-----------------------------------------");
		
		v2.clear();
		
		v2.add("AAA");
		v2.add("BBB");
		v2.add("CCC");
		v2.add("DDD");
		v2.add("EEE");
		
		//������ �����͸� ������� ��� ������ ����ϰ� ������ �ݺ����� ����ϸ�ȴ�.
		for (int i = 0; i < v2.size(); i++) {
			System.out.println(i + "��° �ڷ� : " + v2.get(i));
		}
		System.out.println("-----------------------------------------");
		
		//���� for��
		/*
		 	==> '�迭�̳� �÷���'���� �����͸� �ϳ��� ���� ������ ������ ��
		 	 	'�ݺ��� �����'�� ó���� �� ���� �����͸� ������ ������ �� �ݺ��ϴ� �۾���
		 	 	������ ������ŭ �ڵ����� ó���ϴ� �ݺ����̴�. 
		 	���� ) for(�ڷ����̸� ������ : �迭�̳� �÷���) {
		 				�ݺ��� ����� :
		 				...
		 		  }		 
		 */
		
		for(String s : v2){
			System.out.println(s);
		}
		
		
		
		
		
		
		// ==>
		
		
		
		
		
		
		
	}

}
