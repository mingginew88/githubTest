package basic;

import java.util.Vector;

public class VectorTest {
	public static void main(String[] args) {
		//Vector
		
		Vector v1 = new Vector();
		System.out.println("처음 크기 : " + v1.size());
		
		//Vector는 add명령을 이용하여 데이터를 추가한다.
		v1.add("aaa");
		v1.add(new Integer(111));		//wrapper클래스(기본데이터를 객체화시켜주는 클래스)
		v1.add(123);	//오토박싱(자동으로 객체를 만들어줌)
		v1.add('a');
		v1.add(true);
		v1.add(3.14);
		
		System.out.println("크기 : " + v1.size());
		
		//데이터를 추가하는 명령으로 addElement가 있는데
		//이 메서드는 예전 버전과 호환성을 위해서 제공한다.		
		v1.addElement("CCC");
		
		System.out.println("v1 => " + v1);
		
		//데이터 중간에 새로운 데이터 끼워넣기	
		// ==> add(index, 데이터); ==> 벡터의 index번째에 '데이터'를 끼워넣는다.
		v1.add(1, "kkk");
		System.out.println("v1 =>" + v1);
		System.out.println();
		
		//데이터 수정하기
		// ==> set(index, 새로운데이터);
		// ==> index번째의 데이터를 '새로운데이터'로 변경한다.
		// ==> 반환값 : 원래의 데이터를 반환한다.
		String temp = (String) v1.set(0, "zzz");		//set으로 변경하기전의 값을 temp에 저장한다.
		System.out.println("기존 데이터 : " + temp);
		System.out.println("v1 =>" + v1);
		System.out.println();
		
		//데이터 삭제하기
		// ==> remove(index) ==> index번째의 자료를 삭제한다.
		// ==> 반환값 : 삭제된 데이터
		// ==> 자료가 삭제되면 index번째 이후의 데이터들이 차례로 앞으로 자동으로 당겨져서 채워진다.		
//		String temp2 = (String)v1.remove(1);
//		System.out.println("기존데이터 : " + temp2);		//remove로 삭제하기전에 temp2에 저장한다.
//		System.out.println("v1 =>" + v1);
		
		// ==> remove(삭제할데이터) ==> 삭제할 데이터를 찾아서 삭제한다.		//List나 Vector의 경우에 중복되는 데이터가 존재할수있어서 값이 앞에서부터 하나만 지워진다.
		// ==> 삭제할 데이터가 여러개이면 앞에서부터 삭제된다.
		// ==> 삭제할 데이터가 '정수형' 또 'char형' 일 경우에는 객체형으로 변환해서 사용해야 한다.
		v1.remove(0);
		System.out.println("삭제 후 v1 => " + v1);
		System.out.println();
		
		temp = (String)v1.remove(0);
		System.out.println("삭제된 데이터 : " +  temp);
		System.out.println("삭제 후 v1 : " +  v1);
		System.out.println();
		
		v1.add(123);
		System.out.println("v1 => : " + v1);
		
		v1.remove(true);
		System.out.println("true 삭제 후 v1 : " + v1);
		System.out.println();
		
		v1.remove(new Integer(111));
		System.out.println("111 삭제 후 v1 : " + v1);
		System.out.println();
		
		v1.remove(new Character('a'));
		System.out.println("a를 삭제 후 v1 : " + v1);
		System.out.println();
		
		v1.remove(3.14);
		System.out.println("3.14를 삭제후 v1 : " + v1);
		System.out.println();
		
		v1.remove(new Integer(123));					//중복된 값의 데이터가 여러개일때 앞에서부터 하나만 지운다.
		System.out.println("123을 삭제후 v1 : " + v1);
		System.out.println();
		
		
		//데이터 꺼내오기
		// ==> get(index) : ==> index번째의 데이터를 꺼내온다.
		String data = (String) v1.get(0);
		System.out.println("꺼내온 데이터 : " + data);
		System.out.println("---------------------------------------");
		
		/*
		 	제네릭 타입(Generic Type)
		 	==> 객체를 선언할 때  < > 안에 그 collection이 사용할 데이터 타입을 정해주는 것을 말한다.
		 	 이런식으로 선언하게 되면 지정한 데이터 타입 이외의 다른 데이터를 저장 할 수 없게 된다.
		 	 단, 제네릭으로 선언될 수 있는 데이터 타입은 클래스 형이어야 한다.
		 	 그래서 int는 Integer, boolean은 Boolean, char는 Character등으로 대체하여 사용해야 한다.
		 	 
		 	 제네릭 타입으로 선언하게 되면 데이터를 꺼내올 떄 별도의 형변환을 할 필요가 없어진다.		 
		 */
		System.out.println("-----------Generic 사용-----------------");
		Vector<String> v2 = new Vector<String>();	//String만 저장할수 있는 Vector
		Vector<Integer> v3 = new Vector<Integer>(); //정수형만 저장할수 있는 Vector
		
		v2.add("안녕하세요");
//		v2.add(123);	//오류 : 다른 종류의 데이터를 추가할 수 없다.
		
		String test = v2.get(0);
		System.out.println("test : " + test);
		System.out.println();
		
		Vector<Vector> vv = new Vector<Vector>();
		Vector<Vector<Vector>> vvv = new Vector<Vector<Vector>>();
		
		v2.clear();
		System.out.println("v2의 size : " + v2.size());
		
		v2.add("AAA");
		v2.add("BBB");
		v2.add("CCC");
		v2.add("DDD");
		v2.add("EEE");
		
		Vector<String> v4 = new Vector<String>();
		v4.add("BBB");
		v4.add("EEE");
		
		System.out.println("v2 : " + v2);
		System.out.println("v4 : " + v4);
		System.out.println();
		
		//removeAll(Collection객체) ==> 'Collection객체'가 가지고 있는 데이터를 모두 삭제한다.
		
		v2.removeAll(v4);
		System.out.println("삭제 후 v2 : " + v2);
		System.out.println();
		
		System.out.println("-----------------------------------------");
		
		v2.clear();
		
		v2.add("AAA");
		v2.add("BBB");
		v2.add("CCC");
		v2.add("DDD");
		v2.add("EEE");
		
		//벡터의 데이터를 순서대로 모두 가져와 사용하고 있으면 반복문을 사용하면된다.
		for (int i = 0; i < v2.size(); i++) {
			System.out.println(i + "번째 자료 : " + v2.get(i));
		}
		System.out.println("-----------------------------------------");
		
		//향상된 for문
		/*
		 	==> '배열이나 컬렉션'에서 데이터를 하나씩 꺼내 변수에 저장한 후
		 	 	'반복할 내용들'을 처리한 후 다음 데이터를 변수에 저장한 후 반복하는 작업을
		 	 	데이터 개수만큼 자동으로 처리하는 반복문이다. 
		 	형식 ) for(자료형이름 변수명 : 배열이나 컬렉션) {
		 				반복할 내용들 :
		 				...
		 		  }		 
		 */
		
		for(String s : v2){
			System.out.println(s);
		}
		
		
		
		
		
		
		// ==>
		
		
		
		
		
		
		
	}

}
