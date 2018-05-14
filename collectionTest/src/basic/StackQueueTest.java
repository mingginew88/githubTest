package basic;

import java.util.LinkedList;

public class StackQueueTest {
	public static void main(String[] args) {
		
		/*
		 	Stack ==> LIFO(후입선출)의 자료구조
		 	Queue ==> FIFO(선입선출)의 자료구조
		 	
		 	Stack과 Queue는 LinkedList를 이용하여 사용할 수 있다.
		 */
		
		LinkedList<String> stack = new LinkedList<String>();
		/*
		 	Stack의 명령
		 	1. 자료 입력 : push(입력값)
		 	2. 자료 출력 : pop() ==> 자료를 꺼내온 후 꺼내온 자료를 삭제한다.
		 */
		
		stack.push("홍길동");
		stack.push("일지매");
		stack.push("변학도");
		stack.push("강감찬");
		System.out.println("stack값들 : " + stack);
		
		String data = stack.pop();
		System.out.println("꺼내온 데이터 : " + data);
		System.out.println("꺼내온 데이터 : " + stack.pop());
		System.out.println("stack값들 : " + stack);
		
		stack.push("성춘향");
		System.out.println("stack값들 : " + stack);
		System.out.println("꺼내온 데이터 : " + stack.pop());
		System.out.println("---------------------------------------------");
		
		
		LinkedList<String> queue = new LinkedList<String>();
		/*
		 	queue의 명령
		 	1. 자료 입력 : offer(입력값)
		 	2. 자료 출력 : poll() ==> 자료를 queue에서 꺼내온 후 꺼내온 자료를 queue에서 삭제한다.
		 */
		
		queue.offer("홍길동");
		queue.offer("일지매");
		queue.offer("변학도");
		queue.offer("강감찬");
		System.out.println("queue의 값들 : " + queue);
		
		String data2 = queue.poll();
		System.out.println("꺼내온 데이터 : " + data2);
		System.out.println("꺼내온 데이터 : " + queue.poll());
		System.out.println("queue의 값들 : " + queue);
		
		queue.offer("성춘향");
		System.out.println("queue의 값들 : " + queue);
		System.out.println("꺼내온 데이터 : " + queue.poll());
		System.out.println("queue의 값들 : " + queue);
		
	}
}
