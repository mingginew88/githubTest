package basic;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
	은행의 입출금을 쓰레드로 처리하는 예제2
	(lock객체를 이용한 동기화 예제)
 */

public class ThreadTest17 {
	
	private int balance; //잔액이 저장될 변수
	
	// Lock객체는 되도록이면 private final 로 지정한다.
	private final Lock lock = new ReentrantLock();	//Lock객체 생성
	
	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
	//입금하는 메서드
	public void deposit(int money){
		//lock()메서드로 락을 설정한 곳에서는 반드시 unlock()메서드를 이용하여 락을 해제해 주어야한다.
		
		lock.lock(); 		//락 설정 시작
		balance += money;
		lock.unlock();		//락 해제
	}
	
	
	//출금하는 메서드(출금 성공 : true, 실패 false 반환)
	public synchronized boolean withdraw(int money){
		
		//try-catch블럭이 사용되는 부분에서 unlock()메서드의 호출은 finally영역에서 하도록 해야 한다.
		lock.lock();
		boolean chk = false;
		try {
			if(balance >= money){
				for (int i = 1; i <= 10000000 ; i++);		//시간때우기
				balance -= money;
				System.out.println("메서드 안에서 balance = " + getBalance());
				chk = true;
			}else{
				chk = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		return chk;
	}
	

	public static void main(String[] args) {
		final ThreadTest17 account = new ThreadTest17();
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





