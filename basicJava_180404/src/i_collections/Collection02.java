package i_collections;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Collection02 {
	public static void main(String[] args) {
		Stack<String> st = new Stack<String>();
		
		st.push("0");		//추가
		st.push("1");
		st.push("2");
		
		System.out.println("===================== Stack ========================");
		
		while(!st.empty()){
			System.out.println(st.pop());
		}
		
		Queue<String> que = new LinkedList<String>();
		que.offer("0");
		que.offer("1");
		que.offer("2");
		
		System.out.println("===================== Queue ========================");
		while(!que.isEmpty()){
			System.out.println(que.poll());
		}
		
		
		
		
		
		
		
		
		
		
	}

}
