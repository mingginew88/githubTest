package basic;
/*
	열거형(enum) ==> 서로 관련있는 상수들의 집합
	형식) enum 열거형이름{ 상수명1, 상수명2, ...}
 */


public class EnumTest {
	
	//City 열거형 객체 선언
	public enum City { 서울, 부산, 대구, 광주, 대전}
	
	//Season열거형 객체 선언
	//==> 봄, 여름, 가을 , 겨울 이라는 상수를 선언하고 
	//봄은 '3월부터 5월까지' 여름은 '6월부터 8월까지'
	//가을은 '9월부터 11월까지' 겨울은 '12월부터 2월까지 라는 부가정보를 저장하고자한다.
	
	public enum Season{
		봄("3월부터 5월까지"),
		여름("6월부터 8월까지"),
		가을("9월부터 11월까지"),
		겨울("12월부터 2월까지");
		
		//부가적인 데이터값을 정해줄 경우에는 생성자를 만들어서 괄호속의 값이 변수에 저장되도록 해야한다.
		
		//괄호속의 값이 저장될 변수 선언
		private String span;
		
		//생성자 작성 ==> 생성자는 묵시적으로 'private'이다.
		Season(String months){//private Season(String months)와 같다.
			span = months;
		}
		
		//부가적인 데이터를 외부에서 접근하는 메서드 정의
		public String getSpan(){
			return span;
		}	
	}
	
	
	public static void main(String[] args) {
		
		//열거형 객체를 사용하기		
		City city1 = City.서울; //City열거형에서 "서울" 상수를 가져옴
		//name()메서드 ==> 열거형의 상수 이름을 문자열로 반환한다.
		System.out.println("city1 : " + city1.name());
		
		//ordinal()메서드 ==> 열거형 상수가 정의된 순서값을 반환한다.( 0부터 시작)
		System.out.println("city1. ordinal : " + city1.ordinal());
		System.out.println();
		
		// valueOf("열거형상수명"); ==> 지정된 열거형에서 '열거형상수명'과 일치하는 열거형 상수를 반환한다.
		City city2 = City.valueOf("대구");	//City.대구 와 같다.
		System.out.println("name : " + city2.name());
		System.out.println("ordinal : " + city2.ordinal());
		System.out.println("=====================================");
		System.out.println();
		
		Season ss = Season.valueOf("가을");
		System.out.println("name : " + ss.name());
		System.out.println("ordinal : " + ss.ordinal());
		System.out.println("span : " + ss.getSpan());
		System.out.println("=====================================");
		System.out.println();
		
		//열거형명.values() ==> 열거형의 모든 상수들을 배열에 담아 반환한다.
		for (Season time : Season.values()) {
			System.out.println(time + " : " + time.getSpan());
			System.out.println(time + " : " + time.ordinal());
		}
		
		
		
		
	}

}
