package basic;

import java.util.ArrayList;

public class ArrayListTest {
	public static void main(String[] args) {
		//ArrayList의 사용법은 Vector와 거의 같다.
		
		ArrayList list1 = new ArrayList();
		
		//add를 이용하여 추가한다.
		list1.add("aaa");
		list1.add("bbb");
		list1.add(111);		//정수형
		list1.add('k');		//문자형
		list1.add(true);	//논리형
		list1.add(3.14);	//실수형
		
		System.out.println("size => " + list1.size());
		System.out.println("list1 => " + list1);
		System.out.println();
		
		// get으로 데이터를 꺼내온다.
		System.out.println("1번째 자료 : " + list1.get(1));
		System.out.println();
		
		// 데이터 끼워 넣기도 같다.
		list1.add(2, "zzz");
		System.out.println("list1 => " + list1);
		System.out.println();
		
		// 데이터 변경하기
		String temp = (String)list1.set(0, "yyy");
		System.out.println("temp : " + temp);
		System.out.println("list1 : " + list1);
		System.out.println();
		
		//삭제도 같다
		list1.remove(2);
		System.out.println("list1 : " + list1);
		System.out.println();
		
		list1.remove("yyy");
		System.out.println("list1 : " + list1);
		System.out.println();
		
		// 제네릭을 지정하여 선언 할 수 있다.
		ArrayList<String> list2 = new ArrayList<String>();
		
		list2.add("AAA");
		list2.add("BBB");
		list2.add("CCC");
		list2.add("DDD");
		list2.add("EEE");
		
		for (int i = 0; i < list2.size(); i++) {
			System.out.println(i + "번째 : " + list2.get(i));
		}
		
		System.out.println("---------------------------------------");		
		// 향상된 for문
		for(String s : list2){
			System.out.println(s);
		}
		System.out.println("---------------------------------------");		
		
		// contains(비교객체);  ==>  리스트에 '비교객체'가 있으면 true   ==> 없으면 false
		System.out.println("DDD값 존재 여부 : " + list2.contains("DDD"));
		System.out.println("ZZZ값 존재 여부 : " + list2.contains("ZZZ"));
		System.out.println();
		
		// indexOf(비교객체);  ==> 리스트에 '비교객체'가 있으면 '비교객체'가 있는 index값을 반환한다.
						//	 ==> 리스트에 '비교객체'가 없으면 -1을 반환한다.
		System.out.println("DDD의 index값 : " + list2.indexOf("DDD"));
		System.out.println("ZZZ의 index값 : " + list2.indexOf("ZZZ"));
		System.out.println("---------------------------------------");		
		
		//toArray(); ==> 리스트안의 데이터들을 배열로 변환하여 반환한다.
				//	 ==> 기본적으로 Object형으로 변환된다. 
		
		// toArray(new 제네릭타입[0]); ==> 제네릭타입의 배열로 반환한다.
		Object[] strArr = list2.toArray();
		System.out.println("배열 개수 : "  + strArr.length);
		for (int i = 0; i < strArr.length; i++) {
			System.out.println(i + "번째 : " +strArr[i]);
		}
		System.out.println("---------------------------------------");		
		
//		String[] strArr3 = (String[])list2.toArray();	//형변환 안된다.
		String[] strArr2 = list2.toArray(new String[0]);	// toArray(new 제네릭타입[0]); ==> 제네릭타입의 배열로 반환한다.	
		for (int i = 0; i < strArr2.length; i++) {
			System.out.println(i + "번째 : " +strArr2[i]);
		}
		System.out.println("---------------------------------------");		
		
		for(String str : strArr2){
			System.out.println(str);
		}
		System.out.println("---------------------------------------");		
		
		
	}

}
