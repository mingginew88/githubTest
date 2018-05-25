package basic;
/*
	은생의 입출금을 쓰레드로 처리하는 예제
	(synchronized를 이용한 동기화 예제)
 */



public class ThreadTest16 {
	
	private int balance;	//잔액이 저장될 변수

	public synchronized int getBalance() {
		return balance;
	}

	public synchronized void setBalance(int balance) {
		this.balance = balance;
	}
	
	//입금하는 메서드
	public void deposit(int money){
		balance += money;
	}
	
	//출금하는 메서드(출금 성공 : true, 실패 false 반환)
	//동기화 영역에서 호출하는 메서드도 동기화 처리를 해주어야 한다.
	public synchronized boolean withdraw(int money){
		if(balance >= money){
			for (int i = 1; i <= 10000000 ; i++);		//시간때우기
				balance -= money;
				System.out.println("메서드 안에서 balance = " + getBalance());
				return true;			
		}else{
			return false;
		}
	}


	public static void main(String[] args) {
		final ThreadTest16 account = new ThreadTest16();
		account.setBalance(10000);
		
		//익명구현체를 이용한 쓰레드 구현
		Runnable withdrawTest = new Runnable() {
			
			@Override
			public void run() {
				boolean result = account.withdraw(6000);
				System.out.println("쓰레드에서 result = + " + result + ", balance = " + account.getBalance());
			}
		};
		//----------------------------
		
		Thread th1 = new Thread(withdrawTest);
		Thread th2 = new Thread(withdrawTest);
		
		th1.start();
		th2.start();
		
	}
	
}












