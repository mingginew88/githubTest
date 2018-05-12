package f_oop2;

public class InstanceofTest {	
	public static void main(String[] args) {
		
		FireCar2 fc2 = new FireCar2();
		if(fc2 instanceof FireCar2){
			System.out.println("fc2는 FireCar2의 인스턴스이다.");
			FireCar2 fc3 = fc2;		
		}
		
		if(fc2 instanceof Car2){
			System.out.println("fc2는 Car2의 인스턴스이다.");
			Car2 c2 = fc2;
		}
		
		if(fc2 instanceof Object){
			System.out.println("fc2는 Object의 인스턴스이다.");
			Object obj = fc2;
		}
		
		Car2 c2 = new Car2();
		if(c2 instanceof FireCar2){
			System.out.println("c2는 FireCar2의 인스턴스이다.");
		//FireCar2 fc4 = c2;		//불가능하다.
		}
		
		if(c2 instanceof Car2){
			System.out.println("c2는 Car2의 인스턴스이다.");
			Car2 c3 = c2;
		}
		
		if(c2 instanceof Object){
			System.out.println("c2는 Object의 인스턴스이다.");
			Object obj2 = c2;
		}
		
		Car2 c4 = new FireCar2();
		c4.method();		//오버라이드된 경우에는 부모의것을 사용하는것이 아니라 자식의 인스턴스메서드를 사용한다.
						
	}
}


class Car2{
	void method(){		
		System.out.println("Car2꺼");
	}	
}

//좌측 번호에 녹색 세모는 오버라이드 하고있다는 표시이다.

class FireCar2 extends Car2{
	@Override
	void method(){
		System.out.println("FireCar2꺼");
	}
}





