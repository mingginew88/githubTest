package f_oop2;

public class SingletonTest {
	public static void main(String[] args) {
		Singleton st = Singleton.getInstance();		
		Singleton st2 = Singleton.getInstance();
		
	}
}

//객체를 한번만 만들기위해서

class Singleton{
	
	static Singleton st = null;
	
	private Singleton(){
		
	}
	
	static Singleton getInstance(){				//하나의 객체를 공유해서 사용할때 쓴다.
		if(st == null){
			st = new Singleton();
		}			
		return st;
	}
	
}







































