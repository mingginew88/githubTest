package basic;

public class ThreadTest12 {
	public static void main(String[] args) {
		ThreadYield th1 = new ThreadYield("1�� ������");
		ThreadYield th2 = new ThreadYield("2�� ������");
		
		th1.start();
		th2.start();
		
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {}
		System.out.println("11111========================");
		
		th1.work = false;
		
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {}	
		
		

		System.out.println("11111========================");
		th1.work = true;
		
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {}	
		
		
		th1.stop = true;
		th2.stop = true;
		
	}
}


//yield()�޼��� ������ ������
class ThreadYield extends Thread{
	public boolean stop = false;
	public boolean work = true;
	
	public ThreadYield(String name){
		super(name);	//�������� �̸� ����
	}
	
	@Override
	public void run() {
		while(!stop){		//stop�� true�� �ݺ��� ����
			if(work){
				//getName() ==> ������ �̸� ��, name�� ��ȯ�ϴ� �޼���
				System.out.println(getName() + "�۾���...");
			}else{
				System.out.println(getName() + "�纸 ��...");
				Thread.yield();
				System.out.println(getName() + "�纸 ��...");
			}
		}
		System.out.println(getName() + "����...");
	}
	
	
	
	
}