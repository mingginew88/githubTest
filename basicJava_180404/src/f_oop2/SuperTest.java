package f_oop2;

public class SuperTest {
	
	public static void main(String[] args) {
		
		Child2 c = new Child2();
		int result = c.getAdd(50);		//50 30 10 30 
		int result2 = c.getAdd();		//30
	}
}


class Parent2{
	int x = 10;
	int y = 20;
	
	int getAdd(){
		return x+y;
	}	
	
	Parent2(){
		
	}
}

class Child2 extends Parent2{
	int x = 30;
	
	int getAdd(int x){
		System.out.println(x);	//	인자값
		System.out.println(this.x);	//	30
		System.out.println(super.x);	//	10
		return super.getAdd();	//	30
	}
	
	
	Child2(){
		super();			//기본생성자에 조상클래스를 
	}
	
	
	
	
}