package test_thread;

//�켱���� && ���󾲷���

public class Test6 {
	public static void main(String[] args) {
		Thread th1 = new LowerChar();
		Thread th2 = new UpperChar();		
		
		th1.setPriority(1);
		th2.setPriority(2);
		
		System.out.println("th1�� �켱���� : " + th1.getPriority());
		System.out.println("th2�� �켱���� : " + th2.getPriority());
		
		th1.start();
		th2.start();
	}
}


class LowerChar extends Thread{
	
	AutoSave as = new AutoSave();
	
	@Override
	public void run() {
		as.setDaemon(true);
		as.start();
		for (char c = 'a';  c <= 'z'; c++) {
			System.out.println();
			System.out.print(c);
		
			for (long i = 0; i <= 1000000000L; i++) {}
		}
	}
}

class UpperChar extends Thread{
	
	AutoSave as = new AutoSave();
	
	@Override
	public void run() {
		as.setDaemon(true);
		as.start();
		for (char c = 'A';  c <= 'Z'; c++) {
			System.out.println();
			System.out.print(c);
			
			for (long i = 0; i <= 1000000000L; i++) {}
		}
	}
}


class AutoSave extends Thread{
	public void save(){
		System.out.println("�����մϴ�.");
	}
	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {}
			save();
		}
	}
}







