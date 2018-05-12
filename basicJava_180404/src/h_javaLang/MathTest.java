package h_javaLang;

import java.util.Random;


import java.util.Scanner;

//Math안에있는  메서드들을 자유자재로 쓸수있다		
//round를 쓰기위해서는 static을 붙여주어야 된다. 붙이지않으면 인스턴스의 친구들을 부를수있다.
import static java.lang.Math.*;


public class MathTest {
	
	//두점을 입력받아 거리를 구하는 메서드를 만들어보자.
	
	
	public static void main(String[] args) {
		//반올림			
		double d = 25.1231251515;		
		System.out.println(round(d));		//round가 클래스 메서드
		
		//올림
		System.out.println(ceil(d));
		
		//버림
		System.out.println(floor(d));
		
		//제곱		//반환타입 확인해보자
		System.out.println(pow(3, 3));
	
		//루트
		System.out.println(sqrt(4));
		
		//루트(x2 - x1)^2 (y2-y1)^2
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("첫번째 점의 x좌표를 입력해주세요.");
		int c1 = sc.nextInt();
		System.out.println("첫번째 점의 y좌표를 입력해주세요.");
		int c2 = sc.nextInt();
		System.out.println("두번째 점의 x좌표를 입력해주세요.");
		int d1 = sc.nextInt();
		System.out.println("두번째 점의 y좌표를 입력해주세요.");
		int d2 = sc.nextInt();
		Point2 a = new Point2(c1, c2);
		Point2 b = new Point2(d1, d2);
		System.out.println(a.distance(a, b));
		
	}
}


class Point2{
	int x;
	int y;
	
	Point2(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	double distance(Point2 a, Point2 b){
		double result =(int)(100*(sqrt(pow(a.x - b.x, 2) + pow(a.y - b.y, 2))) + 0.5)/100.0;
		return result;
	}	
}






