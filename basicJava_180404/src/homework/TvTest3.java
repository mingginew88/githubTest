package homework;

public class TvTest3 {
	
	public static void main(String[] args) {
		
		Tv t1 = new Tv();
		Tv t2 = new Tv();
		
		System.out.println("t1의 채널은 " + t1.channel);
		System.out.println("t2의 채널은 " + t2.channel);
		
		t2 = t1;
		t1.channel = 7;
		
		System.out.println("t1의 채널을 7로 변경하였습니다.");
		System.out.println("t1의 채널은 " + t1.channel);
		System.out.println("t2의 채널은 " + t2.channel);
		
		
		Tv t3 = new Tv();
		System.out.println(t3.power);
		t3.power();
		System.out.println(t3.power);
	}

}
