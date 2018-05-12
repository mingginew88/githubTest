package e_oop;

public class TvTest {
	
	public static void main(String[] args) {
		
		//클래스 친구들은 클래스명. 해서 바로 불러올수있다.
		System.out.println(Tv.color);	// . : 아래에 있는
		Tv.changeColor();
		System.out.println(Tv.color);
		
		//클래스명 변수명 = new 클래스명();		
		Tv t = new Tv();  //인스턴스화		
		
		System.out.println(t.channel);
		t.channel = 7;
		System.out.println(t.channel);
		t.channelUp(); 
		System.out.println(t.channel);
		System.out.println(t.power);
		t.power();
		System.out.println(t.power);	
	}  

}


class Tv {
	//전역변수
	
	//Tv색을 저장할 수 있는 변수 선언(color)
	static String color;		//클래스변수 (static이 붙으면)
	//Tv채널을 저장할 수 있는 변수 선언(channel)
	int channel;				//인스턴스변수
	//Tv파워를 저장할 수 있는 변수 선언(power)
	boolean power;				//인스턴스변수
	
	//클래스메서드
	static void changeColor(){
		color = "yellow";		
	}
	
	//인스턴스 메서드
	void channelUp(){
		channel++;
	}
	
	void channelDown(){
		channel--;
	}
	
	void power(){
		power = !power;
	}	
}




