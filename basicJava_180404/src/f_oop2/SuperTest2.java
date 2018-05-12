package f_oop2;

public class SuperTest2 {
	
	public static void main(String[] args) {
		
	}

}

class Point2{
	int x = 10;
	int y = 20;
	
	Point2(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class Point3D extends Point2{			//부모클래스의 기본생성자가 없는경우에 자식클래스에서 부모클래스의 생성자를 이용하여 생성자를 만들어주어야한다.
	int z;
	Point3D(int x, int y, int z) {
		super(x,y);		
		this.z = z;
	}

}
