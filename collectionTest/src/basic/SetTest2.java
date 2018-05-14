package basic;

import java.util.HashSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class SetTest2 {
	public static void main(String[] args) {
		//HashSet은 데이터의 순서가 없으나
		//TreeSet은 데이터를 자동으로 정렬
		
//		HashSet<String> ts = new HashSet<String>();
		TreeSet<String> ts = new TreeSet<String>();		
		for (char ch = 'Z';  ch >= 'A'; ch--) {
//			String temp = String.valueOf(ch);
			String temp = ch + "";
			ts.add(temp);
		}
		System.out.println("TreeSet 데이터 : " + ts);
		System.out.println();
		
		// TreeSet에 저장된 자료중 특정한 자료보다 작은 자료를 찾아서 SortedSet으로 반환하는 메서드가 있다.
		// ==> headSet(기준값) 메서드
		// ==> 이 메서드는 기본적으로 '기준값'은 포함되지 않는다.
		
		// '기준값'의 포함 여부는 메서드를 호출할 때 기준값 다음에 true(포함), false(미포함)를 지정하여 결정할 수 있다.
		SortedSet<String> ss1 = ts.headSet("K");		//K보다 작은 데이터를 꺼내오라는 말임.
		System.out.println("K이전 자료 : " + ss1);
		System.out.println("K까지 자료 : " + ts.headSet("K", true));
		System.out.println();
		
		// tailSet(기준값) ==> '기준값'보다 큰 자료를 찾아 SortedSet으로 반환하는 메서드 기본적으로 '기준값'은 포함된다.
		SortedSet<String> ss2 = ts.tailSet("K");
		System.out.println("K부터 자료 : " + ss2);
		System.out.println("K이후 자료 : " + ts.tailSet("K", false));
		System.out.println();
		
		//subSet(기준값1, 기준값2) ==> ~부터 ~까지의 값을 가져온다.
		System.out.println(ts.subSet("K", "N"));
		
		//subSet도 기준값 뒤에 boolean값을 붙여서 포함 여부를 정할 수 있다.
		System.out.println(ts.subSet("K", true, "N", true));
		System.out.println(ts.subSet("K", false, "N", false));
		System.out.println(ts.subSet("K", false, "N", true));
		
		
		
		
		
		
	}

}
