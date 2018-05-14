package basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapTest {
	/*
		Map ==> key값과 value값을 한 쌍으로 관리하는 객체
			==> key값은 중복을 허용하지 않고 순서가 없다. (Set의 특징)
			==> value값은 중복을 허용한다.
	 */
	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<String, String>();
		HashMap<String, String> map2 = new HashMap<String, String>();
		
		map.put("name", "홍길동");
		map.put("address", "대전");
		map.put("tel", "010-1234-5678");
		
		map2.put("name", "일지매");
		map2.put("address", "안면도");
		map2.put("tel", "010-1234-9999");
		
//		List<HashMap<String, String>> memList = new ArrayList<HashMap<String, String>>();
//		memList.add(map);
//		memList.add(map2);
//		System.out.println(memList);
		
		System.out.println("map => " + map);
		
		//자료수정 ==> 데이터를 지정할 때 key값이 같으면 나중에 입력한 값이 저장된다.
		map.put("address", "서울");
		System.out.println("map => " + map);
		System.out.println();
		
		//자료삭제 ==> remove(key값)
		map.remove("tel");
		System.out.println("map => " + map);
		System.out.println();
		
		//자료읽기 ==> get(key값); ==> key값과 한쌍인 value값을 읽어온다.
		System.out.println("name : " + map.get("name"));
		System.out.println("address : " + map.get("address"));
		System.out.println();
		
		//key값을 읽어와 자료를 출력하는 방법
		//방법 1 => keySet()메서드 이용하기
		//		=> key값만 읽어와 Set형으로 반환한다.
		Set<String> keySet = map.keySet();
		
		Iterator<String> it = keySet.iterator();
		while(it.hasNext()){
			String key = it.next();
			System.out.println(key + " => " + map.get(key));
		}
		System.out.println();
		
		//방법 1-2
		for (String key : keySet) {
			System.out.println(key + " => " + map.get(key));
		}
		System.out.println();
		
		//방법2 ==> value값만 읽어오기
		//		   value()메서드를 이용하기
		for (String value : map.values()) {
			System.out.println(value);
		}
		System.out.println();
		
		/*
	 	방법3 ==> Map에는 Entry라는 내부class가 만들어져 있다.
	 			이 Entry클래스는 key와 value라는 멤버변수로 구성되어 있다.
	 			Map에서는 이 Entry클래스 객체들을 Set형식으로 저장하여 관리한다.
		 */
		//	Entry객체 전체를 가져와서 처리하기
		//	==> entrySet()메서드 ==> 가져온 Entry객체들을 Set형식으로 반환한다.
		Set<Map.Entry<String, String>> mapSet = map.entrySet();
		
		//가져온 Entry객체들을 순서대로 처리하기 위해 Iterator객체로 변환한다.
		Iterator<Map.Entry<String, String>> entryIt = mapSet.iterator();
		
		while(entryIt.hasNext()){
			Map.Entry<String, String> entry = entryIt.next();
			System.out.println("key 값 : " + entry.getKey());
			System.out.println("value 값 : " + entry.getValue());
			System.out.println();
		}

		for (Map.Entry<String, String> entry : mapSet) {
			System.out.println("key 값 : " + entry.getKey());
			System.out.println("value 값 : " + entry.getValue());
			System.out.println();
		}		
		
		//containsKey(key값); ==> 지정한 key값이 있으면 true 없으면 false를 반환한다.
		//get(key값); ==> 해당 데이터가 없으면 null을 반환한다.
		//remove(key값); ==> 삭제가 성공되면 삭제된 데이터를 반환하고 실패하면 null을 반환한다.
		
		System.out.println(map.containsKey("name"));
		System.out.println(map.containsKey("key"));

		

	}
}
