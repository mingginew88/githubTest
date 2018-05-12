package f_oop2;

public class CastingTest {
	public static void main(String[] args) {
		Car c1 = new FireCar();
		c1.stop();
		
		FireCar fc = (FireCar)c1;	//업캐스팅 후 다운캐스팅은 가능
		fc.water();
		
		FireCar fc2 = (FireCar)new Car();		
		//바로 다운캐스팅은 불가능 // 현재 FireCar의 인스턴스가 존재하지않기때문에 Car객체를 넣어줄수 없다.
		//문법상으로는 오류가없지만 실제로는 오류가 날수밖에없다.		
		//instanceof 가 다운캐스팅 업캐스팅이 가능한지를 판단하는 역할을 한다.
	}
}


class Car{	
	String color;
	int door;
	
	void drive(){
		System.out.println("달려");
	}
	
	void stop(){
		System.out.println("멈춰");		
	}	
}

class FireCar extends Car{
	void water(){
		System.out.println("물뿌려");
	}
}

class Ambulance extends Car{
	void useAED(){
		System.out.println("살려");
	}	
}







