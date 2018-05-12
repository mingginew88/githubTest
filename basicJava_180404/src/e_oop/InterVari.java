package e_oop;

class Data{
	int x;
}

public class InterVari {
	public static void main(String[] args) {	
	
	Data d1 = new Data();  
	d1.x = 10;
	System.out.println("before main 기본형 : " +d1.x);	//10	 인스턴스 변수 가 10으로 변경
	
	change(d1.x);		
	System.out.println("after main 기본형 : " +d1.x);	//10	클래스메서드에 10이라는 인트형이 들어감.
	
	Data d2 = new Data();
	d2.x=10;
	System.out.println("before main 참조형 : " +d2.x);	//10	d2라는 인스턴스 새로 생성 한데에 인스턴스변수 x는 10으로 변경
	
	change(d2);
	System.out.println("after main 참조형 : " +d2.x);	//1000	클래스메서드에 d2라는 주소값을 참조하니까. 
	}
	
	static void change (int x){
		x = 1000;
		System.out.println("change 기본형 : "+x);		//1000
	}
	
	static void change(Data d1){		//d1에는 d2의 주소가 들어가는데 아래 d1.x 에서 d1이 d2의주소에있는 x가 바뀐다는 뜻.
		d1.x = 1000;
		System.out.println("change 기본형 :" +d1.x);		//1000
	}
}

	
	
	
	


