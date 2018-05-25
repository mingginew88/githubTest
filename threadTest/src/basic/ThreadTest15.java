package basic;

public class ThreadTest15 {
	public static void main(String[] args) {
		
		ShareObject sObj = new ShareObject();
		
		WorkerThread th1 = new WorkerThread("1��", sObj);
		WorkerThread th2 = new WorkerThread("2��", sObj);
		
		th1.start();
		th2.start();
		
	}
}


//ShareObject�� ����ϴ� ������
class WorkerThread extends Thread{
	private ShareObject sObj;
	
	public WorkerThread(String name, ShareObject sObj) {
		super(name);	//Thread�� name����
		this.sObj = sObj;
	}
	
	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			sObj.add();
		}
	}
}



//�������� ����ϴ� Ŭ����
class ShareObject{
	private int sum = 0;
	
	//����ȭ ���1 ==> �޼��忡 ����ȭ �����ϱ�
//	public synchronized void add(){
//		int n = sum;
//		
//		n += 10;	//10����
//		
//		sum = n;
//		
//		System.out.println(Thread.currentThread().getName() + "�հ� : " + sum);
//	}
	
	//����ȭ ���2 ==> ����ȭ ��� �����ϱ�
	public void add(){
		synchronized (this) {
			int n = sum;
			
			n += 10;	//10����
			
			sum = n;
			
			System.out.println(Thread.currentThread().getName() + "�հ� : " + sum);
		}
	}
}
