package homework;

public class CardTest {
	
	public static void main(String[] args) {
		
		System.out.println("카드의 폭은 : " + Card.width);
		System.out.println("카드의 길이는 : " + Card.height);
		
		Card c1 = new Card();
		
		c1.figure = "heart";
		c1.number = 7;
		
		Card c2 = new Card();
		
		c2.figure = "spade";
		c2.number = 4;
		
		System.out.println("c1의 문양 : " + c1.figure);
		System.out.println("c1의 숫자 : " + c1.number);
		System.out.println("c1의 폭 : " + Card.width);
		System.out.println("c1의 길이 : " + Card.height);
		
		System.out.println("c2의 문양 : " + c2.figure);
		System.out.println("c2의 숫자 : " + c2.number);
		System.out.println("c2의 폭 : " + Card.width);
		System.out.println("c2의 길이 : " + Card.height);
		
		c1.width = 50;
		c1.height = 80;		
		
		System.out.println("c1의 문양 : " + c1.figure);
		System.out.println("c1의 숫자 : " + c1.number);
		System.out.println("c1의 폭 : " + Card.width);
		System.out.println("c1의 길이 : " + Card.height);
		
		System.out.println("c2의 문양 : " + c2.figure);
		System.out.println("c2의 숫자 : " + c2.number);
		System.out.println("c2의 폭 : " + Card.width);
		System.out.println("c2의 길이 : " + Card.height);
		
		
	}
	

}
