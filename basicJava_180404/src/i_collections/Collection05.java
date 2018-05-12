package i_collections;

import java.util.HashMap;
import java.util.Map;

public class Collection05 {
	public static void main(String[] args) {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("김요섭", 100);
		map.put("서영준", 17);
		map.put("공은별", 50);
		map.put("김마음", 95);
		
//		CRUD(Create, Read, Update, Delete)
		
		System.out.println(map.get("공은별"));
		map.remove("공은별");
		System.out.println(map);// { }, Map이 중요!!
		
		map.put("서영준", 80);		//update할때도 put사용
		System.out.println(map);
		
		/*
		 JDK1.8
		 map.replace(key, value);
		 map.replace(key, old value,new value);		//key와 old value 둘다 같아야지 new value값으로 바뀐다.		 
		 */

		
		
	}

}
