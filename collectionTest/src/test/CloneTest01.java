package test;

public class CloneTest01 {
	public static void main(String[] args) {
		
		Point original = new Point(3,5);
		Point copy = (Point)original.clone();
		System.out.println(original);
		System.out.println(copy);
	}

}


class Point implements Cloneable{		//Cloneable인터페이스를 구현한 클래에서만 clone()을 호출 할 수 있다. 
	int x, y;							//이 인터페이스를 구현하지 않고 clone호출하면 예외발생
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public Object clone() {
		Object obj = null;
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) {	//clone()은 반드시 예외처리를 해주어야 한다.
		}
		return obj;
	}
	

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}

}

