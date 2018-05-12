package e_oop;

public class CarTest {
	
	public static void main(String[] args) {
		Car c = new Car();
		System.out.println(c.color);
		System.out.println(c.gearType);
		System.out.println(c.door);
		
		Car c2 = new Car("black", "auto", 4);
		System.out.println(c2.color);
		System.out.println(c2.gearType);
		System.out.println(c2.door);
	}
}


class Car{
	String color;
	String gearType;
	int door;
	
	Car(){			//this()를 통해서 다른 생성자를 불러올수 있다.
		this("yello", "Auto", 3);				//this는  인스턴스 자신을 뜻한다. // this()는 생성자의 가장 위에만 써야한다.
		color = "white";
		gearType = "Stick";
		door = 4;
	}
	
	Car(String color, String gearType, int door){		
		this.color = color;
		this.gearType = gearType;
		this.door = door;		
	}
}





