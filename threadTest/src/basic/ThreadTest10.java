package basic;

//�������� ���¸� ����ϴ� ����
public class ThreadTest10 {
	public static void main(String[] args) {
		TargetThread targetThread = new TargetThread();
		StatePrintThread spt = new StatePrintThread(targetThread);
		
		spt.start();
	}
}

//targetThread�� ���¸� ����ϴ� ������
class StatePrintThread extends Thread{
	private Thread targetThread;
	
	//������
	public StatePrintThread(Thread targetThread){
		this.targetThread = targetThread;
	}
	
	@Override
	public void run() {
		while(true){
			//������ ������ ���°� ���ϱ�
			Thread.State state = targetThread.getState();
			System.out.println("Ÿ�� �������� ���°� : " + state);
			
			//New�������� �˻�
			if(state == Thread.State.NEW){
				targetThread.start(); //������ �۾� ����
			}
			
			//Ÿ�پ����尡 ����������� �˻�
			if(state == Thread.State.TERMINATED){
				break;
			}
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
		}
	}//END run()
}//END StatePrintThread


//target�� ������ (�۾��� ������)
class TargetThread extends Thread{
	@Override
	public void run() {
		for (long i = 1L; i <= 2000000000L ; i++) {} //�ð� ������
			
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
		}
		
		for (long i = 1L; i <= 2000000000L ; i++) {} //�ð� ������

	}
}





