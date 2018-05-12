package h_javaLang;

public class ShallowDeepcopy {	
	public static void main(String[] args) {
		Circle c1 = new Circle(new Point(100, 100), 100);
		Circle c2 = (Circle)c1.ShallowCopy();
		Circle c3 = (Circle)c1.DeepCopy();
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		c1.r = 200;
		c1.p.x = 20;
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
	}

}


class Circle implements Cloneable{
	int r;
	Point p;
	
	Circle(Point p, int r){
		this.r = r;
		this.p = p;
	}

	@Override
	public String toString() {
		return "Circle [r=" + r + ", p=" + p + "]";
	}
	
	public Object ShallowCopy(){		//얕은복사
		Object obj = null;
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	
	public Object DeepCopy(){			//깊은복사
		Object obj = null;		
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		Point p = new Point(this.p.x, this.p.y);
		((Circle)obj).p = p;
		return obj;
	}

	
}

