package i_collections;

import java.util.HashMap;
import java.util.Map;

public class CollectionHashMapMethod {
	public static void main(String[] args) {
		
		//1. HashMap() : HashMap객체를 생성
		Map<String, Integer> hm = new HashMap<String, Integer>();
		hm.put("Dean", 3);		
		hm.put("Yoon", 1);		
		
		
		//2. HashMap(int initial Capacity) : 지정된 값을 초기용량으로 하는 HashMap객체를 생성   //굳이 크기가 커지는데 초기용량설정을하는이유?
		Map<String, Integer> hm2 = new HashMap<String, Integer>(10);
		hm2.put("고양이", 4);
		hm2.put("강아지", 2);
		hm2.put("냐옹이", 3);
		hm2.put("야옹이", 1);
		hm2.put("야옹", 5);
		hm2.put("야이", 1);

		System.out.println(hm2);		
		
		//3. HashMap(int initialCapacity, float loadFactor) : 지정된 초기용량과 load factor의 HashMap객체를 생성
		Map<String, Integer> hm3 = new HashMap<String, Integer>(5, 3);
		hm3.put("호랑이", 3);
		
		System.out.println(hm3);				
		
		//4. HashMap(Map m) : 지정된 Map의 모든 요소를 포함하는 hashMap을 생성
		Map<String, Integer> hm4 = new HashMap<String, Integer>(hm2);
		System.out.println(hm4);			
		
		//5. void clear() : HashMap에 저장된 모든 객체를 제거
		hm.clear();
		
//??	//6. Object clone() : 현재 HashMap을 복제해서 반환		
		
		
		//7. boolean containsKey(Object Key) : hashMap에 지정된 키(key)가 포함되어있는지 알려준다.(포함되어있으면 true)
		System.out.println(hm3.containsKey("호랑이"));
		
		//8. boolean containsValue(object value) : HashMap에 지정된 값(value)가 포함되어 있는지 알려준다.(포함되어있으면 true)
		System.out.println(hm2.containsValue(4));
		
		//9. Set entrySet() : HashMap에 저장된 키와 값을 엔트리(키와 값의 결합)의 형태로 Set에 저장해서 반환
		hm2.entrySet();		
		System.out.println(hm2.entrySet());
		
		//10. Object get(Object key) : 지정된 키(key)의 값(객체)을 반환. 못찾으면 null반환
		System.out.println(hm2.get("호랑이"));
		
//??	//11. Object getOrDefault(Object key, Object defaultValue) : 지정된 키(key)의 값(객체)을 반환한다. 
		//														      키를 못찾으면, 기본값으로 지정된 객체를 반환
		
		
		//12. boolean isEmpty() : HashMap이 비어있는지 알려준다.
		System.out.println(hm2.isEmpty());
		
		//13. void putAll(Map m) : Map에 저장된 모든 요소를 HashMap에 저장
		hm2.putAll(hm3);
		System.out.println(hm2);
		
		//14. Object remove(Object key) : HashMap에서 지정된 키로 저장된 값(객체)를 제거
		System.out.println(hm2.remove("야이"));
		System.out.println(hm2);
		
//??	//15. Object replace(Object key, Object value) :지정된 키의 값을 지정된 객체(value)로 대체
		
		
//??	//16. boolean replace(Object key, Object oldValue, Object newValue) : 지정된 키와 객체(oldValue)가 모두 일치하는 경우에만 새로운 객체(newValue)로 대체
		
		
		//17. int size() : HashMap에 저장된 요소의 개수를 반환
		System.out.println(hm2.size());
		
		//18. Collection values() : HashMap에 저장된 모든 값을 컬렉션의 형태로 반환
		System.out.println(hm2.values());
		
		
		
		
	}

}
