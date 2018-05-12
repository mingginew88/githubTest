package i_collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Collection03 {
	public static void main(String[] args) {
		
		//Iterator
		//Enumeration는 컬렉션이 만들어 지기전에 사용되던 Iterator의 구버전 이라고 생각하면 된다.
		
		List list = new ArrayList();
		list.add("123");
		list.add("456");
		list.add("789");
		
		Iterator it = list.iterator();
		while(it.hasNext()){		//정방향으로 진행
			
//			System.out.println(it.next());	//이것도 가능
//			it.remove();
			
			System.out.println(it.next());		//꺼내옴			
		}
		
		//ListIterator
		//Iterator의 단방향을 보완하기 위해서 나왔다.
		//단 List인터페이스를 구현한 구현체에서만 사용가능하다.
		ListIterator li = list.listIterator();
		li.hasNext();
		li.next();
		li.hasPrevious();
		li.previous();
		
		
	}

}
