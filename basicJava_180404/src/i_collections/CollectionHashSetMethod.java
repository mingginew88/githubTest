package i_collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CollectionHashSetMethod {
	
	public static void main(String[] args) {
		
		//1. HashSet() : HashSet객체를 생성한다
		Set hs = new HashSet();
		
		//2. HashSet(Collection c) : 주어진 컬렉션을 포함하는 HashSet객체를 생성한다.
		Set hs2 = new HashSet(hs);
		
		//3. HashSet(int initialCapacity) : 주어진 값을 초기용량으로 하는 HashSet객체를 생성한다.
		Set hs3 = new HashSet<Integer>(2);
		System.out.println(hs3);
		
		//4. HashSet(int initialCapacity, float loadFactor) : 초기용량과 load factor를 지정하는 생성자.	//load factor 란?
		Set hs4 = new HashSet(10, 3);
		System.out.println(hs4);
		
		//5. boolean add(Object o) : 새로운 객체를 저장한다.
		hs.add("1");
		hs2.add("3");
		System.out.println(hs);
		
		//6. boolean adAll(collection c) : 주어진 컬렉션에 저장된 모든 객체들을 추가한다.(합집합)
		hs2.addAll(hs);
		System.out.println(hs2);
		
		//7. void clear() : 저장된 모든 객체들을 삭제한다.
		hs.clear();
		System.out.println(hs);
		hs.add("4");
		hs.add("2");
		
//??	//8. Object clone() : HashSet을 복제해서 반환한다.(얕은복사)
		
		
		//9. boolean contains(Object o) : 지정된 객체를 포함하고 있는지 알려준다.
		System.out.println(hs.contains("2"));
		
		//10. boolean containsAll(Collection c) : 주어진 컬렉션에 저장된 모든 객체들을 포함하고 있는지 알려준다.
		System.out.println(hs.containsAll(hs2));
		
		//11. boolean isEmpty() : HashSet이 비어있는지 알려준다.
		System.out.println(hs3.isEmpty());
		
//??	//12. Iterator iterator() : Iterator를 반환한다.
		Iterator it = hs.iterator();		
		
		//13. boolean remove(Object o ) : 지정된 객체를 HashSet에서 삭제한다.(성공하면true, 실패하면 false)
		System.out.println(hs.remove("3"));
		System.out.println(hs2.remove("3"));
		
		//14. boolean removeAll(Collection c) : 주어진 컬렉션에 저장된 모든 객체와 동일한 것들을 HashSet에서 모두 삭제한다.(차집합)
		hs.removeAll(hs2);
		System.out.println(hs);
		hs.add("1");
		
		//15. boolean retainAll(Collection c) : 주어진 컬렉션에 저장된 객체와 동일한 것만 남기고 삭제한다.(교집합)
		System.out.println(hs.retainAll(hs2));
		System.out.println(hs);
		
		//16. int size() : 저장된 객체의 개수를 반환한다.
		System.out.println(hs.size());
		
//??	//17. Object[] toArray() : 저장된 객체들을 객체배열의 형태로 반환한다.
				
//??	//18. Object[] toArray(Object[] a) : 저장된 객체들을 주어진 객체배열(a)에 담는다.
		
		
		
	}

}
