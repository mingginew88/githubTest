package basic;

/*
	�������� ����ϴ� �����尡 �ִ�.
	���� �������� ����ϴ� �����尡 �ִ�.
	
	�������� ������ ��ü�� �ʿ��Ѵ�.
	�� ��ü�� �� �����尡 �������� ����Ѵ�.
 */


public class ThreadTest14 {
	public static void main(String[] args) {
		
		ShareData sd = new ShareData();		//�������� ����� ��ü ����
		
		CalcPIThread ct = new CalcPIThread(sd);
		PrintThread pt = new PrintThread(sd);
		
		ct.start();
		pt.start();
	}
}


//�������� �����ϴ� Ŭ����(������ Ŭ����)
class ShareData{
	public double result;		//���� �������� ����� ����
	
	public volatile boolean isOk = false;	//����� �Ϸ�Ǿ����� ���θ� ��Ÿ���� ����
	
	//volatile ==> ����� ������ �����Ϸ��� ����ȭ ��󿡼� ���ܽ�Ų��.
	//			   ��, ���� ����Ǹ� ��� ������ �����Ų��.
}


//����� �Ϸ�Ǹ� �������� ����ϴ� ������
class PrintThread extends Thread{
	private ShareData sd;
	
	public PrintThread(ShareData sd){
		this.sd = sd;
	}
	
	@Override
	public void run() {
		while(true){
			if(sd.isOk)
				break;
		}
		
		System.out.println();
		System.out.println("��� : " + sd.result);
	}
}


//�������� ����ϴ� ������
class CalcPIThread extends Thread{
	private ShareData sd;

	public CalcPIThread(ShareData sd) {
		this.sd = sd;
	}
	
	@Override
	public void run() {
		//������ ==> (1/1 - 1/3 + 1/5 -1/7 + ...) *4
		//			1	   -3	5   -7
		//			0		1	2	 3
		
		double sum = 0.0;
		
		for (int i = 1; i < 10000000; i+=2) {
			if((i/2%2)==0){
				sum += (1.0/i);
			}else {
				sum -= (1.0/i);
			}
		}
		sd.result = sum *4;
		sd.isOk = true;
	}
}







