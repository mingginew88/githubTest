package f_oop2;

import f_oop2.Outer.Inner;

public class InnerEx02 {
	public static void main(String[] args) {
		//Inner클래스의 method()를 호출하세요.
		Outer o = new Outer();
		Outer.Inner i = o.new Inner();
		i.method(30);
		
		Outer.staticInner sti = new Outer.staticInner();
		System.out.println(sti.iv);		
		}
}

class Outer{
	int value = 10;
	
	class Inner{
		int value = 20;
		
		void method(int value){
			System.out.println(value);
			
			System.out.println(this.value); 		//20
			System.out.println(Outer.this.value); 	//10
		}
	}
	
	static class staticInner{
		int iv = 30;
	}	
}












