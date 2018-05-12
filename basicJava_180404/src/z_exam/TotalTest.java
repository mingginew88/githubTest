package z_exam;

public class TotalTest {
	public static void main(String[] args) {
		
		TvMaker.color = "Blue"; //TvMaker라는 클래스호출 클래스관련된 변수와 메서드도 같이 호출한다. (color=  null, inch = 0 호출)  (.은 안에라는 뜻) 
								//TvMaker라는 클래스 안에 color라는 클래스 변수를 Blue로 변경해준다.
		TvMaker tm = new TvMaker();	//TvMaker가 MethodArea에 있는지 확인하고 callstack에 있는 main메서드 안에 tm이라는 지역변수를 설정해준다.
									//그리고 (생성자) TvMaker()라는 인스턴스를 새로 만들어주어 tm이라는 지역변수에 주소값을 저장해 준다. 
									//heap에 tm의 주소를 갖는 인스턴스가 생긴다. 관련된 인스턴스로는 인스턴스변수(name= null, age = 0), 인스턴스메서드(TvMaker(), TvMaker(name, age))가있다. 
		tm.age = 30; // tm은 main메서드의 지역변수이자 참조변수인데  tm의 주소값을 불러와 인스턴스에 30으로 변경해준다. 
		//3. 메서드 호출
		// 3.1 
		System.out.println(TvControll.channel);	//TvControll이라느 클래스를 MethodArea에 호출한다.
												//관련된클래스변수인 final int_MAXCHANNEL, final int_MINCHANNEL channeL도 같이 호출한다. 클래스메서드인 voluneDown() 도호출한다. 
												//TvControll이라는 클래스 안에 channeL이라는 클래스 변수를 출력한다.  콘솔창에 15가 찍힌다.
		
		TvControll.volumeDown();				//TvControll이라는 클래스가 MethodArea에 있는지 확인하고 있으면  그 안에 있는 voluneDown()이라는 클래스메서드를 확인한다.
												//volumeDown()메서드가 콜스택에 쌓이고 그이전에 채널값이 15로 최대치가 아니기때문에 채널값이 16으로 오른다.
		System.out.println(TvControll.channel);	//TvControll이 MethodArea에있는지 확인하고 안에 channeL을 출력한다. 콘솔창에 16이 출력된다.
		
		// 3.2
		TvControll tc; //TvControll이 MethodArea에 있는지 확인하고 tc라는 지역변수를 콜스택의 메인메서드에 생성한다. 
		tc = new TvControll(); //tc에 TvControll() (생성자)를 새롭게 인스턴스화해서 주소값을 저장해준다. 
								//heap에 tc의 주소를 갖는 인스턴스를 생성한다.
								//인스턴스 변수 final int MAX_VOLUME= 100; final int MIN_VOLUME = 0; int channel = 15 int volume = 99;
								//관련된인스턴스메서드 int volumeUp()를 tc인스턴스에 넣는다.
		System.out.println(tc.volume);	//tc의 주소값을 통해 heap에서 볼륨이라는 인스턴스 변수를 출력한다 콘솔창에 99가 찍힌다. 
		tc.volumeUp();		//tc의 volumeUp()이라는 인스턴스메서드를 콜스택에 불러와 쌓는다.
							//volumeUp()을 실행하면 volume이 99에서 100이된다.
		System.out.println(tc.volume); //tc의 볼륨을 출력한다. 콜스택에있는 volumeUp()메서드를 종료한다. 콘솔창에는 100이찍힌다.
		tc.volumeUp();		//tc의 volumeUp()이라는 인스턴메스드를 콜스택에 다시 불러온다.
							//volumeUp()을 실행하면 volume은 100에서 최대치기때문에 min값을 갖는데 여기서 min은 0이다.
		System.out.println(tc.volume);	//tc의 볼륨을 출력하고 콜스택에있는 volumeUp()메서드를 종료한다.  콘솔창에 0이 찍힌다.
		
		//
		Calc cc = new Calc();	//Calc라는 클래스를 MethodArea에 호출하고 관련된 클래스변수 클래스메서드도 함께 호출한다. (하지만 이경우에는 둘다 존재하지않으니 클래스만 생성)
								//cc라는 지역변수를 메인메서드에 생성하고 Calc()를 인스턴스해서 cc에 주소값을 넣어준다.
								//heap에는 cc의 주소가 생기는데 add(int a, int b), long add(long a, int b), int minus(int a, int b)가 저장된다.
		System.out.println(cc.add(Integer.MAX_VALUE, 4));	//cc의 주소값을 불러와 add(int a, int b)라는 인스턴스메서드를 콜스택에 쌓는다.
															//add(int a, int b)안에 a + b는 long타입으로 반환값을 갖는다.
															//Integer.MAX_VALUE가 어떤 결과를 갖는지 모르기때문에 콘솔은 생략하겠다.
															//콜스택에 있던 add(int a, int b)를 종료한다.
		System.out.println(cc.add(3L, Integer.MAX_VALUE)); //cc의 주소값을 불러와 add(long a, int b)라는 인스턴스메서드를 콜스택에 쌓는다.
															//add(long a, int b)안에 a + b는 long타입으로 반환값을 갖는다.
															//콜스택에 있던 add(long a, int b)를 종료한다.
		
	}	//메인메서드를 종료하면서 켜져있던 MethodArea의 클래스들도 종료된다.
}
	class TvMaker{
		//1.전역변수
		//  1.1 클래스변수
		static String color; 
		static int inch; 
		//  1.2 인스턴스변수
		String name = "";
		int age;
		//2. 인스턴스 메서드
		//  2.1 매개변수가 없는 메서드(기본생성자) 
		TvMaker(){ 
			this("man",25);	//생성자에서 다른 생성자를 부르는 this()는 메서드안에 맨 위에만 써야한다.
							//this의 name은 man, age는 25로변경된다. 
		}					
		//  2.2  매개변수가 있는 메서드 
		TvMaker(String name, int age){
			this.name = name;		//이 클래스의 name은 현재 null 인것을 TvMaker의 매개변수 name을 넣어준다는 의미이다.
			this.age = age;			//이 클래스의 age는 기본값이 0 인것을 TvMaker의 매개변수 age를 넣어준다는 의미이다.
		}
	}
		
	class TvControll{
		final int MAX_VOLUME = 100;	//인스턴스변수  상수는 대문자로 써주고 두단어이상인경우 특수기호 '_'로 구분해준다.
		final int MIN_VOLUME = 0;	//인스턴스변수	final은 상수로 지정해주는 고정되어지는 값이 된다.
		static final int MAX_CHANNEL= 50;	//클래스변수
		static final int MIN_CHANNEL= 1;	//클래스변수
		
		static int channel = 15;	//클래스변수
		int volume = 99;		//인스턴스변수

		//4. return문은  반환타입이 void인경우에는 return을 자동으로 추가해주기때문에 안써도 되고 그렇지않은경우에는 return을 반드시 써주어야한다.
		//메서드의 결과값의 타입과 반환타입은 일치해야한다.
		//인스턴스메서드
		int volumeUp(){
			if(volume == MAX_VOLUME){
				volume = MIN_VOLUME;
			}else{
				volume++;
			}
			
			return volume;
		}
		//클래스메서드
		static int volumeDown(){
			if(channel == MAX_CHANNEL){
				channel = MIN_CHANNEL;
			}else{
				channel++;
			}
			return channel;
		}
	}
	
	class Calc{
		//5. 오버로딩 : 메서드명은 같고 타입과 개수만 다를때  
		int add(int a, int b){
			return a+b;
		}
		long add(long a, int b){ //매개변수의 타입이 다르면 타입을 큰 거로 맞춰줘야한다. 
			return a+b;
		}		
		
		int minus(int a, int b){
			return a+b;
		}
	}