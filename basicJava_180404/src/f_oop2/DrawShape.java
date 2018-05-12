package f_oop2;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class DrawShape extends Frame{
	
	public static void main(String[] args) {
		DrawShape ds = new DrawShape();	
//		ds.paint(new Graphics()); 			//주석처리되었지만 실행은 된다.
	}
	
	DrawShape(){
		super("알거없자나");
		setSize(500, 500);
		setVisible(true);
		setBackground(Color.ORANGE);	//칼러라는 클래스의 클래스변수이자 상수
		setResizable(false);
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				
				System.out.println("Frame 끝");
				System.exit(0);
			}
			
		});
	}
	
	@Override
	public void paint(Graphics g){
		//1. 원객체를 만드세요(매개변수 두개짜리 생성자를이용하세요.)
		//중심점은 200, 200  반지름 100
		Point p = new Point(200, 200);		
		Circle c = new Circle(p, 100);
		
		//2. 원을 그리세요.(g.drawOval())		
//		g.drawOval( p.x, p.y, c.radius*2, c.radius*2);	
		g.drawOval( c.a.x, c.a.y, c.radius*2, c.radius*2);
		
		//3. 삼각형의 객체를 만드세요(매개변수 세개짜리생성자를 이용하세요.)
		// 100,100  200,200  200,100
		Point[] p2 = new Point[3];
		p2[0] = new Point(100,100);
		p2[1] = new Point(200,200);
		p2[2] = new Point(200,100);
		Triangle t = new Triangle(p2[0], p2[1], p2[2]);
				
		//4. 삼각형을 그리세요.(g.drawLine())
		//g.drawLine(x1, y1, x2, y2);	
		g.drawLine(t.tria[0].x, t.tria[0].y ,t.tria[1].x , t.tria[1].y );
		g.drawLine(t.tria[1].x, t.tria[1].y ,t.tria[2].x , t.tria[2].y );
		g.drawLine(t.tria[2].x, t.tria[2].y ,t.tria[0].x , t.tria[0].y );
				
		//5. JVM 그리세요	
	}
}

class Point {	
	int x;
	int y;
	
	Point(){			//Point 기본생성자
		this(50, 50);
	}
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;	
	}
}

class Circle {
	//1. 점하나를 저장할 수 잇는 변수를 선언하세요.
	Point a;			//Circle은 Point를 포함하고있다.
	//2. 반지름을 저장할 수 잇는 변수를 선언하세요.
	int radius;
	//3. 매개변수가 두개인 생성자를 만드세요.
	Circle(Point a, int radius) {
		this.a = a;
		this.radius = radius;
	}
	//4. 기본생성자를 만드세요.
	// 단, 기본생성자에서 매개변수가 두개인 생성자를 호출하여 좌표는 100,100으로 반지름은 50으로 생성되게 만드세요.
	Circle(){
		this(new Point(100, 100), 50);
	}
}



class Triangle{
	//1. 점3개를 저장하고 있는 변수를 선언 및 초기화 하세요.	
	Point[] tria = new Point[3];	//배열 이용해서 매개변수3개인 생성자 만들 때 이용
//	Point a;						//배열사용안하고...매개변수 하나인 생성자 만들 때 이용 
//	Point b;
//	Point c;

	//2. 매개변수가 3개인 생성자를 만드세요.		
	Triangle(Point a, Point b, Point c) {
		tria[0] = a;
		tria[1] = b;
		tria[2] = c;
	}
	
	//3. 매개변수가 하나인 생성자를 만드세요.		
//	Triangle(Point p){
//		this(new Point(0,0), new Point(0,0), new Point(0,0));
//	    this.a = new Point(p.x, p.y);
//	    this.b = new Point(p.x, p.y);
//	    this.c = new Point(p.x, p.y);
//    }
	
	//배열  사용
	Triangle(Point[] p){
		this.tria = p;
	}
	
	//매개변수 넣지않은경우?
//	Triangle(){
//        this(new Point(100,100), new Point(100,200), new Point(200,100));
//  }
	
	
	
}

