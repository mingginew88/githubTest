package basic;
/*
	������ ������� ������� ó���ϴ� ����
	(synchronized�� �̿��� ����ȭ ����)
 */



public class ThreadTest16 {
	
	private int balance;	//�ܾ��� ����� ����

	public synchronized int getBalance() {
		return balance;
	}

	public synchronized void setBalance(int balance) {
		this.balance = balance;
	}
	
	//�Ա��ϴ� �޼���
	public void deposit(int money){
		balance += money;
	}
	
	//����ϴ� �޼���(��� ���� : true, ���� false ��ȯ)
	//����ȭ �������� ȣ���ϴ� �޼��嵵 ����ȭ ó���� ���־�� �Ѵ�.
	public synchronized boolean withdraw(int money){
		if(balance >= money){
			for (int i = 1; i <= 10000000 ; i++);		//�ð������
				balance -= money;
				System.out.println("�޼��� �ȿ��� balance = " + getBalance());
				return true;			
		}else{
			return false;
		}
	}


	public static void main(String[] args) {
		final ThreadTest16 account = new ThreadTest16();
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












