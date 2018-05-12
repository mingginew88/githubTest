package h_javaLang;

import java.util.Arrays;

public class CloneTest02 {
	public static void main(String[] args) {
		Point[] arr = {new Point(1,1), new Point(2,2), new Point(3,3)};
		Point[] arrClone = arr.clone();		//객체의 주소를 복사 
		arr[0].x = 100;
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(arrClone));
	}

}



class Point{
	int x;
	int y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}	
	
}