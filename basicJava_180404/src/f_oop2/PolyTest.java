package f_oop2;

public class PolyTest {
	
	public static void main(String[] args) {
		
//		Tv t = new Tv();
//		SmartTv st = new SmartTv();
//		AfreecaTv at = new AfreecaTv();
		
		//다형성
		Tv t1 = (Tv)new SmartTv();		//조상타입으로 올라가는것을 업캐스팅이라 하며 생략가능하다.
		Tv t2 = new AfreecaTv();
		Tv t = new Tv();
		//1. SmartTv 5대를 저장할 수 있는 변수를 만들고 초기화 하세요.
		SmartTv[] st = new SmartTv[] {new SmartTv(),new SmartTv(),new SmartTv(),new SmartTv(),new SmartTv()};
//		for(int i = 0; i < 5; i++){
//			st[i]= new SmartTv();
//		}
	
		
		//2. AfreecaTv 5대를 저장할 수 있는 변수를 만들고 초기화 하세요.
		AfreecaTv[] at = new AfreecaTv[] {new AfreecaTv(),new AfreecaTv(),new AfreecaTv(),new AfreecaTv(),new AfreecaTv()};
//		for(int i = 0; i < 5; i++){
//			at[i]= new AfreecaTv();
//		}
		
		Tv[] tvArr = new Tv[]{t1, t2};
		
		
		// . 이 연산자보다 우선순위가 높아서 .을 찍고 ctrl +spacebar 하면 Tv것만 나온다.
		((SmartTv)tvArr[0]).search();
		
//		AfreecaTv at1 = (AfreecaTv)t;		
//		SmartTv st2 = (SmartTv) new Tv();
		
		
	}
}

class Tv{
	boolean power;
	int channel;
	
	void power(){
		power = !power;
	}
	
	void channelUp(){
		channel++;
	}	
}

class SmartTv extends Tv{
	
	void search(){		
	}	
	
}

class AfreecaTv extends Tv{
	int starBalloon;
	
	void useQuickView(){		
	}
	
}
