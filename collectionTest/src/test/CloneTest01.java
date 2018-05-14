package test;

public class CloneTest01 {
	public static void main(String[] args) {
		
		Point original = new Point(3,5);
		Point copy = (Point)original.clone();
		System.out.println(original);
		System.out.println(copy);
	}

}


class Point implements Cloneable{		//Cloneable�������̽��� ������ Ŭ�������� clone()�� ȣ�� �� �� �ִ�. 
	int x, y;							//�� �������̽��� �������� �ʰ� cloneȣ���ϸ� ���ܹ߻�
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public Object clone() {
		Object obj = null;
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) {	//clone()�� �ݵ�� ����ó���� ���־�� �Ѵ�.
		}
		return obj;
	}
	

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}

}

