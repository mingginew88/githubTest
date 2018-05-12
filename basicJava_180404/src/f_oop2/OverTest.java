package f_oop2;

public class OverTest {
	
	public static void main(String[] args) {
		OverGo o = new OverGo();
		
		String result = o.upMethod();
		System.out.println(result);
		
		String result2 = o.upMethod(10);
		System.out.println(result2);
	}
}



class OverUp{
	int x;
	int y;
	
	String upMethod(){
		return "하이" + x + y;
	}
}

class OverGo extends OverUp{
	int z;
	//오버라이딩 부모클래스의 메서드가 마음에 안들어서 오버라이드 할때 밑에 @Override를 넣는것은 약속이다.
	@Override
	String upMethod(){			//부모클래스의 메서드와 선언부가 동일하다.
		return "OverGo" + z;
	}
	
	//오버로딩
	String upMethod(int k){			
		return "OverGo int" + k;
	}
}
