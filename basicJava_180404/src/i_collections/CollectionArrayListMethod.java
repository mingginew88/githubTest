package i_collections;

import java.util.ArrayList;
import java.util.List;

public class CollectionArrayListMethod {
	
	public static void main(String[] args) {
		
		//1. ArrayList() : 크기가 10인 ArrayList를 생성
		List<Integer> al = new ArrayList();
		for(int i = 0; i < 10; i++){
			al.add(i);
		}
		System.out.println(al);		
		
		//2. ArrayList(Collection c) : 주어진 컬렉션이 저장된 ArrayList를 생성
		List al2 = new ArrayList<Integer>(al);
		al2.add("4");
		System.out.println(al2);
		
//??	//3. ArrayList(int initialCapacity) : 지정된 초기용량을 갖는 ArrayList를 생성
		ArrayList al3 = new ArrayList<Integer>(al);
		al3.add("5");
		System.out.println(al3);
		//4. boolean add(Object o) : ArrayList의 마지막에 객체를 추가. 성공하면 true
		al.add(2);
		
		//5. void add(int index, Object element) : 지정된 위치(index)에 객체를 저장
		al.add(2, 3);
		System.out.println(al);
		
		//6. boolean addAll(Collection c) : 주어진 컬렉션의 모든 객체를 저장한다.
		al.addAll(al2);
		System.out.println(al);
		
		//7. boolean addAll(int index, Collection c) : 지정된 위치부터 주어진 컬렉션의 모든 객체를 저장한다.
		al.addAll(2, al3);
		System.out.println(al);		
		
		//8. void clear() : ArrayList를 완전히 비운다.
		al2.clear();
		System.out.println(al2);
		
		//9. Object clone() : ArrayList를 복제한다.		
		System.out.println(al3.clone());		
		
		//10. boolean contains(Object o) :지정된 객체(o)가 ArrayList에 포함되어 있는지 확인
		System.out.println(al3.contains("5"));
		
//??	//11. void ensureCapacity(int minCapacity) : ArrayList의 용량이 최소한 minCapacity가 되도록 한다.
		((ArrayList) al).ensureCapacity(10);
		System.out.println(al);
		
		//12. Object get(int index) : 지정된 위치(index)에 저장된 객체를 반환한다.
		System.out.println(al.get(3));
		
		//13. int indexOf(Object o) : 지정된 객체가 저장된 위치를 찾아 반환한다.
		System.out.println(al.indexOf("5"));
		
		//14. boolean isEmpty() :ArrayList가 비어있는지 확인한다.
		System.out.println(al2.isEmpty());
		
//??	//15. Iterator iterator() : ArrayList의 Iterator객체를 반환한다.
		
				
		//16. int lastindexOf(Object o) : 객체(o)가 저장된 위치를 끝부터 역방향으로 검색해서 반환
		System.out.println(al.lastIndexOf("4"));		
		
//??	//17. ListIterator ListIterator() : ArrayList의 ListIterator를 반환
		
		
//??	//18. ListIterator ListIterator(int index) : ArrayList의 지정된 위치부터 시작하는 ListIterator를 반환
		
		
		//19. Object remove(int index) : 지정된 위치(index)에 있는 객체를 제거한다.
		System.out.println(al.remove(2));
		
		//20. boolean remove(Object o) : 지정한 객체를 제거한다. (성공하면 true, 실패하면 false)
		System.out.println(al.remove("3"));
		System.out.println(al);
		
		//21. boolean removeAll(collection c) :지정한 컬렉션에 저장된 것과 동일한 객체들을 ArrayList에서 제거한다.
		System.out.println(al.removeAll(al3));
		System.out.println(al);
		
		//22. boolean retainAll(Collection c) : ArrayList에 저장된 객체중에서 주어진 컬렉션과 공통된 것들만 남기고 나머지는 삭제한다.
		System.out.println(al.retainAll(al3));
		System.out.println(al);
		al.add(1);		
		al.add(2);
		System.out.println(al);
		
		//23. Object set(int index, Object element) :주어진 객체(element)를 지정된 위치(index)에 저장한다.
		System.out.println(al.set(1, 2));
		System.out.println(al);		
		
		//24. int size() : ArrayList에 저장된 객체의 개수를 반환한다.
		System.out.println(al.size());		
		al.add(4);
		al.add(6);
		
//??	//25. void sort(Comparator c) : 지정된 정렬기준(c)으로 ArrayList를 정렬		
		
		
		//26. List subList(int fromIndex, int toIndex) : fromIndex부터 toIndex사이에 저장된 객체를 반환한다.
		System.out.println(al.subList(2, 4));
		
//??	//27. Object[] toArray() : ArrayList에 저장된 모든 객체들을 객체배열로 반환한다.		
		
		
//??	//28. Object[] toArray(Object[] a) : ArrayList에 저장된 모든 객체들을 객체배열 a에 담아 반환한다.
		
		
		//29. void trimToSize() : 용량을 크기에 맞게 줄인다.( 빈 공간을 없앤다.)
		((ArrayList) al).trimToSize();
		
		
	
		
	}

}
