package f_oop2;

public class InnerEx01 {
	public static void main(String[] args) {
		System.out.println(InstanceInner.CON);
		
	}
	
	//static 클래스
	static class StaticInner{
		int iv = 300;
		static int cv = 200;
	}
	
	//인스턴스클래스
	class InstanceInner{
		int iv = 400;
//		static int cv = 500;
		static final int CON = 100;
	}
	
	void method(){
		//지역클래스
		class LocalClass {
			int iv = 400;
//			static int cv = 700;
			static final int CON = 100;
		}
	}	

}



