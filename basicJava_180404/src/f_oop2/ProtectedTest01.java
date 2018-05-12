package f_oop2;

import z_exam.ProtectedTest02;

public class ProtectedTest01 {
	public static void main(String[] args) {
		
//		ProtectedTest01 pt1 = new ProtectedTest01();		//클래스에 상속 extends ProtectedTest02
		ProtectedTest02 pt2 = new ProtectedTest02();		
		pt2.changeA(10);
		//protected
		//다른패키지 내에서 상속받는 클래스가 public인 경우에 그 안에있는 protected로 지정된것들을 사용가능하다.
		
		
	
	}
}
