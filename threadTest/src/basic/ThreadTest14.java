package basic;

/*
	원주율을 계산하는 쓰레드가 있다.
	계산된 원주율을 출력하는 쓰레드가 있다.
	
	원주율을 저장할 객체가 필요한다.
	이 객체를 두 쓰레드가 공통으로 사용한다.
 */


public class ThreadTest14 {
	public static void main(String[] args) {
		
		ShareData sd = new ShareData();		//공통으로 사용할 객체 생성
		
		CalcPIThread ct = new CalcPIThread(sd);
		PrintThread pt = new PrintThread(sd);
		
		ct.start();
		pt.start();
	}
}


//원주율을 관리하는 클래스(공유될 클래스)
class ShareData{
	public double result;		//계산된 원주율이 저장될 변수
	
	public volatile boolean isOk = false;	//계산이 완료되었는지 여부를 나타내는 변수
	
	//volatile ==> 선언된 변수를 컴파일러의 최적화 대상에서 제외시킨다.
	//			   즉, 값이 변경되면 즉시 변수에 적용시킨다.
}


//계산이 완료되면 원주율을 출력하는 쓰레드
class PrintThread extends Thread{
	private ShareData sd;
	
	public PrintThread(ShareData sd){
		this.sd = sd;
	}
	
	@Override
	public void run() {
		while(true){
			if(sd.isOk)
				break;
		}
		
		System.out.println();
		System.out.println("결과 : " + sd.result);
	}
}


//원주율을 계산하는 쓰레드
class CalcPIThread extends Thread{
	private ShareData sd;

	public CalcPIThread(ShareData sd) {
		this.sd = sd;
	}
	
	@Override
	public void run() {
		//원주율 ==> (1/1 - 1/3 + 1/5 -1/7 + ...) *4
		//			1	   -3	5   -7
		//			0		1	2	 3
		
		double sum = 0.0;
		
		for (int i = 1; i < 10000000; i+=2) {
			if((i/2%2)==0){
				sum += (1.0/i);
			}else {
				sum -= (1.0/i);
			}
		}
		sd.result = sum *4;
		sd.isOk = true;
	}
}







