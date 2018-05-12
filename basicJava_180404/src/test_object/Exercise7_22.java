package test_object;

class Exercise7_22{

}
	
abstract class Shape {
	Point p;
	Shape() {
		this(new Point(0,0));
	}
	Shape(Point p) {
		this.p = p;
	}
	
abstract double calcArea(); // 도형의 면적을 계산해서 반환하는 메서드
	Point getPosition() {
		return p;
	}
	void setPosition(Point p) {
		this.p = p;
	}
}

class Point {
	int x;
	int y;
	Point() {
		this(0,0);
	}
	Point(int x, int y) {
		this.x=x;
		this.y=y;	
	}
	public String toString() {
		return "["+x+","+y+"]";
	}
}	

/*(1) 클래스명 : Circle
조상클래스 : Shape
멤버변수 : double r - 반지름
(2) 클래스명 : Rectangle
조상클래스 : Shape
멤버변수 : double width - 폭
double height - 높이
메서드 :
1. 메서드명 : isSquare
기 능 : 정사각형인지 아닌지를 알려준다.
반환타입 : boolean
매개변수 : 없음*/


class Circle extends Shape{
	double r;
	
	@Override
	double calcArea() {
		return 0;
	}	
}

class Rectangle extends Shape{
	double width;
	double height;
	
	boolean isSquare(){
		
		return true;		
	}

	@Override
	double calcArea() {
		return 0;
	}
	
}












