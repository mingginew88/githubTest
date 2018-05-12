package f_oop2;
//상속에 대한 개념
//추상의 메서드 인게 있으면 클래스도 추상, 상속받는 클래스도 추상
public class Abstract02 {

}


abstract class Unit{
	int x;
	int y;
	
	abstract void move(int x, int y);		//추상메서드 적는 방법  {} 구현부가 없다
	
	void stop(){
		
	}	
}

class Marine2 extends Unit{
	
	void stimPack(){
		
	}

	@Override
	void move(int x, int y) {		
		
	}
}

class Tank2 extends Unit{
	
	void changeMode(){
		
	}

	@Override
	void move(int x, int y) {			//오버라이드를 했기에 추상클래스가 아니다.  구현부만 있어도 된다		
										//추상메서드가있을때 상속받는클래스가 추상클래스가 아닌것이좋다.
	}	
}

class Dropship2 extends Unit{
	
	void load(){
		
	}
	
	void unLoad(){
		
	}

	@Override
	void move(int x, int y) {		
		
	}
}





