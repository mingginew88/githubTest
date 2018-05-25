package basic;
/*
	�����͸� �����ϴ� ������� �����͸� �Һ��ϴ� ������ ó�� ����
	(wait(), notify()�޼��� �̿�)
 */
public class ThreadTest20 {
	public static void main(String[] args) {
		
		DataBox databox = new DataBox();
		ProducerThread pth = new ProducerThread(databox);
		ConsumerThread cth = new ConsumerThread(databox);
		
		pth.start();
		cth.start();
		
	}
}


//�����͸� �����ϴ� ������
class ProducerThread extends Thread{
	private DataBox databox;

	public ProducerThread(DataBox databox) {
		this.databox = databox;
	}	
	
	@Override
	public void run() {
		for (int i = 1; i <= 5; i++) {
			String data = "data-" + i;
			databox.setData(data);
		}
	}
}


//�����͸� �Һ��ϴ� ������
class ConsumerThread extends Thread{
	private DataBox databox;
	
	public ConsumerThread(DataBox databox){
		this.databox = databox;
	}
	
	@Override
	public void run() {
		for (int i = 1; i <= 5 ; i++) {
			String data = databox.getData();
			System.out.println("������ ������ : " + data);
		}
	}
}


//�����͸� �������� ����ϴ� Ŭ����
class DataBox{
	private String data;
	
	public synchronized void setData(String data){
		if(this.data!=null){		//�����Ͱ� ������
			try {
				wait();
			} catch (InterruptedException e) {}
		}
		this.data = data;
		System.out.println("���޿� �����尡 ������ ������ : " + data);
		notify();
	}
	
	//�����͸� �Һ��ϴ� �޼���
	public synchronized String getData(){
		if(data==null){		//�����Ͱ� ������
			try {
				wait();
			} catch (InterruptedException e) {}
		}
		String returnData = data;
		System.out.println("�Һ�� �����尡 ����� ������ : " + data);
		data = null;
		notify();
		return returnData;
	}
}