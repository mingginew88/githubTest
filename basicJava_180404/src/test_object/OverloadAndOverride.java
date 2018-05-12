package test_object;

public class OverloadAndOverride {

}

class Person{	
	int hp;
	private int speed;
	private int power;
	
	void run(){
		hp--;
	}
	
	void stop(){
		hp++;
	}
	
	void kick(){
		power--;
		hp--;
	}
	
	int kick(int a, int b){
		return 1;
	}
	
	void kick(int a, int b, int c){
		
	}
	
	void hit(){
		
	}
	
}

class Sports extends Person{
	int number;
	int time;
	
	void time(){
		this.time--;
	}
	
	Sports(){
		
	}
}

class Baseball extends Sports{
	
	@Override	
	void hit(){
		hp--;
	}
	
}

class Soccer extends Sports{
	
}


