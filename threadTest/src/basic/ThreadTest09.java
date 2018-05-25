package basic;

public class ThreadTest09 {
	//���� ������ ����
	public static void main(String[] args) {
		AutoSaveThread autoSave = new AutoSaveThread();
		
		//���� ������� ����
		autoSave.setDaemon(true);
		autoSave.start();
		
		try {
			for (int i = 1; i <= 20; i++) {
				System.out.println(i);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
		}
		System.out.println("���ξ����� ����...");
	}
}

//���� ������� ����� ������ �����
//3�ʿ� �ѹ��� �����ϴ� ������
class AutoSaveThread extends Thread{
	public void save(){
		System.out.println("�۾� ������ �����մϴ�.");
	}
	
	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
			}
			save();
		}
	}
}

//suspend() �Ͻ����� ---- resume() ����¸޼���
//sleep()�� join()�� �ȿ� ���� �־���
//yield() �纸�ϴ� �޼���
//suspend() resume() stop() �������¿� ������ ����⶧���� ���̻� ������� �ʰ� ������ ����� �޼����..



