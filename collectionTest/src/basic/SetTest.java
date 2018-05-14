package basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/*
 	- List와 Set의 차이점
 	
 	1. List
 		- 데이터의 순서가 있다.
 		- 중복되는 데이터를 저장할 수 있다.
 		
 	2. Set
 		- 데이터의 순서가 없다.
 		- 중복되는 데이터를 저장할 수 없다.
 */

public class SetTest {
	public static void main(String[] args) {
		HashSet hsl = new HashSet();
		
		//HashSet에 데이터를 추가할 때도 add()메서드를 사용한다.
		hsl.add("DD");
		hsl.add("AA");
		hsl.add(2);
		hsl.add("CC");
		hsl.add("BB");
		hsl.add(1);
		hsl.add(3);
		
		System.out.println("Set의 데이터 : " + hsl);
		System.out.println("크기 : " + hsl.size());
		System.out.println();
		
		// HashSet은 데이터의 순서가 없고 중복을 허용하지 않는다.
		// 그래서 이미 있는 데이터를 add()하면 false를 반환하고 데이터는 추가되지 않는다.
		boolean isAdd;
		isAdd = hsl.add("FF");
		System.out.println("중복되지 않을 때 : " + isAdd);
		isAdd = hsl.add("AA");
		System.out.println("중복되었을 때 : " + isAdd);
		System.out.println("Set의 데이터 : " + hsl);
		System.out.println();
		
		// HashSet의 데이트를 수정하려면 수정하는 명령이 따로 없기때문에해당 자료를 삭제한 후 추가해 주어야 한다.
		// 삭제하는 메서드 : remove(삭제할데이터)
		//				 clear() ==> 전체삭제
		
		// 예) FF를 EE로 수정하기
		hsl.remove("FF");
		System.out.println("삭제후 Set : " + hsl);
		hsl.add("EE");
		System.out.println("추가후 Set : " + hsl);
		/*
		hsl.clear();
		System.out.println("clear() 후 Set 데이터 : " + hsl);
		*/
		System.out.println();
		
		/*
		 	HashSet은 데이터의 순서가 없기 때문에 List처럼 인덱스로 데이터를 하나씩 불러올 수 없다.
		 	그래서 데이터를 하나씩 얻기 위해서는 Iterator로 변환해야한다.		 
		 */
		
		// HashSet의 데이터들을 Iterator로 변환하기
		Iterator it = hsl.iterator();
//		it.hasNext();	//현재 포인터가 가리키는 위치의 다음번째에 데이터가 있는지 여부를 판단해주는 메서드
//		it.next();		//포인터를 다음칸으로 이동시킨 후 그 자리에 있는 데이터를 꺼내오는 메서드
		
		//데이터 개수만큼 반복처리하기
		//hasNext() ==> 다음번째에 데이터가 있으면 true, 그렇지않으면 false
		while(it.hasNext()){
			//next() ==> 포인터를 다음 자료 위치로 이동시키고 이동한 위치의 데이터를 반환한다.
			System.out.println(it.next());			
		}
		System.out.println();
		
		//로또번호 만들기 (Set이용하기)
		System.out.println("※이번주 로또번호※");
		HashSet<Integer> lotto = new HashSet<Integer>();
		// 최소값 ~ 최대값 사이의 정수형 난수 만들기
		//(int)(Math.random()*(최대값-최소값+1) + 최소값);
		while(lotto.size() < 6){
			//1~45사이의 난수 만들기
			int num = (int)(Math.random()*45 + 1);
			lotto.add(num);
		}
		System.out.println(lotto);
		
		// 컬렉션 유형의 객체들은 서로 다른 자료구조로 쉽게 변경이 가능하다.
		ArrayList<Integer> lottoList = new ArrayList<Integer>(lotto);
		for (Integer num : lottoList) {
			System.out.print(num + " ");
		}
		
		
		
		
		
		
		
	}
}
