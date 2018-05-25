package basic;

public class ThreadTest03 {
	
	//Thread�� ���� �ð� Ȯ���� ����
	public static void main(String[] args) {
//		MyRunner r1 = new MyRunner();
		Thread th1 = new Thread(new MyRunner());
		
		//1970�� 1�� 1�� 0�� 0�� 0�� (ǥ�ؽð�����)�κ��� ����� �ð�
		long startTime = System.currentTimeMillis();
		th1.start();
		try {
			th1.join();		//���� �������� �����忡�� join()�޼��带 ȣ���� ������(���⼭�� th1)�� ����ɶ����� ��ٷ���..
		} catch (InterruptedException e) {
		}	
		long endTime = System.currentTimeMillis();	
		System.out.println("����ð� : " + (endTime - startTime));
	
	}
}

class Runner{
	
}

class MyRunner extends Runner implements Runnable{
	@Override
	public void run() {
		long sum = 0L;
		for (long i = 1L; i < 1_000_000_000L; i++) {
			sum += i;
		}
		System.out.println("�հ� : " + sum);
	}
}

class MyRunner2 extends Thread{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
	}
}

