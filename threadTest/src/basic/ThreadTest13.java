package basic;

/*
	Thread�� stop()�޼���� ȣ���ϸ� �����尡 �ٷ� �����.
	�� �� ����ϴ� �ڿ��� �������� ���ϰ� ���α׷��� ����Ǿ ���߿� ����Ǵ� ���α׷��� ������ �� �� �ִ�.
	�׷��� stop()�޼���� ����õ�Ѵ�.

 */

public class ThreadTest13 {
	public static void main(String[] args) {
		/*
		ThreadStopEx01 th = new ThreadStopEx01();
		th.start();
		
		try {
			Thread.sleep(500);
		} catch (Exception e) {}
		
//		th.stop(); 	//������ ����... ����õ
		
		th.setStop(true);
		*/
		
		//interrupt()�޼��带 �̿��� ������ ���߱�
		ThreadStopEx02 th2 = new ThreadStopEx02();
		th2.start();
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {}
		
		th2.interrupt();
	}
}


class ThreadStopEx01 extends Thread{
	private boolean stop;
	
	public void setStop(boolean stop){
		this.stop = stop;
	}
	
	@Override
	public void run() {
		while(!stop){
			System.out.println("������ ���� ��....");
		}
		
		System.out.println("�ڿ� ����....");
		System.out.println("���� ����....");
	}
}


//interrupt()�޼��带 �̿��Ͽ� �����带 ���߰� �ϴ� ���
class ThreadStopEx02 extends Thread{
	@Override
	public void run() {
		/*
		//���1 -->sleep()�޼���� interruptedException�� �̿��� ���
		//		-->sleep()�޼���� interrupt()�޼��� ����� ������ InterruptedException�� �߻��Ѵ�.
		try {
			while(true){
				System.out.println("���� ��...");
				Thread.sleep(1);	//
			}
		} catch (InterruptedException e) {}
		 */
		
		//���2 -->interrupt�� �߻��ߴ��� ���θ� �˼� �ִ� �޼��� �̿��ϱ�
		while(true){
			System.out.println("������...");
			// (�˻���)1
			// isInterrupted() => �ν��Ͻ� �޼���, interrupt()�޼��尡 ȣ��Ǿ����� ���θ� �����Ѵ�.
			if(this.isInterrupted()){
				break;
			}
		}
		
		System.out.println("�ڿ� ����....");
		System.out.println("���� ����....");
	
		
	}
}









