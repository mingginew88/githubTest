package f_oop2;

public class DeckTest {
	
	public static void main(String[] args) {
		
		//덱이라는것을 만들기위해서는 카드가 필요하다  카드 클래스부터 생성하자.
		//카드클래스를 만들었다면 카드의 객체를 만들어볼까요?
		
//		Card c = new Card();
//		System.out.println(c.number);  //원래 뒤에 .toStirng()이 붙어서 주소를 불러오는데 생략한다.
											//to.String()은 object의 것임.
		
		
		
	
		//1. Deck객체를 만드세요. (변수명 d)
		Deck d = new Deck();
		//2. d변수에 있는 카드 52장을 출력해주세요.
		for(int i = 0; i < d.c.length; i++){		//배열의 크기만큼 돌려라 그래서 c.length가 CARD_NUM보다 의미파악에 더 도움이된다.
			System.out.println(d.c[i]);
		}
		//3. 0번째 방의 카드를 출력해주세요.
		System.out.println(d.pick(0));
		//4. random번째 방의 카드를 출력해주세요.
//		int random = (int)(Math.random()*d.CARD_NUM);	
//		System.out.println(d.c[random]);
		Card c = d.pick();
		System.out.println(c);
		//5. shuffle()를 이용하여 카드를 섞어주세요.
		d.shuffle();
		//6. 0번째 방의 카드를 출력해주세요.	
//		System.out.println(d.pick(0));
		Card zero = d.pick(0);
		System.out.println(zero);	//toString메서드때문에 계속 주소가아닌 값이 나온다.		
		//7. shuffle(1000)을 이용하여 카드를 섞어주세요.
		d.shuffle(1000);
		//8. 0번째 방의 카드를 출력해주세요.
		Card zero2 = d.pick(0);
		System.out.println(zero2);
	}

}



class Card{
	
	static final int KIND_MAX = 4; //카드무늬수
	static final int NUM_MAX = 13; //무늬별 카드수
	
	
	static final int SPADE = 1;
	static final int DIAMOND = 2;
	static final int HEART = 3;
	static final int CLOVER = 4;
	
	int kind;
	int number;
	
	//매개변수가 두개인 생성자를 만드세요.
	Card(int a, int b){		//매개변수 kind와 number를 쓰는게 좋겠지만.. 일단 헤깔리니..
		this.kind = a;
		this.number = b;
	}	
	
	//기본생성자를 만드세요.
	//매개변수가 두개인 생성자를 호출하여 만드세요. //SPADE, 1	
	
	Card(){
		this(SPADE, 1);		
	}
	
	@Override		//오버라이드 해주는것을 표현해주어야한다.
	public String toString(){
		String kind = "";
		String number = "";		
		
		switch(this.kind){
		case 1 :
			kind = "SPADE";
			break;
		case 2:
			kind = "DIAMOND";
			break;
		case 3:
			kind = "HEART";
			break;
		case 4:
			kind = "CLOVER";
			break;
		default :
			kind = "";
			break;
		
		}
		//1- A 11 - J , 12 - Q , 13 - K
	
		switch(this.number){
		case 1 :
			number = "A";
			break;		
		case 11 :
			number = "J";
			break;
		case 12 :
			number = "Q";
			break;	
		case 13 :
			number = "K";
			break;
		default :
			number = this.number + "";
			break;
		}		
		return "카드의 문양 : " + kind + "\n카드의 번호 : " + number;
	}	
}	


class Deck {
	// 1. 카드의 수량을 저장할 수 있는 변수 CARD_NUM을 선언 및 초기화 하세요.
	final int CARD_NUM = Card.KIND_MAX * Card.NUM_MAX;
	//변수가 상수이기때문에 final을 붙여준다.
	//상수는 대문자로 구성하고 각 단어 사이에 특수기호'_'를 붙여 구분한다.		
	
	// 2. 카드 52장을 담을수 있는 변수를 선언 및 초기화 하세요.(변수명: c)		
	Card[] c = new Card[CARD_NUM];	
	
	// 3. 기본생성자를 만드세요.
	// 	  기본생성자 내에서는 2.에서 만든 변수 c에 카드 52장을 저장해 주세요.
	
	//기본생성자 기본생성자는 클래스내에 클래스이름과 동일한 메서드를 의미한다.
	// 클래스내에 최소한 하나는 가지고있어야하며 클래스내에 생성자가없는경우 자동으로? 불러온다.
	//생성자의 이름으로 클래스 이름 대신 this를 사용한다???
	//this() 한생성자에서 다른생성자를 호출할때 반드시 첫줄에서만 호출이가능하다.
	Deck(){
		int i = 0;
		for(int j = 0; j < Card.KIND_MAX; j++){
			for(int k = 0; k < Card.NUM_MAX; k++)
			c[i++] = new Card(j+1, k+1);
		}
	}
	
	// 4. 매개변수로 index를 받아 카드 52장중 해당 방번호에 해당하는 카드 한장을 반환하는 메서드를 만들어주세요.(메서드명 :pick)				
	Card pick(int index){
		Card result = c[index]; 
		return result;
	}
	
	
	//오버로딩 이름은 같지만 타입과 변수개수가 다른경우 
	//pick(int)  pick() , shuffle() 과 shuffle(int)
	
	// 5. 랜덤한 방번호의 카드를 반환하는 메서드를 만들어 주세요. (메서드 : pick)
	//	  단, 4번에서 만든 pick메서드를 활용하세요.
	Card pick(){
		int index= (int)(Math.random()*CARD_NUM);
		Card result = pick(index);
		return 	result;		//활용을.. 해야하는구나........
	}
	
	// 6. 카드를 섞는 메서드를 만들어 주세요.(메서드 : shuffle)
	//	  연습문제 5-5의 형태로 만들어주세요.
	void shuffle(){
		for(int i = 0; i < c.length; i++){		
			int index= (int)(Math.random()*CARD_NUM);
			Card tmp = c[i];
			c[i] = c[index];
			c[index] = tmp;
		}
	}
	
	// 7. 카드를 섞는 메서드를 만들어 주세요.(메서드 :shuffle)
	//	  반복횟수를 입력받아 해당 횟수만큼 랜덤한 방번호 두개를 입력받아 자리를 교체해주세요.
		
	//void는 반환타입이 없어도 된다.
	void shuffle(int repeat){
		while(repeat > 0){
			int index1= (int)(Math.random()*CARD_NUM);
			int index2= (int)(Math.random()*CARD_NUM);
			Card tmp = c[index1];
			c[index1] = c[index2];
			c[index2] = tmp;
			repeat--;
		}
	}
}


