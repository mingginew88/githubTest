package basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListSortTest {
	public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("일지매");
		list.add("홍길동");
		list.add("성춘향");
		list.add("변학도");
		list.add("이순신");
		System.out.println("정렬 전 : " + list);
		//정렬은 Collections.sort()메서드를 이용하여 정렬한다.
		//정렬은 기본적으로 오름차순 정렬을 수행한다.
		
		Collections.sort(list);
		System.out.println("정렬 후 : " + list);
		
		Collections.shuffle(list);		//자료섞기
		System.out.println("자료섞기 후 : " + list);
		
		//역순
		Collections.reverse(list);
		System.out.println("역순 : " + list);
		
		//Comparator 와 Comparable
		//Comparable - 기본 정렬기준을 구현하는데 사용.
		//Comparator - 기본 정렬기준 외에 다른 기준으로 정렬하고자 할 때 사용
		
		//내림차순
		Collections.sort(list, new Desc());
		System.out.println("내림차순 : " + list);
		
	}

}


//외부 정렬 기준을 적용할 class구현하기(Comparator를 구현한다.)
class Desc implements Comparator<String>{

	/*
	 	오름차순 ==> 앞의 값이 크면 양수, 같으면 0, 앞의 값이 작으면 음수를 반환하도록 한다.
	 			(양수를 반환하면 데이터의 순서가 바뀐다.)
	 			
	 	String객체에는 정렬을 위해서 compareTo()메서드가 구현되어 있는데 이 메서드의 반환값은 오름차순에 맞게 반환되도록 구현되어 있다.
	 	(wrapper클래스와 Date, File클래스에도 구현되어 있다.)		
	 */
	
	
	@Override
	public int compare(String s1, String s2) {
		
		if(s1.compareTo(s2) > 0) {
			return -1;  //순서를 안바꾸려면 음수를 주면된다. 일반적으로 -1을 사용한다.
		}else if ( s1.compareTo(s2) < 0) {
			return 1;	//순서를 바꾸려면 양수를 주면된다. 일반적으로 1을 사용한다.
		}else {
			return 0;
		}
		
//		return s1.compareTo(s2) * -1;	//이것만 써도 역순으로 반환해준다.
		
	}
}















