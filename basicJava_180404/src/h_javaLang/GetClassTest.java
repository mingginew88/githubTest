package h_javaLang;

import java.io.Serializable;
import java.util.Arrays;

public class GetClassTest {
	public static void main(String[] args) throws ClassNotFoundException {
		Card c1 = new Card();
		Class c2 = c1.getClass();		//생성된 객체로부터 얻는 방법  자주사용
		System.out.println(Arrays.toString(c2.getInterfaces()));
		
		Class<Card> c3 = Card.class;	//적게 사용하는방법
		
		Class obj = Class.forName("h_javaLang.Card");	//패키지명.클래스명  자주사용		
		
	}

}


class Card implements Serializable{
	String kind;
	int num;
	
	Card(){
		this("Heart", 1);		
	}
	
	Card(String kind, int num){
		this.kind = kind;
		this.num = num;
	}	

	@Override
	public String toString() {
		return "Card [kind=" + kind + ", num=" + num + "]";
	}
	
}

