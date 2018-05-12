package test_object;

public class ThisAndSuper {

}



class This extends Super{
	
	static int m;
	static int n;
	
	int s = 0;
	int t = 1;
	
	This(){
		this(3);
		super.a = 1;
	}
	
	This(int a){
		super(4);		
		this.s = a;		
	}
	
	void method(){
		this.t = 6;
		super.b = 3;
	}
}



class Super{	
	int a;
	int b;
	
	Super(){
		return;
	}
	Super(int a){
		
	}
}