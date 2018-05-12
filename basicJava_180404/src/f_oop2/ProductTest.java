package f_oop2;

import java.util.Scanner;
import java.util.Vector;

public class ProductTest {
	public static void main(String[] args) {
		
		
		Tv2 t2 = new Tv2("smart", 300);
		Dron d2 = new Dron("메빅", 100);
//		Buyer b = new Buyer("조계환", 10000);
//		b.buy(t2);
//		b.buy(t2);	
//		b.buy(d2);
//		System.out.println(b);
//		System.out.println(b.item);
//		b.refund(t2);		
//		System.out.println(b);
//		System.out.println(b.item);
//		b.summary();
		
		DBClass db = new DBClass();		
		Scanner sc = new Scanner(System.in);
		System.out.println("고객명을 입력해 주세요.");
		String name = sc.next();
		System.out.println("등록할 고객의 돈을 입력해주세요 숫자로만");
		int money = sc.nextInt();
		
		Buyer b2 = new Buyer(name, money);
		boolean result = db.addBuyer(b2);
		if(result){
			System.out.println("정상적으로 가입되었습니다.");
		}else{
			System.out.println("회원가입에 실패하였습니다.");
		}
		
		
		System.out.println("삭제하실 고객이름을 입력하세요.");
		String name2 = sc.next();
//		String b3 = new String(name2);
		boolean result2 = db.removeBuyer(name2);
		if(result2){
			System.out.println("정상 탈퇴되었습니다.");
		}else{
			System.out.println("실패하였습니다.");
		}		
		
		
//		2. 회원전체 내역을 받아와서 출력하세요.
		Vector<Buyer> buyers = db.allBuyer();
		
		
		
		
		
			
		
//		Buyer b = db.getBuyer(name);
//		if(b == null){
//			System.out.println("존재하지않습니다.");
//		}else{
//			System.out.println(b.getName() + "님 환영합니다.");
//		}
//		
//		b.buy(d2);
//		b.buy(d2);
//		b.buy(d2);
//		b.summary();
		

	}
}


class Product{
	String name;
	int price;
	int bonusPoint;
	
	Product(){
		
	}
	
	public Product(String name, int price){
		this.name = name;
		this.price = price;
		bonusPoint = price/100;
	}
}


class Tv2 extends Product{
	Tv2(String name, int price){
		super(name, price);
	}

	@Override			//alt shift s  -> s  toString생성
	public String toString() {
		return "Tv2";
	}	
}


class Dron extends Product{
	public Dron(String name, int price){
		super(name, price);
	}

	@Override
	public String toString() {
		return "Dron";
	}	
}


class Buyer{
	private String name;
	private int money;
	private int bonusPoint;
	Vector<Product> item = new Vector();
	
	public Buyer(String name, int money){
		this.name = name;
		this.money = money;	
	}
	
	void buy(Product p){			//매개변수의 다형성 원래는 각 제품마다 메서드를 생성해줘야하지만 부모클래스인Product를 매개변수로 받음.
		if(money < p.price){
			System.out.println("나가");	
			return;
		}
		money -= p.price;
		bonusPoint += p.bonusPoint;
		item.add(p);

		System.out.println(p + "를 구매하였습니다.");
	}
	
	void refund(Product p){
		if(item.remove(p)){
			money += p.price;
			bonusPoint -= p.bonusPoint;			
			System.out.println(p + "를 반품하였습니다.");
		}else{
			System.out.println("반품할 품목이 없습니다.");
		}
	}	

	void summary(){
		System.out.println("\t영\t수\t증");
		System.out.println("구매물품");
	
		int sum = 0;
				
		for(int i = 0; i < item.size();i++){
			System.out.println(item.get(i).name + "\t" + item.get(i).price + "만원");
			sum += item.get(i).price;
			if(item.isEmpty()){
				break;
			}		
		}
		System.out.println("총금액" + "\t" + sum + "만원");
		System.out.println("고객님의 남은돈 : " + this.money + "만원");
		System.out.println("고객님읜 포인트 : "+ this.bonusPoint + "만원");
		System.out.println(this.name + "고객님 감사합니다.");
	}
	
//	String count(){
//		int num1 = 0;
//		int num2 = 0;
//		
//		for(int i = 0; i < item.size(); i++){
//			if(item.get(i).equals(item.get(i).name)){
//				num1++;
//			}else if(item.get(i).equals(item.get(i).name)){			//방번호에 들어간것이 ?무어길래 문자열과 이퀄이 성립하지않을까?
//				num2++;
//			}
//		}
//		return "드론 : "  + num1 + " Tv2 : " + num2;
//	}
	
	
	//alt + shift + s -> r 누르면 get set 호출 가능
	public String getName() {
		return name;
	}

	public int getMoney() {
		return money;
	}

	public int getBonusPoint() {
		return bonusPoint;
	}

	public Vector<Product> getItem() {
		return item;
	}

	@Override
	public String toString() {
		return "Buyer [name=" + name + ", money=" + money + ", bonusPoint="
				+ bonusPoint + "]";
		
	}	
}

class DBClass{
	
	Vector<Buyer> buyers = new Vector<Buyer>();
	{
		Buyer b1 = new Buyer("공은별", 100);
		buyers.add(b1);
		Buyer b2 = new Buyer("서영준", 1000);
		buyers.add(b2);
		Buyer b3 = new Buyer("김요섭", 500);
		buyers.add(b3);
		Buyer b4 = new Buyer("김마음", 10000);
		buyers.add(b4);		
	}
	
	Buyer getBuyer(String name){
		Buyer b = null;
		//해당사람이 있는지 확인 하세요.
		for(int i = 0; i < buyers.size(); i++){
			if(name.equals(buyers.get(i).getName())){
				//해당사람이 존재할 경우 그 사람을 반환해주세요.
				b = buyers.get(i);
			}			
		}
		return b;
		
	}
	
	public boolean addBuyer(Buyer b2){
		boolean result = buyers.add(b2);
		return result;
	}
	
	
	public boolean removeBuyer(String name){
		Buyer b = null;
		for(int i = 0; i < buyers.size(); i++){
			if(name.equals(buyers.get(i).getName())){
				b = buyers.get(i);
			}
		}
		boolean result = buyers.remove(b);
		return result;
	}
	
	
	Vector<Buyer> allBuyer(){
		return buyers;
	}


	
	
	
	
}

class Products extends Product{
	
	
}


//Vector()		: 10개의 객체를 저장할 수 있는 Vector인스턴스를 생성한다.
//add()			: Vector의 객체를 추가한다.
//remove() 		: Vector의 객체를 삭제한다.
//isEmpty()		: Vector가 비어있는지 검사한다.
//get(int index): 해당 index번째 위치의 객체를 반환한다.   
//int size()	: 저장되어있는 객체의 개수를 반환한다.	

	//1. 반품 refund
	//2. 영수증(summary), 제품, 가격, 총금액, 남은 돈, 적립포인트
	/*
		영    수    증
		 
	  구매물품
		tv		300만원
		tv		300만원
		tv		300만원
		dron	100만원
		dron	100만원
		dron	100만원
		
	총금액		1200만원
	고객님의 남은돈 : 8800만원
	고객님의 포인트 : 12만원
	xxx고객님 감사합니다.	
	
	*/
	//3. 고객을 여러명 관리할수 있게끔
	//4. 물건을 각각 몇개샀는지 드론 몇개 티비 몇개


	//다하고 여유있으면...	
	//5. 물품수량관리


