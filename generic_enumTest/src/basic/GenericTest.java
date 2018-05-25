package basic;

/*
	제네릭 클래스 만드는 방법
	
	형식 ) class 클래스명 <제네릭타입글자>{
			자료형이름 변수명;		//변수 선언할 때 사용
			....
			
			제네릭타입글자 메서드명(){	//메서드의 반환값 타입에 사용
				....
				return 값;
			}
			
			
			메서드명(제네릭타입글자 변수명){	//메서드의 매개변수의 타입에 사용
			
			}
			
		}
 */

//제네릭을 사용하지 않는 경우
class NonGenericClass{
	private Object val;
	
	public void setVal(Object val){
		this.val = val;
	}
	
	public Object getVal(){
		return val;
	}
	
}

//제네릭을 적용한 클래스
class MyGenericClass<T>{
	private T val;
	
	public void setVal(T val){
		this.val = val;
	}
	
	public T getVal(){
		return val;		
	}
}
/*
	----제네릭 타입 글자----
	T ==> Type
	K ==> Key
	V ==> Value
	E ==> Element
 */


public class GenericTest {
	public static void main(String[] args) {
		NonGenericClass ng1= new NonGenericClass();
		
		ng1.setVal("가나다라");
		String rtn = (String)ng1.getVal();
		System.out.println("문자열 반환값 : " + rtn);
		
		NonGenericClass ng2 = new NonGenericClass();
		ng2.setVal(100);
		Integer irtn = (Integer)ng2.getVal();
		System.out.println("정수 반환값 : " + irtn);
		System.out.println();
		
		MyGenericClass<String> mg1 = new MyGenericClass<String>();
		mg1.setVal("대한민국");
//		mg1.setVal(123);		//다른종류의 데이트를 사용하면 오류발생
		rtn = mg1.getVal();
		System.out.println("제네릭 문자열 반환값 : " + rtn);
		
		MyGenericClass<Integer> mg2 = new MyGenericClass<Integer>();
		
		mg2.setVal(1000);
		irtn = mg2.getVal();
		System.out.println("제네릭 정수 반환값 : " + irtn);
		
		
	}

}






