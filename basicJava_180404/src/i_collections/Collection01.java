package i_collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Collection01 {
	public static void main(String[] args) {
		
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(new Integer(5));
		list1.add(2);		//오토박싱
		list1.add(3);
		list1.add(1);
		list1.add(4);
		
		System.out.println(list1);	//toString 메서드가 오버라이드 되어있다. (주소가아닌 값이 출력된다)
		
		ArrayList<Integer> list2 = new ArrayList<Integer>(list1.subList(2, 4));
		System.out.println(list2);
		
		Collections.sort(list1);		//자동 오름차순정렬 해준다
		System.out.println(list1);
		Collections.sort(list1, Collections.reverseOrder());		//내림차순
		System.out.println(list1);
		
		list1.remove(1);	//방번호 지우는것
//		list1.remove(new ???(1));		//객체를 지우는것
		System.out.println(list1);
		
		
		list1.set(1, 9);		//1번방에 있는것을 9로 바꿔라
		System.out.println(list1);
		System.out.println(list1.get(2));// 2번방의 객체를 가져와라
		
		
//		LinkedList			배열의 끝에 다음것의 주소를 가지고있다.
//		DoubleLInkedList	배열의 앞과 끝에 주소를 가지고있어 ...........
		
		
	}

}
