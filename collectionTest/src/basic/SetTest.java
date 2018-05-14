package basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/*
 	- List�� Set�� ������
 	
 	1. List
 		- �������� ������ �ִ�.
 		- �ߺ��Ǵ� �����͸� ������ �� �ִ�.
 		
 	2. Set
 		- �������� ������ ����.
 		- �ߺ��Ǵ� �����͸� ������ �� ����.
 */

public class SetTest {
	public static void main(String[] args) {
		HashSet hsl = new HashSet();
		
		//HashSet�� �����͸� �߰��� ���� add()�޼��带 ����Ѵ�.
		hsl.add("DD");
		hsl.add("AA");
		hsl.add(2);
		hsl.add("CC");
		hsl.add("BB");
		hsl.add(1);
		hsl.add(3);
		
		System.out.println("Set�� ������ : " + hsl);
		System.out.println("ũ�� : " + hsl.size());
		System.out.println();
		
		// HashSet�� �������� ������ ���� �ߺ��� ������� �ʴ´�.
		// �׷��� �̹� �ִ� �����͸� add()�ϸ� false�� ��ȯ�ϰ� �����ʹ� �߰����� �ʴ´�.
		boolean isAdd;
		isAdd = hsl.add("FF");
		System.out.println("�ߺ����� ���� �� : " + isAdd);
		isAdd = hsl.add("AA");
		System.out.println("�ߺ��Ǿ��� �� : " + isAdd);
		System.out.println("Set�� ������ : " + hsl);
		System.out.println();
		
		// HashSet�� ����Ʈ�� �����Ϸ��� �����ϴ� ����� ���� ���⶧�����ش� �ڷḦ ������ �� �߰��� �־�� �Ѵ�.
		// �����ϴ� �޼��� : remove(�����ҵ�����)
		//				 clear() ==> ��ü����
		
		// ��) FF�� EE�� �����ϱ�
		hsl.remove("FF");
		System.out.println("������ Set : " + hsl);
		hsl.add("EE");
		System.out.println("�߰��� Set : " + hsl);
		/*
		hsl.clear();
		System.out.println("clear() �� Set ������ : " + hsl);
		*/
		System.out.println();
		
		/*
		 	HashSet�� �������� ������ ���� ������ Listó�� �ε����� �����͸� �ϳ��� �ҷ��� �� ����.
		 	�׷��� �����͸� �ϳ��� ��� ���ؼ��� Iterator�� ��ȯ�ؾ��Ѵ�.		 
		 */
		
		// HashSet�� �����͵��� Iterator�� ��ȯ�ϱ�
		Iterator it = hsl.iterator();
//		it.hasNext();	//���� �����Ͱ� ����Ű�� ��ġ�� ������°�� �����Ͱ� �ִ��� ���θ� �Ǵ����ִ� �޼���
//		it.next();		//�����͸� ����ĭ���� �̵���Ų �� �� �ڸ��� �ִ� �����͸� �������� �޼���
		
		//������ ������ŭ �ݺ�ó���ϱ�
		//hasNext() ==> ������°�� �����Ͱ� ������ true, �׷��������� false
		while(it.hasNext()){
			//next() ==> �����͸� ���� �ڷ� ��ġ�� �̵���Ű�� �̵��� ��ġ�� �����͸� ��ȯ�Ѵ�.
			System.out.println(it.next());			
		}
		System.out.println();
		
		//�ζǹ�ȣ ����� (Set�̿��ϱ�)
		System.out.println("���̹��� �ζǹ�ȣ��");
		HashSet<Integer> lotto = new HashSet<Integer>();
		// �ּҰ� ~ �ִ밪 ������ ������ ���� �����
		//(int)(Math.random()*(�ִ밪-�ּҰ�+1) + �ּҰ�);
		while(lotto.size() < 6){
			//1~45������ ���� �����
			int num = (int)(Math.random()*45 + 1);
			lotto.add(num);
		}
		System.out.println(lotto);
		
		// �÷��� ������ ��ü���� ���� �ٸ� �ڷᱸ���� ���� ������ �����ϴ�.
		ArrayList<Integer> lottoList = new ArrayList<Integer>(lotto);
		for (Integer num : lottoList) {
			System.out.print(num + " ");
		}
		
		
		
		
		
		
		
	}
}
