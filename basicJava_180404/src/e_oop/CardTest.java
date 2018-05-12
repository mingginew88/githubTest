package e_oop;

public class CardTest {
	public static void main(String[] args) {
		System.out.println("Card.width : " + Card.width);
		System.out.println("Card.height : " + Card.height);
		
		//1. Card의 객체를 만드세요.(변수명 cd1)
		Card cd1 = new Card();
		//2. cd1객체의 kind를 spade로 변경하세요.
		cd1.kind = "spade";
		//3. cd1객체의 number를 7로 변경하세요.
		cd1.number =7;
		
		System.out.println("cd1의 문양 : " + cd1.kind);
		System.out.println("cd1의 번호 : " + cd1.number);
		System.out.println("cd1의 너비 : " + Card.width);			//클래스변수이기때문에 클래스명을 적어주는것이 좋다.
		System.out.println("cd1의 높이 : " + Card.height);		//cd1.height으로 적으면 참조변수를 통해 불러올순있다.
		
		//4. Card의 객체를 만드세요.(변수명 cd2)
		Card cd2 = new Card();
		//5. cd2객체의 kind를 heart로 변경하세요.
		cd2.kind = "heart";
		//6. cd2객체의 number를 5로 변경하세요.
		cd2.number = 5;
		System.out.println("cd2의 문양 : " + cd2.kind);
		System.out.println("cd2의 번호 : " + cd2.number);
		System.out.println("cd2의 너비 : " + Card.width);
		System.out.println("cd2의 높이 : " + Card.height);
		
		//7. cd1의 너비를 50으로 변경하세요.
		cd1.width = 50;
		
		//8. cd1의 높이를 80으로 변경하세요.
		cd1.height = 80;
		
		System.out.println("===========변경후==============");
		System.out.println("cd1의 문양 : " + cd1.kind);
		System.out.println("cd1의 번호 : " + cd1.number);
		System.out.println("cd1의 너비 : " + Card.width);
		System.out.println("cd1의 높이 : " + Card.height);
		
		System.out.println("cd2의 문양 : " + cd2.kind);
		System.out.println("cd2의 번호 : " + cd2.number);
		System.out.println("cd2의 너비 : " + Card.width);
		System.out.println("cd2의 높이 : " + Card.height);
		
	}

}


class Card{
	//인스턴스변수
	String kind; //문양
	int number;	//번호
	
	//클래스변수
	static int width = 100; //너비
	static int height = 250; //높이
	
	//인스턴스함수
	void method(){
		int v = 3;
		for( int i = 0; i <5; i++) {
			System.out.println(i);
		}
	}
	
	//클래스함수
	static void method2() {
		
	}
}
