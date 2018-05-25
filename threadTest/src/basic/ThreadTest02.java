package basic;

//��Ƽ ������ ���α׷� ����			-- ��� �����尡 ����Ǿ�� ���θ޼��尡 ������
public class ThreadTest02 {
	public static void main(String[] args) {
		//��Ƽ Thread�� ����ϴ� ���
		
		//��� 1.
		//ThreadŬ������ ����� class�� �ν��Ͻ��� ������ �� �� �ν��Ͻ��� start()�޼��带 ȣ���Ѵ�.
		MyThread1 th1 = new MyThread1();
		th1.start();
		
		
		//��� 2.
		//Runnable�������̽��� ������ class�� �ν��Ͻ��� ������ ��
		//�� �ν��Ͻ��� Thread��ü�� �ν��Ͻ��� ������ �� �������� �Ű������� �Ѱ��ش�.
		//�� �� ������ Thread�ν��Ͻ��� start()�޼��带 ȣ���Ѵ�.
		MyThread2 r2 = new MyThread2();
		Thread th2 = new Thread(r2);
		th2.start();
		
		
		//��� 3. ==> �͸���ü�� �̿��� ���
		//Runnable�������̽��� ������ �͸� ����ü�� �ν��Ͻ��� Thread�ν��Ͻ��� ������ �� �Ű������� ����ش�.
		Runnable r3 = new Runnable(){
			@Override
			public void run() {
				for (int i = 0; i <= 100; i++) {
					System.out.print("@");
					try {
						//Thread.sleep(�ð�); ==> �־��� �ð����� �۾��� ��� �����.
						//�ð��� �и������� ������ ����Ѵ�.
						//��, 1000�� 1�ʸ� �ǹ��Ѵ�.
						Thread.sleep(100);
					} catch (InterruptedException e) {
						
					}
				}	
			}			
		};
		Thread th3 = new Thread(r3);
		th3.start();
		
		
		System.out.println("����()�޼��� ��....");
	}//End main()
}//End ThreadTest02


//ThreadŬ������ ����� Ŭ���� �ۼ��ϱ�
class MyThread1 extends Thread{
	@Override
	public void run() {
		//������� ó���� ������ run()�޼��忡 �ۼ��� ���´�.
		for (int i = 0; i <= 100 ; i++) {
			System.out.print("*");
			try {
				//Thread.sleep(�ð�); ==> �־��� �ð����� �۾��� ��� �����.
				//�ð��� �и������� ������ ����Ѵ�.
				//��, 1000�� 1�ʸ� �ǹ��Ѵ�.
				Thread.sleep(100);
			} catch (InterruptedException e) {}
		}
	}	
}

//Runnable�������̽��� ������ Ŭ���� �ۼ��ϱ�
class MyThread2 implements Runnable{
	@Override
	public void run() {
		//������� ó���� ������ run()�޼��忡 �ۼ��� ���´�.
		for (int i = 0; i <= 100; i++) {			
			System.out.print("$");
			try {
				//Thread.sleep(�ð�); ==> �־��� �ð����� �۾��� ��� �����.
				//�ð��� �и������� ������ ����Ѵ�.
				//��, 1000�� 1�ʸ� �ǹ��Ѵ�.
				Thread.sleep(100);
			} catch (InterruptedException e) {
				
			}
		}		
	}	
}





