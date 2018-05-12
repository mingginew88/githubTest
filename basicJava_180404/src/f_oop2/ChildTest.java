package f_oop2;

public class ChildTest {
	
	public static void main(String[] args) {
		Child c = new Child();
		Parent p = new Parent();
		c.volume = 40;
		c.volumeUp(); 	//volume = 41
		c.channel = 10;
		System.out.println(c.channel);
		c.channelUp();
//		System.out.println(p.channel);
		System.out.println(c.channel);
		
	}
}



class Parent{
	
//	static int cv;
	int channel;
	void channelUp(){
		channel++;
	}
	
	Parent(){
		
	}
}


class Child extends Parent{
//	static int cv2 = cv;	부모클래스가 먼저 생성되는 이유 
	int channel;
	int volume;
	
	void volumeUp(){
		volume++;
	}
	Child(){
		super();
	}
}


