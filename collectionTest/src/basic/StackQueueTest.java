package basic;

import java.util.LinkedList;

public class StackQueueTest {
	public static void main(String[] args) {
		
		/*
		 	Stack ==> LIFO(���Լ���)�� �ڷᱸ��
		 	Queue ==> FIFO(���Լ���)�� �ڷᱸ��
		 	
		 	Stack�� Queue�� LinkedList�� �̿��Ͽ� ����� �� �ִ�.
		 */
		
		LinkedList<String> stack = new LinkedList<String>();
		/*
		 	Stack�� ���
		 	1. �ڷ� �Է� : push(�Է°�)
		 	2. �ڷ� ��� : pop() ==> �ڷḦ ������ �� ������ �ڷḦ �����Ѵ�.
		 */
		
		stack.push("ȫ�浿");
		stack.push("������");
		stack.push("���е�");
		stack.push("������");
		System.out.println("stack���� : " + stack);
		
		String data = stack.pop();
		System.out.println("������ ������ : " + data);
		System.out.println("������ ������ : " + stack.pop());
		System.out.println("stack���� : " + stack);
		
		stack.push("������");
		System.out.println("stack���� : " + stack);
		System.out.println("������ ������ : " + stack.pop());
		System.out.println("---------------------------------------------");
		
		
		LinkedList<String> queue = new LinkedList<String>();
		/*
		 	queue�� ���
		 	1. �ڷ� �Է� : offer(�Է°�)
		 	2. �ڷ� ��� : poll() ==> �ڷḦ queue���� ������ �� ������ �ڷḦ queue���� �����Ѵ�.
		 */
		
		queue.offer("ȫ�浿");
		queue.offer("������");
		queue.offer("���е�");
		queue.offer("������");
		System.out.println("queue�� ���� : " + queue);
		
		String data2 = queue.poll();
		System.out.println("������ ������ : " + data2);
		System.out.println("������ ������ : " + queue.poll());
		System.out.println("queue�� ���� : " + queue);
		
		queue.offer("������");
		System.out.println("queue�� ���� : " + queue);
		System.out.println("������ ������ : " + queue.poll());
		System.out.println("queue�� ���� : " + queue);
		
	}
}
