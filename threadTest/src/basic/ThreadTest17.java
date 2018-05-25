package basic;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
	������ ������� ������� ó���ϴ� ����2
	(lock��ü�� �̿��� ����ȭ ����)
 */

public class ThreadTest17 {
	
	private int balance; //�ܾ��� ����� ����
	
	// Lock��ü�� �ǵ����̸� private final �� �����Ѵ�.
	private final Lock lock = new ReentrantLock();	//Lock��ü ����
	
	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
	//�Ա��ϴ� �޼���
	public void deposit(int money){
		//lock()�޼���� ���� ������ �������� �ݵ�� unlock()�޼��带 �̿��Ͽ� ���� ������ �־���Ѵ�.
		
		lock.lock(); 		//�� ���� ����
		balance += money;
		lock.unlock();		//�� ����
	}
	
	
	//����ϴ� �޼���(��� ���� : true, ���� false ��ȯ)
	public synchronized boolean withdraw(int money){
		
		//try-catch���� ���Ǵ� �κп��� unlock()�޼����� ȣ���� finally�������� �ϵ��� �ؾ� �Ѵ�.
		lock.lock();
		boolean chk = false;
		try {
			if(balance >= money){
				for (int i = 1; i <= 10000000 ; i++);		//�ð������
				balance -= money;
				System.out.println("�޼��� �ȿ��� balance = " + getBalance());
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
		
		//�͸���ü�� �̿��� ������ ����
		Runnable withdrawTest = new Runnable() {
			
			@Override
			public void run() {
				boolean result = account.withdraw(6000);
				System.out.println("�����忡�� result = + " + result + ", balance = " + account.getBalance());
			}
		};
		//----------------------------
		
		Thread th1 = new Thread(withdrawTest);
		Thread th2 = new Thread(withdrawTest);
		
		th1.start();
		th2.start();
	}
}





