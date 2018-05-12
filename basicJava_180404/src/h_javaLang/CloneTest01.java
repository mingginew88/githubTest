package h_javaLang;

public class CloneTest01 {
	public static void main(String[] args) throws CloneNotSupportedException {
		
		CloneEx ce = new CloneEx(4, 6);
		CloneEx ce2 = (CloneEx)ce.clone();
		ce.x = 100;		
		System.out.println(ce);
		System.out.println(ce2);
		
		
		
		
		
		
	}

}


class CloneEx implements Cloneable{
	int x;
	int y;	
	
	CloneEx(int x, int y){
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "CloneEx [x=" + x + ", y=" + y + "]";
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}	
}

