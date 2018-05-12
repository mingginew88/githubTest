package f_oop2;

public class Interface01 {
	public static void main(String[] args) {
		Fight f = new Fight();
		System.out.println(f instanceof Unit2);
		Unit2 u2 = f;
		System.out.println(f instanceof Object);
		System.out.println(f instanceof Movable);
		Movable m = f;
//		인터페이스의 타입에 참조변수로 그 인스턴스를 구현한 클래스의 인스턴스를 참조할수 있다.
		System.out.println(f instanceof Attackable);
		System.out.println(f instanceof Fightable);
	}
}

interface Fightable extends Movable, Attackable{
	
}

interface Movable{
	void move(int x, int y);
}

interface Attackable{
	void attack(Unit2 u);
}

class Unit2{
	int x;
	int y;	
	int currentHp;
}

class Fight extends Unit2 implements Fightable{

	@Override
	public void move(int x, int y) {
	
	}

	@Override
	public void attack(Unit2 u) {
	
	}
	
}











