package basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
/*
	Vector, Hashtable�� �������� �����ϴ� Collection���� ���ο� ����ȭ ó���� �Ǿ� �ִ�.
	
	�׷��� �ֱ׿� ���� ������ Collection���� ����ȭ ó���� �Ǿ� ���� �ʴ�.
	�׷��� ����ȭ�� �ʿ��� ���α׷����� �̷� Collection���� ����Ϸ��� ����ȭ ó���� �� �Ŀ� ����ؾ� �Ѵ�. 
	

 */




public class ThreadTest18 {
	
	//Vector
	private static Vector<Integer> vec = new Vector<Integer>();
	
	//ArrayList(����ȭó���� ���� ���� ���)
	private static ArrayList<Integer> list1 = new ArrayList<Integer>();
	
	//ArrayList(����ȭó���� �� ���)
	private static List<Integer> list2 = Collections.synchronizedList((new ArrayList<Integer>()));
			
	
	public static void main(String[] args) {
		//�͸� ����ü�� ������ ����
		Runnable r = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
//					vec.add(i);
//					list1.add(i);
					list2.add(i);
				}
			}
		};
		//=============================================
		
		Thread[] ths = new Thread[]{
				new Thread(r),
				new Thread(r),
				new Thread(r),
				new Thread(r),
				new Thread(r)
		};
		
		for (Thread th : ths) {
			th.start();
		}
		
		for (Thread th : ths) {
			try {
				th.join();
			} catch (InterruptedException e) {
			}
		}
		
//		System.out.println("Vector�� ���� : " + vec.size());
//		System.out.println("List�� ���� : " + list1.size());
		System.out.println("List�� ���� : " + list2.size());
		
	}

}
