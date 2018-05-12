package e_oop;

public class DiceTest {
	
	public static void main(String[] args) {
		
		DoubleDice dd = new DoubleDice();
		System.out.println("전체 이동거리는 : " + dd.throwDice());		
	}
}


class DoubleDice {
	
	//1. 인스턴스 메서드 throwDice()
	int throwDice(){
		int dice1 = (int)(Math.random()*6 + 1);
		System.out.println("주사위 의 수는 : " + dice1);
		int dice2 = (int)(Math.random()*6 + 1);
		System.out.println("주사위 의 수는 : " + dice2);
		int sum = dice1 + dice2;
		System.out.println("주사위의 합은 : " + sum);
		if(dice1 == dice2) {
			sum += throwDice();
		}
		return sum;
	}

}



